package quru.qa.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideListenerTest {

    @Test
    public void issueSearchTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open(TestBase.URL);

        $(".search-input-container").click();
        $("#query-builder-test").sendKeys(TestBase.SEARCH);
        $("#query-builder-test").submit();

        $(TestBase.REPOSITORY).click();
        $("#issues-tab").click();
        $(withText("#" + TestBase.ISSUE)).should(Condition.exist);
    }
}
