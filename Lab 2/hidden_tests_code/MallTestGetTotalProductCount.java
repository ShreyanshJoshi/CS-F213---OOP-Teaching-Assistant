/**
 * @author Santosh, Shreyansa, Shreyansh
 *
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class MallTestGetTotalProductCount {

	@Test
	public void testGetTotalProductCount() {
		Mall mall  = new Mall();
		
		mall.addShop(10,  5);
		mall.addShop(20, 5);
		mall.addShop(15, 2);
		
		mall.addProduct(0, "Sofa");
		mall.addProduct(0, "Coffee table");
		mall.addProduct(0, "Dining table");
		mall.addProduct(0, "Bed");
		mall.addProduct(0, "Bookshelf");
		mall.addProduct(0, "Cushions");
		mall.addProduct(0, "Side table");
		mall.addProduct(0, "Sofa");
		mall.addProduct(0, "Coffee table");
		mall.addProduct(0, "Dining table");
		mall.addProduct(0, "Bed");
		mall.addProduct(0, "Bookshelf");
		mall.addProduct(1, "Cushions");
		mall.addProduct(1, "Side table");
		mall.addProduct(1, "Sofa");
		mall.addProduct(1, "Coffee table");

		
		boolean check = (mall.getTotalProductCount() == 14);
		assertTrue(check);

	}
}
