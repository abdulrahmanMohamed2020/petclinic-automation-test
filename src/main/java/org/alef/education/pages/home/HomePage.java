package org.alef.education.pages.home;

import io.qameta.allure.Step;
import org.alef.education.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By homeImage = By.className("img-responsive");
    private final By findOwnersTab = By.xpath("//span[text()='Find owners']");
    private final By veterinariansTab = By.xpath("//span[text()='Veterinarians']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on Find Owners Tab")
    public void clickOnFindOwnersTab() {
        actionClick(findOwnersTab);
    }

    @Step("Click on Veterinarians Tab")
    public void clickOnVeterinariansTab() {
        actionClick(veterinariansTab);
    }

    @Step("Validate the Home Page Image")
    public boolean isHomeImageVisible() {
        return elementVisible(homeImage);
    }
}
