package ru.netology.test.paymentbycard;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.page.MainPage;
import ru.netology.page.PaymentPage;
import ru.netology.test.TestBaseUI;

import static com.codeborne.selenide.Selenide.$$;
import static ru.netology.data.DataHelper.getFormWithAllEmptyFields;

public class AllFieldsAreEmptyWhenPayByCard extends TestBaseUI {
    private MainPage mainPage = new MainPage();
    private PaymentPage paymentPage = new PaymentPage();

    @BeforeEach
    public void clickBuy() {

        mainPage.clickBuy();
    }

    @Test
    public void testWithEmptyAllFieldsPayByCard() {
        val cardData = getFormWithAllEmptyFields();
        paymentPage.completedPaymentForm(cardData);
        final ElementsCollection emptyField = $$(".input__sub");
        final SelenideElement fieldNumberCard = emptyField.get(1);
        final SelenideElement fieldMonth = emptyField.get(2);
        final SelenideElement fieldYear = emptyField.get(3);
        final SelenideElement fieldHolder = emptyField.get(4);
        final SelenideElement fieldCvc = emptyField.get(5);
        fieldNumberCard.shouldHave(Condition.text("Неверный формат"));
        fieldMonth.shouldHave(Condition.text("Неверный формат"));
        fieldYear.shouldBe(Condition.text("Неверный формат"));
        fieldHolder.shouldBe(Condition.text("Поле обязательно для заполнения"));
        fieldCvc.shouldBe(Condition.visible.text("Неверный формат"));
    }
}