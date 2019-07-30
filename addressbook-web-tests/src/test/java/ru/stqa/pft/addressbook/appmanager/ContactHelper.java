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
import java.util.function.Function;

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
ContactDataMapper contactDataMapper = new ContactDataMapper();
    List<ContactData> contacts = new ArrayList<>();
     WebElement table = wd.findElement(By.id("maintable"));
      List<WebElement> elementsContact = table.findElements(By.name("entry"));//wd.findElements(By.tagName("tr"));

      for (WebElement element : elementsContact){
        List<WebElement> columnElement = element.findElements(By.tagName("td"));



        contacts.add(contactDataMapper.apply(columnElement));
    }
    return contacts;
  }

  private class ContactDataMapper implements Function<List<WebElement>, ContactData>{
    @Override
    public ContactData apply(List<WebElement> columnElements) {

      String firstName = columnElements.get(2).getText();
      String lastName = columnElements.get(1).getText();
      String homePhone = columnElements.get(5).getText();
      String email = columnElements.get(4).getText();
      String address = columnElements.get(3).getText();


      return new ContactData(firstName, lastName, homePhone, email, null);
    }
  }
}
