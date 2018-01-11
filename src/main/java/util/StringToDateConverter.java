package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;


public class StringToDateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String source) {
		// TODO Auto-generated method stub
		try {
			return new SimpleDateFormat("yyyy-M-dd").parse(source);
		} catch (ParseException e) {
			return null;
		}
	}

}
