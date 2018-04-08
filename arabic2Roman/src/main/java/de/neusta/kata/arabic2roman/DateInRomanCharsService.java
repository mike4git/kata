package de.neusta.kata.arabic2roman;

import java.util.Date;

import javax.annotation.Resource;

public class DateInRomanCharsService {

   @Resource
   private Arabic2RomanConverter converter;

   public String getDate(final Date date) {
      return converter.convert(date.getDate()) + "-" + converter.convert(date.getMonth() + 1) + "-"
            + converter.convert(date.getYear() + 1900);
   }

}
