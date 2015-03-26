/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.repository;

import java.io.Serializable;
import java.util.List;
import mx.unam.ciencias.model.Local;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author guillermorojas
 */
public interface LocalRepository extends CrudRepository<Local, Integer>{
     @Query("SELECT l FROM Local l")
     @Override
    List<Local> findAll();

    @Query("SELECT loc FROM Local loc WHERE loc.nombre LIKE CONCAT(?,'%') ")
    List<Local> findByNombre(String nombre);
    
    @Query("SELECT l FROM Local l WHERE l IN (SELECT m.local FROM Menu m WHERE m.categoria LIKE CONCAT('%',?,'%') ) ")
    List<Local> findByCategoria(String categoria);
    
    @Query("SELECT l FROM Local l WHERE l IN (SELECT m.local FROM Menu m WHERE m.nombre LIKE CONCAT('%',?,'%') ) ")
    List<Local> findByNombreMenu(String menu);
    
    @Query("SELECT l FROM Local l WHERE l.rangoInferior > ? AND l.rangoSuperior< ?")
    List<Local> findByRangoInferior(Integer rangoInferior,Integer rangoSuperior);
    
    @Query("SELECT l FROM Local l JOIN FECTH RutaPumaBus r "+
           "WHERE r.nombreRuta LIKE CONCAT('%',?,'%')")
    List<Local> findByRutaPumaBus(String nombreRuta);
}
