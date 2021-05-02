import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();

    @Before
    public void main(){

        System.setProperty("webdriver.chrome.driver",Utils.CHROME_DRIVER_LOCATION);

    }

    @Test
    public void startTest(){

        driver.get(Utils.BASE_URL);
        driver.manage().window().maximize();
        //check if the right page opened
        try{
            String expectedUrl = "https://www.gittigidiyor.com/";
            Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
            System.out.println("Correct Webpage Opened");
        }
        catch (Throwable pageNavigationError){
            System.out.println("Wrong Webpage Opened");
        }


        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Web web = new Web(driver);
        web.pressLoginButton();

        //i try to find xpath and css selector for second login button but i couldn't so i simulated manually to login page
        driver.get(Utils.LOGIN_URL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        web.enterEmail();
        web.enterPassword();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        web.pressSubmitButton();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(Utils.CHECK_LOGIN_URL);
        //check if login successful
        try {
            String expectedUrl = "https://www.gittigidiyor.com/BanaOzel/satin-aldiklarim.php";
            Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
            System.out.println("Login Successful");

        } catch (Throwable pageNavigationError){
            System.out.println("Login Not Successful");
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(Utils.BASE_URL);
        web.enterSearch();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        web.pressSearchButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("scrollBy(0,30000)");
        web.changePage();
        //check if second page opened
        try{
            String expectedUrl = "https://www.gittigidiyor.com/arama/?k=Bilgisayar&sf=2";
            Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
            System.out.println("Second Page Opened Successfully");
        }catch (Throwable pageNavigationError){
            System.out.println("Second Page Did Not Opened Successfully");

        }
        web.chooseRandom();
        // i scroll down because in some products with long informations add to basket button is not visible
        javascriptExecutor.executeScript("scrollBy(0,150)");
        web.addProductToBasket();
        web.priceCheck();
        web.pressCardButton();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        web.addSecondProduct();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        web.pressDeleteCart();




    }
    @After
    public void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }


}
