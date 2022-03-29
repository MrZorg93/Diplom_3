package com;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ForgotPasswordPage {
    //Локатор кнопки ВОЙТИ
    private By enterButton = By.xpath("//a[text()='Войти']");
    @Step("Жмякаем кнопку войти")
    public LoginPage enterButtonClick(){
        $(enterButton).click();
        return new LoginPage();
    }
}
