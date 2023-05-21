package com.portfolio.met.Repository;

import com.portfolio.met.Entity.hys;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Rhys extends JpaRepository<hys, Integer> {
    Optional<hys> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
    
/*    
    Optional<hys> findByPorcentaje(int porcentaje);
    public boolean existsByPorcentaje(int porcentaje);
*/    
}
