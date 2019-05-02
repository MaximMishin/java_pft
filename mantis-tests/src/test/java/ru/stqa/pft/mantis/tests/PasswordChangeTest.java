package ru.stqa.pft.mantis.tests;

import net.bytebuddy.utility.RandomString;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.appmanager.HttpSession;
import ru.stqa.pft.mantis.model.AccountData;
import ru.stqa.pft.mantis.model.Accounts;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class PasswordChangeTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() throws IOException, MessagingException {
    if (app.db().accounts().size() == 0) {
      RandomString gen = new RandomString(3);
      String randomPart = gen.nextString();
      String user = "user" + randomPart;
      String email = user + "@localhost";
      String password = "qwerty";
      app.james().createUser(user, password);
      app.registration().start(user, email);
      List<MailMessage> mailMessages = app.james().waitForMail(user, password, 60000);
      String confirmationLink = findConfirmationLink(mailMessages, email);
      app.registration().finish(confirmationLink, password);
      assertTrue(app.newSession().login(user, password));
    }
  }

  @Test
  public void testPasswordChange() throws InterruptedException, IOException, MessagingException {
    Accounts before = app.db().accounts();
    Accounts accounts = app.db().accounts();
    AccountData editedAccount = accounts.iterator().next();
    String user = editedAccount.getUsername();
    String email = editedAccount.getEmail();
    String password = "qwerty";
    app.james().drainEmail(user, password);
    app.goTo().login();
    app.goTo().managerUsers();
    app.account().edit(editedAccount).resetPassword();
    List<MailMessage> mailMessages = app.james().waitForMail(user, password, 60000);
    String confirmationLink = findConfirmationLink(mailMessages, email);
    String newPsw = "ytrewq";
    app.registration().finish(confirmationLink, newPsw);
    assertTrue(app.newSession().login(user,newPsw));
    AccountData  updatedAccount = app.db().updateData(editedAccount);
    Accounts after = app.db().accounts();
    assertThat(after, equalTo(before.withOut(editedAccount).withAdded(updatedAccount)));
  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }
}
