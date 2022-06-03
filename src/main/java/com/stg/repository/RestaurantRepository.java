package com.stg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stg.entity.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

	public Restaurant findByRestaurantId(int restaurantId);

	public List<Restaurant> findByRestaurantType(String restaurantType);

	public void deleteByRestaurantId(int restaurantId);

}
