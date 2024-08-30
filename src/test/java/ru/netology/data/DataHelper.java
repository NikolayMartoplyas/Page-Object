package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class DataHelper {
    private DataHelper() {
    }
    public static String getGenerateLogin(String local){
        Faker faker = new Faker(new Locale(local));
        return faker.name().fullName();
    }
    public static String getGeneratePassword(String local){
        Faker faker = new Faker(new Locale(local));
        return faker.internet().password();
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }
    public static AuthInfo getRandom(){
        return new AuthInfo(getGenerateLogin("en"), getGeneratePassword("en"));

    }


    @Value
    public static class VerificatinCode {
        private String code;
    }

    public static VerificatinCode getVerificatinCode(AuthInfo authInfo) {
        return new VerificatinCode("12345");
    }

}
