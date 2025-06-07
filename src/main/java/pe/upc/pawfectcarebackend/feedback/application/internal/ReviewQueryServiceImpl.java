package pe.upc.pawfectcarebackend.feedback.application.internal;

import org.springframework.stereotype.Service;
import pe.upc.pawfectcarebackend.feedback.domain.model.aggregates.Review;
import pe.upc.pawfectcarebackend.feedback.domain.model.queries.GetAllReviewsByVeterinarianIdQuery;
import pe.upc.pawfectcarebackend.feedback.domain.model.queries.GetAllReviewsQuery;
import pe.upc.pawfectcarebackend.feedback.domain.model.queries.GetReviewByIdQuery;
import pe.upc.pawfectcarebackend.feedback.domain.services.ReviewQueryService;
import pe.upc.pawfectcarebackend.feedback.infrastructure.persistence.jpa.repositories.ReviewRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewQueryServiceImpl implements ReviewQueryService {
    private final ReviewRepository reviewRepository;
    public ReviewQueryServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Optional<Review> handle(GetReviewByIdQuery query) {
        return reviewRepository.findById((query.id()));
    }

    @Override
    public List<Review> handle(GetAllReviewsQuery query) {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> handle(GetAllReviewsByVeterinarianIdQuery query) {
        return reviewRepository.findAllByVeterinarianId(query.veterinarianId());
    }
}
