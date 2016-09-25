package com.example.fw;

import com.example.tests.ContactData;
import org.openqa.selenium.By;

/**
 * Created by Nick on 9/17/2016.
 */
public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.firstName);
        type(By.name("lastname"), contactData.lastName);
        type(By.name("address"), contactData.address);
        type(By.name("home"), contactData.homePhone);
        type(By.name("mobile"), contactData.mobilePhone);
        type(By.name("work"), contactData.workPhone);
        type(By.name("email"), contactData.firstEmail);
        type(By.name("email2"), contactData.secondEmail);
        selectByText(By.name("bday"), contactData.dayOfBirthday);
        selectByText(By.name("bmonth"), contactData.monthOfBirthday);
        type(By.name("byear"), contactData.yearOfBirthday);
        //selectByText(By.name("new_group"), contactData.relatedGroup);
        type(By.name("address2"), contactData.secondAddress);
        type(By.name("phone2"), contactData.secondHomePhone);
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void deleteContact(int index) {
        selectContactByIndex(index);
        editContactByIndex(index);
        deleteContactButton();
    }

    private void deleteContactButton() {
        click(By.xpath("(//input[@name='update'])[2]"));//button delete
    }

    private void selectContactByIndex(int index) {
        click(By.xpath("//tr[@name='entry'][\"+(index+1)+\"]//input[@name='selected[]']"));
    }

    private void editContactByIndex(int index) {
        click(By.xpath("//tr[@name='entry']["+(index+1)+"]//img[@ alt = 'Edit']"));

    }

    public void initContactModification(int index) {
        selectContactByIndex(index);
        editContactByIndex(index);
    }

    public void submitContactModification() {
        click(By.xpath("(//input[@name='update'])[1]"));//button update
    }
}
