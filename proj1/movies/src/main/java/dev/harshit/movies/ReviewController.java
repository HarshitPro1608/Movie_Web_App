package dev.harshit.movies;

// import java.io.ObjectInputFilter.Config;
import java.util.Map;

// import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.context.config.ConfigDataLocation;
// import org.springframework.context.annotation.ComponentScan;
// import org.springframework.context.annotation.FilterType;
// import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.harshit.movies.reviews.ReviewService;

@RestController
@RequestMapping("/api/v1/reviews")


public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String,String> payload){
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"),payload.get("imdbId")),HttpStatus.CREATED);
    }
}
