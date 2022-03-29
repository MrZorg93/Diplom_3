import com.MainPage;
import com.UserOperations;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUserLogin {
    public static final String URL = "https://stellarburgers.nomoreparties.site";

    @AfterEach
    public void logOut(){
        MainPage page = open( URL, MainPage.class);
        page.userOfficeButtonClick("second").logOutButtonClick();
        UserOperations.delete();
    }

    @Description("Входим через кнопку Личный кабинет на главной странице")
    @Test
    public void checkLoginFromEnterToAccountButton(){
        UserOperations.register();
        MainPage page = open( URL, MainPage.class);
        boolean actual = page.userOfficeButtonClick("first")
                .fillEmailField(UserOperations.responseData.get("email"))
                .fillPasswordField(UserOperations.responseData.get("password"))
                .enterButtonClick().userOfficeButtonClick("second").isProfileLinkDisplayed();

        assertTrue(actual);
    }

    @Description("Входим через кнопку «Войти в аккаунт» на главной странице")
    @Test
    public void checkLoginFromUserOfficeButton(){
        UserOperations.register();
        MainPage page = open( URL, MainPage.class);
        boolean actual = page.enterToAccountButtonClick()
                .fillEmailField(UserOperations.responseData.get("email"))
                .fillPasswordField(UserOperations.responseData.get("password"))
                .enterButtonClick().userOfficeButtonClick("second").isProfileLinkDisplayed();

        assertTrue(actual);
    }

    @Description("Входим через кнопку вход на странице регистрации")
    @Test
    public void checkLoginFromUserRegisterPage(){
        UserOperations.register();
        MainPage page = open( URL, MainPage.class);
        boolean actual = page.userOfficeButtonClick("first")
                .registerButtonClick().enterButtonClick()
                .fillEmailField(UserOperations.responseData.get("email"))
                .fillPasswordField(UserOperations.responseData.get("password"))
                .enterButtonClick().userOfficeButtonClick("second").isProfileLinkDisplayed();

        assertTrue(actual);
    }

    @Description("Входим через кнопку вход на странице восстановления пароля")
    @Test
    public void checkLoginFromUserForgotPasswordPage(){
        UserOperations.register();
        MainPage page = open( URL, MainPage.class);
        boolean actual = page.userOfficeButtonClick("first")
                .renewPasswordButtonClick().enterButtonClick()
                .fillEmailField(UserOperations.responseData.get("email"))
                .fillPasswordField(UserOperations.responseData.get("password"))
                .enterButtonClick().userOfficeButtonClick("second").isProfileLinkDisplayed();

        assertTrue(actual);
    }
}
