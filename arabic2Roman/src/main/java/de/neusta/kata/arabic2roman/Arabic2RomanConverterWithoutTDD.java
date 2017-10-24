package de.neusta.kata.arabic2roman;

public class Arabic2RomanConverterWithoutTDD {

   public String convert(final int arabicNumber) {

      if (arabicNumber > 3000 || arabicNumber < 0) {
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

      handleUnitPosition(result, rest, "IX");

      return result.toString();

   }

   private void handle1000digits(final StringBuilder result, final int rest) {
      int digit = rest / 1000;

      for (int i = 0; i < digit; i++) {
         result.append("M");
      }
   }

   private void handle100digits(final StringBuilder result, final int rest) {
      int digit = rest / 100;
      // rest = 9**
      if (digit == 9) {
         result.append("CM");
      } else if (digit >= 5) {
         // rest = 8** - 5**
         result.append("D");
         for (int i = 0; i < digit - 5; i++) {
            result.append("C");
         }
      } else if (digit == 4) {
         // rest = 4**
         result.append("CD");
      } else {
         // rest = 3** - 1**
         for (int i = 0; i < digit; i++) {
            result.append("C");
         }
      }
   }

   private void handle10digits(final StringBuilder result, final int rest) {
      int digit = rest / 10;

      if (digit == 9) {
         result.append("XC");
      } else if (digit >= 5) {
         result.append("L");
         for (int i = 0; i < digit - 5; i++) {
            result.append("X");
         }
      } else if (digit == 4) {
         result.append("XL");
      } else {
         for (int i = 0; i < digit; i++) {
            result.append("X");
         }
      }
   }

   private void handleUnitPosition(final StringBuilder result, final int rest, String romanChar) {
      int digit = rest;

      if (digit == 9) {
         result.append(romanChar);
      } else if (digit >= 5) {
         result.append("V");
         for (int i = 0; i < digit - 5; i++) {
            result.append("I");
         }
      } else if (digit == 4) {
         result.append("IV");
      } else {
         for (int i = 0; i < digit; i++) {
            result.append("I");
         }
      }
   }

}
