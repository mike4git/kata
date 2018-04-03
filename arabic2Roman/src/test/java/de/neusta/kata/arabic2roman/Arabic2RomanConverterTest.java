package de.neusta.kata.arabic2roman;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.googlecode.catchexception.CatchException;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class Arabic2RomanConverterTest {

   private Arabic2RomanConverter converter;

   @BeforeEach
   public void setUp() {
      converter = new Arabic2RomanConverter();
   }

   @Test
   @DisplayName("Negative numbers throw an IllegalArgumentException.")
   public void testInvalidNegativeParameter() throws Exception {
      try {
         converter.convert(-1);
         fail("Exception should have been thrown before.");
      } catch (IllegalArgumentException e) {
         assertThat(e.getMessage(), is("Only numbers between 0 and 3000 are allowed."));
      }
   }

   @Test
   @DisplayName("Numbers over 3000 throw an IllegalArgumentException.")
   public void testInvalidTooBigParameter() throws Exception {
      Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
         converter.convert(3001);
      });
      Assertions.assertEquals(exception.getMessage(), "Only numbers between 0 and 3000 are allowed.");
   }

   @Test
   @DisplayName("Numbers over 3000 throw an IllegalArgumentException.")
   public void testAnotherInvalidTooBigParameter() throws Exception {
      CatchException.catchException(converter).convert(3002);
      assertThat(CatchException.caughtException(), isA(IllegalArgumentException.class));
      assertThat(CatchException.caughtException().getMessage(), is("Only numbers between 0 and 3000 are allowed."));
   }

   @ParameterizedTest(name = "{0}  → \"{1}\"")
   @CsvSource({ "0, ''", "1, I", "2, II", "4, IV", "5, V", "9, IX", "40, XL", "90, XC", "400, CD", "500, D", "900, CM",
         "1000, M", "1984, MCMLXXXIV", "2300, MMCCC", "2330, MMCCCXXX", "2350, MMCCCL", "3000,MMM" })
   @DisplayName("Konvertiere arabische Zahl in römische Zeichen")
   void testDifferentValues(final int arabicNumber, final String romanChars) throws Exception {
      assertThat(new Arabic2RomanConverter().convert(arabicNumber), is(romanChars));
   }

}
