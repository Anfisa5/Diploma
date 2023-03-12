package ru.netology.test.paymentbycard;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.page.MainPage;
import ru.netology.page.PaymentPage;
import ru.netology.test.TestBaseUI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static ru.netology.data.DataHelper.*;
import static ru.netology.data.SQL.*;

public class HappyPathPayByCard extends TestBaseUI {
    private PaymentPage paymentPage = new PaymentPage();
    private MainPage mainPage = new MainPage();

    @BeforeEach
    public void clickBuy() {

        mainPage.clickBuy();
    }

    @Test
    public void successResultIfApprovedCardsBuyForm() {
        val cardData = getCorrectlyFormForApprovedCardForm();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitSuccessResult();

        val statusExpected = "APPROVED";
        val statusActual = getCardStatusForPayment();
        assertEquals(statusExpected, statusActual);

        val expectedAmount = "4500000";
        val actualAmount = getAmountPayment();
        assertEquals(expectedAmount, actualAmount);

        val expectedId = getTransactionId();
        val actualId = getPaymentId();
        assertNotNull(actualId);
        assertNotNull(expectedId);
        assertEquals(expectedId, actualId);
    }

    @Test
    public void failResultIfDeclinedCardBuyForm() {
        val cardData = getCorrectlyFormForDeclinedCardForm();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitError();

        val statusExpected = "DECLINED";
        val statusActual = getCardStatusForPayment();
        assertEquals(statusExpected, statusActual);

        val expectedId = getBankId();
        val actualId = getPaymentId();
        assertNotNull(expectedId);
        assertNotNull(actualId);
        assertEquals(expectedId, actualId);
    }

    @Test
    public void successResultIfApprovedCardsBuyFormRu() {
        val cardData = getCorrectlyFormForApprovedCardFormRu();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitSuccessResult();

        val statusExpected = "APPROVED";
        val statusActual = getCardStatusForPayment();
        assertEquals(statusExpected, statusActual);

        val expectedAmount = "4500000";
        val actualAmount = getAmountPayment();
        assertEquals(expectedAmount, actualAmount);

        val expectedId = getTransactionId();
        val actualId = getPaymentId();
        assertNotNull(actualId);
        assertNotNull(expectedId);
        assertEquals(expectedId, actualId);
    }

}