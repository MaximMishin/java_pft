package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactHelper extends HelperBase {
  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickName());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhone());
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
    if (creation) {
      if(contactData.getGroups().size() >0){
        Assert.assertTrue(contactData.getGroups().size()==1);
        new Select(wd.findElement(By.name("new_group")))
                .selectByVisibleText(contactData.getGroups().iterator().next().getName());
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
    attach(By.name("photo"), contactData.getPhoto());
  }

  public void selectById(int id) {
    wd.findElement(By.cssSelector(".center input[value='" + id + "']")).click();
  }

  public void delete() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void initContactModificationById(int id) {
    wd.findElement(By.xpath(".//input[@value='" + id + "']/../..//img[@alt='Edit']")).click();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public boolean isThereContact(int id) {

    return isElementPresent(By.xpath("//*[@id="+id+"]"));
  }

  NavigationHelper navigationHelper = new NavigationHelper(wd);

  public void create(ContactData contact, boolean creation) {
    fillContactForm(contact, creation);
    submitContactCreation();
    contactCache = null;
    navigationHelper.homePage();
  }

  public void modify(ContactData contact) {
    initContactModificationById(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    contactCache = null;
    navigationHelper.homePage();
  }

  public void delete(ContactData contact) {
    selectById(contact.getId());
    delete();
    contactCache = null;
    navigationHelper.closeDialogBox();
    navigationHelper.homePage();
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.cssSelector("[name=entry]"));

    for (WebElement element : elements) {
      String lastName = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
      String firstName = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
      String allPhones = element.findElement(By.cssSelector("td:nth-child(6)")).getText();
      String allEmails = element.findElement(By.cssSelector("td:nth-child(5)")).getText();
      String address = element.findElement(By.cssSelector("td:nth-child(4)")).getText();

      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData()
              .withId(id)
              .withLastName(lastName)
              .withFirstName(firstName)
              .withAllPhones(allPhones)
              .withAllEmails(allEmails)
              .withAddress(address));
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
    String homePhone = wd.findElement(By.name("home")).getAttribute("value");
    String mobilePhone = wd.findElement(By.name("mobile")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String workPhone = wd.findElement(By.name("work")).getAttribute("value");
    String phoneTwo = wd.findElement(By.name("phone2")).getAttribute("value");
    String email1 = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");

    wd.navigate().back();
    return new ContactData()
            .withId(contact.getId())
            .withFirstName(firstName)
            .withLastName(lastName)
            .withHomePhon(homePhone)
            .withMobilePhone(mobilePhone)
            .withWorkPhone(workPhone)
            .withPhoneTwo(phoneTwo)
            .withEmail1(email1)
            .withEmail2(email2)
            .withEmail3(email3)
            .withAddress(address);
  }


  public void removeFromGroup(ContactData contact) {
    selectById(contact.getId());
    click(By.name("remove"));
    navigationHelper.homePage();
  }

  public void addToGroup(ContactData contact, GroupData group) {
    selectById(contact.getId());
    selectValue(By.cssSelector("[name=to_group]"), group.getName());
    click(By.cssSelector("[type=submit]"));
  }
}
