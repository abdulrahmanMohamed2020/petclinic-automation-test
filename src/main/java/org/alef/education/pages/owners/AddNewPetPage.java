package org.alef.education.pages.owners;

import io.qameta.allure.Step;
import org.alef.education.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddNewPetPage extends BasePage {

    private final By petNameInputField = By.id("name");
    private final By birthDateDropDownMenu = By.id("birthDate");
    private final By monthDropDownMenu = By.className("flatpickr-monthDropdown-months");
    private final By yearInputField = By.xpath("//input[@type='number']");
    private final String dayFieldString = "//span[text()='@val']";
    private final By typeDropDownMenu = By.id("type");

    private final By addPetButton = By.xpath("//button[text()='Add Pet']");

    public AddNewPetPage(WebDriver driver) {
        super(driver);
    }

    @Step("Enter the Pet Name: {0}")
    public void enterPetName(String name) {
        typeText(petNameInputField,name);
    }

    @Step("Click on the birth date drop down")
    public void clickOnBirthDateDropDown() {
        actionClick(birthDateDropDownMenu);
    }

    @Step("Select a: {0} from type")
    public void selectType(String type) {
        selectItem(type,typeDropDownMenu);
    }

    @Step("Select {0} from months")
    public void selectMonth(String month) {
        selectItem(month,monthDropDownMenu);
    }

    @Step("Enter the year: {0}")
    public void enterYear(String year) {
        typeText(yearInputField,year);
    }

    @Step("Select {0} from days")
    public void selectDay(String day) {
        actionClick(By.xpath(dayFieldString.replace("@val",day)));
    }

    @Step("Click on Add Pet button")
    public void clickOnAddNewPetButton() {
        actionClick(addPetButton);
    }

}
