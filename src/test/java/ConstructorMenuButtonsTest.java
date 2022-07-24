import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import stellar_burgers.pageObjects.MainPage;

import static com.codeborne.selenide.Selenide.open;

import static stellar_burgers.pageObjects.MainPage.MAIN_PAGE;

public class ConstructorMenuButtonsTest {

    @Test
    @DisplayName("Проверка работы пункта меню Булка")
    public void menuBreadCheck(){
        MainPage mainPage = open(MAIN_PAGE, MainPage.class);
        mainPage.buttonMenuBreadCheck();
    }

    @Test
    @DisplayName("Проверка работы пункта меню Соусы")
    public void menuSaucesCheck(){
        MainPage mainPage = open(MAIN_PAGE, MainPage.class);
        mainPage.buttonMenuSaucesCheck();
    }

    @Test
    @DisplayName("Проверка работы пункта меню Начинки")
    public void menuToppingsCheck(){
        MainPage mainPage = open(MAIN_PAGE, MainPage.class);
        mainPage.buttonMenuToppingsCheck();
    }
}
