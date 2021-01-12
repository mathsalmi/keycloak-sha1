package com.msalmi;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SHA1HashProviderTest {

	@Test
	public void encodeHelloWorld() {
		final var provider = new SHA1HashProvider(SHA1HashProviderFactory.ID);
		var expected = "2aae6c35c94fcfb415dbe95f408b9ce91ee846ed";
		var encoded = provider.encode("hello world", 0);
		assertTrue(encoded.equals(expected));
	}
	
	@Test
	public void encodeEmptyString() {
		final var provider = new SHA1HashProvider(SHA1HashProviderFactory.ID);
		var expected = "da39a3ee5e6b4b0d3255bfef95601890afd80709";
		var encoded = provider.encode("", 0);
		assertTrue(encoded.equals(expected));
	}
	
	@Test
	public void ensureIterationParameterIsIgnored() {
		final var provider = new SHA1HashProvider(SHA1HashProviderFactory.ID);
		var expected = "da39a3ee5e6b4b0d3255bfef95601890afd80709";
		var encoded = provider.encode("", 0);
		assertTrue(encoded.equals(expected));
		
		expected = "da39a3ee5e6b4b0d3255bfef95601890afd80709";
		encoded = provider.encode("", 42); // any random number
		assertTrue(encoded.equals(expected));
	}
	
	@Test
	public void testHashesWithLeadingZeros() {
		final var provider = new SHA1HashProvider(SHA1HashProviderFactory.ID);
		var expected = "042dc4512fa3d391c5170cf3aa61e6a638f84342";
		var encoded = provider.encode("i", 0);
		assertTrue(encoded.equals(expected));
	}
}
