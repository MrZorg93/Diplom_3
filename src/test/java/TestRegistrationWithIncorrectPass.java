import com.RegistrationPage;
import com.UserOperations;
import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.HashMap;
import java.util.Map;
import static com.UserOperations.EMAIL_POSTFIX;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRegistrationWithIncorrectPass {
    public static final String REGISTRATION_URL = "https://stellarburgers.nomoreparties.site/register";
    public static final Map<String, String> inputDataMap = new HashMap<>();

    @Description("Проверим ошибки для коротких паролей")
    @ParameterizedTest()
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void checkRegistrationPossibleWithCorrectInputData(int passwordLength){
        //генерим данные регистрации
        String email = RandomStringUtils.randomAlphabetic(10) + EMAIL_POSTFIX;
        String password = RandomStringUtils.randomAlphabetic(passwordLength);
        String name = RandomStringUtils.randomAlphabetic(10);
        inputDataMap.put("email", email);
        inputDataMap.put("password", password);
        inputDataMap.put("name", name);
        RegistrationPage page = open( REGISTRATION_URL, RegistrationPage.class);
        boolean actual = page.fillName(inputDataMap.get("name"))
                .fillEmail(inputDataMap.get("email"))
                .fillPassword(inputDataMap.get("password"))
                .confirmRegistration().passwordErrorIsDisplayed();

        assertTrue(actual);

    }
}
