package org.example.restomanagement.RestoManagement.controller;

import jakarta.validation.Valid;
import org.example.restomanagement.RestoManagement.*;
import org.example.restomanagement.RestoManagement.DTO.RestaurantDTO;
import org.example.restomanagement.RestoManagement.exceptions.RestaurantNotFoundException;
import org.example.restomanagement.RestoManagement.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
@Validated
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserSession userSession;

    @Autowired
    private RequestContext requestContext;

    // Add a new restaurant
    @PostMapping
    public ResponseEntity<RestaurantDTO> addRestaurant(@Valid @RequestBody RestaurantDTO restaurantDTO) {
        // Set request ID for the current request
        requestContext.setCurrentUser("REQ-" + System.currentTimeMillis());
        System.out.println("Request ID: " + requestContext.getCurrentUser());

        // Set favorite restaurant in the user's session
        userSession.setFavoriteRestaurant(restaurantDTO.getName());
        System.out.println("User's favorite restaurant: " + userSession.getFavoriteRestaurant());

        RestaurantDTO createdRestaurant = restaurantService.addRestaurant(restaurantDTO);
        return ResponseEntity.ok(createdRestaurant);
    }

    // Get all restaurants
    @GetMapping
    public ResponseEntity<List<RestaurantDTO>> getAllRestaurants() {
        List<RestaurantDTO> restaurants = restaurantService.getAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }

    @GetMapping("/favorite")
    public ResponseEntity<String> getFavoriteRestaurant() {
        String favoriteRestaurant = userSession.getFavoriteRestaurant();
        return ResponseEntity.ok(favoriteRestaurant != null ? favoriteRestaurant : "No favorite restaurant set.");
    }

    // Get a restaurant by its ID
    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable Long id) {
        RestaurantDTO restaurant = restaurantService.getRestaurantById(id);
        if (restaurant == null) { // or use an appropriate method to check if the restaurant exists
            throw new RestaurantNotFoundException(id.toString()); // Throw exception if not found
        }
        return ResponseEntity.ok(restaurant);
    }
}




//package org.example.weatherfetch.RestoManagement;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/restaurants")
//public class RestaurantController {
//
//    @Autowired
//    private RestaurantService restaurantService;
//
//    @GetMapping
//    public List<Restaurant> getAllRestaurants() {
//        return restaurantService.getAllRestaurants();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id) {
//        return restaurantService.getRestaurantById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
//        return restaurantService.createRestaurant(restaurant);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id, @RequestBody Restaurant updatedRestaurant) {
//        Restaurant restaurant = restaurantService.updateRestaurant(id, updatedRestaurant);
//        if (restaurant != null) {
//            return ResponseEntity.ok(restaurant);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
//        restaurantService.deleteRestaurant(id);
//        return ResponseEntity.noContent().build();
//    }
//}
