package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoAddNewPage();
    app.getContactHelper().createContact(new ContactData("firstName", "middleName", "lastName",
            "nickName", "title", "Company", "address", "757575",
            null, "575757", "999666",
            "email1@mail.ru", "email2@mail.ru", "email3@mail.ru", "http://homepage",
            "10", null, "1990",
            "5", "February", "2020",
            "Secondary Address", "767676", "notesText",
            "test1"), true);
  }
}