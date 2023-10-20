package org.alef.education.tests.veterinarians;

import org.alef.education.base.BaseTestSetup;
import org.alef.education.base.CustomSoftAssert;
import org.alef.education.constants.TestData;
import org.alef.education.pages.home.HomePage;
import org.alef.education.pages.veterinarians.VeterinariansPage;
import org.testng.annotations.Test;

import java.util.Map;

public class VeterinariansTest extends BaseTestSetup {

    private HomePage homePage;
    private VeterinariansPage veterinariansPage;
    private Map<String,String> veterinariansTestData;
    private CustomSoftAssert softAssert;

    @Test(description = "Find all the Veterinarians which are added in the application")
    public void findVeterinarians() {
        softAssert = new CustomSoftAssert();
        veterinariansTestData = TestData.getVeterinariansData();

        homePage = new HomePage(getDriver());
        homePage.clickOnVeterinariansTab();

        veterinariansPage = new VeterinariansPage(getDriver());
        Map<String,String> tableDataValue = veterinariansPage.getTableData();

        for (Map.Entry<String, String> entry : tableDataValue.entrySet()) {
            softAssert.assertTrue(entry.getValue().contains(veterinariansTestData.get(entry.getKey())),
                    "This Specialty: {" + entry.getValue() +"} for this name: "+ entry.getKey()
                            + " is wrong as the data should be:" + "{"+ veterinariansTestData.get(entry.getKey())+"}");
        }

        softAssert.assertAll();
    }
}
