package org.example.restomanagement.RestoManagement.mapper;

import org.example.restomanagement.RestoManagement.DTO.RestaurantDTO;
import org.example.restomanagement.RestoManagement.entity.Restaurant;

public class RestaurantMapper {

    public static Restaurant toEntity(RestaurantDTO dto) {
        if (dto == null) {
            return null;
        }
        Restaurant restaurant = new Restaurant();
        restaurant.setId(dto.getId());
        restaurant.setName(dto.getName());
        restaurant.setCusine(dto.getCusine());
        // If you are also mapping reviews, ensure to handle that as well
        return restaurant;
    }

    public static RestaurantDTO toDTO(Restaurant entity) {
        if (entity == null) {
            return null;
        }
        RestaurantDTO dto = new RestaurantDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCusine(entity.getCusine());
        // If you are also mapping reviews, ensure to handle that as well
        return dto;
    }
}
