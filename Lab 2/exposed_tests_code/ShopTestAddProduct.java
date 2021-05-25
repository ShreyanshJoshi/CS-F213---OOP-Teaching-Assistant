/**
 * @author Santosh, Shreyansa, Shreyansh
 *
 */

import static org.junit.Assert.*;
import org.junit.Test;


public class ShopTestAddProduct {
	
	@Test
	public void testAddProduct() throws NoSuchFieldException, IllegalAccessException {
		
		Shop shop = new Shop(6,10);
		
		/* Testing addProduct */
		boolean check1 = shop.addProduct("Cloth");
		boolean check2 = shop.addProduct("Teddy");
		boolean check3 = shop.addProduct("Sofa");
		boolean check4 = shop.addProduct("Ball");
		boolean check5 = shop.addProduct("Sunglasses");
		boolean check6 = shop.addProduct("Shoes");
		boolean check7 = shop.addProduct("Fridge");
		boolean check8 = shop.addProduct("TV");
		boolean check9 = shop.addProduct("Speakers");
		boolean check10 = shop.addProduct("Laptop");
		boolean check11 = shop.addProduct("Controller"); // false
		
		/* The 11th product isn't supposed to be added to the shop since MAX_PRODUCTS = 10 */
		boolean check = check1 && check2 && check3 && check4 && check5
				&& check6 && check7 && check8 && check9 && check10 && !check11;
		
		assertTrue(check);	
	}
}
