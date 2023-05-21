package com.portfolio.met.Controller;


import com.portfolio.met.Entity.Persona;
import com.portfolio.met.Securiry.Controller.Mensaje;
import com.portfolio.met.Securiry.Dto.dtoPersona;
import com.portfolio.met.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:8080","http://localhost:10000"})

public class PersonaController {

    @Autowired
    ImpPersonaService personaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
   @PreAuthorize("hasRole('ADMIN')")
   @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        // Validación de ID para saber si existe o no existe
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("este ID no existe"), HttpStatus.NOT_FOUND);
        }
        personaService.delete(id);
        return new ResponseEntity(new Mensaje("Educación borrada"), HttpStatus.OK);
    }
 @PreAuthorize("hasRole('ADMIN')")  
 @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtoPersona) {
        if (StringUtils.isBlank(dtoPersona.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (personaService.existsByNombre(dtoPersona.getNombre())) {
            return new ResponseEntity(new Mensaje("Este Nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
      Persona persona = new Persona(dtoPersona.getNombre(), dtoPersona.getDescripcion());
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Educación agregada"), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("el ID no existe"), HttpStatus.NOT_FOUND);
        }

        if (personaService.existsByNombre(dtopersona.getNombre()) && personaService.getByNombre(dtopersona.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtopersona.getNombre())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }

       if (personaService.existsByApellido(dtopersona.getApellido()) && personaService.getByApellido(dtopersona.getApellido()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("El apellido ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtopersona.getApellido())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }

        if (personaService.existsByDescripcion(dtopersona.getDescripcion()) && personaService.getByDescripcion(dtopersona.getDescripcion()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("La descripcion ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtopersona.getDescripcion())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }

        if (personaService.existsByImg(dtopersona.getImg()) && personaService.getByImg(dtopersona.getImg()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("La imagen ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtopersona.getImg())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = personaService.getOne(id).get();
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setDescripcion(dtopersona.getDescripcion());
        persona.setImg(dtopersona.getImg());

        personaService.save(persona);
        return new ResponseEntity(new Mensaje("persona actualizada"), HttpStatus.OK);
    }
}
