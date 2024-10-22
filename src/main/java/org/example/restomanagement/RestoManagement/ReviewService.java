package org.example.restomanagement.RestoManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private RestaurantRepository restaurantRepository; // Assuming you have a repository for Restaurant

    public List<ReviewDTO> getReviewsByRestaurant(Long restaurantId) {
        List<Review> reviews = reviewRepository.findByRestaurant_Id(restaurantId);
        if (reviews.isEmpty()) {
            throw new RestaurantNotFoundException(restaurantId.toString()+"Not found"); // Throw exception if no reviews found
        }
        return reviews.stream().map(ReviewMapper::toDTO).collect(Collectors.toList());
    }

    public ReviewDTO createReview(ReviewDTO reviewDTO, Long restaurantId) {
        // Check if restaurant exists
        if (!restaurantRepository.existsById(restaurantId)) {
            throw new RestaurantNotFoundException(restaurantId.toString());
        }

        // Validate review data (example)
        if (reviewDTO.getRating() < RestaurantConstants.MIN_RATING || reviewDTO.getRating() > RestaurantConstants.MAX_RATING) {
            throw new InvalidReviewException("Rating must be between " + RestaurantConstants.MIN_RATING + " and " + RestaurantConstants.MAX_RATING);
        }

        Review review = ReviewMapper.toEntity(reviewDTO);
        review.setRestaurantId(restaurantId); // Set the restaurant ID
        Review savedReview = reviewRepository.save(review);
        return ReviewMapper.toDTO(savedReview);
    }
}


//    public ReviewDTO updateReview(Long id, ReviewDTO updatedReviewDTO) {
//        return reviewRepository.findById(id).map(review -> {
//            review.setRating(updatedReviewDTO.getRating());
//            review.setReviewerName(updatedReviewDTO.getReviewerName());
//            review.setComment(updatedReviewDTO.getComment());
//            Review updatedReview = reviewRepository.save(review);
//            return ReviewMapper.toDTO(updatedReview);
//        }).orElse(null);
//    }
//
//    public void deleteReview(Long id) {
//        reviewRepository.deleteById(id);
//    }
//}





//package org.example.weatherfetch.RestoManagement;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ReviewService {
//
//    @Autowired
//    private ReviewRepository reviewRepository;
//
//    @Autowired
//    private RestaurantRepository restaurantRepository;
//
//    public List<Review> getAllReviews() {
//        return reviewRepository.findAll();
//    }
//
//    public List<Review> getReviewsByRestaurant(Long restaurantId) {
//        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
//        return restaurant.map(Restaurant::getReviews).orElse(null);
//    }
//
//    public Review createReview(Review review, Long restaurantId) {
//        // Validate review
//        ReviewValidator.validateReview(review);
//
//        // Check if restaurant exists
//        return restaurantRepository.findById(restaurantId)
//                .map(restaurant -> {
//                    review.setRestaurant(restaurant);
//                    return reviewRepository.save(review);
//                }).orElseThrow(() -> new RestaurantNotFoundException(String.valueOf(restaurantId)));
//    }
//
//    public Review updateReview(Long id, Review updatedReview) {
//        Optional<Review> existingReview = reviewRepository.findById(id);
//        if (existingReview.isPresent()) {
//            Review review = existingReview.get();
//            review.setReviewerName(updatedReview.getReviewerName());
//            review.setRating(updatedReview.getRating());
//            review.setComment(updatedReview.getComment());
//            return reviewRepository.save(review);
//        }
//        return null;  // Handle case if review does not exist
//    }
//
//    public void deleteReview(Long id) {
//        reviewRepository.deleteById(id);
//    }
//}
