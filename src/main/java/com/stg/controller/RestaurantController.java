package com.stg.controller;

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

import com.stg.Services.RestaurantService;
import com.stg.entity.Restaurant;

@RestController
@RequestMapping(value = "restaurant")
@CrossOrigin("http://localhost:4200/")
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantService;

	@GetMapping(value = "/findRestaurant", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurant> findRestaurant(@PathVariable int restaurantId) {

		Restaurant restaurant = restaurantService.findRestaurant(restaurantId);

		return new ResponseEntity<Restaurant>(restaurant, HttpStatus.OK);
	}

	@PostMapping(value = "/addRestaurant", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {

		Restaurant restaurant1 = restaurantService.addRestaurant(restaurant);

		return new ResponseEntity<Restaurant>(restaurant1, HttpStatus.OK);
	}

	@PutMapping(value = "/updateRestaurant", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateRestaurant(@PathVariable int restaurantId, @PathVariable String restaurantType,
			@PathVariable String restaurantName) {

		String restaurant1 = restaurantService.updateRestaurant(restaurantId, restaurantType, restaurantName);

		return new ResponseEntity<String>(restaurant1, HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteRestaurtant", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteRestaurtant(@PathVariable int restaurantId) {

		String restaurant1 = restaurantService.deleteRestaurtant(restaurantId);

		return new ResponseEntity<String>(restaurant1, HttpStatus.OK);
	}

}
