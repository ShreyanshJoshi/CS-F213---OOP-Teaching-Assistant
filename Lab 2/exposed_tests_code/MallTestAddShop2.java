/**
 * @author Santosh, Shreyansa, Shreyansh
 *
 */
import static org.junit.Assert.*;
import org.junit.Test;


// Checking the AddShop method of the Mall CLass
public class MallTestAddShop2 {


	@Test
	public void testAddShop() {
		
		Mall mall = new Mall();
		
		boolean check1 = mall.addShop(2, 5);
		boolean check2 = mall.addShop(6, 10);
		boolean check3 = mall.addShop(5, 5);
		boolean check4 = mall.addShop(9, 12);

		boolean check = check1 && check2 && check3 && check4;
		
		assertTrue(check);
	}
}
