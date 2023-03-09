package web.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$x;

public class NewSearchNotificationModal {
    SelenideElement
            newSearchNotificationModal = $x("//div[contains(@class,'djmGIm')]"),
            closeButton=$x("//div[contains(@class,'bFrvYP')]");

    public void closeNewSearchModal() {
        if(newSearchNotificationModal.shouldBe(Condition.visible, Duration.ofSeconds(30)).is(appear)){
            closeButton.click();
        }
    }
}
