import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args) {
        // ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "The Latest News author and image check")
    public static void latestNews1(){
        driver.get(Utils.BASE_URL);
        WebForm webForm = new WebForm(driver);
        Assert.assertEquals(webForm.getArticle(),webForm.getAuthor());
        Assert.assertEquals(webForm.getArticle(),webForm.getPicture());
    }
    @Test(testName = "The Latest News browser and links verify")
    public static void latestNews2(){
        driver.get(Utils.BASE_URL);
        WebForm webForm = new WebForm(driver);
        webForm.clickFirstArticle();
        Assert.assertEquals(webForm.getBrowserTitle(),webForm.getArticleTitle());
        Assert.assertEquals(webForm.linkVerify(),0);
    }

    @AfterSuite
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}