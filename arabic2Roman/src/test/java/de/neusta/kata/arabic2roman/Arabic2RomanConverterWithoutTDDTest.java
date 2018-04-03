package de.neusta.kata.arabic2roman;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThat;

public class Arabic2RomanConverterWithoutTDDTest {

   private Arabic2RomanConverterWithoutTDD converter;

   @BeforeEach
   public void setUp() {
      converter = new Arabic2RomanConverterWithoutTDD();
   }

   @Test
   public void testInvalidNegativeParameter() throws Exception {
      Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
         converter.convert(-1);
      });
      assertEquals("Only numbers between 0 and 3000 are allowed.", exception.getMessage());
   }

   @Test
   public void testInvalidTooBigParameter() throws Exception {
      assertThatThrownBy(() -> {
         converter.convert(3001);
      }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Only numbers between 0 and 3000 are allowed.");

   }

   @Test
   public void test2111() {
      assertThat(converter.convert(2111), is("MMCXI"));
   }

   @Test
   public void test444() {
      assertThat(converter.convert(444), is("CDXLIV"));
   }

   @Test
   public void test999() {
      assertThat(converter.convert(999), is("CMXCIX"));
   }

   @Test
   public void test666() {
      assertThat(converter.convert(666), is("DCLXVI"));
   }

   @Test
   public void test1000() {
      assertThat(converter.convert(1000), is("M"));
   }

   @Test
   public void test100() throws Exception {
      assertThat(converter.convert(100), is("C"));
   }
}
