package quru.qa.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepsLambdaTest {

    @Test
    public void lambdaStepsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open(TestBase.URL);
        });
        step("Ищем репозиторий " + TestBase.REPOSITORY, () -> {
            $(".search-input-container").click();
            $("#query-builder-test").sendKeys(TestBase.SEARCH);
            $("#query-builder-test").submit();
        });
        step("Кликаем по ссылке репозитория " + TestBase.REPOSITORY, () -> {
            $(TestBase.REPOSITORY).click();
        });
        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issues с номером " + TestBase.ISSUE, () -> {
            $(withText("#" + TestBase.ISSUE)).should(Condition.exist);
        });
    }
}
