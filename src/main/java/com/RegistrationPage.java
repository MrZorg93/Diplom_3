package com;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage{

    //Локатор поля ввода Имени
    private By nameInputField = By.xpath("//label[text()='Имя']//following-sibling::input");
    public RegistrationPage fillName(String name){
        $(nameInputField).sendKeys(name);
        return this;
    }
    //Локатор поля ввода Email
    private By emailInputField = By.xpath("//label[text()='Email']//following-sibling::input");
    public RegistrationPage fillEmail(String email){
        $(emailInputField).sendKeys(email);
        return this;
    }
    //Локатор поля ввода Пароля
    private By passwordInputField = By.xpath("//input[@type='password']");
    public RegistrationPage fillPassword(String password){
        $(passwordInputField).sendKeys(password);
        return this;
    }
    //Локатор кнопки Регистрации
    private By confirmRegistration = By.xpath("//button[text()='Зарегистрироваться']");
    public RegistrationPage confirmRegistration(){
        $(confirmRegistration).click();
        return this;
    }

    //Локатор кнопки ВОЙТИ
    private By enterButton = By.xpath("//a[text()='Войти']");
    @Step("Жмякаем кнопку ВОЙТИ")
    public LoginPage enterButtonClick(){
        $(enterButton).click();
        return new LoginPage();
    }

    //Локатор ошибки короткого пароля
    private By passwordError = By.xpath("//p[text()='Некорректный пароль']");
    public boolean passwordErrorIsDisplayed(){
        return $(passwordError).isDisplayed();
    }

}