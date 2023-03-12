package ru.netology.test.paymentoncredit;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.page.MainPage;
import ru.netology.page.PaymentPage;
import ru.netology.test.TestBaseUI;

import static ru.netology.data.DataHelper.getFormWithEmptyFieldNumberCard;
import static ru.netology.data.DataHelper.getFormWithInValidNumberCardWithDeficientNumbers;

public class NumberFieldCardPayOnCredit extends TestBaseUI {
    private MainPage mainPage = new MainPage();
    private PaymentPage paymentPage = new PaymentPage();

    @BeforeEach
    public void clickBuy() {

        mainPage.clickBuyOnCredit();
    }

    @Test
    public void testWithEmptyNumberCardOnCredit() {
        val cardData = getFormWithEmptyFieldNumberCard();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitIncorrectFormat();
    }

    @Test
    public void testWithDeficientNumbersCardPayOnCredit() {
        val cardData = getFormWithInValidNumberCardWithDeficientNumbers();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitIncorrectFormat();
    }

}