package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("NEWfirstName", "NEWmiddleName", "NEWlastName",
            "NEWnickName", "NEWtitle", "NEWCompany", "NEWaddress", "757570",
            "+79876543210", "575750", "999660",
            "NEWemail1@mail.ru", "NEWemail2@mail.ru", "NEWemail3@mail.ru", "http://NEWhomepage",
            "12", "January", "1991",
            "7", "February", "2021",
            "NEWSecondary Address", "767670", "NEWnotesText"));
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
  }
}
