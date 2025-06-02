package pe.upc.pawfectcarebackend.petmanagement.domain.model.commands;

public record CreateVeterinarianCommand(
        String fullName,
        String phoneNumber,
        String email,
        String dni,
        String veterinarianSpeciality) {
}
