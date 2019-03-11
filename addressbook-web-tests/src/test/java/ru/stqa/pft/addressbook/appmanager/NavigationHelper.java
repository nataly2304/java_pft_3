package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends BaseHelper{

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }


  public void goToGroupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))) {
      return; // если условие выолняется, то нужно сразу выйти из этого метода
    }
    click(By.linkText("groups"));
  }

  public void goToNewContactPage() {
    click(By.linkText("add new"));
  }

  public void goToContactPage() {
    if (isElementPresent(By.id("maintable"))){
      return;
    }
    click(By.linkText("home"));
  }
}
