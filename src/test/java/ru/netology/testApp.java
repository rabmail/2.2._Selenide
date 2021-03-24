package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class testApp {

      public String SetDate (int date){
       return LocalDate.now().plusDays(date).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @BeforeEach
    void shouldOpenWebApp() {
        open("http://localhost:9999");
    }

    @Test
    void shouldTestValidation() {
        $("[data-test-id=city] input").setValue("Белгород");
        $("[data-test-id=date] input").setValue(SetDate(3));
        $("[data-test-id=name] input").setValue("Пупкин Василий");
        $("[data-test-id=phone] input").setValue("+79102280000");
        $("[data-test-id=agreement]").click();
        $$("button").get(1).click();
        //$("[data-test-id='notification']").waitUntil(visible, 15000).shouldHave(text("Успешно!"));
        //$("[data-test-id=notification]").shouldHave((visible),Duration.ofSeconds(15));
        //$(withText("Встреча успешно забронирована на")).shouldBe(visible, Duration.ofSeconds(15));
        $("[data-test-id=notification]").shouldBe((visible), Duration.ofSeconds(15));
    }
//
//    @Test
//    void shouldTestValidationFIO() {
//        open("http://localhost:9999");
//        $("[data-test-id=name] input").setValue("");
//        $("[data-test-id=phone] input").setValue("+79102280000");
//        $("[data-test-id=agreement]").click();
//        $("button").click();
//        // $(".input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
//        $$(".input__sub").get(0).shouldHave(exactText("Поле обязательно для заполнения"));
//    }
//
//    @Test
//    void shouldTestValidationPhone() {
//        open("http://localhost:9999");
//        $("[data-test-id=name] input").setValue("Вася Пупкин");
//        $("[data-test-id=phone] input").setValue("");
//        $("[data-test-id=agreement]").click();
//        $("button").click();
//
//        // $$(".input__sub").shouldHave(size(2));
//        $$(".input__sub").get(1).shouldHave(exactText("Поле обязательно для заполнения"));
//        //  $$(".input__sub").shouldHave(texts("Укажите точно как в паспорте", "Поле обязательно для заполнения"));
//    }
}
