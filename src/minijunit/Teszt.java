/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package minijunit;

import java.lang.annotation.*;
/**
 *
 * @author ministar
 */

// Marks a method as a test; the runner finds it with reflection
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Teszt {
    
}
