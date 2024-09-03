package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement loginField = $("[data-test-id='login'] input");
    private final SelenideElement passwordField = $("[data-test-id='password'] input");
    private final SelenideElement buttonField = $("[data-test-id='action-login']");

    public VerificationPage validLogin(DataHelper.AuthInfo info){
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        buttonField.click();
        return new VerificationPage();
    }
    public void invalidLogin(DataHelper.AuthInfo info){
        $("[data-test-id='login'] input").setValue(DataHelper.getRandom().getLogin());
        $("[data-test-id='password'] input").setValue(info.getPassword());
        $("[data-test-id='action-login']").click();

    }
    public void invalidPassword(DataHelper.AuthInfo info){
        $("[data-test-id='login'] input").setValue(info.getLogin());
        $("[data-test-id='password'] input").setValue(DataHelper.getRandom().getPassword());
        $("[data-test-id='action-login']").click();

    }
}
