/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minijunit;

import java.util.Objects;
/**
 *
 * Static assertion helpers. Each failure throws AssertHiba.
 */
public class Assert {
    
    public static void egyenlo(Object expected, Object actual)
    {
        if (!Objects.equals(expected, actual)) 
            throw new AssertHiba("expected: <" + expected + "> but was: <" + actual + ">");
    }
    
    public static void igaz(boolean condition)
    {
        if(!condition) throw new AssertHiba("expected: <true> but was: <false>");
    }
    
    public static void hamis(boolean condition)
    {
        if(condition) throw new AssertHiba("expected: <false> but was: <true>");
    }
    
    public static void nemNull(Object value)
    {
        if(value == null) throw new AssertHiba("expected: <not null> but was: <null>");
    }
    
    public static void dobja(Class<? extends Throwable> expected, Runnable code)
    {
        try 
        {
            code.run();
        } 
        catch (Throwable t) 
        {
            if (expected.isInstance(t)) return;
            throw new AssertHiba("expected exception: <" + expected.getName() + "> but was: <" + t.getClass().getName() + ">");
        }
        throw new AssertHiba("expected exception: <" + expected.getName() + "> but nothing was thrown");
    }
}
