package org.example.restomanagement.RestoManagement;

public class RestaurantConstants {

    // Error messages
    public static final String RESTAURANT_NOT_FOUND = "Restaurant not found with id: ";
    public static final String REVIEW_NOT_FOUND = "Review not found with id: ";

    // Validation constants
    public static final int MIN_RATING = 1;
    public static final int MAX_RATING = 5;

    // Success messages
    public static final String RESTAURANT_CREATED = "Restaurant created successfully.";
    public static final String REVIEW_CREATED = "Review added successfully.";

    private RestaurantConstants() {
        // private constructor to prevent instantiation
    }
}
