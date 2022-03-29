import com.RegistrationPage;
import com.UserOperations;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;
import static com.UserOperations.EMAIL_POSTFIX;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRegistration {
    public static final String REGISTRATION_URL = "https://stellarburgers.nomoreparties.site/register";
    public static final Map<String, String> inputDataMap = new HashMap<>();
    @DisplayName("Check successfully registration with correct input data of different length")
    @ParameterizedTest(name = "#{index} - In this iteration lengths of name, email, password = {0}")
    @CsvSource({
            "2, 2, 7",
            "3, 3, 8",
            "10, 10, 10",
    })
    public void checkRegistrationPossibleWithCorrectInputData(int nameLength, int emailLength, int passwordLength){
        //генерим данные регистрации
        String email = RandomStringUtils.randomAlphabetic(emailLength) + EMAIL_POSTFIX;
        String password = RandomStringUtils.randomAlphabetic(passwordLength);
        String name = RandomStringUtils.randomAlphabetic(nameLength);
        inputDataMap.put("email", email);
        inputDataMap.put("password", password);
        inputDataMap.put("name", name);
        RegistrationPage page = open( REGISTRATION_URL, RegistrationPage.class);
         page.fillName(inputDataMap.get("name"))
                .fillEmail(inputDataMap.get("email"))
                .fillPassword(inputDataMap.get("password"))
                .confirmRegistration();
                //.isLoginButtonDisplayed();

        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/login"));

        UserOperations.login(inputDataMap.get("email"), inputDataMap.get("password"));
        UserOperations.delete();

    }

}
