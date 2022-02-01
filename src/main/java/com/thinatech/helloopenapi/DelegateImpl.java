package com.thinatech.helloopenapi;

import com.thinatech.helloopenapi.api.PetApiDelegate;
import com.thinatech.helloopenapi.data.PetService;
import com.thinatech.helloopenapi.model.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DelegateImpl implements PetApiDelegate {

    private final PetService petService;

    @Override
    public ResponseEntity<Void> addPet(Pet body) {
        //petService.save(body);
        petService.saveAsync(body, pet -> log.info("saved pet {}", pet));
        log.info("return from saved");
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Pet> getPetById(String petId) {
        return petService.findById(petId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
