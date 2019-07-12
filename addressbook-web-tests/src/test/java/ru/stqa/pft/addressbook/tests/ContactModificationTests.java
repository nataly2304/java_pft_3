package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification(){
    app.getNavigationHelper().goToContactPage();
    if (! app.getContactHelper().isThereAContact()){
      app.getNavigationHelper().goToNewContactPage();
      app.getContactHelper().createContact(new ContactData("test1", "test2", null, null, "test1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm(new ContactData("test1", "test2", "123", "123@123.ru", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
  }
}
