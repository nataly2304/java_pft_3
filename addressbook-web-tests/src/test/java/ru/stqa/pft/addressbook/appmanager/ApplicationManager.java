package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;


import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  WebDriver wd;
  private GroupHelper groupHelper;
  private NavigationHelper navigationHelper;
  private SessionHelper sessionHelper;
  private ContactHelper contactHelper;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() {
    if (Objects.equals(browser, BrowserType.SAFARI)){
      wd = new SafariDriver();
    } else if(Objects.equals(browser, BrowserType.CHROME))
    {
      System.setProperty("webdriver.chrome.driver", "/Users/Nataly/Documents/Study/JAVA/java_pft_3/addressbook-web-tests/src/test/resources/chromedriver");
      wd = new ChromeDriver();
    } else if (Objects.equals(browser, BrowserType.FIREFOX)){
      wd = new FirefoxDriver();
    }

    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/index.php");
//    wd.get("http://air-natalia/addressbook/index.php");
    groupHelper = new GroupHelper(wd);
    contactHelper = new ContactHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
  }

  public void stop() {
    wd.quit();
  }

  public void closeAlert(){
    wd.switchTo().alert().accept();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }
}
