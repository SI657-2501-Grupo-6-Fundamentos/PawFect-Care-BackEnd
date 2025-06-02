package pe.upc.pawfectcarebackend.petmanagement.interfaces.rest.resources;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Schema(description = "Data required to update a veterinarian")
public record UpdateVeterinarianResource(
        @Schema(description = "Veterinarian's full name",
                example = "Dr. Carlos Mendoza Ruiz",
                requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "Full name is required")
        String fullName,

        @Schema(description = "Veterinarian's phone number",
                example = "+51-987-654-321",
                requiredMode = Schema.RequiredMode.REQUIRED)
        @Pattern(regexp = "^\\+51-[0-9]{3}-[0-9]{3}-[0-9]{3}$",
                message = "Format must be +51-XXX-XXX-XXX")
        @NotBlank(message = "Phone number is required")
        String phoneNumber,

        @Schema(description = "Veterinarian's email address",
                example = "carlos.mendoza@pawfectcare.com",
                requiredMode = Schema.RequiredMode.REQUIRED)
        @Email(message = "Must be a valid email address")
        @NotBlank(message = "Email is required")
        String email,

        @Schema(description = "Veterinarian's DNI",
                example = "12345678",
                requiredMode = Schema.RequiredMode.REQUIRED)
        String dni,

        @Schema(description = "Veterinarian's speciality",
                example = "GENERAL_MEDICINE",
                requiredMode = Schema.RequiredMode.REQUIRED)
        String speciality) {
}
