package PageObjectModel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class googleCloudResultsPage {

    private WebDriver Cdriver;

    public googleCloudResultsPage(WebDriver driver){
        Cdriver = driver;
        waitForElementLocatedBy(By.xpath("//*[@class='devsite-search-title']"));

    }


    public googleCloudCalculatorPage clickSearchResult() {
        waitForElementLocatedBy(By.xpath("//b[text()='Google Cloud Platform Pricing Calculator']//parent::a")).click();
        return new googleCloudCalculatorPage(Cdriver);
    }
    protected WebElement waitForElementLocatedBy (By by){
        return new WebDriverWait(Cdriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

}
