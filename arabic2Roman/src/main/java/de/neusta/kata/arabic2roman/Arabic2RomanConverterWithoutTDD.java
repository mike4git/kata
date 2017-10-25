package de.neusta.kata.arabic2roman;

public class Arabic2RomanConverterWithoutTDD {

   public String convert(final int arabicNumber) {

      if (arabicNumber >= 3000 || arabicNumber < 0) {
         throw new IllegalArgumentException();
      }

      StringBuilder result = new StringBuilder();
      int rest = arabicNumber;

      handle1000digits(result, rest);
      rest = arabicNumber % 1000;

      handle100digits(result, rest);
      rest = rest % 100;

      handle10digits(result, rest);
      rest = rest % 10;

      handleUnitPosition(result, rest);

      return result.toString();

   }

   private void handle1000digits(final StringBuilder result, final int rest) {
      int digit = rest / 1000;

      for (int i = 0; i < digit; i++) {
         result.append("M");
      }
   }

   private void handle100digits(final StringBuilder result, final int rest) {
      handleSpecialDigits(100, "C", "D", "M", result, rest);
   }

   private void handle10digits(final StringBuilder result, final int rest) {
      handleSpecialDigits(10, "X", "L", "C", result, rest);
   }

   private void handleUnitPosition(final StringBuilder result, final int rest) {
      handleSpecialDigits(1, "I", "V", "X", result, rest);
   }

   private void handleSpecialDigits(final int digitValue, final String romanChar4digitValue,
         final String romanChar4NextDigitValue, final String romanChar4NextDecimalValue, final StringBuilder result,
         final int rest) {
      int digit = rest / digitValue;
      // rest = 9**
      if (digit == 9) {
         result.append(romanChar4digitValue + romanChar4NextDecimalValue);
      } else if (digit >= 5) {
         // rest = 8** - 5**
         result.append(romanChar4NextDigitValue);
         for (int i = 0; i < digit - 5; i++) {
            result.append(romanChar4digitValue);
         }
      } else if (digit == 4) {
         // rest = 4**
         result.append(romanChar4digitValue + romanChar4NextDigitValue);
      } else {
         // rest = 3** - 1**
         for (int i = 0; i < digit; i++) {
            result.append(romanChar4digitValue);
         }
      }
   }

}
