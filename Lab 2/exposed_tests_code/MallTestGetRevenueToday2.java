import static org.junit.Assert.*;

import org.junit.Test;

public class MallTestGetRevenueToday2 {

	@Test
	public void testGetRevenueToday() {
		
		Mall mall = new Mall();
		mall.addShop(5,  5);
		
		mall.addProduct(0, "Sofa");
		mall.addProduct(0, "Coffee table");
		mall.addProduct(0, "Dining table");
		mall.addProduct(0, "Bed");
		mall.addProduct(0, "Bookshelf");
		mall.addProduct(0, "Cushions");
		mall.addProduct(0, "Side table");
		
		mall.checkIn(0, 100, true, 3);
		mall.checkIn(0, 101, true, 1);
		mall.checkOut(0);
		mall.checkOut(0);
	
		boolean check = (mall.getRevenueToday() == 20);
		assertTrue(check);
		
	}

}
