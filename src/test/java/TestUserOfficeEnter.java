import com.LoginPage;
import com.UserOperations;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUserOfficeEnter {
    public static final String URL = "https://stellarburgers.nomoreparties.site/login";

    @Description("Проверка работы кнопки входа в личный кабинет пользователя")
    @Test
    public void checkLogOutFromUserOfficePage(){
        UserOperations.register();
        LoginPage page = open( URL, LoginPage.class);
        boolean actual = page.fillEmailField(UserOperations.responseData.get("email"))
                .fillPasswordField(UserOperations.responseData.get("password"))
                .enterButtonClick().userOfficeButtonClick("second")
                .isProfileLinkDisplayed();
        UserOperations.delete();

        assertTrue(actual);
    }

}
