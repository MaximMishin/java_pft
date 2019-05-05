package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0){
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
              .withMobilePhone(null)
              .withWorkPhone("575757")
              .withFax("999666")
              .withEmail1("email1@mail.ru")
              .withEmail2("email2@mail.ru")
              .withEmail3("email3@mail.ru")
              .withHomePage("http://homepage")
              .withBday("10")
              .withBmonth(null)
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
  public void testContactDeletion() throws InterruptedException {
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Contacts after = app.db().contacts();
    Assert.assertEquals(after.size(), before.size() - 1);
    assertThat(after, equalTo(before.without(deletedContact)));
    verifyContactListInUI();
  }
}