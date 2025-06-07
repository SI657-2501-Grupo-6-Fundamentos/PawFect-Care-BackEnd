package pe.upc.pawfectcarebackend.petmanagement.domain.exceptions;

public class VeterinarianNotFoundException extends RuntimeException {
    public VeterinarianNotFoundException(Long aLong) {
        super("Veterinarian with id " + aLong + " not found");
    }
}
