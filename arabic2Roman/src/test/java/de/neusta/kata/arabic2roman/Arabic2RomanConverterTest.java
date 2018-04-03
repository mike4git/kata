package de.neusta.kata.arabic2roman;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
   public void testInvalidNegativeParameter() throws Exception {
      try {
         converter.convert(-1);
         fail("Exception should have been thrown before.");
      } catch (IllegalArgumentException e) {
         assertThat(e.getMessage(), is("Only numbers between 0 and 3000 are allowed."));
      }
   }

   @Test
   public void testInvalidTooBigParameter() throws Exception {
      Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
         converter.convert(3001);
      });
      Assertions.assertEquals(exception.getMessage(), "Only numbers between 0 and 3000 are allowed.");
   }

   @Test
   public void testAnotherInvalidTooBigParameter() throws Exception {
      CatchException.catchException(converter).convert(3002);
      assertThat(CatchException.caughtException(), isA(IllegalArgumentException.class));
      assertThat(CatchException.caughtException().getMessage(), is("Only numbers between 0 and 3000 are allowed."));
   }

   @Test
   public void test1000() {
      assertThat(converter.convert(1000), is("M"));
   }

   @Test
   public void test3000() {
      assertThat(converter.convert(3000), is("MMM"));
   }

   @Test
   public void test2300() throws Exception {
      assertThat(converter.convert(2300), is("MMCCC"));
   }

   @Test
   public void test2350() throws Exception {
      assertThat(converter.convert(2350), is("MMCCCL"));
   }

   @Test
   public void test2330() throws Exception {
      assertThat(converter.convert(2330), is("MMCCCXXX"));
   }

   @Test
   public void test40() throws Exception {
      assertThat(converter.convert(40), is("XL"));
   }

   @Test
   public void test90() throws Exception {
      assertThat(converter.convert(90), is("XC"));
   }

   @Test
   public void test500() throws Exception {
      assertThat(converter.convert(500), is("D"));
   }

   @Test
   public void test900() throws Exception {
      assertThat(converter.convert(900), is("CM"));
   }

   @Test
   public void test400() throws Exception {
      assertThat(converter.convert(400), is("CD"));
   }

   @Test
   public void test9() throws Exception {
      assertThat(converter.convert(9), is("IX"));
   }

   @Test
   public void test5() throws Exception {
      assertThat(converter.convert(5), is("V"));
   }

   @Test
   public void test4() throws Exception {
      assertThat(converter.convert(4), is("IV"));
   }

   @Test
   public void test1() throws Exception {
      assertThat(converter.convert(1), is("I"));
   }

   @Test
   public void test0() throws Exception {
      assertThat(converter.convert(0), is(""));
   }
}
