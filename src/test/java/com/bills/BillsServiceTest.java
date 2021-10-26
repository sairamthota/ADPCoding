package com.bills;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bills.service.BillsService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BillsApplication.class)
public class BillsServiceTest {

	@Autowired
	private BillsService service;
	
	@Before
	public void before(){
		service.insertBillsData(getBills());
		service.insertCoinsData(getCoins(), 100);
	}
	private List<Double> getBills(){
		List<Double> bills = new ArrayList<Double>();
		bills.add(1.0);bills.add(2.0);bills.add(5.0);bills.add(10.0);
		bills.add(20.0);bills.add(50.0);bills.add(100.0);
		return bills;
	}
	
	private List<Double> getCoins(){
		List<Double> coins = new ArrayList<Double>();
		coins.add(0.01);coins.add(0.05);coins.add(0.10);coins.add(0.25);
		return coins;
	}
	
	@Test
	public void getCoinsCount(){
		try {
			List<Double> details = service.getCoinsCount(10.0);
			assertTrue(details.size()>0);
		} catch (Exception e) {
			assertFalse(true);
		}
	}
	
	@Test
	public void getInvalidBill(){
		try {
			service.getCoinsCount(0.3);
			assertFalse(true);
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void getInvalidCoinsChange(){
		try {
			service.getCoinsCount(1200000.0);
			assertFalse(true);
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
}
