package PageObjectModel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pasteBinPage {

    protected WebDriver Cdriver;
    public static final String Base_Url = "https://pastebin.com";


    public pasteBinPage(WebDriver driver) {

        Cdriver = driver;
        open();

    }
    public String getPageTitle(){
        return Cdriver.getTitle();
    }

    public void open() {
        Cdriver.get(Base_Url);
        waitForElementLocatedBy(By.id("postform-text"));
    }

    public void newPasteFill(String code) {
        WebElement codeFiled = waitForElementLocatedBy(By.id("postform-text"));
        codeFiled.sendKeys(code);
    }

    public void pasteExpirationFill(String expiration) {

        WebElement dropbox = waitForElementLocatedBy(By.id("select2-postform-expiration-container"));
        dropbox.click();

        waitForElementLocatedBy(By.xpath("//li[@class='select2-results__option'][text()='10 Minutes']")).click();
    }

    public void pasteNameTitleFill(String title) {
        WebElement fillName = waitForElementLocatedBy(By.id("postform-name"));
        fillName.sendKeys(title);

    }
    public void syntaxHighlightingFill(String fillSyntaxHighlighting){
        WebElement dropbox = waitForElementLocatedBy(By.id("select2-postform-format-container"));
        dropbox.click();

        waitForElementLocatedBy(By.xpath("//li[@class='select2-results__option'][text()='Bash']")).click();
    }


    public pasteBinResultPage createNewPasteClick() {
        WebElement clickCreateNewPaste= waitForElementLocatedBy(By.xpath("//button[@type='submit']"));
        clickCreateNewPaste.click();
        return new pasteBinResultPage(Cdriver);
    }

    protected   WebElement waitForElementLocatedBy ( By by){
        return new WebDriverWait(Cdriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
