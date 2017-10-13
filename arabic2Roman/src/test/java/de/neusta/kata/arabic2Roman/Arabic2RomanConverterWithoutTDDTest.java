package de.neusta.kata.arabic2Roman;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;

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
   public void testConvert1984() throws Exception {
      assertThat(converter.convert(1984), is("MCMLXXXIV"));
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

}
