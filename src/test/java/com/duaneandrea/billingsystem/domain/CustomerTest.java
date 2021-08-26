package com.duaneandrea.billingsystem.domain;

import junit.framework.Assert;

import org.junit.Test;

import com.mckinsey.billingsystem.base.BillingSystemBuilder;

public class CustomerTest {
	
	@Test
	public void shouldReturnTrueForMoreThanTwoYearOldRegistration() {
		Customer customer = BillingSystemBuilder.getCustomerWithMoreThanTwoYearOldRegistration();
		Assert.assertTrue(customer.isAvailableForLoyaltyDiscount());
	}
	
	@Test
	public void shouldReturnFalseForNonEmployee() {
		Customer customer = BillingSystemBuilder.getAffiliateCustomer();
		Assert.assertFalse(customer.isAvailableForLoyaltyDiscount());
	}
	
	@Test
	public void shouldReturnFalseForLessThanTwoYearOldRegistration() {
		Customer customer = BillingSystemBuilder.getCustomerWithLessThanTwoYearOldRegistration();
		Assert.assertFalse(customer.isAvailableForLoyaltyDiscount());
	}
}
