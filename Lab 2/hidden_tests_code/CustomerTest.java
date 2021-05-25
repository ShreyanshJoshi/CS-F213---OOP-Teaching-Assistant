/**
 * @author Santosh, Shreyansh
 *
 */
import static org.junit.Assert.*;

import org.junit.Test;

//This Class is used to test all the getter functions of Customer Class
//Working functions needed - numProducts(), getWantToBuy(), getCustomerID()
public class CustomerTest {

	@Test
	public void testAll() {
		
		Customer c1  = new Customer(24,true,17);
		Customer c2  = new Customer(4,false,9);
		
		/* Testing getNumProducts */
		boolean check1 = (c1.getNumProducts() == 17);
		boolean check2 = (c2.getNumProducts() == 9);
		
		/* Testing getWantToBuy */
		boolean check3 = c1.getWantToBuy();
		boolean check4 = c2.getWantToBuy(); // false
		
		/* Testing getCustomerID */
		boolean check5 = (c1.getCustomerID() == 24);
		boolean check6 = (c2.getCustomerID() == 4);
		
		boolean check = check1 && check2 && check3 && !check4 && check5 && check6;
		assertTrue(check);
	}
}