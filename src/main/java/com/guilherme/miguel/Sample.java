package com.guilherme.miguel;

import com.guilherme.miguel.domain.Movie;
import com.guilherme.miguel.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Stream;

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
        Stream.of("Gone with the Wind", "The Wizard of Oz", "One Flew over the Cuckoo's Nest", "Dr. Strangelove")
                .forEach(title -> movieRepository.save(new Movie(UUID.randomUUID().toString(), title)));

        // Count
        long count = movieRepository.count();
        log.info("Count: {}", count);

        // All Movies
        Iterable<Movie> all = movieRepository.findAll();
        log.info("All Movies: {}", all);

        // Retrieve one movie
        Collection<Movie> movies = movieRepository.findByTitle("The Wizard of Oz");
        log.info("findByTitle(...) {}", movies);

    }
}
