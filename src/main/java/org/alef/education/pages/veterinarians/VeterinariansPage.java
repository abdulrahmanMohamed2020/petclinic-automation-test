package org.alef.education.pages.veterinarians;

import io.qameta.allure.Step;
import org.alef.education.pages.BasePage;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class VeterinariansPage extends BasePage {

    public VeterinariansPage(WebDriver driver) {
        super(driver);
    }

    @Step("Read the table data")
    public Map<String, String> getTableData() {
        return readVeterinariansTableData("vetsTable");
    }
}
