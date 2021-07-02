package PageObjectModel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class googleCloudCalculatorPage {
    private WebDriver Cdriver;

    public googleCloudCalculatorPage(WebDriver driver){
        Cdriver = driver;
        waitForElementLocatedBy(By.xpath("//*[@class='md-toolbar-tools flex-gt-sm-50']"));
    }


    public void fillRequiredFields(String nOfInstances,
                                                        String operatingSystems,
                                                        String wmClass,
                                                        String nodeType,
                                                        String numberOfGPU,
                                                        String gPUType,
                                                        String localSSD,
                                                        String dataCenter,
                                                        String commitedUsage) {
        Cdriver.switchTo().frame(0);
        Cdriver.switchTo().frame(0);


        Cdriver.findElement(By.id("input_65")).sendKeys(nOfInstances);
        Cdriver.findElement(By.id("select_77")).click();
        Cdriver.findElement(By.xpath("//*[contains(text(), '" + operatingSystems + "')]//parent::md-option")).click();

        Cdriver.findElement(By.id("select_81")).sendKeys(wmClass);
        Cdriver.findElement(By.id("select_89")).sendKeys("N1");


        Cdriver.findElement(By.id("select_91")).click();
        Cdriver.findElement(By.xpath("//*[contains(text(), '" + nodeType + "')]//parent::md-option")).click();
        //waitForElementLocatedBy(By.xpath());

        Cdriver.findElement(By.xpath("//*[@class='md-label'][contains(text(), 'Add GPUs.')]")).click();
        //waitForElementLocatedBy(By.xpath());

        Cdriver.findElement(By.xpath("//md-select[@placeholder='Number of GPUs']")).sendKeys(numberOfGPU);
        Cdriver.findElement(By.xpath("//md-select[@placeholder='GPU type']")).click();
        //waitForElementLocatedBy(By.xpath());

        Cdriver.findElement(By.xpath("//*[contains(text(), '" + gPUType + "')]//parent::md-option")).click();
        //waitForElementLocatedBy(By.xpath());

        Cdriver.findElement(By.xpath("//md-select[@placeholder='Local SSD']")).click();
        //waitForElementLocatedBy(By.xpath());

        Cdriver.findElement(By.xpath("//*[contains(text(), '" + localSSD + "')]//parent::md-option")).click();
        //waitForElementLocatedBy(By.xpath());

        Cdriver.findElement(By.id("select_93")).click();
        //waitForElementLocatedBy(By.xpath());

        Cdriver.findElements(By.xpath("//*[contains(text(), '" + dataCenter + "')]//parent::md-option")).get(2).click();
        //waitForElementLocatedBy(By.xpath());

        Cdriver.findElement(By.id("select_100")).click();
        //waitForElementLocatedBy(By.xpath());

        Cdriver.findElements(By.xpath("//*[contains(text(), '" + commitedUsage + "')]//parent::md-option")).get(1).click();
        //waitForElementLocatedBy(By.xpath());





    }

    public googleCloudEstimatePage addToEstimate() {
//        Cdriver.findElement(By.xpath("//button[@aria-label='Add to Estimate'][not(@disabled = 'disabled')]")).click();
        waitForElementLocatedBy(By.xpath("//button[@aria-label='Add to Estimate'][not(@disabled = 'disabled')]")).click();
        return new googleCloudEstimatePage(Cdriver);
    }

    protected WebElement waitForElementLocatedBy (By by){
        return new WebDriverWait(Cdriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}

