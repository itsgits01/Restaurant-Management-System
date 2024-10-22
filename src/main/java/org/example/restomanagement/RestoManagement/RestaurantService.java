package org.example.restomanagement.RestoManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantHelper restaurantHelper;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public RestaurantDTO addRestaurant(RestaurantDTO restaurantDTO) {

        String code = restaurantHelper.generateRestaurantCode(restaurantDTO);
        System.out.println("Generated Code: " + code);

        Restaurant restaurant = RestaurantMapper.toEntity(restaurantDTO);
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return RestaurantMapper.toDTO(savedRestaurant);
    }

    public List<RestaurantDTO> getAllRestaurants() {
        return restaurantRepository.findAll().stream()
                .map(RestaurantMapper::toDTO)
                .collect(Collectors.toList());
    }

    public RestaurantDTO getRestaurantById(Long id) {
        return restaurantRepository.findById(id)
                .map(RestaurantMapper::toDTO)
                .orElseThrow(() -> new RestaurantNotFoundException(String.valueOf(id)));
    }
}




//package org.example.weatherfetch.RestoManagement;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class RestaurantService {
//
//    @Autowired
//    private RestaurantRepository restaurantRepository;
//
//    public List<Restaurant> getAllRestaurants() {
//        return restaurantRepository.findAll();
//    }
//
//    public Optional<Restaurant> getRestaurantById(Long id) {
//        return restaurantRepository.findById(id);
//    }
//
//    public Restaurant createRestaurant(Restaurant restaurant) {
//        return restaurantRepository.save(restaurant);
//    }
//
//    public Restaurant updateRestaurant(Long id, Restaurant updatedRestaurant) {
//        Optional<Restaurant> existingRestaurant = restaurantRepository.findById(id);
//        if (existingRestaurant.isPresent()) {
//            Restaurant restaurant = existingRestaurant.get();
//            restaurant.setName(updatedRestaurant.getName());
//            restaurant.setCusine(updatedRestaurant.getCusine());
//            return restaurantRepository.save(restaurant);
//        }
//        return null;  // Handle case if restaurant does not exist
//    }
//
//    public void deleteRestaurant(Long id) {
//        restaurantRepository.deleteById(id);
//    }
//}
