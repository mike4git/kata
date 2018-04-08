package de.neusta.kata.arabic2roman;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class DateInRomanCharsServiceTest {

   @InjectMocks
   private DateInRomanCharsService service;

   @Mock
   private Arabic2RomanConverter converter;

   @BeforeEach
   void setUp() {
      MockitoAnnotations.initMocks(this);
   }

   @Test
   void testServiceCallForCertainDate() throws Exception {
      String date = "25.04.1971";
      when(converter.convert(25)).thenReturn("XXV");
      when(converter.convert(4)).thenReturn("VI");
      when(converter.convert(1971)).thenReturn("MCMLXXI");
      assertEquals("XXV-VI-MCMLXXI", service.getDate(new SimpleDateFormat("dd.MM.yyyy").parse(date)));
   }

}
