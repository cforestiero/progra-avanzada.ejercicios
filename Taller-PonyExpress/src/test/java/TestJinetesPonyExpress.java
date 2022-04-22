import org.junit.Assert;
import org.junit.Test;

import ponyexpress.PonyExpress;

public class TestJinetesPonyExpress {

	@Test
	public void testJinetes() {
		PonyExpress p = new PonyExpress();

		Assert.assertEquals(1, p.jinetes(new int[] { 18, 15 }));
		Assert.assertEquals(2, p.jinetes(new int[] { 43, 23, 40, 13 }));
		Assert.assertEquals(3, p.jinetes(new int[] { 33, 8, 16, 47, 30, 30, 46 }));
		Assert.assertEquals(3, p.jinetes(new int[] { 51, 51, 51 }));
		Assert.assertEquals(4, p.jinetes(new int[] { 6, 24, 6, 8, 28, 8, 23, 47, 17, 29, 37, 18, 40, 49 }));
	}

}
