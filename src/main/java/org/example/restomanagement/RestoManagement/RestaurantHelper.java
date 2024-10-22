package org.example.restomanagement.RestoManagement;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // New instance on each request
public class RestaurantHelper {

    public String generateRestaurantCode(RestaurantDTO restaurantDTO) {
        return "CODE-" + restaurantDTO.getName().toUpperCase();
    }
}

