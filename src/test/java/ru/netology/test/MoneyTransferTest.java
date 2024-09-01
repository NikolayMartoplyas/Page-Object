package ru.netology.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MoneyTransferTest {
//    DashboardPage dashboardPage = new DashboardPage();
//    int initialBalnceFirstCard = dashboardPage.getCardBalance(0);
//    int initialBalanceSecondCard = dashboardPage.getCardBalance(1);

    @BeforeEach
    void setUp() {
        open("http:localhost:9999");
    }

    @Test
    void positiveLoggingAndTransferBetweenAccounts(){
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificatinPage = loginPage.validLogin(authInfo);
        var verificatinCode = DataHelper.getVerificatinCode(authInfo);
        var dashboardPage1 = verificatinPage.validVerify(verificatinCode);
        dashboardPage1.transferToCard(0,1,"1000");
        $("[data-test-id='dashboard']").shouldBe(visible);


    }
    @Test
    void invalidLogin(){
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        loginPage.invalidLogin(authInfo);
    }
    @Test
    void invalidPassword(){
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        loginPage.invalidPassword(authInfo);
    }


}
