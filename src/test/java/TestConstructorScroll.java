import com.MainPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestConstructorScroll {
    public static final String URL = "https://stellarburgers.nomoreparties.site";

    @Description("Проверка активации вкладки Соусы по клику на неё")
    @Test
    public void сheckSauceTabActivation(){
        MainPage page = open( URL, MainPage.class);
        String actual = page.sauceTabClick().getActiveTabName();
        assertEquals("Соусы", actual);
    }

    @Description("Проверка активации вкладки Булки по клику на неё")
    @Test
    public void сheckBunsTabActivation(){
        MainPage page = open( URL, MainPage.class);
        String actual = page.sauceTabClick().bunsTabClick().getActiveTabName();
        assertEquals("Булки", actual);
    }

    @Description("Проверка активации вкладки Начинки по клику на неё")
    @Test
    public void сheckFillingsTabActivation(){
        MainPage page = open( URL, MainPage.class);
        String actual = page.fillingsTabClick().getActiveTabName();
        assertEquals("Начинки", actual);
    }
}
