package com.stg.Services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.Exception.CustomException;
import com.stg.entity.Sales;
import com.stg.repository.SalesRepository;

@Service
public class SalesServiceImpl implements SalesService {

	@Autowired
	private SalesRepository salesRepository;

	@Override
	public Sales findSaleByDate(Date saleDate) {

		Sales sales = salesRepository.findBySaleDate(saleDate);
		if (sales == null) {
			throw new CustomException("sale not found!");
		} else {
			return sales;
		}
	}

	@Override
	public List<Sales> fetchSalesList() {

		return salesRepository.findAll();
	}

	@Override
	public Sales addSales(Sales sales) {

		return salesRepository.save(sales);
	}

	@Override
	public String updateSales(int saleId, float saleAmount, Date saleDate) {
		Sales sales = salesRepository.findBySaleId(saleId);
		if (sales != null) {
			sales.setSaleAmount(saleAmount);
			sales.setSaleDate(saleDate);
			return "Sale details are updated!";
		} else {
			throw new CustomException("Sale not found!");
		}
	}

	@Override
	public String deleteBySalesId(int saleId) {
		Sales sales = salesRepository.findBySaleId(saleId);
		if (sales != null) {
			salesRepository.delete(sales);
			return "Sale is deleted!";
		} else {
			throw new CustomException("Sale not found!");
		}

	}

}
