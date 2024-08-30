package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ErorPage {
    private SelenideElement notification = $("[data-test-id='error-notification'] .notification__content");

    public ErorPage(){
        notification.shouldBe(visible, Duration.ofSeconds(15));
        notification.shouldHave(Condition.exactText("Ошибка! Неверно указан логин или пароль"));
    }
}
