package stellar_burgers.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage {

    public static final String REGISTER_PAGE = "https://stellarburgers.nomoreparties.site/register";

    @FindBy(css = "fieldset:nth-child(1) input")
    private SelenideElement inputName;

    @FindBy(css = "fieldset:nth-child(2) input")
    private SelenideElement inputEmail;

    @FindBy(xpath = ".//input[@type='password']")
    private SelenideElement inputPassword;

    @FindBy(xpath = ".//button[text()='Зарегистрироваться']")
    private SelenideElement buttonRegister;

    @FindBy(xpath = ".//p[@class ='input__error text_type_main-default']")
    private SelenideElement inputError;

    @FindBy(xpath = ".//a[text()='Войти']")
    private SelenideElement hrefLogin;

    public void setDataInput(String name,String email,String password){
        inputName.setValue(name);
        inputEmail.setValue(email);
        inputPassword.sendKeys(password);
    }

    public void checkErrorPassword(){
        inputError.getText().equals("Некорректный пароль");
    }

    public void buttonRegisterClick(){
        buttonRegister.doubleClick();
    }

    public void hrefLoginClick(){
        hrefLogin.click();
    }

}
