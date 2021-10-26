package com.bills.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bills.service.BillsService;

@RestController
public class BillsController {
	
	@Autowired
	private BillsService service;
	
	@GetMapping("/test")
	public String test() {
		return "ssa";
	}
	
	@PostMapping("/insertBillsData")
	public String insertBillsData(@RequestBody List<Double> bills) {
		return service.insertBillsData(bills);
	}
	
	@PostMapping("/insertCoinsData/{coinsCount}")
	public String insertCoinsData(@RequestBody List<Double> coins, @PathVariable Integer coinsCount) {
		return service.insertCoinsData(coins,coinsCount);
	}
	
	@GetMapping("/getCoins/{bill}")
	public ResponseEntity<?> getCoinsCount(@PathVariable Double bill) throws Exception{
		return new ResponseEntity<>( this.service.getCoinsCount(bill), HttpStatus.OK);
	}
}
