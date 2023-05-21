
package com.portfolio.met.Securiry.Repository;

import com.portfolio.met.Securiry.Entity.Rol;
import com.portfolio.met.Securiry.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
