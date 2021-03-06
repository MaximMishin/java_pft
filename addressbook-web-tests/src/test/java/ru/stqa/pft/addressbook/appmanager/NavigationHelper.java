package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void groupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))) {
      return;
    }
    click(By.linkText("groups"));
  }

  public void addNewPage() {
    if (isElementPresent(By.xpath("//label[21]"))
            && wd.findElement(By.xpath("//label[21]")).getText().equals("Groups")) {
      return;
    }
    click(By.cssSelector("li.all > a"));
  }

  public void homePage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

  public void closeDialogBox() {
    wd.switchTo().alert().accept();
  }


  public void filterByGroup(GroupData group) {
    selectValue(By.cssSelector("#right [name=group]"), group.getName());
  }
  public void filterByAllGroups() {
    selectValue(By.cssSelector("#right [name=group]"), "[all]");
  }
}
