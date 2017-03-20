package com.guilherme.miguel;

import com.guilherme.miguel.domain.Actor;
import com.guilherme.miguel.domain.ActorKey;
import com.guilherme.miguel.repository.ActorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static java.util.UUID.randomUUID;

/**
 * @author Miguel Guilherme
 */
@Slf4j
//@Component
public class ActorSample implements CommandLineRunner {

    private ActorRepository actorRepository;

    public ActorSample(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        actorRepository.deleteAll();
        Actor firstActor = actorRepository.save(new Actor(new ActorKey(randomUUID().toString()), "Emma Watson"));

        Actor actorFromBucket = actorRepository.findOne(firstActor.getKey());
        log.info("Saved Actor: {}", actorFromBucket);
    }
}
