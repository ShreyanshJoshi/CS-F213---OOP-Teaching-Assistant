/**
 * @author Santosh, Shreyansa, Shreyansh
 *
 */
import static org.junit.Assert.*;
import java.lang.reflect.Field;

import org.junit.Test;

public class ShopTestConstructor {

	@Test
	public void test() throws NoSuchFieldException, IllegalAccessException{
		
		Shop shop = new Shop(20,10);
		Field productList = shop.getClass().getDeclaredField("productList");
		productList.setAccessible(true);
		String[] products = (String[]) productList.get(shop);
		
		Field customerList = shop.getClass().getDeclaredField("customerList");
		customerList.setAccessible(true);
		Customer[] customers = (Customer[]) customerList.get(shop);
		
		Field priceOfProduct = shop.getClass().getDeclaredField("priceOfProduct");
		priceOfProduct.setAccessible(true);
		int price = (int) priceOfProduct.get(shop);
		
		Field currentCustomerCount = shop.getClass().getDeclaredField("currentCustomerCount");
		currentCustomerCount.setAccessible(true);
		int count1 = (int) currentCustomerCount.get(shop);
		
		Field customerCountToday = shop.getClass().getDeclaredField("customerCountToday");
		customerCountToday.setAccessible(true);
		int count2 = (int) customerCountToday.get(shop);
		
		Field revenueToday = shop.getClass().getDeclaredField("revenueToday");
		revenueToday.setAccessible(true);
		int revenue = (int) revenueToday.get(shop);
		
		boolean check1 = (products.length == 10);
		boolean check2 = (customers.length == 20);
		boolean check3 = (price == 10);
		boolean check4 = (count1 == 0);
		boolean check5 = (count2 == 0);
		boolean check6 = (revenue == 0);
		
		
		boolean check = check1 && check2 && check3 && check4 && check5 && check6;
		assertTrue(check);
	}
}
