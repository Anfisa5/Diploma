package ru.netology.test.paymentbycard;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.page.MainPage;
import ru.netology.page.PaymentPage;
import ru.netology.test.TestBaseUI;

import static ru.netology.data.DataHelper.*;

public class HolderFieldPayByCard extends TestBaseUI {
    private MainPage mainPage = new MainPage();
    private PaymentPage paymentPage = new PaymentPage();

    @BeforeEach
    public void clickBuy() {

        mainPage.clickBuy();
    }

    @Test
    public void testWithEmptyHolderFieldPayByCard() {
        val cardData = getFormWithEmptyFieldHolder();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitThisFieldIsRequired();
    }

    @Test
    public void testWithSpaceAtBeginningInFieldHolderPayByCard() {
        val cardData = getFormWithHolderNameEqualsOwnerWithSpaceAtBeginningField();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitIncorrectFormat();
    }

    @Test
    public void testWithSpaceAtEndInFieldHolderPayByCard() {
        val cardData = getFormWithHolderNameEqualsOwnerWithSpaceAtEndField();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitIncorrectFormat();
    }

    @Test
    public void testWithPunctuationMarksInFieldHolderPayByCard() {
        val cardData = getFormWithHolderNameWithNumbersAndPunctuationMarks();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitIncorrectFormat();
    }

    @Test
    public void testWithNumberInFieldHolderPayByCard() {
        val cardData = getFormWithHolderNameEqualsToNumbers();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitIncorrectFormat();
    }

    @Test
    public void testWithShortNameInFieldHolderPayByCard() {
        val cardData = getFormWithShortNameInFieldHolder();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitIncorrectFormat();
    }

    @Test
    public void testWithApostropheInFieldHolderPayByCard() {
        val cardData = getFormWithHolderNameWithApostrophe();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitIncorrectFormat();
    }

}