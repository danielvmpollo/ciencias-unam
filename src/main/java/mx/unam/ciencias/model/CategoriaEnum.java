/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.model;

/**
 *
 * @author guillermorojas
 */
public enum CategoriaEnum{
    VEGETARIANA("Vegetariana"),
    BEBIDA("Bebidas"),
    CARNES("Carenes");
    
    public String categoria;
    
    private CategoriaEnum(String categoria){
        this.categoria=categoria;
    }
    
    
    @Override
    public String toString(){
        return this.categoria;
    }
}
