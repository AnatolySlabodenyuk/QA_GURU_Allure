package qa.guru;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SimpleTest {

    private static final String key = "allure";
    private static final String REPOSITORY = "allure-framework/allure2";
    private static final String IssueText  = "Nested describes are hidden in Allure report";

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys(key);
        $(".header-search-input").submit();

        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText(IssueText)).should(Condition.exist);
    }
}
