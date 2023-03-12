package ru.netology.test.paymentoncredit;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.page.MainPage;
import ru.netology.page.PaymentPage;
import ru.netology.test.TestBaseUI;

import static ru.netology.data.DataHelper.*;


public class CvcFieldPayOnCredit extends TestBaseUI {

    private MainPage mainPage = new MainPage();
    private PaymentPage paymentPage = new PaymentPage();

    @BeforeEach
    public void clickBuy() {

        mainPage.clickBuyOnCredit();
    }

    @Test
    public void testWithEmptyCvcFieldPayOnCredit() {
        val cardData = getFormWithEmptyFieldCvc();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitIncorrectFormat();
    }

    @Test

    public void shouldCardWithIncompleteCVCEqualToOneNumberOnCredit() {
        val cardData = getFormWithCVCEqualToOneNumber();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitIncorrectFormat();
    }

    @Test

    public void shouldCardWithIncompleteCVCEqualToTwoNumberOnCredit() {
        val cardData = getFormWithCVCEqualToTwoNumber();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitIncorrectFormat();
    }

}