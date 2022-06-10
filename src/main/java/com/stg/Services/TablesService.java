package com.stg.Services;

import java.util.List;

import com.stg.entity.Tables;

public interface TablesService {
	public abstract Tables findTable(int tableNo); // validation

	public abstract List<Tables> fetchTableList(); // read

	public abstract Tables addTable(Tables tables); // add

	public abstract String updateTables(int tableNo, int tableOccupanyNo); // update

}