package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase{

  @Test
  public void testContactDeletion(){
    app.getNavigationHelper().goToContactPage();
    if (! app.getContactHelper().isThereAContact()){
      app.getNavigationHelper().goToNewContactPage();
      app.getContactHelper().createContact(new ContactData("test1", "test2", null, null, "test1"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
    app.closeAlert();
    app.getContactHelper().returnToHomePage();
  }
}
