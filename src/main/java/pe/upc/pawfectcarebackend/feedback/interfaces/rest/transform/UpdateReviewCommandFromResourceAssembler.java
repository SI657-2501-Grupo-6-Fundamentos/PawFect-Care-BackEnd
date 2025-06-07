package pe.upc.pawfectcarebackend.feedback.interfaces.rest.transform;

import pe.upc.pawfectcarebackend.feedback.domain.model.commands.UpdateReviewCommand;
import pe.upc.pawfectcarebackend.feedback.interfaces.rest.resources.UpdateReviewResource;

public class UpdateReviewCommandFromResourceAssembler {
    public static UpdateReviewCommand toCommandFromResource(Long reviewId, UpdateReviewResource resource) {
        return new UpdateReviewCommand(
                reviewId,
                resource.content(),
                resource.rating());
    }
}
