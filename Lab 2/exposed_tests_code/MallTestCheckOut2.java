/**
 * @author Santosh, Shreyansa, Shreyansh
 *
 */
import static org.junit.Assert.*;

import org.junit.Test;


//CheckOut Function of the Mall Class
//Working functions needed - addShop(), addProduct(), checkIn(), productAvailToBuy(), getRevenueToday(), getCurrentCustomerCOunt(), getCustomerCountToday()
public class MallTestCheckOut2 {


	@Test
	public void testCheckOut() {
		
		Mall mall = new Mall();
		mall.addShop(5,  5);
		mall.addShop(10, 2);
		
		mall.addProduct(0, "Sofa");
		mall.addProduct(0, "Coffee table");
		mall.addProduct(0, "Dining table");
		mall.addProduct(0, "Bed");
		mall.addProduct(0, "Bookshelf");
		mall.addProduct(0, "Cushions");
		mall.addProduct(0, "Side table");
		
		mall.addProduct(1, "Shoes");
		mall.addProduct(1, "Basketball");
		mall.addProduct(1, "Cycle pump");
		mall.addProduct(1, "Backpack");
		
		
		mall.checkIn(0, 100, true, 3);
		
		/* Testing checkOut() */
		boolean check1 = mall.checkOut(0);
		boolean check2 = mall.checkOut(0); // false
		
		
		/* Testing getCustomerCountToday() and getCurrentCustomerCount() since they are a part of checkOut() */
		boolean check3 = (mall.getCustomerCountToday() == 1);
		boolean check4 = (mall.getCurrentCustomerCount() == 0);
		

		boolean check = check1 && !check2 && check3 && check4;
		assertTrue(check);
		
	}
}
