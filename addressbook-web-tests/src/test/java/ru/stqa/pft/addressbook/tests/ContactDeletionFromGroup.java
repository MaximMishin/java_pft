package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionFromGroup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.goTo().addNewPage();
      app.contact().create(new ContactData()
              .withFirstName("firstName")
              .withMiddleName("middleName")
              .withLastName("lastName")
              .withNickName("nickName"), true);
    }
  }

  @Test
  public void testContactDeletionFromGroup() {
    ContactData contact = app.db().contacts().iterator().next();
    GroupData group = app.db().groups().iterator().next();
    app.goTo().homePage();
    app.goTo().filterByGroup(group);
    if (!app.contact().isThereContact(contact.getId())) {
      app.goTo().filterByAllGroups();
      app.contact().addToGroup(contact, group);
      app.goTo().homePage();
      app.goTo().filterByGroup(group);
    }
    app.contact().removeFromGroup(contact);
    Groups groupInContact = app.db().updateData(contact).iterator().next().getGroups();
    assertThat(groupInContact, not(group));
  }
}
