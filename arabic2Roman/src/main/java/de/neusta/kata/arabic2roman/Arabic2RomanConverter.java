package de.neusta.kata.arabic2roman;

import java.util.Map;
import java.util.TreeMap;

public class Arabic2RomanConverter {

   private Map<Integer, String> a2r = new TreeMap<>((final Integer o1, final Integer o2) -> o2.compareTo(o1));

   public Arabic2RomanConverter() {
      a2r.put(1000, "M");
      a2r.put(900, "CM");
      a2r.put(500, "D");
      a2r.put(400, "CD");
      a2r.put(100, "C");
      a2r.put(90, "XC");
      a2r.put(50, "L");
      a2r.put(40, "XL");
      a2r.put(10, "X");
      a2r.put(9, "IX");
      a2r.put(5, "V");
      a2r.put(4, "IV");
      a2r.put(1, "I");
   }

   public String convert(final int number) {

      if (number < 0 || number > 3000) {
         throw new IllegalArgumentException("Only numbers between 0 and 3000 are allowed.");
      }

      StringBuilder result = new StringBuilder();

      int arabicNumber = number;

      for (Integer key : a2r.keySet()) {
         arabicNumber = handleDigit(result, arabicNumber, key.intValue());
      }

      return result.toString();
   }

   private int handleDigit(final StringBuilder result, final int arabicNumber, final int digit) {
      for (int i = 0; i < arabicNumber / digit; i++) {
         result.append(a2r.get(digit));
      }
      return arabicNumber % digit;
   }

}
