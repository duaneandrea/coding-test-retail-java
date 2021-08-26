package com.mckinsey.billingsystem.base;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import com.duaneandrea.billingsystem.domain.Customer;
import com.duaneandrea.billingsystem.domain.CustomerType;
import com.duaneandrea.billingsystem.domain.Item;
import com.duaneandrea.billingsystem.domain.Product;

public class BillingSystemBuilder {
	
	private static final int CUSTOMER_LOYALTY_TIME_PERIOD_IN_YRS = 2;
	
	public static Product getDiscountableProduct() {
		Product product = new Product();
		product.setSku("MKU12344345");
		product.setName("SpiderManStickers");
		product.setDiscountable(Boolean.TRUE);
		product.setPrice(57.99);
		
		return product;
	}
	
	public static Product getNonDiscountableProduct() {
		Product product = new Product();
		product.setSku("MKU99999999");
		product.setName("Oats");
		product.setDiscountable(Boolean.FALSE);
		product.setPrice(49.99);
		
		return product;
	}
	
	public static Customer getAffiliateCustomer() {
		Customer customer = new Customer(CustomerType.AFFILIATE, "testCustomer001", "ABC Affiliate", new DateTime().minusYears(3));
		return customer;
	}
	
	public static Customer getEmployeeCustomer() {
		Customer customer = new Customer(CustomerType.EMPLOYEE, "testCustomer111", "John", new DateTime().minusYears(3));
		return customer;
	}
	
	public static Customer getCustomerWithMoreThanTwoYearOldRegistration() {
		Customer customer = new Customer(CustomerType.CUSTOMER, "testCustomer222", "Caroll", new DateTime().minusYears(CUSTOMER_LOYALTY_TIME_PERIOD_IN_YRS).minusDays(1));
		return customer;
	}
	
	public static Customer getCustomerWithLessThanTwoYearOldRegistration() {
		Customer customer = new Customer(CustomerType.CUSTOMER, "testCustomer333", "Rambo", new DateTime().minusYears(CUSTOMER_LOYALTY_TIME_PERIOD_IN_YRS).plusDays(1));
		return customer;
	}
	
	public static Item getItemWithDiscountableProduct(int quantity) {
		return new Item(getDiscountableProduct(), quantity);
	}
	
	public static Item getItemWithNonDiscountableProduct(int quantity) {
		return new Item(getNonDiscountableProduct(), quantity);
	}
	
	public static List<Item> getItemListWithMultipleProducts() {
		List<Item> items = new ArrayList<Item>();
		items.add(getItemWithDiscountableProduct(10));
		items.add(getItemWithNonDiscountableProduct(5));
		return items;
	}
}
