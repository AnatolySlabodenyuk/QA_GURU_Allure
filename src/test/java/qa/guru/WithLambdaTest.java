package qa.guru;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class WithLambdaTest {
    private static final String key = "allure";
    private static final String REPOSITORY = "allure-framework/allure2";
    private static final String IssueText  = "Nested describes are hidden in Allure report";

    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть github", () -> {
            open("https://github.com");
        });
        step("В поисковой строке прописать: " + key + " и нажать Enter", () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(key);
            $(".header-search-input").submit();
        });
        step("Кликнуть по первой ссылке: " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открыть таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверить, что на странице есть элемент с названием " + IssueText, () -> {
            $(withText(IssueText)).should(Condition.exist);
        });
    }
}
