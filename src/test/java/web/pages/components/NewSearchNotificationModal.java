package web.pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$x;

public class NewSearchNotificationModal {
    SelenideElement
            newSearchNotificationModal = $x("//div[contains(@class,'djmGIm')]"),
            closeButton=$x("//div[contains(@class,'bFrvYP')]");

    public void closeNewSearchModal() {
        if(newSearchNotificationModal.is(appear)){
            closeButton.click();
        }
    }
}
