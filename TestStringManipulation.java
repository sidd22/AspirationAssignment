package com.aspiration.collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestStringManipulation {

	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringManipulation() {
		
		StringManipulation strManipulation = new StringManipulation();

		Assert.assertEquals("Mismatch", "asPirAtiOn.cOm", strManipulation.manipulateString("Aspiration.com", 3));
		Assert.assertEquals("Mismatch", "aspIratIon.cOm", strManipulation.manipulateString("Aspiration.com", 4));
		Assert.assertEquals("Mismatch", "Aspiration.com", strManipulation.manipulateString("Aspiration.com", 0));
		Assert.assertEquals("Mismatch", "ASPIRATION.COM", strManipulation.manipulateString("Aspiration.com", 1));

	}
}
