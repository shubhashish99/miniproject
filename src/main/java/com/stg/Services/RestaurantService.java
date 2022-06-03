package com.stg.Services;

import java.util.List;

import com.stg.entity.Restaurant;

public interface RestaurantService {
	public abstract Restaurant checkRestaurant(int restaurantId);

	public abstract List<Restaurant> fetchRestaurantList();

	public abstract List<Restaurant> searchByRestaurantType(String restaurantType);

	public abstract Restaurant addRestaurant(Restaurant restaurant);

	public abstract Restaurant updateRestaurant(Restaurant restaurant);

	public abstract void deleteByRestaurtantId(int restaurantId);

}
