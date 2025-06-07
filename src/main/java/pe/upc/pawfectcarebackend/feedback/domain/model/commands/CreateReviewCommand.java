package pe.upc.pawfectcarebackend.feedback.domain.model.commands;

public record CreateReviewCommand(
        String content,
        Integer rating,
        Long veterinarianId
) {
}
