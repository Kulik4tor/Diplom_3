package stellar_burgers.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage {

    final static public String FORGOT_PASSWORD_PAGE = "https://stellarburgers.nomoreparties.site/forgot-password";

    @FindBy(xpath = ".//a[text()='Войти']")
    private SelenideElement hrefLogin;

    public void hrefLoginClick() {
        hrefLogin.click();
    }

}
