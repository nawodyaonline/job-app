package com.incognito.jobapp.review.impl;

import com.incognito.jobapp.company.Company;
import com.incognito.jobapp.company.CompanyService;
import com.incognito.jobapp.review.Review;
import com.incognito.jobapp.review.ReviewRepo;
import com.incognito.jobapp.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepo reviewRepo;
    private CompanyService companyService;

    public ReviewServiceImpl(ReviewRepo reviewRepo, CompanyService companyService) {
        this.reviewRepo = reviewRepo;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepo.findByCompanyId(companyId);
    }

    @Override
    public void addReview(Review review, Long companyId) {
        Company company = companyService.getCompanyById(companyId);
        if (company == null) {
            throw new RuntimeException("Company not found");
        } else {
            review.setCompany(company);
            reviewRepo.save(review);
        }
    }

    @Override
    public Review getReview(Long reviewId, Long companyId) {
        List<Review> byCompanyId = reviewRepo.findByCompanyId(companyId);
        return byCompanyId.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

}
