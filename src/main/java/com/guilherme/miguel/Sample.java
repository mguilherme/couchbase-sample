package com.guilherme.miguel;

import com.guilherme.miguel.domain.Movie;
import com.guilherme.miguel.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Stream;

import static java.util.UUID.randomUUID;

/**
 * @author Miguel Guilherme
 */
@Slf4j
@Component
public class Sample implements CommandLineRunner {

    private MovieRepository movieRepository;

    public Sample(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        // Delete All
        movieRepository.deleteAll();

        // Add Movies
        Stream.of("Gone with the Wind", "The Wizard of Oz", "One Flew over the Cuckoo's Nest", "Dr. Strangelove", "The Founder", "Gone in 60 Seconds")
                .forEach(title -> movieRepository.save(new Movie(randomUUID().toString(), title)));

        // Add one movie
        Movie someMovie = movieRepository.save(new Movie(randomUUID().toString(), "Logan"));

        // Retrieve one movie
        Movie oneMovie = movieRepository.findOne(someMovie.getId());
        boolean exists = movieRepository.exists(someMovie.getId());
        log.info("Some movie by ID: {}", oneMovie);
        log.info("Exists? {}", exists);

        // Count
        long count = movieRepository.count();
        log.info("Count: {}", count);

        // All Movies
        Iterable<Movie> all = movieRepository.findAll();
        log.info("All Movies: {}", all);

        // Retrieve one movie
        Collection<Movie> movies = movieRepository.findByTitle("The Wizard of Oz");
        log.info("findByTitle() {}", movies);

        // Title like 'The%'
        Collection<Movie> moviesByTitleLike = movieRepository.findByTitleLike("The%");
        log.info("Movies starting with 'The': {}", moviesByTitleLike);

        // Starting with
        Collection<Movie> moviesStartingWith = movieRepository.findByTitleStartingWith("Gone");
        log.info("Movies starting with 'Gone': {}", moviesStartingWith);

    }
}
