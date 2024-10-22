package org.example.restomanagement.RestoManagement;


public class ReviewValidator {

    public static void validateReview(Review review) {
        if (review.getRating() < RestaurantConstants.MIN_RATING || review.getRating() > RestaurantConstants.MAX_RATING) {
            throw new InvalidReviewException("Rating should be between " + RestaurantConstants.MIN_RATING + " and " + RestaurantConstants.MAX_RATING);
        }
        if (review.getComment() == null || review.getComment().isEmpty()) {
            throw new InvalidReviewException("Comment cannot be empty");
        }
    }
}
