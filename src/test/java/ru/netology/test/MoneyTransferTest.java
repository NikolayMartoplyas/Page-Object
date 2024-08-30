package ru.netology.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MoneyTransferTest {

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
        var dashboardPage = verificatinPage.validVerify(verificatinCode);

    }
    @Test
    void invalidLogin(){
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getRandom();
        var erorPage = loginPage.invalidLogin(authInfo);



    }


}
