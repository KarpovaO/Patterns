import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DeliveryForCardTest {


    @Test
    void shouldGenerateTestDataUsingUtils() {
        open("http://localhost:9999");
        RegistrationInfoTest info = DataGeneratorTest.Registration.generateInfo("ru");
        String city = info.getCity();
        String name = info.getName();
        String phone = info.getPhone();


        String planningDate = DataGeneratorTest.generateDate(5, "dd.MM.yyyy");
        String planningDate2 = DataGeneratorTest.generateDate(6, "dd.MM.yyyy");
        $("[data-test-id= 'city'] input").setValue(city);
        $("div.menu div.menu-item span.menu-item__control").click();
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(planningDate);
        $("td.calendar__day.calendar__day_state_current").click();
        $("[data-test-id= 'name'] input").setValue(name);
        $("[data-test-id= 'phone'] input").setValue(phone);
        $("[data-test-id= 'agreement']").click();
        $(byText("Запланировать")).click();
        $("[data-test-id= 'success-notification']").shouldBe(visible, Duration.ofSeconds(14));
        $(".notification__content").shouldHave(Condition.text("Встреча успешно запланирована на " + planningDate), Duration.ofSeconds(15)).shouldBe(Condition.visible);

        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(planningDate2);
        $("td.calendar__day.calendar__day_state_current").click();
        $(byText("Запланировать")).click();
        $("[data-test-id= 'replan-notification']").shouldBe(visible);
        $(byText("Перепланировать")).click();
        $(".notification__content").shouldHave(Condition.text("Встреча успешно запланирована на " + planningDate2), Duration.ofSeconds(15)).shouldBe(Condition.visible);

    }


}
