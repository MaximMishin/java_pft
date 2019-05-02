package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(ApplicationManager app) {
    super(app);
  }


  public void loginAsAdmin() {
    wd.get(app.getProperty("web.baseUrl") + "login_page.php");
    type(By.cssSelector("#username"), "administrator");
    click(By.cssSelector("[type=submit]"));
    type(By.name("password"), "psw");
    click(By.cssSelector("[type=submit]"));
  }
  public void login()  {
    wd.get(app.getProperty("web.baseUrl"));
    type(By.name("username"), app.getProperty("web.adminLogin"));
    click(By.xpath("//*[@type = 'submit']"));
    type(By.name("password"), app.getProperty("web.adminPassword"));
    click(By.xpath("//*[@type = 'submit']"));
  }

  public void managerUsers() {
    click(By.linkText("Manage Users"));
  }





}
