package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void ContactCreationTests() {

    app.getNavigationHelper().goToNewContactPage();
    app.getContactHelper().createContact(new ContactData("test1", "test2", "123", "123@123.ru", "test1"));
  }

}
