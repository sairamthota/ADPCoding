package com.bills.service;

import java.util.List;

public interface BillsService {

	String insertBillsData(List<Double> bills);

	String insertCoinsData(List<Double> coins, Integer coinsCount);

	List<Double> getCoinsCount(Double bill)throws Exception;
	
}
