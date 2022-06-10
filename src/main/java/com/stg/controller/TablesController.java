package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stg.Services.TablesService;
import com.stg.entity.Tables;

@RestController
@RequestMapping(value = "tables")
@CrossOrigin("http://localhost:4200/")
public class TablesController {
	@Autowired
	private TablesService tablesService;

	@GetMapping(value = "/findTable/{tableNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tables> findTable(@PathVariable int tableNo) {

		Tables check = tablesService.findTable(tableNo);

		return new ResponseEntity<Tables>(check, HttpStatus.OK);
	}

	@GetMapping(value = "/fetchTableList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tables> fetchTableList() {

		List<Tables> resTables = tablesService.fetchTableList();

		return new ResponseEntity<Tables>((Tables) resTables, HttpStatus.OK);
	}

	@PostMapping(value = "/addTable/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tables> addTable(@RequestBody Tables resTables) {

		Tables resTables1 = tablesService.addTable(resTables);

		return new ResponseEntity<Tables>(resTables1, HttpStatus.OK);
	}

	@PutMapping(value = "/updateTables/{tableNo}/{tableOccupanyNo}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateTables(@PathVariable int tableNo, @PathVariable int tableOccupanyNo) {

		String resTables1 = tablesService.updateTables(tableNo, tableOccupanyNo);

		return new ResponseEntity<String>(resTables1, HttpStatus.OK);
	}

}
