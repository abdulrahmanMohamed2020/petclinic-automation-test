package org.alef.education.tests.home;

import org.alef.education.base.BaseTestSetup;
import org.alef.education.pages.home.HomePage;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

public class HomeTest extends BaseTestSetup {

    private HomePage homePage;

    @Test(description = "Verify image on home page is visible")
    public void verifyHomeImage() {
        homePage = new HomePage(getDriver());

        assertTrue(homePage.isHomeImageVisible(),"The home page image is not visible or broken");
    }
}
