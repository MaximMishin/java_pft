package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class HelperBase {

  protected ApplicationManager app;
  protected WebDriver wd;

  public HelperBase (ApplicationManager app) {
    this.app=app;
    this.wd=app.getDriver();
  }


  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  private void select(By locator, String chosen) {
    new Select(wd.findElement(locator)).selectByVisibleText(chosen);
  }

  protected boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

  protected void type(By locator, String text) {
    click(locator);
    if (text != null) {
      String existingText = wd.findElement(locator).getAttribute("value");
      if (!text.equals(existingText)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }

  protected void attach(By locator, File file) {
    if (file != null) {
      String existingText = wd.findElement(locator).getAttribute("value");
        wd.findElement(locator).sendKeys(file.getAbsolutePath());

    }
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  protected void selectValue(By locator, String chosen) {
    if (chosen != null) {
      if (isElementPresent(locator)) {
        String existingText = wd.findElement(locator).getAttribute("value");
        if (!chosen.equals(existingText)) {
          click(locator);
          select(locator, chosen);
        }
      }
    }
  }
}
