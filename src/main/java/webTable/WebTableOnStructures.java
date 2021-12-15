package webTable;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

class WebTableOnStructures extends DataProvider {
    WebDriver driver;

    public void openUrl() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
    }

    public void verifyTheStructureCount() {
        System.out.println("Verifying structures count with the value in total column:\n");
        List<WebElement> structure = driver.findElements(By.cssSelector
                (".tsc_table_s13 > tbody> tr > th"));
        int actualStructureCount = structure.size();
        WebElement expectedStructureCountElement = driver.findElement(By.cssSelector
                (".tsc_table_s13 > tfoot> tr > td"));
        int expectedStructureCount = Integer.parseInt(expectedStructureCountElement
                .getText().replace(" buildings", ""));
        if (actualStructureCount == expectedStructureCount) {
            System.out.println("Expected Count: " + expectedStructureCount);
            System.out.println("Actual Count: " + actualStructureCount);
            System.out.println("Expected Count = Actual Count");
        } else {
            System.out.println("Expected Count: " + expectedStructureCount);
            System.out.println("Actual Count: " + actualStructureCount);
            System.out.println("Expected Count != Actual Count");
        }
        System.out.println("---------------------------------------------------------------");
    }

    public void printTheTableValues() {
        System.out.println("Printing table values row wise:\n");
        List<WebElement> tableHead = driver.findElements(By.cssSelector(".tsc_table_s13 > thead> tr > th"));
        List<WebElement> tableBody = driver.findElements(By.cssSelector(".tsc_table_s13 > tbody> tr"));
        List<WebElement> tableFoot = driver.findElements(By.cssSelector(".tsc_table_s13 > tfoot> tr > *"));

        for (WebElement headElement : tableHead) {
            System.out.print(headElement.getText() + "  ");
        }
        System.out.println();
        for (WebElement rowInTableBody : tableBody) {
            List<WebElement> columnsInBodyRow = rowInTableBody.findElements(By.cssSelector("*"));
            for (WebElement column : columnsInBodyRow) {
                System.out.print(column.getText() + "  ");
            }
            System.out.println();
        }
        for (WebElement footElement : tableFoot) {
            System.out.print(footElement.getText() + "  ");
        }
        System.out.println();
        System.out.println("---------------------------------------------------------------");
    }

    public void findStructureHeight() {
        System.out.println("Finding the height of the structure given by user:");
        List<WebElement> listOfStructures = driver.findElements(By.cssSelector
                (".tsc_table_s13 > tbody> tr > th"));
        List<WebElement> listOfStructureHeights = driver.findElements(By.cssSelector
                (".tsc_table_s13 > tbody> tr > td:nth-child(4)"));
        int numberOfStructures = listOfStructures.size();
        String heightOfTheStructure;
        for (int structureIndex = 0; structureIndex < numberOfStructures; structureIndex++) {
            String structureName = listOfStructures.get(structureIndex).getText();
            if (structureName.equals(getStructureName())) {
                heightOfTheStructure = listOfStructureHeights.get(structureIndex).getText();
                System.out.println("Height of " + structureName + " is " + heightOfTheStructure);
                break;
            }
        }
        System.out.println("---------------------------------------------------------------");
    }

    public void verifySixthRowHasTwoColumns() {
        System.out.println("Verifying column count in 6th row:\n");
        int actualColumnCount = driver.findElements(By.cssSelector
                (".tsc_table_s13 > tfoot > tr > *")).size();
        System.out.println("Expected Column Count in 6th Row: " + getExpectedColumnCountInSixthRow());
        System.out.println("Actual Size: " + actualColumnCount);
        if (getExpectedColumnCountInSixthRow() == actualColumnCount) {
            System.out.println("Expected Count = Actual Count");
        } else {
            System.out.println("Expected Count != Actual Count");
        }
        System.out.println("---------------------------------------------------------------");
    }

    public void closeTheBrowser() {
        driver.quit();
    }
}
