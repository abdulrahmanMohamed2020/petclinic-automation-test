package org.alef.education.tests.owners;

import org.alef.education.base.BaseTestSetup;
import org.alef.education.base.CustomSoftAssert;
import org.alef.education.constants.TestData;
import org.alef.education.pages.home.HomePage;
import org.alef.education.pages.owners.OwnersPage;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Map;

public class OwnersTest extends BaseTestSetup {

    private HomePage homePage;
    private OwnersPage ownersPage;
    private Map<String,String[]> ownersTestData;
    private CustomSoftAssert softAssert;

    @Test(description = "Find all the existing owners which are added in application")
    public void findOwners() {
        softAssert = new CustomSoftAssert();
        ownersTestData = TestData.getOwnersData();

        homePage = new HomePage(getDriver());
        homePage.clickOnFindOwnersTab();

        ownersPage = new OwnersPage(getDriver());
        ownersPage.clickOnFindOwnerButton();
        Map<String, String[]> tableDataValue = ownersPage.getTableData();

        for (Map.Entry<String, String[]> entry : ownersTestData.entrySet()) {
            String name = entry.getKey();
            String[] details = entry.getValue();

            softAssert.assertEquals(Arrays.toString(tableDataValue.get(name)),Arrays.toString(details),
                    "The data for this name: {"+name+"} is wrong");
        }

        softAssert.assertAll();
    }
}
