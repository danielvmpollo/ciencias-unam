/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.service;

import java.util.List;
import mx.unam.ciencias.model.Local;

/**
 *
 * @author guillermorojas
 */
public interface LocalService {
    
    void guardaLocal(Local local);
    
    void eliminarLocal(Local local);
    
    List<Local> findAll();
    
    List<Local> findByNombre(String nombre);
    
    List<Local> findByCategoria(String categoria);
  
}
