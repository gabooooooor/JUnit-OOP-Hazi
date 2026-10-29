/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peldateszt;

import minijunit.*;
/**
 *
 * @author ministar
 */
public class HandTeszt {
    
    @Teszt
    public void passes()
    {
        Assert.egyenlo(4, 2 + 2);
    }
    
    @Teszt
    public void fails()
    {
        Assert.egyenlo(5, 2 + 2);
    }
    
    @Teszt
    public void errors()
    {
        throw new IllegalStateException("boom");
    }
    
    @Teszt
    @VartKivetel(IllegalArgumentException.class)
    public void expectedException()
    {
        throw new IllegalArgumentException("ok");
    }
}
