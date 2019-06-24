package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void ContactCreationTests() {
    app.getNavigationHelper().goToContactPage();
    int before = app.getContactHelper().getContactCount();
    app.getNavigationHelper().goToNewContactPage();
    app.getContactHelper().createContact(new ContactData("test1", "test2", "123", "123@123.ru", "test1"));
    app.getContactHelper().returnToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);
  }

}
