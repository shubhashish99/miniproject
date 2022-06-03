package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stg.Services.RestaurantService;
import com.stg.entity.Restaurant;

@RestController
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantService;

	@GetMapping(value = "/checkRestaurant", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurant> checkRestaurant(@RequestBody int restaurantId) {

		Restaurant restaurant = restaurantService.checkRestaurant(restaurantId);

		return new ResponseEntity<Restaurant>(restaurant, HttpStatus.OK);
	}

	@GetMapping(value = "/searchByRestaurantType", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurant> searchByRestaurantType(@RequestBody String restaurantType) {

		List<Restaurant> restaurant = restaurantService.searchByRestaurantType(restaurantType);

		return new ResponseEntity<Restaurant>((Restaurant) restaurant, HttpStatus.OK);
	}

	@PostMapping(value = "/addRestaurant", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {

		Restaurant restaurant1 = restaurantService.addRestaurant(restaurant);

		return new ResponseEntity<Restaurant>(restaurant1, HttpStatus.OK);
	}

	@PutMapping(value = "/updateRestaurant", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurant> updateRestaurant(@RequestBody Restaurant restaurant) {

		Restaurant restaurant1 = restaurantService.updateRestaurant(restaurant);

		return new ResponseEntity<Restaurant>(restaurant1, HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteByRestaurtantId", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurant> deleteByRestaurtantId(@RequestBody int restaurantId) {

		restaurantService.deleteByRestaurtantId(restaurantId);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
