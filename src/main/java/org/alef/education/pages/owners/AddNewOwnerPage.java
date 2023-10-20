package org.alef.education.pages.owners;

import io.qameta.allure.Step;
import org.alef.education.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class AddNewOwnerPage extends BasePage {

    private final By firstNameInputField = By.id("firstName");
    private final By lastNameInputField = By.id("lastName");
    private final By addressInputField = By.id("address");
    private final By cityInputField = By.id("city");
    private final By telephoneInputField = By.id("telephone");
    private final By addOwnerButton = By.xpath("//button[text()='Add Owner']");
    private final By addNewPetButton = By.xpath("//a[text()='Add New Pet']");

    public AddNewOwnerPage(WebDriver driver) {
        super(driver);
    }

    @Step("Enter the firstname: {0}")
    public void enterFirstName(String firstname) {
        typeText(firstNameInputField,firstname);
    }

    @Step("Enter the lastName: {0}")
    public void enterLastName(String lastName) {
        typeText(lastNameInputField,lastName);
    }

    @Step("Enter the address: {0}")
    public void enterAddress(String address) {
        typeText(addressInputField,address);
    }

    @Step("Enter the city: {0}")
    public void enterCity(String city) {
        typeText(cityInputField,city);
    }

    @Step("Enter the telephone: {0}")
    public void enterTelephone(String telephone) {
        typeText(telephoneInputField,telephone);
    }

    @Step("Click on Add Owner button")
    public void clickOnAddOwnerButton() {
        actionClick(addOwnerButton);
    }

    @Step("Click on Add New Pet button")
    public void clickOnAddNewPetButton() {
        actionClick(addNewPetButton);
    }

    @Step("Read the owner table data")
    public Map<String, String> getOwnerTableData() {
        return readOwnerInfoTable("//h2[@id='ownerInformation']/following-sibling::table");
    }

    @Step("Read the pet table data")
    public Map<String, String> getPetTableData() {
        return readPetInfoTable("//h2[@id='petsAndVisits']/following-sibling::table");
    }
}
