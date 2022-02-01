package com.thinatech.helloopenapi.data;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PetRepository extends ReactiveMongoRepository<Pet, String> {
}
