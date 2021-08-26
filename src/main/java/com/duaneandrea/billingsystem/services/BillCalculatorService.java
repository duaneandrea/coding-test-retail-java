package com.duaneandrea.billingsystem.services;

import java.util.List;
import com.duaneandrea.billingsystem.domain.Customer;
import com.duaneandrea.billingsystem.domain.Item;

public interface BillCalculatorService {
	
	double calculateTotalPayableAmount(Customer customer, List<Item> items);

}
