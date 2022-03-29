package com;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends LoginToUserOffice{
    //Локатор кнопки Войти
    private By enterButton = By.xpath("//button[text()='Войти']");
    public boolean isLoginButtonDisplayed(){
        return $(enterButton).isDisplayed();
    }
    @Step("Жмякаем кнопку войти")
    public MainPage enterButtonClick(){
        $(enterButton).click();
        return new MainPage();
    }

    //Локатор кнопки зарегистрироваться
    private By registerButton = By.xpath("//a[text()='Зарегистрироваться']");
    @Step("Жмякаем кнопку зарегистрироваться")
    public RegistrationPage registerButtonClick(){
        $(registerButton).click();
        return new RegistrationPage();
    }

    //Локатор кнопки восстановить пароль
    private By renewPasswordButton = By.xpath("//a[text()='Восстановить пароль']");
    @Step("Жмякаем кнопку восстановить пароль")
    public ForgotPasswordPage renewPasswordButtonClick(){
        $(renewPasswordButton).click();
        return new ForgotPasswordPage();
    }

    //Локатор поля ввода Email
    private By emailField = By.xpath("//input[@type='text']");
    @Step("Вводим почту")
    public LoginPage fillEmailField(String email){
        $(emailField).setValue(email);
        return this;
    }

    //Локатор поля ввода Password
    private By passwordField = By.xpath("//input[@type='password']");
    @Step("Вводим пароль")
    public LoginPage fillPasswordField(String pass){
        $(passwordField).setValue(pass);
        return this;
    }

    //Локатор заголовка ВХОД
    private By enterHeader = By.xpath("//h2[text()='Вход']");
    @Step("Смотрим попали ли мы на страницу входа")
    public boolean enterHeaderIsDisplayed(){
        return $(enterHeader).isDisplayed();
    }


}



