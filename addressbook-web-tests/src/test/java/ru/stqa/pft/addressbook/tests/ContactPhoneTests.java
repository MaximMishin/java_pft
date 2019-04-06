package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
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
  public void testContactPhone() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactIntoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactIntoFromEditForm)));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(),
            contact.getMobilePhone(),
            contact.getWorkPhone(),
            contact.getPhoneTwo())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]","");
  }
}
