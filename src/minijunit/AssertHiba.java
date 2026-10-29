/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minijunit;

/**
 *
 * Thrown when an assertion fails (a test FAILS, as opposed to an ERROR).
 */


public class AssertHiba extends RuntimeException{
    
    public AssertHiba(String message)
    {
        super(message);
    }
}
