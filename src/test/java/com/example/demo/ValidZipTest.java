package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ValidZipTest {

	@Test
	public void validXZip() {
		String zip = "12345";
		assertEquals(true, zip.matches("[0-9]{1,5}"));
	}
	
	@Test
	public void inValidXZip() {
		String zip = "1234A";
		assertEquals(true, zip.matches("[0-9]{1,5}"));
	}
}
