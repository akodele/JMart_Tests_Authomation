package web.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$x;

public class QRModal {

    static SelenideElement
            qrTitle = $x(".//div[contains(text(), 'Покупайте в мобильном приложении Jusan!')] ");

    public void qrTitleShouldBeVisible() {
        qrTitle.shouldBe(appear);
    }
}
