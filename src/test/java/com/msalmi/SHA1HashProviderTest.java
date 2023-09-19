package com.msalmi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SHA1HashProviderTest {
	private SHA1HashProvider provider;

	@BeforeEach
	public void setup() {
		provider = new SHA1HashProvider(SHA1HashProviderFactory.ID);
	}

	@Test
	@DisplayName("Should encode 'hello world'")
	public void shouldEncodeHelloWorld() {
		var expected = "a67ee490ee7bff6898131cdc31e534338103c095";
		var encoded = provider.encode("hello world", 0);

		assertEquals(expected, encoded);
	}

	@Test
	@DisplayName("Should encode 'hello world' and ignore iterations")
	public void shouldEncodeHelloWorldAndIgnoreIterations() {
		var expected = "a67ee490ee7bff6898131cdc31e534338103c095";
		var encoded = provider.encode("hello world", 12);

		assertEquals(expected, encoded);
	}
	
	@Test
	@DisplayName("Should encode empty string")
	public void shouldEncodeEmptyString() {
		var expected = "da39a3ee5e6b4b0d3255bfef95601890afd80709";
		var encoded = provider.encode("", 0);

		assertEquals(expected, encoded);
	}

	@Test
	@DisplayName("Should encode with leading zeros")
	public void shouldEncodeWithLeadingZeros() {
		var expected = "0dd8e518cc8b6e0e4344462b1bab04dd5fe263da";
		var encoded = provider.encode("At4zpr9csm", 0);

		assertEquals(expected, encoded);
	}

	@Test
	@DisplayName("Should encode random string")
	public void shouldEncodeRandomString() {
		var expected = "e17d7c8ca045548d3bf7ad9eeb2f7ecf83654e78";
		var encoded = provider.encode("Zt72864b5", 0);

		assertEquals(expected, encoded);
	}
}
