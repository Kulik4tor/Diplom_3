package stellar_burgers.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static java.time.Duration.ofSeconds;

public class LoginPage {
    final static public String LOGIN_PAGE = "https://stellarburgers.nomoreparties.site/login";

    @FindBy(how = How.XPATH, using = ".//input[@type='text']")
    private SelenideElement inputEmail;

    @FindBy(how = How.XPATH, using = ".//input[@type='password']")
    private SelenideElement inputPassword;

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement buttonSubmit;

    @FindBy(xpath = "//button[text()='Оформить заказ']")
    private SelenideElement buttonMadeOrder;


    public void setInputEmail(String email) {
        inputEmail.shouldBe(visible);
        inputEmail.sendKeys(email);
    }

    public void setInputPassword(String password) {
        inputPassword.shouldBe(visible);
        inputPassword.setValue(password);
    }

    public void clickSubmitButton() {
        buttonSubmit.click();
    }

    public void setLoginForm(String email, String password) {
        setInputEmail(email);
        setInputPassword(password);
        clickSubmitButton();
        buttonMadeOrder.shouldBe(visible, ofSeconds(10));
    }

    public void unauthorizedCheck() {
        inputEmail.shouldBe(visible);
        inputPassword.shouldBe(visible);
    }

}
