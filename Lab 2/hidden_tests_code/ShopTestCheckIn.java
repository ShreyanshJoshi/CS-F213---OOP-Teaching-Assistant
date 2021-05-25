/**
 * @author Santosh, Shreyansa, Shreyansh
 *
 */
import static org.junit.Assert.*;
import org.junit.Test;


/* Here we are checking the CheckIn function of the Shop Class.
   Working functions needed - checkIn(), getCurrentCustomerCount() */

public class ShopTestCheckIn {
	
	
	@Test
	public void testCheckIn() throws NoSuchFieldException, IllegalAccessException {
		
		Shop shop = new Shop(3,10);
		
		boolean check1 = shop.checkIn(123, true, 1);
		boolean check2 = shop.checkIn(34, true, 2);
		boolean check3 = shop.checkIn(19, false, 3);
		boolean check4 = shop.checkIn(100, true, 5); // false
		boolean check5 = (shop.getCurrentCustomerCount() == 3);
		
		/* 4th customer isn't checked in since there are too many people in the shop */
		boolean check = check1 & check2 & check3 & !check4 & check5;
		assertTrue(check);
	}
}
