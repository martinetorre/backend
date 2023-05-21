package com.portfolio.met.Repository;

import com.portfolio.met.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
    
    /*public Optional<Educacion> findByDescripcionE(String descripcionE);
    public boolean existsByDescripcionE(String descripcionE);
*/
}
