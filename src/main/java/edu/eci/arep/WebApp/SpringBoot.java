/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arep.WebApp;

import edu.eci.arep.annotations.Web;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eduardo.ocampo
 */
public class SpringBoot {
    static public void main(String[] args){
        String className = "edu.eci.arep.WebService.WebService";
        try {
            Class c = Class.forName(className);
            Method[] methods = c.getMethods();
            for(Method m: methods){
                if(m.isAnnotationPresent(Web.class)){
                    System.out.println("Ejecutando el metodo: " + m.getName());
                    System.out.println("Ejecutando la clase: " + c.getName());
                    try {
                        
                        System.out.println(m.invoke(null));
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(SpringBoot.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(SpringBoot.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvocationTargetException ex) {
                        Logger.getLogger(SpringBoot.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SpringBoot.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
