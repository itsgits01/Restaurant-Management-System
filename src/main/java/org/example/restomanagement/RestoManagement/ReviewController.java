package org.example.restomanagement.RestoManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants/{restaurantId}/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // Get all reviews for a specific restaurant
    @GetMapping
    public ResponseEntity<List<ReviewDTO>> getReviewsByRestaurant(@PathVariable Long restaurantId) {
        List<ReviewDTO> reviews = reviewService.getReviewsByRestaurant(restaurantId);
        return ResponseEntity.ok(reviews);
    }

    // Create a new review for a specific restaurant
    @PostMapping
    public ResponseEntity<ReviewDTO> createReview(@PathVariable Long restaurantId, @RequestBody ReviewDTO reviewDTO) {
        ReviewDTO createdReview = reviewService.createReview(reviewDTO, restaurantId);
        if (createdReview != null) {
            return ResponseEntity.ok(createdReview);
        }
        return ResponseEntity.notFound().build();
    }

    // Update an existing review
//    @PutMapping("/{id}")
//    public ResponseEntity<ReviewDTO> updateReview(@PathVariable Long id, @RequestBody ReviewDTO updatedReviewDTO) {
//        ReviewDTO reviewDTO = reviewService.updateReview(id, updatedReviewDTO);
//        if (reviewDTO != null) {
//            return ResponseEntity.ok(reviewDTO);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    // Delete a review
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
//        reviewService.deleteReview(id);
//        return ResponseEntity.noContent().build();
//    }
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
//@RequestMapping("/api/restaurants/{restaurantId}/reviews")
//public class ReviewController {
//
//    @Autowired
//    private ReviewService reviewService;
//
//    @GetMapping
//    public List<Review> getReviewsByRestaurant(@PathVariable Long restaurantId) {
//        return reviewService.getReviewsByRestaurant(restaurantId);
//    }
//
//    @PostMapping
//    public ResponseEntity<Review> createReview(@PathVariable Long restaurantId, @RequestBody Review review) {
//        Review createdReview = reviewService.createReview(review, restaurantId);
//        if (createdReview != null) {
//            return ResponseEntity.ok(createdReview);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review updatedReview) {
//        Review review = reviewService.updateReview(id, updatedReview);
//        if (review != null) {
//            return ResponseEntity.ok(review);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
//        reviewService.deleteReview(id);
//        return ResponseEntity.noContent().build();
//    }
//}
