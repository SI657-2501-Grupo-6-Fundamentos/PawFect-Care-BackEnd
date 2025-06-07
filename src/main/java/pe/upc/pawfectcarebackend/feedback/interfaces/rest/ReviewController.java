package pe.upc.pawfectcarebackend.feedback.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.pawfectcarebackend.feedback.domain.model.queries.GetAllReviewsQuery;
import pe.upc.pawfectcarebackend.feedback.domain.model.queries.GetReviewByIdQuery;
import pe.upc.pawfectcarebackend.feedback.domain.services.ReviewCommandService;
import pe.upc.pawfectcarebackend.feedback.domain.services.ReviewQueryService;
import pe.upc.pawfectcarebackend.feedback.interfaces.rest.resources.CreateReviewResource;
import pe.upc.pawfectcarebackend.feedback.interfaces.rest.resources.ReviewResource;
import pe.upc.pawfectcarebackend.feedback.interfaces.rest.resources.UpdateReviewResource;
import pe.upc.pawfectcarebackend.feedback.interfaces.rest.transform.CreateReviewCommandFromResourceAssembler;
import pe.upc.pawfectcarebackend.feedback.interfaces.rest.transform.ReviewResourceFromEntityAssembler;
import pe.upc.pawfectcarebackend.feedback.interfaces.rest.transform.UpdateReviewCommandFromResourceAssembler;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "api/v1/reviews", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Reviews", description = "Feedback Endpoints")
@CrossOrigin(origins = {"https://pawfect-care-app-web.web.app","http://localhost:4200"})
public class ReviewController {
    private final ReviewQueryService reviewQueryService;
    private final ReviewCommandService reviewCommandService;
    public ReviewController(ReviewQueryService reviewQueryService, ReviewCommandService reviewCommandService) {
        this.reviewQueryService = reviewQueryService;
        this.reviewCommandService = reviewCommandService;
    }
    
    @PostMapping
    public ResponseEntity<ReviewResource> createResource(@RequestBody CreateReviewResource createReviewResource) {
        var createReviewCommand = CreateReviewCommandFromResourceAssembler.toCommandFromResource(createReviewResource);
        var reviewId = reviewCommandService.handle(createReviewCommand);
        if (reviewId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getReviewByIdQuery = new GetReviewByIdQuery(reviewId);
        var review = reviewQueryService.handle(getReviewByIdQuery);
        if (review.isEmpty()) return ResponseEntity.badRequest().build();
        var reviewResource = ReviewResourceFromEntityAssembler.toResourceFromEntity(review.get());
        return new ResponseEntity<>(reviewResource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ReviewResource>> getAllReviews() {
        var getAllReviewsQuery = new GetAllReviewsQuery();
        var reviews = reviewQueryService.handle(getAllReviewsQuery);
        var reviewResources = reviews.stream().map(ReviewResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(reviewResources);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<ReviewResource> getReviewById(@PathVariable Long reviewId) {
        var getReviewByIdQuery = new GetReviewByIdQuery(reviewId);
        var review = reviewQueryService.handle(getReviewByIdQuery);
        if (review.isEmpty()) return ResponseEntity.badRequest().build();
        var reviewResource = ReviewResourceFromEntityAssembler.toResourceFromEntity(review.get());
        return ResponseEntity.ok(reviewResource);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<ReviewResource> updateReview(@PathVariable Long reviewId, @RequestBody UpdateReviewResource updateReviewResource) {
        var updateReviewCommand = UpdateReviewCommandFromResourceAssembler.toCommandFromResource(reviewId, updateReviewResource);
        var updatedReview = reviewCommandService.handle(updateReviewCommand);
        if (updatedReview.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var reviewResource = ReviewResourceFromEntityAssembler.toResourceFromEntity(updatedReview.get());
        return ResponseEntity.ok(reviewResource);
    }

    // A review should not be deleted

    /*
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?> deleteReview(@PathVariable Long reviewId) {
        var deleteReviewCommand = new DeleteReviewCommand(reviewId);
        reviewCommandService.handle(deleteReviewCommand);
        return ResponseEntity.ok("review with given id successfully deleted");
    }*/
}
