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
        int maxProducts = randomProduct.size();
        Random random = new Random(47);
        int randomProducts = random.nextInt(maxProducts);
        randomProduct.get(randomProducts).click();
    }


}
