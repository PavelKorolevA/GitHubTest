package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchSelenideRepo {

    @Test
    void shoulofSelenideInGithub(){
        // открыть страницу github.com
        open("https://github.com/");
        // ввести в поле поиск selenide И нажать Enter
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        // нажимаем на линк от первого результата поиска
        $$(".repo-list li").first().$("a").click();
        // перехожим в раздел wiki
        $("#wiki-tab").click();
        // убедиться, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        // открыть страницу SoftAssertions
        $(byText("SoftAssertions")).click();
        // проверяем, что есть пример кода JUnit5
        $("#user-content-3-using-junit5-extend-test-class").parent()
                .shouldHave(text("Using JUnit5 extend test class"));

    }
}
