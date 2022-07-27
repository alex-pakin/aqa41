package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class DeliveryFormTest {

    @BeforeEach
    void openBrowser() {open("http://localhost:9999");}

    @Test
    void shouldSendForm() {
        $x("//*[@data-test-id='city']//input").val("Тула");
        $x("//*[@data-test-id='date']//input").doubleClick().sendKeys("BackSpace");
        $x("//*[@data-test-id='date']//input").val("29.08.2022");
        $x("//*[@data-test-id='name']//input").val("Джеймс Бонд");
        $x("//*[@data-test-id='phone']//input").val("+79110070707");
        $x("//*[@data-test-id='agreement']").click();
        $x("//*[text()='Забронировать']").click();
        $x("//*[@data-test-id='notification']").shouldBe(visible, Duration.ofSeconds(14));
    }

    @Test
    void shouldSendFormCityWithDash() {
        $x("//*[@data-test-id='city']//input").val("Санкт-Петербург");
        $x("//*[@data-test-id='date']//input").doubleClick().sendKeys("BackSpace");
        $x("//*[@data-test-id='date']//input").val("29.08.2022");
        $x("//*[@data-test-id='name']//input").val("Джеймс Бонд");
        $x("//*[@data-test-id='phone']//input").val("+79110070707");
        $x("//*[@data-test-id='agreement']").click();
        $x("//*[text()='Забронировать']").click();
        $x("//*[@data-test-id='notification']").shouldBe(visible, Duration.ofSeconds(14));
    }

    //тест буквы "ё"
    @Test
    void shouldSendFormCityWithE() {
        $x("//*[@data-test-id='city']//input").val("Орёл");
        $x("//*[@data-test-id='date']//input").doubleClick().sendKeys("BackSpace");
        $x("//*[@data-test-id='date']//input").val("29.08.2022");
        $x("//*[@data-test-id='name']//input").val("Джеймс Бонд");
        $x("//*[@data-test-id='phone']//input").val("+79110070707");
        $x("//*[@data-test-id='agreement']").click();
        $x("//*[text()='Забронировать']").click();
        $x("//*[@data-test-id='notification']").shouldBe(visible, Duration.ofSeconds(14));
    }

    @Test
    void shouldSendFormCityWithSpace() {
        $x("//*[@data-test-id='city']//input").val("Нижний Новгород");
        $x("//*[@data-test-id='date']//input").doubleClick().sendKeys("BackSpace");
        $x("//*[@data-test-id='date']//input").val("29.08.2022");
        $x("//*[@data-test-id='name']//input").val("Джеймс Бонд");
        $x("//*[@data-test-id='phone']//input").val("+79110070707");
        $x("//*[@data-test-id='agreement']").click();
        $x("//*[text()='Забронировать']").click();
        $x("//*[@data-test-id='notification']").shouldBe(visible, Duration.ofSeconds(14));
    }

    @Test
    void shouldSendFormNameWithDash() {
        $x("//*[@data-test-id='city']//input").val("Тула");
        $x("//*[@data-test-id='date']//input").doubleClick().sendKeys("BackSpace");
        $x("//*[@data-test-id='date']//input").val("29.08.2022");
        $x("//*[@data-test-id='name']//input").val("Ана-Мария Огбезян");
        $x("//*[@data-test-id='phone']//input").val("+79110070707");
        $x("//*[@data-test-id='agreement']").click();
        $x("//*[text()='Забронировать']").click();
        $x("//*[@data-test-id='notification']").shouldBe(visible, Duration.ofSeconds(14));
    }

    @Test
    void shouldSendFormSurNameWithDash() {
        $x("//*[@data-test-id='city']//input").val("Тула");
        $x("//*[@data-test-id='date']//input").doubleClick().sendKeys("BackSpace");
        $x("//*[@data-test-id='date']//input").val("29.08.2022");
        $x("//*[@data-test-id='name']//input").val("Марина Перейра-Родригес");
        $x("//*[@data-test-id='phone']//input").val("+79110070707");
        $x("//*[@data-test-id='agreement']").click();
        $x("//*[text()='Забронировать']").click();
        $x("//*[@data-test-id='notification']").shouldBe(visible, Duration.ofSeconds(14));
    }

    @Test
    void shouldSendFormDate3Days() {
        $x("//*[@data-test-id='city']//input").val("Тула");
        $x("//*[@data-test-id='date']//input").doubleClick().sendKeys("BackSpace");
        $x("//*[@data-test-id='date']//input").val("30.07.2022");
        $x("//*[@data-test-id='name']//input").val("Марина Перейра-Родригес");
        $x("//*[@data-test-id='phone']//input").val("+79110070707");
        $x("//*[@data-test-id='agreement']").click();
        $x("//*[text()='Забронировать']").click();
        $x("//*[@data-test-id='notification']").shouldBe(visible, Duration.ofSeconds(14));
    }

    @Test
    void shouldSendFormDate4Days() {
        $x("//*[@data-test-id='city']//input").val("Тула");
        $x("//*[@data-test-id='date']//input").doubleClick().sendKeys("BackSpace");
        $x("//*[@data-test-id='date']//input").val("31.07.2022");
        $x("//*[@data-test-id='name']//input").val("Марина Перейра-Родригес");
        $x("//*[@data-test-id='phone']//input").val("+79110070707");
        $x("//*[@data-test-id='agreement']").click();
        $x("//*[text()='Забронировать']").click();
        $x("//*[@data-test-id='notification']").shouldBe(visible, Duration.ofSeconds(14));
    }

    @Test
    void shouldNotSendFormCityWrongSpelling() {
        $x("//*[@data-test-id='city']//input").val("Санкт Петербург");
        $x("//*[@data-test-id='date']//input").doubleClick().sendKeys("BackSpace");
        $x("//*[@data-test-id='date']//input").val("29.08.2022");
        $x("//*[@data-test-id='name']//input").val("Джеймс Бонд");
        $x("//*[@data-test-id='phone']//input").val("+79110070707");
        $x("//*[@data-test-id='agreement']").click();
        $x("//*[text()='Забронировать']").click();
        $x("//*[@data-test-id='city']//*[@class='input__sub']").shouldHave(exactText("Доставка в "
                + "выбранный город недоступна"));
    }

    @Test
    void shouldNotSendFormCityNotInList() {
        $x("//*[@data-test-id='city']//input").val("Белозерск");
        $x("//*[@data-test-id='date']//input").doubleClick().sendKeys("BackSpace");
        $x("//*[@data-test-id='date']//input").val("29.08.2022");
        $x("//*[@data-test-id='name']//input").val("Джеймс Бонд");
        $x("//*[@data-test-id='phone']//input").val("+79110070707");
        $x("//*[@data-test-id='agreement']").click();
        $x("//*[text()='Забронировать']").click();
        $x("//*[@data-test-id='city']//*[@class='input__sub']").shouldHave(exactText("Доставка в "
                + "выбранный город недоступна"));
    }

    @Test
    void shouldNotSendFormDateLessThanThreeDays() {
        $x("//*[@data-test-id='city']//input").val("Вологда");
        $x("//*[@data-test-id='date']//input").doubleClick().sendKeys("BackSpace");
        $x("//*[@data-test-id='date']//input").val("29.07.2022");
        $x("//*[@data-test-id='name']//input").val("Джеймс Бонд");
        $x("//*[@data-test-id='phone']//input").val("+79110070707");
        $x("//*[@data-test-id='agreement']").click();
        $x("//*[text()='Забронировать']").click();
        $x("//*[@data-test-id='date']//*[@class='input__sub']").shouldHave(exactText("Заказ на "
                + "выбранную дату невозможен"));
    }

    @Test
    void shouldNotSendFormDateInPast() {
        $x("//*[@data-test-id='city']//input").val("Вологда");
        $x("//*[@data-test-id='date']//input").doubleClick().sendKeys("BackSpace");
        $x("//*[@data-test-id='date']//input").val("29.08.2021");
        $x("//*[@data-test-id='name']//input").val("Джеймс Бонд");
        $x("//*[@data-test-id='phone']//input").val("+79110070707");
        $x("//*[@data-test-id='agreement']").click();
        $x("//*[text()='Забронировать']").click();
        $x("//*[@data-test-id='date']//*[@class='input__sub']").shouldHave(exactText("Заказ на "
                + "выбранную дату невозможен"));
    }

    @Test
    void shouldNotSendFormNameInLatin() {
        $x("//*[@data-test-id='city']//input").val("Вологда");
        $x("//*[@data-test-id='date']//input").doubleClick().sendKeys("BackSpace");
        $x("//*[@data-test-id='date']//input").val("29.09.2022");
        $x("//*[@data-test-id='name']//input").val("James Bond");
        $x("//*[@data-test-id='phone']//input").val("+79110070707");
        $x("//*[@data-test-id='agreement']").click();
        $x("//*[text()='Забронировать']").click();
        $x("//*[@data-test-id='name']//*[@class='input__sub']").shouldHave(exactText("Имя и Фамилия "
                + "указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    void shouldNotSendFormSymbolsInsteadOfName() {
        $x("//*[@data-test-id='city']//input").val("Вологда");
        $x("//*[@data-test-id='date']//input").doubleClick().sendKeys("BackSpace");
        $x("//*[@data-test-id='date']//input").val("29.09.2022");
        $x("//*[@data-test-id='name']//input").val("~!@#$%^&*()_+?...;");
        $x("//*[@data-test-id='phone']//input").val("+79110070707");
        $x("//*[@data-test-id='agreement']").click();
        $x("//*[text()='Забронировать']").click();
        $x("//*[@data-test-id='name']//*[@class='input__sub']").shouldHave(exactText("Имя и Фамилия "
                + "указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    void shouldNotSendFormPhoneStartsWithEight() {
        $x("//*[@data-test-id='city']//input").val("Вологда");
        $x("//*[@data-test-id='date']//input").doubleClick().sendKeys("BackSpace");
        $x("//*[@data-test-id='date']//input").val("29.09.2022");
        $x("//*[@data-test-id='name']//input").val("Джеймс Бонд");
        $x("//*[@data-test-id='phone']//input").val("89110070707");
        $x("//*[@data-test-id='agreement']").click();
        $x("//*[text()='Забронировать']").click();
        $x("//*[@data-test-id='phone']//*[@class='input__sub']").shouldHave(exactText("Телефон указан "
                + "неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    void shouldNotSendFormPhoneWithSpaces() {
        $x("//*[@data-test-id='city']//input").val("Вологда");
        $x("//*[@data-test-id='date']//input").doubleClick().sendKeys("BackSpace");
        $x("//*[@data-test-id='date']//input").val("29.09.2022");
        $x("//*[@data-test-id='name']//input").val("Джеймс Бонд");
        $x("//*[@data-test-id='phone']//input").val("+7 911 007 07 07");
        $x("//*[@data-test-id='agreement']").click();
        $x("//*[text()='Забронировать']").click();
        $x("//*[@data-test-id='phone']//*[@class='input__sub']").shouldHave(exactText("Телефон указан "
                + "неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    void shouldNotSendFormIfNoAgreement() {
        $x("//*[@data-test-id='city']//input").val("Вологда");
        $x("//*[@data-test-id='date']//input").doubleClick().sendKeys("BackSpace");
        $x("//*[@data-test-id='date']//input").val("29.09.2022");
        $x("//*[@data-test-id='name']//input").val("Джеймс Бонд");
        $x("//*[@data-test-id='phone']//input").val("+79110070707");
        $x("//*[text()='Забронировать']").click();
        $x("//*[@data-test-id='agreement']//*[@class='checkbox__text']").shouldHave(exactText("Я "
                + "соглашаюсь с условиями обработки и использования моих персональных данных"));
    }

    @Test
    void shouldNotSendFormIfEmptyCity() {
        $x("//*[@data-test-id='city']//input").val("");
        $x("//*[@data-test-id='date']//input").doubleClick().sendKeys("BackSpace");
        $x("//*[@data-test-id='date']//input").val("29.09.2022");
        $x("//*[@data-test-id='name']//input").val("Джеймс Бонд");
        $x("//*[@data-test-id='phone']//input").val("+79110070707");
        $x("//*[@data-test-id='agreement']").click();
        $x("//*[text()='Забронировать']").click();
        $x("//*[@data-test-id='city']//*[@class='input__sub']").shouldHave(exactText("Поле обязательно "
                + "для заполнения"));
    }

    @Test
    void shouldNotSendFormIfEmptyDate() {
        $x("//*[@data-test-id='city']//input").val("Вологда");
        $x("//*[@data-test-id='date']//input").doubleClick().sendKeys("BackSpace");
        $x("//*[@data-test-id='date']//input").val("");
        $x("//*[@data-test-id='name']//input").val("Джеймс Бонд");
        $x("//*[@data-test-id='phone']//input").val("+79110070707");
        $x("//*[@data-test-id='agreement']").click();
        $x("//*[text()='Забронировать']").click();
        $x("//*[@data-test-id='date']//*[@class='input__sub']").shouldHave(exactText("Неверно "
                + "введена дата"));
    }

    @Test
    void shouldNotSendFormIfEmptyName() {
        $x("//*[@data-test-id='city']//input").val("Вологда");
        $x("//*[@data-test-id='date']//input").doubleClick().sendKeys("BackSpace");
        $x("//*[@data-test-id='date']//input").val("29.08.2022");
        $x("//*[@data-test-id='name']//input").val("");
        $x("//*[@data-test-id='phone']//input").val("+79110070707");
        $x("//*[@data-test-id='agreement']").click();
        $x("//*[text()='Забронировать']").click();
        $x("//*[@data-test-id='name']//*[@class='input__sub']").shouldHave(exactText("Поле обязательно "
                + "для заполнения"));
    }

    @Test
    void shouldNotSendFormIfEmptyPhone() {
        $x("//*[@data-test-id='city']//input").val("Вологда");
        $x("//*[@data-test-id='date']//input").doubleClick().sendKeys("BackSpace");
        $x("//*[@data-test-id='date']//input").val("29.08.2022");
        $x("//*[@data-test-id='name']//input").val("Джеймс Бонд");
        $x("//*[@data-test-id='phone']//input").val("");
        $x("//*[@data-test-id='agreement']").click();
        $x("//*[text()='Забронировать']").click();
        $x("//*[@data-test-id='phone']//*[@class='input__sub']").shouldHave(exactText("Поле обязательно "
                + "для заполнения"));
    }

    @Test
    void shouldNotSendFormIfWholeFormEmpty() {
        $x("//*[@data-test-id='date']//input").doubleClick().sendKeys("BackSpace");
        $x("//*[text()='Забронировать']").click();
        $x("//*[@data-test-id='city']//*[@class='input__sub']").shouldHave(exactText("Поле обязательно "
                + "для заполнения"));
    }
}
