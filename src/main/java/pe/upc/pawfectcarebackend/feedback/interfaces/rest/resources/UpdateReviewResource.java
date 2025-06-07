package pe.upc.pawfectcarebackend.feedback.interfaces.rest.resources;

public record UpdateReviewResource(
        String content,
        Integer rating) {
}
