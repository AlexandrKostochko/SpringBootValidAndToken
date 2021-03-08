package app.service;

import app.exceptions.PetNotFoundException;
import app.repository.PetRepository;
import lombok.Data;
import app.model.Pet;
import app.model.PetStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public void createPet(Pet pet) {
        petRepository.save(pet);
    }

    public Optional<Pet> getById(long id) {
        return petRepository.findById(id);
    }

    public List<Pet> getByStatus(PetStatus petStatus) {
        return petRepository.findAllByPetStatus(petStatus);
    }

//    public void updateExistPet (Pet pet) {
//        for (Pet currentPet : pets) {
//            if (currentPet.getId() == pet.getId()) {
//                pets.set(pets.indexOf(currentPet), pet);
//            } else {
//                throw new PetNotFoundException(pet.getId());
//            }
//        }
//    }

    public boolean deletePet (long id) {
        if(petRepository.existsById(id)) {
            petRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Pet> getPets() {
        return petRepository.findAll();
    }
}