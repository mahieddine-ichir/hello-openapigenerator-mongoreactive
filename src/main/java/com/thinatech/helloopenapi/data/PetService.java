package com.thinatech.helloopenapi.data;

import com.thinatech.helloopenapi.PetMapper;
import com.thinatech.helloopenapi.model.Pet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Consumer;

@Service
@Slf4j
public record PetService(
        PetRepository petRepository,
        PetMapper petMapper
) {

    public void saveAsync(Pet body, Consumer<Pet> savedConsumer) {
        petRepository.save(petMapper.toEntity(body))
                .map(petMapper::toModel)
                .subscribe(savedConsumer);
    }

    public Pet save(Pet body) {
        return petMapper.toModel(petRepository.save(petMapper.toEntity(body)).block());
    }

    public Optional<Pet> findById(String petId) {
        return petRepository.findById(petId)
                .blockOptional()
                .map(petMapper::toModel);
    }
}
