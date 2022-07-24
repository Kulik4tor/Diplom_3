import ApiUserData.ApiRequests;
import ApiUserData.UserData;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import stellar_burgers.pageObjects.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static stellar_burgers.pageObjects.AccountPage.ACCOUNT_PAGE_AUTHORIZED;
import static stellar_burgers.pageObjects.LoginPage.LOGIN_PAGE;
import static stellar_burgers.pageObjects.MainPage.MAIN_PAGE;

public class PersonalAccountTransferTest {

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
    }

    @Test
    @DisplayName("Проверка работы перехода в личный кабинет")
    public void personalAccountTransferFromMainPage() {
        mainPage = open(MAIN_PAGE, MainPage.class);
        mainPage.linkToAccInHeaderClick();
        accountPage = page(AccountPage.class);
        accountPage.textInAccountCheck();
        Assert.assertEquals(WebDriverRunner.currentFrameUrl(), ACCOUNT_PAGE_AUTHORIZED);
    }

    @After
    public void tearDown() {
        ApiRequests deleteUser = new ApiRequests();
        UserData userData = new UserData(email, password);
        deleteUser.deleteRegisteredUser(deleteUser.getUserAccessToken(userData.getLoginInfo()));
    }
}
