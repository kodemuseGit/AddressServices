package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PhoneFormatTest {

	@Test
	public void validLength() {
		String phone = "1234567890";
	 	assertEquals(true, phone.matches("[0-9]{1,10}"));
	}
	
	@Test
	public void inValidLength() {
		String phone = "12345678901";
	 	assertEquals(true, phone.matches("[0-9]{1,10}"));
	}
	
	@Test
	public void validFormat() {
		String phone = "123456789";
	 	assertEquals(true, phone.matches("[0-9]{1,10}"));
	}
	
	@Test
	public void inValidFormat() {
		String phone = "12345678";
	 	assertEquals(true, phone.matches("[0-9]{1,10}"));
	}
}
