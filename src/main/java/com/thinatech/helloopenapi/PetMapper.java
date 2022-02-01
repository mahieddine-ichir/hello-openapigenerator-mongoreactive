package com.thinatech.helloopenapi;

import com.thinatech.helloopenapi.data.Pet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetMapper {

    Pet toEntity(com.thinatech.helloopenapi.model.Pet pet);

    com.thinatech.helloopenapi.model.Pet toModel(Pet pet);
}
