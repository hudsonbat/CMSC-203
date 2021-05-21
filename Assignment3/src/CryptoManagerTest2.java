import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CryptoManagerTest2 {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEncryptBellaso() {
		assertEquals("BNSIBEFV",CryptoManager.encryptBellaso("ALPHABET", "ABC"));
		
		
	}

}
