package com.stg.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.Exception.CustomException;
import com.stg.entity.Restaurant;
import com.stg.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public Restaurant findRestaurant(int restaurantId) {
		Restaurant restaurant = restaurantRepository.findByRestaurantId(restaurantId);

		if (restaurant == null) {
			throw new CustomException("Restaurant not found!");
		} else {
			return restaurant;
		}
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		List<Restaurant> restaurants = restaurantRepository.findAll();

		if (restaurants.size() > 0) {
			return restaurants;
		} else {
			return new ArrayList<Restaurant>();
		}

	}

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) {

		return restaurantRepository.save(restaurant);
	}

	@Override
	public String updateRestaurant(int restaurantId, String restaurantType, String restaurantName) {

		Restaurant restaurant = restaurantRepository.findByRestaurantId(restaurantId);
		if (restaurant != null) {

			restaurant.setRestaurantName(restaurantName);
			restaurant.setRestaurantType(restaurantType);
			restaurantRepository.save(restaurant);
			return "Restaurant deatils updated ";
		} else {
			throw new CustomException("Restaurant not found!");
		}

	}

	@Override
	public String deleteRestaurtant(int restaurantId) {
		Restaurant restaurant = restaurantRepository.findByRestaurantId(restaurantId);
		if (restaurant != null) {
			restaurantRepository.delete(restaurant);
			return "Restaurant is deleted!";
		} else {
			throw new CustomException("No restaurant found by given id!");
		}

	}

}
