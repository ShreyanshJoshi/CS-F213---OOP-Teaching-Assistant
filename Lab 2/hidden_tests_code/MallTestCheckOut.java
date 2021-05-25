/**
 * @author Santosh, Shreyansa, Shreyansh
 *
 */
import static org.junit.Assert.*;

import org.junit.Test;


//CheckOut Function of the Mall Class
//Working functions needed - addShop(), addProduct(), checkIn(), productAvailToBuy(), getRevenueToday(), getCurrentCustomerCOunt(), getCustomerCountToday()
public class MallTestCheckOut {


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

		/* Testing getProductList() since it is a part of checkOut */
		String[] productList = {"Bed", "Bookshelf", "Cushions", "Side table"};
		boolean check2 = true;
		for(int i = 0 ; i < 4 ; i++) {
			check2 = check2 && (mall.getProductList(0)[i] == productList[i]);
		}
		
		
		boolean check3 = mall.checkOut(0); // false
		mall.checkIn(0, 101, false, 1);
		mall.checkIn(0, 102, true, 1);
		mall.checkIn(0, 103, true, 1);
		mall.checkIn(0, 104, false, 1);
		mall.checkIn(0, 105, true, 1);
		boolean check4 = mall.checkOut(0);
		mall.checkIn(0, 106, true, 1);
		
		mall.checkIn(1, 107, true, 2);
		mall.checkIn(1, 107, true, 1);
		mall.checkIn(1, 107, true, 1);
		boolean check5 = mall.checkOut(1);
		
		/* Testing getCustomerCountToday() and getCurrentCustomerCount() since they are a part of checkOut() */
		boolean check6 = (mall.getCustomerCountToday() == 10);
		boolean check7 = (mall.getCurrentCustomerCount() == 7);
		

		boolean check = check1 && check2 && !check3 && check4 && check5 && check6 && check7;
		assertTrue(check);
		
	}
}
