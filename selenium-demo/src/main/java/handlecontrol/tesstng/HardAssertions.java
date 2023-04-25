package handlecontrol.tesstng;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions {

	@Test
	void test() {
		int x = 10;
		int y = 15;

		if (x == y) {
			System.out.println("test passed");
		} else {
			System.out.println("test failed");
		}

		// Assert.assertEquals(actual, expected, description)
		// Assert.assertEquals(actual, expected)
		// description hiển thị khi điều khiển so sánh sai
		// Assert.assertNotEquals(null, null);
		Assert.assertFalse(false);
		Assert.assertTrue(false, "Failed data");
		// Assert.assertNull(getClass());
		// Assert.assertSame(getClass(), getClass());

		Assert.assertEquals(10, 10, "Verify giá trị x,y");

		Assert.assertTrue(x < y); // pass

		int a = 10;
		int b = 20;
		Assert.assertEquals(a < b, true, "a is less than b"); // false
		Assert.assertEquals(a > b, true, "a is not greater than b"); // false

		String s1 = "abc";
		String s2 = "abc1";

		// Assert.assertEquals(s1, s2, "string are not equal"); // pass

		Assert.assertNotEquals(s1, s2); // fail
		System.out.println("Kết thúc việc test");

	}

}
