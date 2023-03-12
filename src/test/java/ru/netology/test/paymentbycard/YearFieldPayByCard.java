package ru.netology.test.paymentbycard;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.page.MainPage;
import ru.netology.page.PaymentPage;
import ru.netology.test.TestBaseUI;

import static ru.netology.data.DataHelper.*;

public class YearFieldPayByCard extends TestBaseUI {
    private MainPage mainPage = new MainPage();
    private PaymentPage paymentPage = new PaymentPage();

    @BeforeEach
    public void clickBuy() {

        mainPage.clickBuy();
    }

    @Test
    public void testWithEmptyFieldYearPayByCard() {
        val cardData = getFormWithEmptyFieldYear();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitIncorrectFormat();
    }


    @Test
    public void testWithExpiredYearPayByCard() {
        val cardData = getFormWithExpiredYear();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitCardExpired();
    }

    @Test
    public void testWithInvalidFillingYearPayByCard() {
        val cardData = getFormWithInvalidYear();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitInvalidCardExpirationDate();
    }

    @Test
    public void testWithIncorrectFillingYearPayByCard() {
        val cardData = getFormWithIncorrectFieldYearEqualsToOneNumber();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitIncorrectFormat();
    }

}