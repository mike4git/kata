package de.neusta.kata.arabic2roman;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;

import de.neusta.kata.arabic2roman.Arabic2RomanConverterWithoutTDD;

public class Arabic2RomanConverterWithoutTDDTest {

   private Arabic2RomanConverterWithoutTDD converter;

   @Before
   public void setUp() {
      converter = new Arabic2RomanConverterWithoutTDD();
   }

   @Test(expected = IllegalArgumentException.class)
   public void testInvalidNegativeParameter() throws Exception {
      converter.convert(-1);
   }

   @Test(expected = IllegalArgumentException.class)
   public void testInvalidTooBigParameter() throws Exception {
      converter.convert(3001);
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

}
