package com;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class UserProfilePage extends LoginToUserOffice{
    //локатор Кнопки профиль
    private By profileLink = By.xpath("//a[text()='Профиль']");
    @Step("Проверяем, что попали в личный кабинет")
    public boolean isProfileLinkDisplayed(){
        return $(profileLink).shouldBe(Condition.visible).isDisplayed();
    }

    //локатор Кнопки Выйти из профиля
    private By logOutButton = By.xpath("//button[text()='Выход']");
    @Step("Сваливаем из личного кабинета")
    public void logOutButtonClick(){
       $(logOutButton).click();
    }
    @Step("Сваливаем из личного кабинета на главную страницу")
    public MainPage logOutButtonClick2(){
        $(logOutButton).click();
        return new MainPage();
    }

    //локатор Кнопки Конструктор
    private By constructorButton = By.xpath("//p[text()='Конструктор']");
    @Step("Переход на главную по клику на кнопку Конструктор")
    public MainPage constructorButtonClick() {
        $(constructorButton).click();
        return new MainPage();
    }
}

