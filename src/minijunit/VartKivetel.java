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

// The test passes only if it throws the given exception type
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface VartKivetel {
    
    Class<? extends Throwable> value();
}
