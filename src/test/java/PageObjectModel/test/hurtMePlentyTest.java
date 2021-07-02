package PageObjectModel.test;

import PageObjectModel.pages.googleCloudCalculatorPage;
import PageObjectModel.pages.googleCloudEstimatePage;
import PageObjectModel.pages.googleCloudHomePage;
import PageObjectModel.pages.googleCloudResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class hurtMePlentyTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser(){
        driver = new ChromeDriver();
    }

    @Test
    public void commonGoogleCloudFill() {
        googleCloudHomePage home = new googleCloudHomePage(driver);
        googleCloudResultsPage searchResultsPage = home.searchText("Google Cloud Platform Pricing Calculator");
        driver.manage().window().maximize();


        googleCloudCalculatorPage cloudPricingCalculator = searchResultsPage.clickSearchResult();
        cloudPricingCalculator.fillRequiredFields("4",
                "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS",
                "Regular",
                "n1-standard-8 (vCPUs: 8, RAM: 30GB)",
                "1",
                "NVIDIA Tesla V100",
                "2x375 GB",
                "Frankfurt (europe-west3)",
                "1 Year");
        googleCloudEstimatePage estimatePage = cloudPricingCalculator.addToEstimate();

        Assert.assertEquals("VM class: regular", estimatePage.getWmClass());
        Assert.assertEquals("Instance type: n1-standard-8", estimatePage.getInstanceType());
        Assert.assertEquals("Region: Frankfurt", estimatePage.getRegion());
        Assert.assertEquals("Total available local SSD space 2x375 GiB", estimatePage.getLocalSSD());
        Assert.assertEquals("Commitment term: 1 Year", estimatePage.getCommitmentTerm());
        Assert.assertEquals("1,082.77", estimatePage.getTotalCost());

        driver.quit();

    }

    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser(){
        driver.quit();
        driver = null;

    }

}
