package PageObjectModel.test;

import PageObjectModel.pages.pasteBinPage;
import PageObjectModel.pages.pasteBinResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class pasteBinBringItOnTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser(){
        driver = new ChromeDriver();
    }

    @Test
    public void createNewPasteTest() {
        pasteBinPage element = new pasteBinPage(driver);
        driver.manage().window().maximize() ;
        element.syntaxHighlightingFill("Bash");
        element.newPasteFill("git config --global user.name  \"New Sheriff in Town\"\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                        "git push origin master --force");

        element.pasteExpirationFill("10 Minutes");
        element.pasteNameTitleFill("how to gain dominance among developers");
        pasteBinResultPage page2 = element.createNewPasteClick();

        Assert.assertTrue(page2.getBrowserTitle().contains("how to gain dominance among developers"));
        Assert.assertEquals("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force", page2.getPastedText());

        driver.quit();

    }

    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser(){
        driver.quit();
        driver = null;

    }

}
