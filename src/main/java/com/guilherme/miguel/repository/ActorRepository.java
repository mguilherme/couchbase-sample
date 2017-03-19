package com.guilherme.miguel.repository;

import com.guilherme.miguel.domain.Actor;
import com.guilherme.miguel.domain.ActorKey;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

/**
 * @author Miguel Guilherme
 */
@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "actor")
public interface ActorRepository extends CouchbaseRepository<Actor, ActorKey> {
}
