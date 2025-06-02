package pe.upc.pawfectcarebackend.petmanagement.domain.model.commands;

public record UpdateVeterinarianCommand(Long id, String fullName, String phoneNumber,
                                        String email, String dni, String veterinarianSpeciality) {
}
