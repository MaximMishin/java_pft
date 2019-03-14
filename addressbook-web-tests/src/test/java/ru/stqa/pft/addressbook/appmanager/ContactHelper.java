package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {
  public ContactHelper(ChromeDriver wd) {
    super(wd);
  }
  
  public void submitContactCration() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickName());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhon());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("fax"), contactData.getFax());
    type(By.name("email"), contactData.getEmail1());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());
    type(By.name("homepage"), contactData.getHomePage());
    selectValue(By.name("bday"), contactData.getBday());
    selectValue(By.name("bmonth"), contactData.getBmonth());
    type(By.name("byear"), contactData.getByear());
    selectValue(By.name("aday"), contactData.getAday());
    selectValue(By.name("amonth"), contactData.getAmonth());
    type(By.name("ayear"), contactData.getAyear());
    type(By.name("address2"), contactData.getSecondaryAddress());
    type(By.name("phone2"), contactData.getPhoneTwo());
    type(By.name("notes"), contactData.getNotes());
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void deletContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

}
