package dev.harshit.movies;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
// import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
// import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository
extends MongoRepository<Movie,ObjectId> {
    Optional<Movie> findByImdbId(String imdbId);
}
// public interface MovieRepository extends  CrudRepository<Movie, ObjectId>{

// }

