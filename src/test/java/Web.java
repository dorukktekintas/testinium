import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;


public class Web  extends PageObject{

    private final String EMAIL = "tekintasdoruk@gmail.com";
    private final String PASSWORD = "03091997ert";
    private final String SEARCH = "Bilgisayar";

    @FindBy(xpath = "//div[@class='gekhq4-5 grTfZj']")
    private WebElement login_field;

    @FindBy(xpath = "//header/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/a[1][@class='sc-84am1q-0 sc-1r48nyr-0 gpYIaK']")
    private WebElement cart;

    @FindBy(xpath = "//*/div[1]/div[4]/div/div[2]/select/option[2]")
    private WebElement addQuantity;

    @FindBy(xpath = "//*/div[1]/div[3]/div/div[2]/div/a[1]")
    private WebElement deleteCart;







    @FindBy(id = "L-UserNameField")
    private WebElement email_field;

    @FindBy(id = "L-PasswordField")
    private WebElement password_field;

    @FindBy(id = "gg-login-enter")
    private WebElement submit_button;

    @FindBy(id="add-to-basket")
    private WebElement add_to_basket;

    @FindBy(css = "header.sc-1ycxyu1-0.hTdDsg div.u0iwlj-0.jdHemr div.sc-1yvp483-0.jUYNgf div.sc-1nx8ums-0.fXQfgp:nth-child(2) form:nth-child(1) div.sc-1yew439-0.gKMWDJ div.sc-1yew439-3.bxSoKG div.sc-4995aq-4.dNPmGY:nth-child(2) > input.sc-4995aq-0.sc-14oyvky-0.itMXHg")
    private WebElement search_field_css;


    @FindBy(xpath = "/html/body/div[2]/header/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input[@class='sc-4995aq-0 sc-14oyvky-0 itMXHg']")
    private WebElement search_field;

    @FindBy(xpath = "//*[@class='qjixn8-0 sc-1bydi5r-0 hKfdXF']")
    private WebElement search_button;

    @FindBy(xpath = "//a[contains(text(),'2')]")
    private WebElement page2;

    public Web(WebDriver driver){
        super(driver);
    }


    public void pressLoginButton(){
        this.login_field.click();
    }

    public void pressCardButton(){
        this.cart.click();
    }



    public void enterEmail(){
        this.email_field.sendKeys(EMAIL);
    }

    public void enterPassword(){
        this.password_field.sendKeys(PASSWORD);
    }

    public void pressSubmitButton(){
        this.submit_button.click();
    }

    public void addProductToBasket(){
        this.add_to_basket.click();
    }

    public void enterSearch(){
       WebDriverWait wait = new WebDriverWait(driver,10);
       search_field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("/html/body/div[2]/header/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input[@class='sc-4995aq-0 sc-14oyvky-0 itMXHg']")));
       this.search_field.sendKeys(SEARCH);
    }

    public void pressSearchButton(){
        this.search_button.click();
    }

    public void changePage(){
        this.page2.click();
    }

    public void chooseRandom(){
        List<WebElement> randomProduct = driver.findElements(By.xpath("//ul/li[@product-index>0]"));
        int maxProduct = randomProduct.size();
        Random random = new Random();
        int randomProducts = random.nextInt(maxProduct);
        randomProduct.get(randomProducts).click();
    }

    public void priceCheck(){
        String lowPrice = driver.findElement(By.id("sp-price-lowPrice")).getText();
        String highPrice = driver.findElement(By.id("sp-price-highPrice")).getText();
        String priceInCart = driver.findElement(By.className("product-new-price")).getText();


        if(lowPrice.equals(priceInCart)){
            System.out.println("Price in Page and Price in Cart have same amount");
        }else if(highPrice.equals(priceInCart)){
            System.out.println("Price in Page and Price in Cart have same amount");
        }




    }
    public void addSecondProduct(){
        this.addQuantity.click();
        System.out.println("Second Product added");
    }

    public void pressDeleteCart(){
        this.deleteCart.click();
        System.out.println("All Products removed");

    }


}
