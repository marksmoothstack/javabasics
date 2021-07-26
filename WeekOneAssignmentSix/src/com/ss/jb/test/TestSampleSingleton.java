package com.ss.jb.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ss.jb.six.SampleSingleton;

public class TestSampleSingleton {

	@Test
	public void testSingleton() {
		
		// Check to ensure only one instance is in use
		assertEquals(SampleSingleton.getInstance(), SampleSingleton.getInstance());
		
		// Use setter and check if getter returns same value
		SampleSingleton.setConn(null);
		assertEquals(null, SampleSingleton.getConn());
	}
	
}
