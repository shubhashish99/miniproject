package com.stg.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.Exception.CustomException;
import com.stg.entity.Tables;
import com.stg.repository.TablesRepository;

@Service
public class TablesServiceImpl implements TablesService {

	@Autowired
	private TablesRepository tableRepository;

	@Override
	public Tables findTable(int tableNo) {

		Tables checkTable = tableRepository.findByTableNo(tableNo);
		if (checkTable == null) {
			throw new CustomException("Employee not found!");
		} else {
			return checkTable;
		}
	}

	@Override
	public List<Tables> fetchTableList() {

		return tableRepository.findAll();
	}

	@Override
	public Tables addTable(Tables tables) {

		return tableRepository.save(tables);
	}

	@Override
	public String updateTables(int tableNo, int tableOccupanyNo) {

		{
			Tables tables = tableRepository.findByTableNo(tableNo);

			if (tables != null) {
				tables.setTableOccupanyNo(tableOccupanyNo);
				return "table is updated!";
			} else {
				throw new CustomException("table is not found!");

			}

		}

	}

}
