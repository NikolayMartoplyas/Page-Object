package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement header = $("[data-test-id='dashboard']");
    private ElementsCollection cards = $$(".list__item div");
    private ElementsCollection replenish = $$("[data-test-id='action-deposit']");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public DashboardPage(){
        header.shouldBe(visible);
    }

    public int getCardBalance(int cardIndex){
        return extractBalance(cards.get(cardIndex).text());
    }
    private int extractBalance(String text){
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }
    public void transferToCard(int fromCardIndex, int toCardIndex,String sum){
        replenish.get(toCardIndex).click();
        $("[data-test-id='amount'] input").sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        $("[data-test-id='amount'] input").setValue(sum);
        $("[data-test-id='from'] input").sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        $("[data-test-id='from'] input").setValue(cards.get(fromCardIndex).getText());
        $("[data-test-id='action-transfer']").click();
    }
}
