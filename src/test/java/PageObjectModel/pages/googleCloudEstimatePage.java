package PageObjectModel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class googleCloudEstimatePage {
    protected WebDriver Cdriver;
    public googleCloudEstimatePage(WebDriver driver ){
        Cdriver = driver;
        waitForElementLocatedBy(By.xpath("//*[@class='md-toolbar-tools flex-gt-sm-50']"));
    }
    public String getWmClass() {

        return  Cdriver.findElements(By.xpath("//div[@class = 'md-list-item-text ng-binding']")).get(1).getText();
    }
    public String getInstanceType() {

        return  Cdriver.findElements(By.xpath("//div[@class = 'md-list-item-text ng-binding']")).get(2).getText();
    }
    public String getRegion() {

        return  Cdriver.findElements(By.xpath("//div[@class = 'md-list-item-text ng-binding']")).get(3).getText();
    }
    public String getLocalSSD() {

        return  Cdriver.findElements(By.xpath("//div[@class = 'md-list-item-text ng-binding']")).get(4).getText();

    }
    public String getCommitmentTerm() {

        return  Cdriver.findElements(By.xpath("//div[@class = 'md-list-item-text ng-binding']")).get(5).getText();

    }
    public String getTotalCost(){
       String costText = Cdriver.findElement(By.xpath("//*[contains(text(),'Total Estimated Cost')]")).getText();
        Pattern p = Pattern.compile("-?\\d+(,\\d+)*?\\.?\\d+\\d+?");
        Matcher m = p.matcher(costText);
        m.find();
        return m.group();
    }

    protected WebElement waitForElementLocatedBy (By by){
        return new WebDriverWait(Cdriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
