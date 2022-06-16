package com.stg.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stg.Services.SalesService;
import com.stg.entity.Sales;

@RestController
@RequestMapping(value = "sale")
@CrossOrigin("http://localhost:4200/")
public class SalesController {

	@Autowired
	private SalesService salesService;

	@GetMapping(value = "/findSaleByDate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sales> findSaleByDate(@RequestBody Date saleDate) {

		Sales sales = salesService.findSaleByDate(saleDate);

		return new ResponseEntity<Sales>(sales, HttpStatus.OK);
	}

	@GetMapping(value = "/fetchSalesList", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sales> fetchSalesList() {

		List<Sales> sales = salesService.fetchSalesList();

		return new ResponseEntity<Sales>((Sales) sales, HttpStatus.OK);
	}

	@PostMapping(value = "/addSales", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sales> addSales(@RequestBody Sales sales) {

		Sales sales1 = salesService.addSales(sales);

		return new ResponseEntity<Sales>(sales1, HttpStatus.OK);
	}

	@PutMapping(value = "/updateSales/{saleId}/{saleAmount}/{saleDate}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateSales(@PathVariable int saleId, @PathVariable float saleAmount,
			@PathVariable Date saleDate) {

		String sales = salesService.updateSales(saleId, saleAmount, saleDate);

		return new ResponseEntity<String>(sales, HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteBySalesId/{saleId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteBySalesId(@PathVariable int saleId) {

		String sales = salesService.deleteBySalesId(saleId);

		return new ResponseEntity<String>(sales, HttpStatus.OK);
	}

}
