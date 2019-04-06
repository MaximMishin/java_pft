package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {

    Contacts before = app.contact().all();
    app.goTo().addNewPage();
    ContactData contact = new ContactData()
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
            .withNotes("notesText")
            .withGroup("test1");
    app.contact().create(contact, true);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}