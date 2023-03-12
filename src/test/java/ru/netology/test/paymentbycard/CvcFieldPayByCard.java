package ru.netology.test.paymentbycard;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.page.MainPage;
import ru.netology.page.PaymentPage;
import ru.netology.test.TestBaseUI;

import static ru.netology.data.DataHelper.*;


public class CvcFieldPayByCard extends TestBaseUI {

    private MainPage mainPage = new MainPage();
    private PaymentPage paymentPage = new PaymentPage();

    @BeforeEach
    public void clickBuy() {

        mainPage.clickBuy();
    }

    @Test
    public void testWithEmptyCvcFieldPayByCard() {
        val cardData = getFormWithEmptyFieldCvc();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitIncorrectFormat();
    }

    @Test

    public void shouldCardWithIncompleteCVCEqualToOneNumberByCard() {
        val cardData = getFormWithCVCEqualToOneNumber();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitIncorrectFormat();
    }

    @Test

    public void shouldCardWithIncompleteCVCEqualToTwoNumberByCard() {
        val cardData = getFormWithCVCEqualToTwoNumber();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitIncorrectFormat();
    }

}