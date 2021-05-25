import static org.junit.Assert.*;

import org.junit.Test;

public class MallTestGetRevenueToday {

	@Test
	public void testGetRevenueToday() {
		
		Mall mall = new Mall();
		mall.addShop(5,  5);
		mall.addShop(20, 2);
		
		mall.addProduct(0, "Sofa");
		mall.addProduct(0, "Coffee table");
		mall.addProduct(0, "Dining table");
		mall.addProduct(0, "Bed");
		mall.addProduct(1, "Bookshelf");
		mall.addProduct(1, "Cushions");
		mall.addProduct(1, "Side table");
		
		mall.checkIn(0, 100, true, 3);
		mall.checkOut(0);
		
		mall.checkIn(1, 101, false, 1);
		mall.checkIn(1, 102, true, 4);
		mall.checkOut(1);
		mall.checkOut(1);
		
		/* The customer in shop 0 buys 3 products worth 15. The customer in shop 1 buys 4 products worth 6. The other customer in shop 1
		 * doesn't buy anything.
		 */
		boolean check = (mall.getRevenueToday() == 21);
		assertTrue(check);
		
	}

}
