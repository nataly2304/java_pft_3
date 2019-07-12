package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends BaseHelper{

  public ContactHelper(WebDriver wd){
    super(wd);
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("email"), contactData.getEmail());
    if (creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void editContact() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void createContact(ContactData contact){
    fillContactForm(contact, true);
    submitContactCreation();
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    int contactCount = wd.findElements(By.name("entry")).size();
    return contactCount;
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<>();
    List<WebElement> elements = wd.findElements(By.xpath("//td[3]"));
    for (WebElement element : elements){
      String firstName = element.getText();
      ContactData contact = new ContactData(firstName, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }

//  public List<GroupData> getContactList() {
//    List<ContactData> contacts = new ArrayList<>();
//    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
//    for (WebElement element : elements){
//      String name = element.getText(); //получаем имя группы
//      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
//      ContactData contact = new ContactData(id, name, null, null);
//      contacts.add(contact);
//    }
//    return contacts;
//  }
}
