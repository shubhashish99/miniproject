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
	public boolean checkRestaurantTable(int tableNo) {

		boolean isAvailable = tableRepository.existsById(tableNo);
		if (isAvailable == false) {

			throw new CustomException("");
		}

		return true;

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
	public Tables updateRestaurantTables(Tables tables) {

		return tableRepository.save(tables);
	}

}
