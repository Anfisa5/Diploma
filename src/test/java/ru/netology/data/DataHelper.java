package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

@NoArgsConstructor
public class DataHelper {

    public void DataHelper() {
    }

    private static final Faker fakerEn = new Faker(new Locale("en"));
    private static final Faker fakerRu = new Faker(new Locale("ru"));


    @Value
    public static class CardData {
        String number;
        String month;
        String year;
        String holder;
        String cvc;
    }


    public static String getFieldEmpty() {

        return " ";
    }


    //For Number Card Field

    public static String getApprovedNumberCard() {

        return "4444 4444 4444 4441";
    }

    public static CardData getCorrectlyFormForApprovedCardForm() {

        return new CardData(getApprovedNumberCard(), getValidMonth(), getValidYear(), getRandomNameEn(), getValidCVC());
    }

    public static String getDeclinedNumberCard() {

        return "4444 4444 4444 4442";
    }

    public static CardData getCorrectlyFormForDeclinedCardForm() {

        return new CardData(getDeclinedNumberCard(), getValidMonth(), getValidYear(), getRandomNameEn(), getValidCVC());
    }

    public static String getFormWithDeficientNumberCard() {

        return "4444 4444 4444 444";

    }

    public static String getValidCardStatus() {

        return "APPROVED";

    }

    public static String getInvalidCardStatus() {

        return "DECLINED";

    }

    public static CardData getFormWithEmptyFieldNumberCard() {

        return new CardData(getFieldEmpty(), getValidMonth(), getValidYear(), getRandomNameEn(), getValidCVC());
    }

    public static CardData getFormWithAllEmptyFields() {

        return new CardData(getFieldEmpty(), getFieldEmpty(), getFieldEmpty(), getFieldEmpty(), getFieldEmpty());
    }

    public static String getInValidNumberCardWithDeficientNumbers() {

        return "4444 4444 4444 444";
    }

    public static CardData getFormWithInValidNumberCardWithDeficientNumbers() {

        return new CardData(getInValidNumberCardWithDeficientNumbers(), getValidMonth(), getValidYear(), getRandomNameEn(), getValidCVC());
    }

    //For Month Field

    public static String getValidMonth() {

        var months = new String[]{
                "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        return months[new Random().nextInt(months.length)];

    }

    public static CardData getFormWithEmptyFieldMonth() {

        return new CardData(getApprovedNumberCard(), getFieldEmpty(), getValidYear(), getRandomNameEn(), getValidCVC());

    }

    public static String getInValidMonthEqualsToNoExistentMonth() {

        return String.valueOf(fakerEn.number().numberBetween(13, 99));
    }

    public static CardData getFormWithInvalidMonthEqualsToNoExistentMonth() {

        return new CardData(getApprovedNumberCard(), getInValidMonthEqualsToNoExistentMonth(), getValidYear(), getRandomNameEn(), getValidCVC());
    }

    public static String getInvalidMonthEqualsToOneNumber() {

        return String.valueOf(fakerEn.number().numberBetween(0, 9));
    }

    public static CardData getFormWithIncorrectFieldMonthEqualsOneNumber() {

        return new CardData(getApprovedNumberCard(), getInvalidMonthEqualsToOneNumber(), getValidYear(), getRandomNameEn(), getValidCVC());
    }

    public static String getInValidMonthEqualsTo00() {

        return "00";
    }

    public static CardData getFormWithIncorrectMonthEqualTo00() {

        return new CardData(getApprovedNumberCard(), getInValidMonthEqualsTo00(), getValidYear(), getRandomNameEn(), getValidCVC());
    }

    //public static CardData getFormWithInValidMonth(int months) {
    //     String month = LocalDate.now().minusMonths(months).format(DateTimeFormatter.ofPattern("MM"));
    //     return new CardData(getApprovedNumberCard(), month, getValidYear(), getRandomNameEn(), getValidCVC());
    // }

    //For Year Field

    public static String getValidYear() {

        return String.valueOf(fakerEn.number().numberBetween(23, 28));

    }

    public static CardData getFormWithEmptyFieldYear() {

        return new CardData(getApprovedNumberCard(), getValidMonth(), getFieldEmpty(), getRandomNameEn(), getValidCVC());

    }

    public static String getInvalidYearEqualsToExpiredYear() {

        return String.valueOf(fakerEn.number().numberBetween(15, 22));
    }

    public static CardData getFormWithExpiredYear() {

        return new CardData(getApprovedNumberCard(), getValidMonth(), getInvalidYearEqualsToExpiredYear(), getRandomNameEn(), getValidCVC());
    }

    public static String getInValidYear() {

        return String.valueOf(fakerEn.number().numberBetween(29, 99));
    }

    public static CardData getFormWithInvalidYear() {

        return new CardData(getApprovedNumberCard(), getValidMonth(), getInValidYear(), getRandomNameEn(), getValidCVC());

    }

    public static String getInvalidYearEqualToOneNumber() {

        return String.valueOf(fakerEn.number().numberBetween(0, 9));

    }

    public static CardData getFormWithIncorrectFieldYearEqualsToOneNumber() {

        return new CardData(getApprovedNumberCard(), getValidMonth(), getInvalidYearEqualToOneNumber(), getRandomNameEn(), getValidCVC());
    }


    //For Holder Field

    public static String getRandomNameEn() {

        Faker faker = new Faker();
        return fakerEn.name().fullName();
    }

    public static String getRandomNameRu() {

        Faker faker = new Faker();
        return fakerRu.name().fullName();
    }

    public static CardData getCorrectlyFormForApprovedCardFormRu() {

        return new CardData(getApprovedNumberCard(), getValidMonth(), getValidYear(), getRandomNameRu(), getValidCVC());
    }

    public static CardData getFormWithEmptyFieldHolder() {

        return new CardData(getApprovedNumberCard(), getValidMonth(), getValidYear(), getFieldEmpty(), getValidCVC());

    }

    public static String getInvalidHolderNameEqualsOwnerWithSpaceAtBeginningField() {

        return " Ivanov Ivan";

    }

    public static CardData getFormWithHolderNameEqualsOwnerWithSpaceAtBeginningField() {

        return new CardData(getApprovedNumberCard(), getValidMonth(), getValidYear(), getInvalidHolderNameEqualsOwnerWithSpaceAtBeginningField(), getValidCVC());
    }

    public static String getInvalidHolderNameEqualsOwnerWithSpaceAtEndField() {

        return "Ivanov Ivan ";
    }

    public static CardData getFormWithHolderNameEqualsOwnerWithSpaceAtEndField() {

        return new CardData(getApprovedNumberCard(), getValidMonth(), getValidYear(), getInvalidHolderNameEqualsOwnerWithSpaceAtEndField(), getValidCVC());
    }

    public static String getInvalidHolderNameWithNumbersAndPunctuationMarks() {

        return "I@vanov Ivan";
    }

    public static CardData getFormWithHolderNameWithNumbersAndPunctuationMarks() {

        return new CardData(getApprovedNumberCard(), getValidMonth(), getValidYear(), getInvalidHolderNameWithNumbersAndPunctuationMarks(), getValidCVC());
    }

    public static String getInvalidHolderNameEqualsToNumbers() {

        return String.valueOf(fakerEn.number().numberBetween(1000, 5000));

    }

    public static CardData getFormWithHolderNameEqualsToNumbers() {

        return new CardData(getApprovedNumberCard(), getValidMonth(), getValidYear(), getInvalidHolderNameEqualsToNumbers(), getValidCVC());

    }

    public static String getInvalidHolderNameEqualsToOneLetter() {

        var names = new String[]{
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "K", "O", "M"};
        return names[new Random().nextInt(names.length)];

    }

    public static CardData getFormWithShortNameInFieldHolder() {

        return new CardData(getApprovedNumberCard(), getValidMonth(), getValidYear(), getInvalidHolderNameEqualsToOneLetter(), getValidCVC());
    }

    public static String getInvalidHolderNameWithApostrophe() {

        return "Ivanov Ivan’a";
    }

    public static CardData getFormWithHolderNameWithApostrophe() {

        return new CardData(getApprovedNumberCard(), getValidMonth(), getValidYear(), getInvalidHolderNameWithApostrophe(), getValidCVC());
    }


    //For CVC Field

    public static String getValidCVC() {

        return String.valueOf(fakerEn.number().numberBetween(100, 999));
    }

    public static CardData getFormWithEmptyFieldCvc() {

        return new CardData(getApprovedNumberCard(), getValidMonth(), getValidYear(), getRandomNameEn(), getFieldEmpty());
    }

    public static String getInvalidCVCEqualToOneNumber() {

        return String.valueOf(fakerEn.number().numberBetween(0, 9));
    }

    public static CardData getFormWithCVCEqualToOneNumber() {

        return new CardData(getApprovedNumberCard(), getValidMonth(), getValidYear(), getRandomNameEn(), getInvalidCVCEqualToOneNumber());
    }

    public static String getInvalidCVCEqualToTwoNumber() {

        return String.valueOf(fakerEn.number().numberBetween(11, 99));
    }

    public static CardData getFormWithCVCEqualToTwoNumber() {

        return new CardData(getApprovedNumberCard(), getValidMonth(), getValidYear(), getRandomNameEn(), getInvalidCVCEqualToTwoNumber());
    }

}