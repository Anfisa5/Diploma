package ru.netology.test.paymentoncredit;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.page.MainPage;
import ru.netology.page.PaymentPage;
import ru.netology.test.TestBaseUI;

import static ru.netology.data.DataHelper.*;

public class HolderFieldPayOnCredit extends TestBaseUI {
    private MainPage mainPage = new MainPage();
    private PaymentPage paymentPage = new PaymentPage();

    @BeforeEach
    public void clickBuy() {

        mainPage.clickBuyOnCredit();
    }

    @Test
    public void testWithEmptyHolderFieldPayOnCredit() {
        val cardData = getFormWithEmptyFieldHolder();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitThisFieldIsRequired();
    }

    @Test
    public void testWithSpaceAtBeginningInFieldHolderPayOnCredit() {
        val cardData = getFormWithHolderNameEqualsOwnerWithSpaceAtBeginningField();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitIncorrectFormat();
    }

    @Test
    public void testWithSpaceAtEndInFieldHolderPayOnCredit() {
        val cardData = getFormWithHolderNameEqualsOwnerWithSpaceAtEndField();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitIncorrectFormat();
    }

    @Test
    public void testWithPunctuationMarksInFieldHolderPayOnCredit() {
        val cardData = getFormWithHolderNameWithNumbersAndPunctuationMarks();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitIncorrectFormat();
    }

    @Test
    public void testWithNumberInFieldHolderPayOnCredit() {
        val cardData = getFormWithHolderNameEqualsToNumbers();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitIncorrectFormat();
    }

    @Test
    public void testWithShortNameInFieldHolderPayOnCredit() {
        val cardData = getFormWithShortNameInFieldHolder();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitIncorrectFormat();
    }

    @Test
    public void testWithApostropheInFieldHolderPayOnCredit() {
        val cardData = getFormWithHolderNameWithApostrophe();
        paymentPage.completedPaymentForm(cardData);
        paymentPage.waitIncorrectFormat();
    }

}