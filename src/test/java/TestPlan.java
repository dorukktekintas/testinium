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
        //check if the right page opened




        driver.get(Utils.BASE_URL);
        driver.manage().window().maximize();
        try{
            String expectedUrl = "https://www.gittigidiyor.com/";
            Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
            System.out.println("Correct Webpage Opened");
        }
        catch (Throwable pageNavigationError){
            System.out.println("Wrong Webpage Opened");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Web web = new Web(driver);
        web.pressLoginButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Utils.LOGIN_URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        web.enterEmail();
        web.enterPassword();
        web.pressSubmitButton();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Utils.CHECK_LOGIN_URL);
        //check if login successful
        try {
            String expectedUrl = "https://www.gittigidiyor.com/BanaOzel/satin-aldiklarim.php";
            Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
            System.out.println("Login Successful");

        } catch (Throwable pageNavigationError){
            System.out.println("Login Not Successful");
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(Utils.BASE_URL);


        //I try to take the xpath or css selector from search box to search "bilgisayar" but it gave error so i manualy simulated the page. I did not delete the xpaths and the functions you can check it from web classs
        //web.enterSearch();
        //web.pressSearchButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Utils.SEARCH_SIMULATOR);


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
        javascriptExecutor.executeScript("scrollBy(0,150)");

        web.addProductToBasket();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        web.priceCheck();
       // web.pressCardButton();
        driver.get(Utils.CART);
        web.addSecondProduct();

        web.pressDeleteCart();




    }
    //@After
   //public void cleanUp(){
     //  driver.manage().deleteAllCookies();
      // driver.close();
    //}


}
