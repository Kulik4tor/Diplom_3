import ApiUserData.ApiRequests;
import ApiUserData.UserData;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import stellar_burgers.pageObjects.RegisterPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static stellar_burgers.pageObjects.LoginPage.LOGIN_PAGE;
import static stellar_burgers.pageObjects.RegisterPage.REGISTER_PAGE;

public class RegistrationTest {

    String name = "Kirill";
    String email = "KirillMegaTester228@mail.org";
    String password = "password007";
    String errorPass = "sonic";
    boolean needDeleteUserData = false;
    RegisterPage registerPage;

    @Before
    public void setUp() {
        registerPage = open(REGISTER_PAGE, RegisterPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @Test
    @DisplayName("Позитивный тест регистрации")
    public void registrationUserPositiveTest() {
        registerPage = page(RegisterPage.class);
        registerPage.setDataInput(name, email, password);
        registerPage.buttonRegisterClick();
        WebDriverRunner.currentFrameUrl().equals(LOGIN_PAGE);
        needDeleteUserData = true;
    }

    @Test
    @DisplayName("Негативный тест регистрации")
    public void registrationUserWithIncorrectPassword() {
        registerPage = page(RegisterPage.class);
        registerPage.setDataInput(name, email, errorPass);
        registerPage.buttonRegisterClick();
        registerPage.checkErrorPassword();

    }

    @After
    public void tearDown() {
        if (needDeleteUserData) {
            ApiRequests deleteUser = new ApiRequests();
            UserData userData = new UserData(email, password);
            deleteUser.deleteRegisteredUser(deleteUser.getUserAccessToken(userData.getLoginInfo()));
        }
    }
}
