package com.mcu.backend.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mcu.backend.apirest.models.VinPersonas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author admin
 */
@Repository 
public interface PersonasRepository extends JpaRepository <VinPersonas, Long> {
        
        
}
