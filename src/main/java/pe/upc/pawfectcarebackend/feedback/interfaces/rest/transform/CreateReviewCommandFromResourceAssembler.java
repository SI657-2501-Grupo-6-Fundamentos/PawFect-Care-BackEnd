package pe.upc.pawfectcarebackend.feedback.interfaces.rest.transform;

import pe.upc.pawfectcarebackend.feedback.domain.model.commands.CreateReviewCommand;
import pe.upc.pawfectcarebackend.feedback.interfaces.rest.resources.CreateReviewResource;

public class CreateReviewCommandFromResourceAssembler {
    public static CreateReviewCommand toCommandFromResource(CreateReviewResource resource) {
        return new CreateReviewCommand(resource.content(), resource.rating(), resource.veterinarianId());
    }
}
