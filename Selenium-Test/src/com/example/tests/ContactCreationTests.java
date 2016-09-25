package com.example.tests;


import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static com.example.fw.ContactHelper.CREATION;


public class ContactCreationTests extends TestBase {

    @Test(dataProvider = "randomValidContactGenerator")
    public void testContactCreationWithValidData(ContactData contact) throws Exception {
        app.navigateTo().mainPage();
        //save old state
        List<ContactData> oldList = app.getContactHelper().getContactData();

        //action
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(contact, CREATION);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
        //save new state
        List<ContactData> newList = app.getContactHelper().getContactData();

        // compare states
        oldList.add(contact);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }
}
