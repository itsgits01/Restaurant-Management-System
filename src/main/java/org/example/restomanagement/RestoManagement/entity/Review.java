package org.example.restomanagement.RestoManagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String reviewerName;

    @Column(nullable = false)
    private int rating;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false) // Change to false to ensure it can't be null
    @JsonBackReference
    private Restaurant restaurant;

    @Column(nullable = false)
    private String comment;

    // Getters and setters
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getReviewerName(){
        return reviewerName;
    }
    public void setReviewerName(String reviewerName){
        this.reviewerName = reviewerName;
    }
    public int getRating(){
        return rating;
    }
    public void setRating(int rating){
        this.rating = rating;
    }
    public Restaurant getRestaurant(){
        return restaurant;
    }
    public void setRestaurant(Restaurant restaurant){
        this.restaurant = restaurant;
    }
    public String getComment(){
        return comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }

    // Implementing the setRestaurantId method
    public void setRestaurantId(Long restaurantId) {
        // Assuming you have a method to find a restaurant by ID
        this.restaurant = new Restaurant(); // Create a new Restaurant instance
        this.restaurant.setId(restaurantId); // Set the ID
    }
}
