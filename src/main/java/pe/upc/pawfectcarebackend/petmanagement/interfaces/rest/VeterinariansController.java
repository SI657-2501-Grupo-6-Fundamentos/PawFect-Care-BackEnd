package pe.upc.pawfectcarebackend.petmanagement.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.pawfectcarebackend.petmanagement.domain.model.queries.GetAllVeterinariansBySpecialityQuery;
import pe.upc.pawfectcarebackend.petmanagement.domain.model.queries.GetAllVeterinariansQuery;
import pe.upc.pawfectcarebackend.petmanagement.domain.model.queries.GetVeterinariansByIdQuery;
import pe.upc.pawfectcarebackend.petmanagement.domain.model.valueobjects.VeterinarianSpeciality;
import pe.upc.pawfectcarebackend.petmanagement.domain.services.VeterinarianCommandService;
import pe.upc.pawfectcarebackend.petmanagement.domain.services.VeterinarianQueryService;
import pe.upc.pawfectcarebackend.petmanagement.interfaces.rest.resources.*;
import pe.upc.pawfectcarebackend.petmanagement.interfaces.rest.transform.CreateVeterinarianCommandFromResourceAssembler;
import pe.upc.pawfectcarebackend.petmanagement.interfaces.rest.transform.VeterinarianResourceFromEntityAssembler;
import pe.upc.pawfectcarebackend.petmanagement.interfaces.rest.transform.UpdateVeterinarianCommandFromResourceAssembler;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/veterinarians", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Veterinarians", description = "Veterinarians Management Endpoints")
@CrossOrigin(origins = {"https://pawfect-care-app-web.web.app","http://localhost:4200"})
public class VeterinariansController {
    private final VeterinarianQueryService veterinarianQueryService;
    private final VeterinarianCommandService veterinarianCommandService;
    public VeterinariansController(VeterinarianQueryService veterinarianQueryService,VeterinarianCommandService veterinarianCommandService) {
        this.veterinarianCommandService = veterinarianCommandService;
        this.veterinarianQueryService = veterinarianQueryService;
    }

    @Operation(
            summary = "Obtain Veterinarian by ID",
            description = "Retrieves a veterinarian by their unique ID."
    )
    @GetMapping("/{veterinarianId}")
    public ResponseEntity<VeterinarianResource> getVeterinarianById(
            @Parameter(description = "Veterinarian Unique ID", example = "1", required = true)
            @PathVariable Long veterinarianId
    ) {
        var getVeterinarianByIdQuery = new GetVeterinariansByIdQuery(veterinarianId);
        var veterinarian = veterinarianQueryService.handle(getVeterinarianByIdQuery);
        if (veterinarian.isEmpty()) return ResponseEntity.badRequest().build();
        var veterinarianResource = VeterinarianResourceFromEntityAssembler.toResourceFromEntity(veterinarian.get());
        return ResponseEntity.ok(veterinarianResource);
    }

    @Operation(
            summary = "List all Veterinarians",
            description = "Retrieves a list of all veterinarians."
    )
    @ApiResponse(responseCode = "200", description = "Veterinarians found")
    @GetMapping
    public ResponseEntity<List<VeterinarianResource>> getAllVeterinarians() {
        var getAllVeterinariansQuery = new GetAllVeterinariansQuery();
        var veterinarians = veterinarianQueryService.handle(getAllVeterinariansQuery);
        var petResources = veterinarians.stream().map(VeterinarianResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(petResources);
    }

    @Operation(
            summary = "Find Veterinarians by Speciality",
            description = "Retrieves a list of veterinarians filtered by their speciality."
    )
    @GetMapping("/speciality")
    public ResponseEntity<List<VeterinarianResource>> getVeterinariansBySpeciality(
            @Parameter(
                    description = "Veterinarian Speciality",
                    example = "GENERAL_MEDICINE",
                    required = true,
                    schema = @Schema(implementation = VeterinarianSpeciality.class)
            )
            @RequestParam VeterinarianSpeciality speciality
    ) {
        var getVeterinariansBySpecialityQuery = new GetAllVeterinariansBySpecialityQuery(speciality);
        var veterinarians = veterinarianQueryService.handle(getVeterinariansBySpecialityQuery);
        var veterinarianResources = veterinarians.stream().map(VeterinarianResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(veterinarianResources);
    }

    @Operation(
            summary = "Create a new Veterinarian",
            description = "Registers a new veterinarian with the provided details."
    )
    @PostMapping
    public ResponseEntity<VeterinarianResource> createVeterinarian(@RequestBody CreateVeterinarianResource createVeterinarianResource) {
        var createVeterinarianCommand = CreateVeterinarianCommandFromResourceAssembler.toCommandFromResource(createVeterinarianResource);
        var veterinarianId = veterinarianCommandService.handle(createVeterinarianCommand);
        if (veterinarianId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getVeterinarianByIdQuery = new GetVeterinariansByIdQuery(veterinarianId);
        var veterinarian = veterinarianQueryService.handle(getVeterinarianByIdQuery);
        if (veterinarian.isEmpty()) return ResponseEntity.badRequest().build();
        var veterinarianResource = VeterinarianResourceFromEntityAssembler.toResourceFromEntity(veterinarian.get());
        return new ResponseEntity<>(veterinarianResource, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Update Veterinarian",
            description = "Updates the information of an existing veterinarian by their ID."
    )
    @PutMapping("/{veterinarianId}")
    public ResponseEntity<VeterinarianResource> updateVeterinarian(@PathVariable Long veterinarianId, @RequestBody UpdateVeterinarianResource updateVeterinarianResource) {
        var updateVeterinarianCommand = UpdateVeterinarianCommandFromResourceAssembler.toCommandFromResource(veterinarianId, updateVeterinarianResource);
        var updatedVeterinarian = veterinarianCommandService.handle(updateVeterinarianCommand);
        if (updatedVeterinarian.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var veterinarianResource = VeterinarianResourceFromEntityAssembler.toResourceFromEntity(updatedVeterinarian.get());
        return ResponseEntity.ok(veterinarianResource);
    }
}
