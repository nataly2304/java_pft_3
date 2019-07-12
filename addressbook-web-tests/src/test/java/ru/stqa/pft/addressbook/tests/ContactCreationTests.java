package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void ContactCreationTests() {
    app.getNavigationHelper().goToContactPage();
    List<ContactData> before = app.getContactHelper().getContactList();
//    int before = app.getContactHelper().getContactCount();
    app.getNavigationHelper().goToNewContactPage();
    app.getContactHelper().createContact(new ContactData("test1", "test2", "123", "123@123.ru", "test1"));
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
//    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after.size(), before.size() + 1);
  }

}
