package de.neusta.kata.arabic2roman;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertThat;

public class Arabic2RomanConverterWithoutTDDTest {

   private Arabic2RomanConverterWithoutTDD converter;

   @Rule
   public ExpectedException expectedException = ExpectedException.none();

   @Before
   public void setUp() {
      converter = new Arabic2RomanConverterWithoutTDD();
   }

   @Test
   public void testInvalidNegativeParameter() throws Exception {
      expectedException.expect(IllegalArgumentException.class);
      expectedException.expectMessage("Only numbers between 0 and 3000 are allowed.");
      converter.convert(-1);
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
