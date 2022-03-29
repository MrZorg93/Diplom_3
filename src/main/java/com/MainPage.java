package com;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

        //Локатор кнопки перехода на страницу логина в систему
        private By userOfficeButton = By.xpath("//p[text()='Личный Кабинет']");
        //метод клика кнопки перехода на страницу логина в систему
        @Step("Кликаем по кнопке Личный кабинет")
        public LoginToUserOffice userOfficeButtonClick(String step) {
                $(userOfficeButton).click();
                if (step == "first")
                        return new LoginPage();
                else if (step == "second")
                        return new UserProfilePage();
                else return new LoginToUserOffice();
        }

        //Локатор кнопки войти в аккаунт
        private By enterToAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
        //метод клика кнопки перехода на страницу логина в систему
        @Step("Кликаем по кнопке Войти в аккаунт")
        public LoginToUserOffice enterToAccountButtonClick() {
                $(userOfficeButton).click();
                return new LoginPage();

        }

        //локатор заголовка Соберите бургер
        private By combineBurgerHeader = By.xpath("//h1[text()='Соберите бургер']");
        //метод клика кнопки перехода на страницу логина в систему
        @Step("Кликаем по кнопке Войти в аккаунт")
        public boolean combineBurgerHeaderIsDisplayed() {
                return $(combineBurgerHeader).isDisplayed();
        }

        //локатор таба Соусы
        private By sauceTab = By.xpath("//span[text()='Соусы']");
        @Step("Кликаем по табу Соусы")
        public MainPage sauceTabClick() {
                $(sauceTab).click();
                return this;
        }

        //локатор таба Булки
        private By bunsTab = By.xpath("//span[text()='Булки']");
        @Step("Кликаем по табу Соусы")
        public MainPage bunsTabClick() {
                $(bunsTab).click();
                return this;
        }

        //локатор таба Начинки
        private By fillingsTab = By.xpath("//span[text()='Начинки']");
        @Step("Кликаем по табу Соусы")
        public MainPage fillingsTabClick() {
                $(fillingsTab).click();
                return this;
        }

        //Локатор активного таба
        private By activeTab = By.xpath("//div[contains(@class, 'tab_tab_type_current__2BEPc')]");
        @Step("Смотрим текст активного таба")
        public String getActiveTabName() {
                return $(activeTab).getText();
        }

}





