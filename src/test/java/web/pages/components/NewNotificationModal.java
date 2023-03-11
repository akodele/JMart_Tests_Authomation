package web.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$x;

public class NewNotificationModal {
    SelenideElement
            newNotificationModal = $x("//div[contains(@class,'fFDdfv')]"),
            closeButton=$x("//div[contains(@class,'bFrvYP')]");

    public void closeNewSearchModal() {
        if(newNotificationModal.shouldBe(Condition.visible, Duration.ofSeconds(30)).is(appear)){
            closeButton.click();
        }
    }
}
