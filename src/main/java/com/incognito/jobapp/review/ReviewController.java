package com.incognito.jobapp.review;

import com.incognito.jobapp.company.Company;
import com.incognito.jobapp.company.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        return ResponseEntity.ok(reviewService.getAllReviews(companyId));
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@RequestBody Review review, @PathVariable Long companyId) {
        reviewService.addReview(review, companyId);
        return ResponseEntity.ok("Review added successfully!");
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long reviewId, @PathVariable Long companyId) {
        return ResponseEntity.ok(reviewService.getReview(reviewId, companyId));
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(
            @PathVariable Long companyId,
            @PathVariable Long reviewId,
            @RequestBody Review review
    ) {
        boolean isUpdate = reviewService.updateReview(review, companyId, reviewId);
        if(isUpdate) return new ResponseEntity<>("Review updated", HttpStatus.OK);
        else return new ResponseEntity<>("Review not updated", HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId, @PathVariable Long companyId) {
        boolean isDeleted = reviewService.deleteReview(companyId, reviewId);
        if(isDeleted) return new ResponseEntity<>("Review deleted", HttpStatus.OK);
        else return new ResponseEntity<>("Review not deleted", HttpStatus.NOT_FOUND);
    }




}
