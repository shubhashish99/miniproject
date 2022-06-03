package com.stg.Services;

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
	public Restaurant checkRestaurant(int restaurantId) {
		Restaurant restaurant = restaurantRepository.findByRestaurantId(restaurantId);

		if (restaurant == null) {
			throw new CustomException("Restaurant not found!");
		} else {
			return restaurant;
		}
	}

	@Override
	public List<Restaurant> fetchRestaurantList() {

		return restaurantRepository.findAll();
	}

	@Override
	public List<Restaurant> searchByRestaurantType(String restaurantType) {

		return restaurantRepository.findByRestaurantType(restaurantType);
	}

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) {

		return restaurantRepository.save(restaurant);
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant) {

		return restaurantRepository.save(restaurant);
	}

	@Override
	public void deleteByRestaurtantId(int restaurantId) {
		restaurantRepository.deleteByRestaurantId(restaurantId);

	}

}
