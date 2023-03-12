package ru.netology.test.paymentoncredit;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.page.MainPage;
import ru.netology.page.PaymentPage;
import ru.netology.test.TestBaseUI;

import static ru.netology.data.DataHelper.*;

public class MonthFieldPayOnCredit extends TestBaseUI {
    private MainPage mainPage = new MainPage();
    private PaymentPage paymentPage = new PaymentPage();

    @BeforeEach
    public void clickBuy() {

        mainPage.clickBuyOnCredit();
    }

    @Test
    public void testWithEmptyFieldMonthPayOnCredit() {
        val cardData = getFormWithEmptyFieldMonth();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitIncorrectFormat();
    }

    @Test
    public void testZeroMonthPayOnCredit() {
        val cardData = getFormWithIncorrectMonthEqualTo00();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitInvalidCardExpirationDate();
    }

    @Test
    public void testWithNonexistentMonthPayOnCredit() {
        val cardData = getFormWithInvalidMonthEqualsToNoExistentMonth();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitInvalidCardExpirationDate();
    }
}