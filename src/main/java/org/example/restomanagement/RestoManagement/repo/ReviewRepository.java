package org.example.restomanagement.RestoManagement.repo;


import org.example.restomanagement.RestoManagement.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    // Correcting the method to use the restaurant property
    List<Review> findByRestaurant_Id(Long restaurantId); // Use 'restaurant_Id' to access the id of the restaurant

    // Additional query methods can be added here if needed
}
