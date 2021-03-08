package app.repository;

import app.model.Pet;
import app.model.PetStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findAllByPetStatus(PetStatus petStatus);
}
