package facebook;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class FacebookReaderTest {

	FacebookReader fb;
	
	@Before
	public void initBeforeTests() {
		
		fb = new FacebookReader();
		
	}
	
	@Test
	public void testJUnit() {
		
		assertTrue(true);
		
	}
	
	@Test
	public void testGetMyPosts() {
		
		assertNotNull(fb.getMyPosts());
		
	}
	
}
