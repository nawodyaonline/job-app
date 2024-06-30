package com.incognito.jobapp.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    void addReview(Review review, Long companyId);
    Review getReview(Long reviewId, Long companyId);
    boolean updateReview(Review review, Long companyId, Long reviewId);
    boolean deleteReview(Long reviewId, Long companyId);
}
