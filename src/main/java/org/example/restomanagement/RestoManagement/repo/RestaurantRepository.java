package org.example.restomanagement.RestoManagement.repo;

import org.example.restomanagement.RestoManagement.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    // Additional query methods can be added here
}
