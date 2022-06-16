package com.stg.Services;

import java.util.List;

import com.stg.entity.Restaurant;

public interface RestaurantService {
	public abstract Restaurant findRestaurant(int restaurantId);

	public abstract List<Restaurant> getAllRestaurants();

	public abstract Restaurant addRestaurant(Restaurant restaurant);

	public abstract String updateRestaurant(int restaurantId, String restaurantType, String restaurantName);

	public abstract String deleteRestaurtant(int restaurantId);

}
