package com.bills.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bills.service.BillsService;

@Service 
public class BillsServiceImpl implements BillsService {
	
	private static List<Double> bills = new ArrayList<>();
	private static Map<Double,Integer> coins = new HashMap<>();
	private static List<Double> deno = new ArrayList<Double>();
	@Override
	public String insertBillsData(List<Double> bills) {
		BillsServiceImpl.bills = bills;
		return "Inserted Bills";
	}

	@Override
	public String insertCoinsData(List<Double> coins, Integer coinsCount) {
		for(Double coin : coins) {
			BillsServiceImpl.coins.put(coin, coinsCount);
			deno.add(coin);
		}
		return "Inserted Coins";
	}

	@Override
	public List<Double> getCoinsCount(Double bill) throws Exception {
			if(!bills.contains(bill)) {
				throw new Exception("Invalid Bill Amount");
			}
			
			List<Double> result =  new ArrayList<>();
			int n = deno.size();
			boolean flag = true;
			for (int i = n - 1; i >= 0; i--) {
				while (bill >= deno.get(i) && flag) {
					Integer val = coins.get(deno.get(i));
					if(val !=null) {
						bill -= deno.get(i);
						bill = Math.round(bill * 100.0) / 100.0;
						result.add(deno.get(i));
						if(val ==1) coins.remove(deno.get(i));
						else coins.put(deno.get(i), val-1);
					}else flag = false;
				}
			}
			
			if(!flag) {
				throw new Exception("Coins are not available to provide change");
			}
			
			return result;
	}
	
}
