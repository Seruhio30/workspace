package com.seruhioCode30.quickbites.QuickBites_Back_End.repository;

import com.seruhioCode30.quickbites.QuickBites_Back_End.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // Esta anotación es importante
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name); // Método para buscar roles por nombre
}
