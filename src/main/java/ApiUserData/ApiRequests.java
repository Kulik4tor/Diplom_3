package ApiUserData;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiRequests extends Api {

    @Step("Удаление пользователя")
    public void deleteRegisteredUser(String auToken) {
        given()
                .headers("Authorization", auToken)
                .spec(apiSpecification())
                .delete("auth/user")
                .then()
                .statusCode(202);
    }

    @Step("Получение токена")
    public String getUserAccessToken(UserData user) {
        String auToken = "";
        Response response = given()
                .spec(apiSpecification())
                .and()
                .body(user)
                .post("/auth/login");

        if (response.statusCode() == 200) {
            auToken = response.body().path("accessToken");
        }
        return auToken;
    }

    @Step("Регистрация пользователя")
    public void userRegistration(UserData user) {
        given()
                .spec(apiSpecification())
                .and()
                .body(user)
                .post("/auth/register")
                .then()
                .statusCode(200);
    }
}
