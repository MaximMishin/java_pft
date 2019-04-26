package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.goTo().addNewPage();
      app.contact().create(new ContactData()
              .withFirstName("firstName")
              .withMiddleName("middleName")
              .withLastName("lastName")
              .withNickName("nickName")
              .withTitle("title")
              .withCompany("Company")
              .withAddress("address")
              .withHomePhon("757575")
              .withMobilePhone("88005553535")
              .withWorkPhone("575757")
              .withFax("999666")
              .withEmail1("email1@mail.ru")
              .withEmail2("email2@mail.ru")
              .withEmail3("email3@mail.ru")
              .withHomePage("http://homepage")
              .withBday("10")
              .withBmonth("February")
              .withByear("1990")
              .withAday("5")
              .withAmonth("February")
              .withAyear("2020")
              .withSecondaryAddress("Secondary Address")
              .withPhoneTwo("767676")
              .withNotes("notesText"), true);
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    ContactData modifyContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifyContact.getId())
            .withFirstName("NEWfirstName")
            .withMiddleName("NEWmiddleName")
            .withLastName("NEWlastName")
            .withNickName("nickName")
            .withTitle("title")
            .withCompany("Company")
            .withAddress("address")
            .withHomePhon("757575")
            .withMobilePhone("88005553535")
            .withWorkPhone("575757")
            .withFax("999666")
            .withEmail1("email1@mail.ru")
            .withEmail2("email2@mail.ru")
            .withEmail3("email3@mail.ru")
            .withHomePage("http://homepage")
            .withBday("10")
            .withBmonth("February")
            .withByear("1990")
            .withAday("5")
            .withAmonth("february")
            .withAyear("2020")
            .withSecondaryAddress("Secondary Address")
            .withPhoneTwo("767676")
            .withNotes("notesText");
    app.contact().modify(contact);
    Contacts after = app.db().contacts();
    assertThat(after.size(), equalTo(before.size()));
    assertThat(after, equalTo(before.without(modifyContact).withAdded(contact)));
    verifyContactListInUI();
  }
}