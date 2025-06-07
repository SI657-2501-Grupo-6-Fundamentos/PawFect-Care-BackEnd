package pe.upc.pawfectcarebackend.feedback.domain.services;

import pe.upc.pawfectcarebackend.feedback.domain.model.aggregates.Review;
import pe.upc.pawfectcarebackend.feedback.domain.model.commands.CreateReviewCommand;
import pe.upc.pawfectcarebackend.feedback.domain.model.commands.UpdateReviewCommand;

import java.util.Optional;

public interface ReviewCommandService {
    Optional<Review> handle(UpdateReviewCommand command);
    Long handle(CreateReviewCommand command);
}
