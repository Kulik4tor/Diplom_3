import ApiUserData.ApiRequests;
import ApiUserData.UserData;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import stellar_burgers.pageObjects.ForgotPasswordPage;
import stellar_burgers.pageObjects.LoginPage;
import stellar_burgers.pageObjects.MainPage;
import stellar_burgers.pageObjects.RegisterPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static java.lang.Thread.sleep;
import static stellar_burgers.pageObjects.ForgotPasswordPage.FORGOT_PASSWORD_PAGE;
import static stellar_burgers.pageObjects.MainPage.MAIN_PAGE;
import static stellar_burgers.pageObjects.RegisterPage.REGISTER_PAGE;

public class LoginButtonsTest {

    MainPage mainPage;
    RegisterPage registerPage;
    ForgotPasswordPage forgotPasswordPage;
    LoginPage loginPage;

    String name = "Kirill";
    String email = "KirillMegaTester228@mail.org";
    String password = "password007";

    @Before
    public void setUp() throws InterruptedException {
        ApiRequests apiRequests = new ApiRequests();
        UserData userData = new UserData(name, email, password);
        apiRequests.userRegistration(userData);
        sleep(3000);
    }

    @Test
    @DisplayName("Логин через кнопку 'Войти'")
    public void loginByButtonLoginInAccOnMainPage() {
        mainPage = open(MAIN_PAGE, MainPage.class);
        mainPage.buttonLoginInAccClick();
        loginPage = page(LoginPage.class);
        loginPage.setLoginForm(email, password);
        mainPage.buttonMadeOrderCheck();
    }

    @Test
    @DisplayName("Логин через кнопку личный кабинет")
    public void loginByButtonPersonalAccountOnMainPage() {
        mainPage = open(MAIN_PAGE, MainPage.class);
        mainPage.linkToAccInHeaderClick();
        loginPage = page(LoginPage.class);
        loginPage.setLoginForm(email, password);
        mainPage.buttonMadeOrderCheck();
    }

    @Test
    @DisplayName("Логин с формы регистрации")
    public void loginByButtonOnRegisterPage() {
        registerPage = open(REGISTER_PAGE, RegisterPage.class);
        registerPage.hrefLoginClick();
        loginPage = page(LoginPage.class);
        loginPage.setLoginForm(email, password);
        mainPage = page(MainPage.class);
        mainPage.buttonMadeOrderCheck();
    }

    @Test
    @DisplayName("Логин с формы забыли пароль")
    public void loginByButtonOnForgotPasswordPage() {
        forgotPasswordPage = open(FORGOT_PASSWORD_PAGE, ForgotPasswordPage.class);
        forgotPasswordPage.hrefLoginClick();
        loginPage = page(LoginPage.class);
        loginPage.setLoginForm(email, password);
        mainPage = page(MainPage.class);
        mainPage.buttonMadeOrderCheck();
    }


    @After
    public void tearDown() {
        ApiRequests deleteUser = new ApiRequests();
        UserData userData = new UserData(email, password);
        deleteUser.deleteRegisteredUser(deleteUser.getUserAccessToken(userData.getLoginInfo()));
    }
}
