package stellar_burgers.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static java.time.Duration.ofSeconds;

public class MainPage {

    final static public String MAIN_PAGE = "https://stellarburgers.nomoreparties.site";

    @FindBy(xpath = "//button[text()='Войти в аккаунт']")
    private SelenideElement buttonLoginInAcc ;

    @FindBy(xpath = ".//a[contains(@href,'/account')]")
    private SelenideElement linkToAccInHeader;

    @FindBy(xpath = "//button[text()='Оформить заказ']")
    private SelenideElement buttonMadeOrder;

    @FindBy(css = ".BurgerIngredients_ingredients__menuContainer__Xu3Mo")
    private SelenideElement burgerConstructorBlock;

    //разводящая конструктора булки
    @FindBy(xpath = ".//span[text()='Булки']" )
    private SelenideElement buttonMenuBread;

    //разводящая конструктора соусы
    @FindBy(xpath = ".//span[text()='Соусы']" )
    private SelenideElement buttonMenuSauces;

    //разводящая конструктора начинки
    @FindBy(xpath = ".//span[text()='Начинки']" )
    private SelenideElement buttonMenuToppings;

   @FindBy(css = ".tab_tab_type_current__2BEPc")
   private SelenideElement selectedMenuButton;

    @FindBy(xpath = ".//p[text()='В этом разделе вы можете изменить свои персональные данные']")
    private SelenideElement textInAccountProfile;



    public void buttonLoginInAccClick(){
        buttonLoginInAcc.click();
    }

    public void linkToAccInHeaderClick(){
        linkToAccInHeader.hover().click();
    }

    public void buttonMadeOrderCheck(){
        buttonMadeOrder.shouldBe(visible, ofSeconds(10));
    }

    public void buttonLogInInAccCheck(){
        buttonLoginInAcc.shouldBe(visible);
    }

    public void burgerConstructorBlockCheck(){
        burgerConstructorBlock.shouldBe(visible);
    }

    public void buttonMenuToppingsCheck(){
        buttonMenuToppings.click();
        Assert.assertEquals(selectedMenuButton.find(By.cssSelector("span")).getText(),buttonMenuToppings.getText());
    }

    public void buttonMenuSaucesCheck(){
        buttonMenuSauces.click();
        Assert.assertEquals(selectedMenuButton.find(By.cssSelector("span")).getText(),buttonMenuSauces.getText());
    }

    public void buttonMenuBreadCheck(){
        buttonMenuToppings.click();
        buttonMenuBread.click();
        Assert.assertEquals(selectedMenuButton.find(By.cssSelector("span")).getText(),buttonMenuBread.getText());
    }
}
