package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends BaseHelper{

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }


  public void goToGroupPage() {
    click(By.linkText("groups"));
  }

  public void goToNewContactPage() {
    click(By.linkText("add new"));
  }
}
