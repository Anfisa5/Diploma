package ru.netology.test.paymentbycard;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.page.MainPage;
import ru.netology.page.PaymentPage;
import ru.netology.test.TestBaseUI;

import static ru.netology.data.DataHelper.*;

public class MonthFieldPayByCard extends TestBaseUI {
    private MainPage mainPage = new MainPage();
    private PaymentPage paymentPage = new PaymentPage();

    @BeforeEach
    public void clickBuy() {

        mainPage.clickBuy();
    }

    @Test
    public void testWithEmptyFieldMonthPayByCard() {
        val cardData = getFormWithEmptyFieldMonth();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitIncorrectFormat();
    }

    @Test
    public void testZeroMonthPayByCard() {
        val cardData = getFormWithIncorrectMonthEqualTo00();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitInvalidCardExpirationDate();
    }

    @Test
    public void testWithNonexistentMonthPayByCard() {
        val cardData = getFormWithInvalidMonthEqualsToNoExistentMonth();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitInvalidCardExpirationDate();
    }

    @Test
    public void testWithIncorrectMonthEqualsOneNumberPayByCard() {
        val cardData = getFormWithIncorrectFieldMonthEqualsOneNumber();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitIncorrectFormat();
    }
}