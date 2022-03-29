import com.LoginPage;
import com.MainPage;
import com.UserOperations;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUserLogOut {
    public static final String URL = "https://stellarburgers.nomoreparties.site/login";

    @Description("Выход по кнопке «Выйти» в личном кабинете")
    @Test
    public void checkLogOutFromUserOfficePage(){
        UserOperations.register();
        LoginPage page = open( URL, LoginPage.class);
        boolean actual = page.fillEmailField(UserOperations.responseData.get("email"))
                .fillPasswordField(UserOperations.responseData.get("password"))
                .enterButtonClick().userOfficeButtonClick("second").logOutButtonClick2()
                .userOfficeButtonClick("first")
                .enterHeaderIsDisplayed();
        UserOperations.delete();

        assertTrue(actual);
    }
}
