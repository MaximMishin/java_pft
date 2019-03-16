package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if (!app.getContactHelper().isThereContact()) {
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
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("NEWfirstName", "NEWmiddleName", "NEWlastName",
            "NEWnickName", "NEWtitle", "NEWCompany", "NEWaddress", "757570",
            "+79876543210", "575750", "999660",
            "NEWemail1@mail.ru", "NEWemail2@mail.ru", "NEWemail3@mail.ru", "http://NEWhomepage",
            "12", null, "1991",
            "7", "February", "2021",
            "NEWSecondary Address", "767670", "NEWnotesText", "test1"), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
  }
}
