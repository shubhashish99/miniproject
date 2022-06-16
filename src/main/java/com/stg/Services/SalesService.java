package com.stg.Services;

import java.util.Date;
import java.util.List;

import com.stg.entity.Sales;

public interface SalesService {

	public abstract Sales findSaleByDate(Date saleDate); // validation

	public abstract List<Sales> fetchSalesList(); // read

	public abstract Sales addSales(Sales sales); // add

	public abstract String updateSales(int saleId, float saleAmount, Date saleDate); // update

	public abstract String deleteBySalesId(int saleId); // delete

}
