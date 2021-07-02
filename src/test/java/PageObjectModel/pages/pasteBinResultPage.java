package PageObjectModel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pasteBinResultPage {
    protected WebDriver Cdriver;

    public pasteBinResultPage(WebDriver driver) {
        Cdriver = driver;
        waitForElementLocatedBy(By.xpath("//*[@class='notice -success -post-view']"));
    }

    public String getBrowserTitle(){
        return Cdriver.getTitle();
    }

    public String getPastedText() {
        return waitForElementLocatedBy(By.xpath("//*[@class='textarea']")).getText();

    }
    protected WebElement waitForElementLocatedBy (By by){
        return new WebDriverWait(Cdriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
