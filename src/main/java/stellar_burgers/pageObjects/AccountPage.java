package stellar_burgers.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static java.time.Duration.ofSeconds;

public class AccountPage {
    final static public String ACCOUNT_PAGE_AUTHORIZED = "https://stellarburgers.nomoreparties.site/account/profile";

    @FindBy(xpath = ".//p[text()='В этом разделе вы можете изменить свои персональные данные']")
    private SelenideElement textInAccountProfile;

    @FindBy(xpath = ".//p[text()='Конструктор']")
    private SelenideElement linkToConstructor;

    @FindBy(xpath = ".//div[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement logo;

    @FindBy(xpath = "//button[text()='Выход']")
    private SelenideElement buttonLogOut;



    public void textInAccountCheck(){
        textInAccountProfile.shouldBe(visible, ofSeconds(5));
    }

    public void linkToConstructorClick(){
        linkToConstructor.click();
    }

    public void logoClick(){
        logo.click();
    }

    public void logOutButtonClick(){
        buttonLogOut.click();
    }
}
