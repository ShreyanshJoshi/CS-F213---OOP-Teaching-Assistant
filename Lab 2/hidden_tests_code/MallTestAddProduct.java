/**
 * @author Santosh, Shreyansh
 *
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class MallTestAddProduct {

	@Test
	public void testAddProduct() {
		
		Mall mall = new Mall();
		mall.addShop(20, 2);
		mall.addShop(10,6);
		
		
		boolean check = mall.addProduct(2, "Speakers"); //false
		assertTrue(!check);
		
	}

}
