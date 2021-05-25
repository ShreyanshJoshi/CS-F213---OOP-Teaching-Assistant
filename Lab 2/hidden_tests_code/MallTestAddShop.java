/**
 * @author Santosh, Shreyansa, Shreyansh
 *
 */
import static org.junit.Assert.*;
import org.junit.Test;


// Checking the AddShop method of the Mall CLass
public class MallTestAddShop {


	@Test
	public void testAddShop() {
		
		Mall mall = new Mall();
		
		boolean check1 = mall.addShop(2, 5);
		boolean check2 = mall.addShop(6, 10);
		boolean check3 = mall.addShop(5, 5);
		boolean check4 = mall.addShop(9, 12);
		boolean check5 = mall.addShop(5, 3);
		boolean check6 = mall.addShop(7, 20);
		boolean check7 = mall.addShop(6, 7); // false
		
		/* The number of shops in a Mall should not exceed MAX_SHOPS, so it should return false on the 7th entry of a shop. */
		boolean check = check1 && check2 && check3 && check4 && check5 && check6 && !check7;
		
		assertTrue(check);
	}
}
