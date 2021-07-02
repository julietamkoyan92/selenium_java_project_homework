package PageObjectModel.test;

import PageObjectModel.pages.pasteBinResultPage;
import PageObjectModel.pages.pasteBinPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class pasteBinICanWinTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser(){
        driver = new ChromeDriver();
    }

    @Test
    public void createNewPasteTest() {
        

        pasteBinPage page = new pasteBinPage(driver);
        page.open();
        driver.manage().window().maximize() ;
        page.newPasteFill("Hello from WebDriver");
        page.pasteExpirationFill("10 Minutes");
        page.pasteNameTitleFill("helloweb");
        pasteBinResultPage page2 = page.createNewPasteClick();

        driver.quit();

    }

    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser(){
        driver.quit();
        driver = null;

    }

}
