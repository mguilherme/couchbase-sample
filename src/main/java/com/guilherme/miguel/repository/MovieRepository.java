package com.guilherme.miguel.repository;

import com.guilherme.miguel.domain.Movie;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

import java.util.Collection;

/**
 * @author Miguel Guilherme
 */
@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "movie")
public interface MovieRepository extends CouchbaseRepository<Movie, String> {

    Collection<Movie> findByTitle(String title);

    Collection<Movie> findByTitleLike(String title);

    Collection<Movie> findByTitleStartingWith(String title);

    @Query("#{#n1ql.selectEntity} WHERE director = 'Some director' AND #{#n1ql.filter}")
    Collection<Movie> findDirector();

}
