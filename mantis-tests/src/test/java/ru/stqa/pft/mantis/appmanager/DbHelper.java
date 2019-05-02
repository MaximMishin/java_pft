package ru.stqa.pft.mantis.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.subethamail.smtp.server.Session;
import ru.stqa.pft.mantis.model.AccountData;
import ru.stqa.pft.mantis.model.Accounts;

import java.util.List;

public class DbHelper {

  private final SessionFactory sessionFactory;

  public DbHelper() {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();

    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
  }

  public Accounts accounts() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<AccountData> result = session.createQuery("from AccountData where email !='root@localhost'").list();
    System.out.println("result =" + result);
    session.getTransaction().commit();
    session.close();
    return new Accounts(result);
  }
  public AccountData updateData(AccountData account) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    AccountData result =(AccountData)session.createQuery("from AccountData where id =" + account.getId()).uniqueResult();
    session.getTransaction().commit();
    session.close();
    return result;
  }
}
