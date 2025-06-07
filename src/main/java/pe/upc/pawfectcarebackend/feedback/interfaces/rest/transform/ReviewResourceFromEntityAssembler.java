package pe.upc.pawfectcarebackend.feedback.interfaces.rest.transform;

import pe.upc.pawfectcarebackend.feedback.domain.model.aggregates.Review;
import pe.upc.pawfectcarebackend.feedback.interfaces.rest.resources.ReviewResource;

public class ReviewResourceFromEntityAssembler {
    public static ReviewResource toResourceFromEntity(Review entity) {
        return new ReviewResource(
                entity.getId(),
                entity.getContent(),
                entity.getRating(),
                entity.getVeterinarian().getId());
    }
}
