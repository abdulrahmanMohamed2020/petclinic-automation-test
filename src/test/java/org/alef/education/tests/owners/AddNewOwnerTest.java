package org.alef.education.tests.owners;

import org.alef.education.base.BaseTestSetup;
import org.alef.education.base.CustomSoftAssert;
import org.alef.education.constants.TestData;
import org.alef.education.pages.home.HomePage;
import org.alef.education.pages.owners.AddNewOwnerPage;
import org.alef.education.pages.owners.AddNewPetPage;
import org.alef.education.pages.owners.OwnersPage;
import org.testng.annotations.Test;

import java.util.Map;

public class AddNewOwnerTest extends BaseTestSetup {

    private HomePage homePage;
    private OwnersPage ownersPage;
    private AddNewOwnerPage addNewOwnerPage;
    private AddNewPetPage addNewPetPage;
    private Map<String,String> ownersTestData;
    private Map<String,String> petTestData;
    private CustomSoftAssert softAssert;

    @Test(description = "Check all the information added for the newly created owner and pet is correct")
    public void verifyNewlyAddedOwnerAndPet() {
        softAssert = new CustomSoftAssert();
        ownersTestData = TestData.generateOwnerTestData();
        petTestData = TestData.generatePetTestData();

        homePage = new HomePage(getDriver());
        homePage.clickOnFindOwnersTab();

        ownersPage = new OwnersPage(getDriver());
        ownersPage.clickOnAddOwnerButton();

        // Add New Owner
        addNewOwnerPage = new AddNewOwnerPage(getDriver());
        fillOwnerForm();
        addNewOwnerPage.clickOnAddNewPetButton();

        // Add New Pet
        addNewPetPage = new AddNewPetPage(getDriver());
        fillPetForm();

        Map<String, String> ownerInfo = addNewOwnerPage.getOwnerTableData();

        // Check all the information added for the newly created owner
        validateOwnerInfo(ownerInfo);

        // Check all the information added for the newly created pet is correct
        Map<String, String> petInfo = addNewOwnerPage.getPetTableData();
        validatePetInfo(petInfo);

        softAssert.assertAll();
    }

    private void fillOwnerForm() {

        addNewOwnerPage.enterFirstName(ownersTestData.get("firstName"));
        addNewOwnerPage.enterLastName(ownersTestData.get("lastName"));
        addNewOwnerPage.enterAddress(ownersTestData.get("address"));
        addNewOwnerPage.enterCity(ownersTestData.get("city"));
        addNewOwnerPage.enterTelephone(ownersTestData.get("telephone"));
        addNewOwnerPage.clickOnAddOwnerButton();
    }

    private void fillPetForm() {
        addNewPetPage.enterPetName(petTestData.get("name"));
        addNewPetPage.clickOnBirthDateDropDown();
        addNewPetPage.selectMonth(petTestData.get("month"));
        addNewPetPage.enterYear(petTestData.get("year"));
        addNewPetPage.selectDay(petTestData.get("day"));
        addNewPetPage.selectType(petTestData.get("petType"));

        addNewPetPage.clickOnAddNewPetButton();
    }

    private void validateOwnerInfo(Map<String, String> ownerInfo) {
        softAssert.assertEquals(ownerInfo.get("Name"),
                ownersTestData.get("firstName") +" "+ownersTestData.get("lastName"),
                "The owner Name is wrong");

        softAssert.assertEquals(ownerInfo.get("Address"),ownersTestData.get("address"),
                "The owner Address is wrong");

        softAssert.assertEquals(ownerInfo.get("City"),ownersTestData.get("city"),
                "The owner City is wrong");

        softAssert.assertEquals(ownerInfo.get("Telephone"),ownersTestData.get("telephone"),
                "The owner Telephone is wrong");
    }

    private void validatePetInfo(Map<String, String> petInfo) {
        softAssert.assertEquals(petInfo.get("Name"),
                petTestData.get("name"),
                "The pet Name is wrong");

        softAssert.assertTrue(petInfo.get("Birth Date").contains(
                petTestData.get("year")+"-"+petTestData.get("monthIndex")+"-"+petTestData.get("day")),
                "The pet Birth Date is wrong");

        softAssert.assertEquals(petInfo.get("Type"),
                petTestData.get("petType"),
                "The pet Type is wrong");

    }
}
