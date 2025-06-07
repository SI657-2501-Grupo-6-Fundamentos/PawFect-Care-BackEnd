package pe.upc.pawfectcarebackend.feedback.interfaces.rest.resources;

public record CreateReviewResource(
        String content,
        Integer rating,
        Long veterinarianId
) {
}
