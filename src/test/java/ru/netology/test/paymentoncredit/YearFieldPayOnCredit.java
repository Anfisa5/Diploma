package ru.netology.test.paymentoncredit;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.page.MainPage;
import ru.netology.page.PaymentPage;
import ru.netology.test.TestBaseUI;

import static ru.netology.data.DataHelper.*;

public class YearFieldPayOnCredit extends TestBaseUI {
    private MainPage mainPage = new MainPage();
    private PaymentPage paymentPage = new PaymentPage();

    @BeforeEach
    public void clickBuyOnCredit() {

        mainPage.clickBuyOnCredit();
    }

    @Test
    public void testWithEmptyFieldYearPayOnCredit() {
        val cardData = getFormWithEmptyFieldYear();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitIncorrectFormat();
    }


    @Test
    public void testWithExpiredYearPayOnCredit() {
        val cardData = getFormWithExpiredYear();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitCardExpired();
    }

    @Test
    public void testWithInvalidFillingYearPayOnCredit() {
        val cardData = getFormWithInvalidYear();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitInvalidCardExpirationDate();
    }

    @Test
    public void testWithIncorrectFillingYearPayOnCredit() {
        val cardData = getFormWithIncorrectFieldYearEqualsToOneNumber();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitIncorrectFormat();
    }

}