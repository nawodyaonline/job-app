package com.incognito.jobapp.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    void addReview(Review review, Long companyId);
    Review getReview(Long reviewId, Long companyId);
}
