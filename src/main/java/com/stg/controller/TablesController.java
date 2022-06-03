package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stg.Services.TablesService;
import com.stg.entity.Tables;

@RestController
public class TablesController {
	@Autowired
	private TablesService tablesService;

	@GetMapping(value = "/checkRestaurantTable", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> checkRestaurantTable(@RequestBody int tableNo) {

		boolean check = tablesService.checkRestaurantTable(tableNo);

		return new ResponseEntity<Boolean>(check, HttpStatus.OK);
	}

	@GetMapping(value = "/fetchTableList", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tables> fetchTableList() {

		List<Tables> resTables = tablesService.fetchTableList();

		return new ResponseEntity<Tables>((Tables) resTables, HttpStatus.OK);
	}

	@PostMapping(value = "/addTable", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tables> addTable(@RequestBody Tables resTables) {

		Tables resTables1 = tablesService.addTable(resTables);

		return new ResponseEntity<Tables>(resTables1, HttpStatus.OK);
	}

	@PutMapping(value = "/updateRestaurantTables", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tables> updateRestaurantTables(@RequestBody Tables resTables) {

		Tables resTables1 = tablesService.updateRestaurantTables(resTables);

		return new ResponseEntity<Tables>(resTables1, HttpStatus.OK);
	}

}
