package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.mantis.model.Accounts;
import ru.stqa.pft.mantis.model.AccountData;

import java.util.List;

public class AccountHelper extends HelperBase {

  public AccountHelper(ApplicationManager app) {
    super(app);
  }

  public AccountHelper edit(AccountData account) {
    click(By.linkText(account.getUsername()));
    return this;
  }

  public AccountHelper edit(String name) {
    click(By.linkText(name));
    return this;
  }

  private Accounts accountsCache = null;

  public Accounts all() {
    if (accountsCache != null) {
      return new Accounts(accountsCache);
    }
    accountsCache = new Accounts();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr"));

    for (WebElement element : elements) {

      String link = element.findElement(By.cssSelector("td:nth-child(1) > a ")).getAttribute("href");
      String userName = element.findElement(By.cssSelector("td:nth-child(1)")).getText();
      String realName = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
      String email = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
      int dateCreated = Integer.parseInt(element.findElement(By.cssSelector("td:nth-child(7)")).getText());
      int lastVisit = Integer.parseInt(element.findElement(By.cssSelector("td:nth-child(8)")).getText());

      accountsCache.add(new AccountData()
              .withLink(link)
              .withUsername(userName)
              .withRealname(realName)
              .withEmail(email)
              .withDate_created(dateCreated)
              .withLast_visit(lastVisit));
    }
    return new Accounts(accountsCache);
  }

  public AccountHelper resetPassword() {

    click(By.xpath("//input[@value='Reset Password']"));
    return this;
  }
}
