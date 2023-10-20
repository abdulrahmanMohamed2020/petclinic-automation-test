package org.alef.education.pages.owners;

import io.qameta.allure.Step;
import org.alef.education.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class OwnersPage extends BasePage {

    private final By findOwnerButton = By.xpath("//form[@id='search-owner-form']//button");
    private final By addOwnerButton = By.xpath("//a[text()='Add Owner']");

    public OwnersPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on Find Owner button")
    public void clickOnFindOwnerButton() {
        actionClick(findOwnerButton);
    }

    @Step("Click on Add Owner button")
    public void clickOnAddOwnerButton() {
        actionClick(addOwnerButton);
    }

    @Step("Read the table data")
    public Map<String, String[]> getTableData() {
        return readOwnersTableData("ownersTable");
    }
}
