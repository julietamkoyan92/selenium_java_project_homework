package PageObjectModel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class googleCloudHomePage {

    private WebDriver Cdriver;
    public static final String Base_Url = "https://cloud.google.com";
    public googleCloudHomePage(WebDriver driver) {

        Cdriver = driver;
        open();
    }

    public void open() {
        Cdriver.get(Base_Url);
        waitForElementLocatedBy(By.name("q"));
    }

    public googleCloudResultsPage searchText(String text) {
        Cdriver.findElement(By.name("q")).sendKeys(text +"\n");
        return new googleCloudResultsPage(Cdriver);

    }

    protected WebElement waitForElementLocatedBy (By by){
        return new WebDriverWait(Cdriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}


