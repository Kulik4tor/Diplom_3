import ApiUserData.ApiRequests;
import ApiUserData.UserData;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import stellar_burgers.pageObjects.AccountPage;
import stellar_burgers.pageObjects.LoginPage;
import stellar_burgers.pageObjects.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static stellar_burgers.pageObjects.LoginPage.LOGIN_PAGE;
import static stellar_burgers.pageObjects.MainPage.MAIN_PAGE;

public class LinkToConstructorAndLogoFromPersonalAccountTest {
    MainPage mainPage;
    LoginPage loginPage;
    AccountPage accountPage;

    String name = "Kirill";
    String email = "KirillMegaTester228@mail.org";
    String password = "password007";

    @Before
    public void setUp() {
        ApiRequests apiRequests = new ApiRequests();
        UserData userData = new UserData(name, email, password);
        apiRequests.userRegistration(userData);
        loginPage = open(LOGIN_PAGE, LoginPage.class);
        loginPage.setLoginForm(email, password);
        mainPage = page(MainPage.class);
        mainPage.linkToAccInHeaderClick();
    }

    @Test
    @DisplayName("Проверка работы кнопки Конструктов в хедере")
    public void linkToConstructorCheck() {
        accountPage = page(AccountPage.class);
        accountPage.linkToConstructorClick();
        mainPage = page(MainPage.class);
        mainPage.burgerConstructorBlockCheck();
        Assert.assertEquals(WebDriverRunner.currentFrameUrl(), MAIN_PAGE + "/");
    }

    @Test
    @DisplayName("Проверка работы перехода по логотипу")
    public void logoTransferCheck() {
        accountPage = page(AccountPage.class);
        accountPage.logoClick();
        Assert.assertEquals(WebDriverRunner.currentFrameUrl(), MAIN_PAGE + "/");
    }

    @After
    public void tearDown() {
        ApiRequests deleteUser = new ApiRequests();
        UserData userData = new UserData(email, password);
        deleteUser.deleteRegisteredUser(deleteUser.getUserAccessToken(userData.getLoginInfo()));
    }
}
