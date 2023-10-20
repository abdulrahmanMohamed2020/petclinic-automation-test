package org.alef.education.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasePage {

    protected WebDriver driver;
    private WebDriverWait driverWait;
    private static final Duration TIMEOUT = Duration.ofSeconds(5);
    private static final Duration POLLING_TIMEOUT = Duration.ofMillis(200);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        driverWait = new WebDriverWait(driver, TIMEOUT);
    }

    public BasePage(WebDriver driver, Duration timeout) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, timeout);
    }

    public WebElement findElement(By locator) {
        Wait<WebDriver> wait = getFluentWait();
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public boolean elementVisible(By locator) {
        scrollToElement(findElement(locator));
        boolean flag;
        try {
            WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            flag = true;
        } catch (Exception ex) {
            flag = false;
        }
        return flag;
    }

    public void actionClick(By locator) {
        WebElement element = findElement(locator);
        scrollToElement(element);

        driverWait.until(ExpectedConditions.visibilityOf(element));
        driverWait.until(ExpectedConditions.elementToBeClickable(element));
        try {
            element.click();
        } catch (StaleElementReferenceException ex) {
            findElement(locator).click();
        }
    }

    public void typeText(By locator, String text) {
        WebElement element = findElement(locator);

        try {
            scrollToElement(element);

            driverWait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(text);
        } catch (StaleElementReferenceException ex) {
            findElement(locator).clear();
            findElement(locator).sendKeys(text);
        }
    }

    public void selectItem(String item, By dropDown) {

        // Create a Select object with the dropdown element
        Select select = new Select(driver.findElement(dropDown));
        // Select an option by value
        select.selectByVisibleText(item);
    }

    protected void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    private Wait<WebDriver> getFluentWait() {
        return new FluentWait<>(driver)
                .withTimeout(TIMEOUT)
                .pollingEvery(POLLING_TIMEOUT)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
    }

    public Map<String, String> readVeterinariansTableData(String locator) {

        WebElement table = driver.findElement(By.id(locator));

        Map<String, String> tableData = new HashMap<>();

        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (int i = 1; i < rows.size(); i++) {
            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));

            if (columns.size() >= 2) {
                String key = columns.get(0).getText();
                String value = columns.get(1).getText();
                tableData.put(key, value);
            }
        }

          // Print the data in the map
//        for (Map.Entry<String, String> entry : tableData.entrySet()) {
//            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
//        }
        return tableData;
    }

    public Map<String, String[]> readOwnersTableData(String locator) {
        WebElement table = driver.findElement(By.id(locator));

        Map<String, String[]> dataMap = new HashMap<>();

        for (WebElement row : table.findElements(By.tagName("tr"))) {
            List<WebElement> columns = row.findElements(By.tagName("td"));

            if (columns.size() >= 5) {
                String name = columns.get(0).getText();
                String address = columns.get(1).getText();
                String city = columns.get(2).getText();
                String telephone = columns.get(3).getText();
                String pets = columns.get(4).getText();

                String[] details = {address, city, telephone, pets};

                dataMap.put(name, details);
            }
        }

//        for (Map.Entry<String, String[]> entry : dataMap.entrySet()) {
//            String name = entry.getKey();
//            String[] details = entry.getValue();
//            System.out.println(name + " = [" + details[0] + ", " + details[1] + ", " + details[2] + ", " + details[3] + "]");
//        }
        return dataMap;
    }

    public Map<String, String> readOwnerInfoTable(String locatorStr) {

        WebElement table = driver.findElement(By.xpath(locatorStr));

        Map<String, String> tableData = new HashMap<>();

        for (WebElement row : table.findElements(By.tagName("tr"))) {
            WebElement header = row.findElement(By.tagName("th"));
            WebElement cell = row.findElement(By.tagName("td"));
            String key = header.getText();
            String value = cell.getText();
            tableData.put(key, value);
        }

//           Print the extracted data
//        for (Map.Entry<String, String> entry : tableData.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }

        return tableData;
    }

    public Map<String, String> readPetInfoTable(String locatorStr) {

        WebElement table = driver.findElement(By.xpath(locatorStr));
        Map<String, String> tableData = new HashMap<>();

        // Extract the data from the table
        WebElement nameElement = table.findElement(By.xpath("//dd[1]"));
        WebElement birthDateElement = table.findElement(By.xpath("//dd[2]"));
        WebElement typeElement = table.findElement(By.xpath("//dd[3]"));

        tableData.put("Name",nameElement.getText());
        tableData.put("Birth Date",birthDateElement.getText());
        tableData.put("Type",typeElement.getText());

        return tableData;
    }
}
