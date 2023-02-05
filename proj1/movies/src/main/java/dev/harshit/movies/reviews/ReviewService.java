package dev.harshit.movies.reviews;

//import java.lang.reflect.Executable;
//import java.security.Key;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.FilterType;
//import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.ExecutableUpdateOperation.ExecutableUpdate;
//import org.springframework.data.mongodb.core.ExecutableUpdateOperation.UpdateWithUpdate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import dev.harshit.movies.*;;
@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    private MongoTemplate mongoTemplate;
    public Review createReview(String reviewBody, String imdbId){
        Review review=reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
        .matching(Criteria.where("imdbId").is(imdbId)) 
        .apply(new Update().push("reviewIds").value(review))
        .first();
        return review;
    }
}
 