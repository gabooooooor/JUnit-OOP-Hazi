/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minijunit;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 *
 * @author ministar
 */
public class TesztFuttato {
   
    private final Class<?> testClass;
    
    private int passed = 0;
    private int failed = 0; // AssertHiba
    private int errors = 0; // unexpected exception
    
    public TesztFuttato(Class<?> testClass)
    {
        this.testClass = testClass;
    }
    
    private List<Method> findMethods(Class<? extends Annotation> annotation)
    {
        List<Method> result = new ArrayList<>();
        for(Method m : testClass.getDeclaredMethods())
        {
            if(m.isAnnotationPresent(annotation))
            {
                result.add(m);
            }
        }
        return result;
    }
    
    private Object newInstance() throws Exception
    {
        return testClass.getDeclaredConstructor().newInstance();
    }
    
    private void invokeAll(List<Method> methods, Object instance) throws Exception
    {
        for(Method m : methods)
        {
            m.invoke(instance);
        }
    }
    
    public void runTest(Method test)
    {
        Object instance = null;
        Throwable thrown = null;
        try
        {
            instance = newInstance();
            invokeAll(findMethods(Elotte.class), instance);
            test.invoke(instance);
        }
        catch(InvocationTargetException e)
        {
            thrown = e.getCause();
        }
        catch(Exception e)
        {
            thrown = e;
        }
        
        if(instance != null)
        {
            try
            {
                invokeAll(findMethods(Utana.class), instance);
            }
            catch(InvocationTargetException e)
            {
                if(thrown == null)
                {
                    thrown = e.getCause();
                }
            }
            catch(Exception e)
            {
                if(thrown == null)
                {
                    thrown = e;
                }
            }
        }
        evaluate(test, thrown);
    }
    
    private void evaluate(Method test, Throwable thrown)
    {
        VartKivetel expected = test.getAnnotation(VartKivetel.class);
        if(expected != null)
        {
            if(expected.value().isInstance(thrown))
            {
                passed++;
                System.out.println("✔ " + test.getName());
            }
            else
            {
                failed++;
                System.out.println("✘ " + test.getName() + " - " + (thrown == null ? "expected exception not thrown" : thrown.getMessage()));
            }
        }
        else
        {
            if(thrown == null) 
            { 
                passed++;
                System.out.println("✔ " + test.getName());
            }
            else if(thrown instanceof AssertHiba) 
            { 
                failed++;
                System.out.println("✘ " + test.getName() + " - " + thrown.getMessage());
            }
            else 
            { 
                errors++;
                System.out.println("✘ " + test.getName() + " - ERROR: " + thrown);
            }
        }
    }
    
    public void futtat()
    {
        long start = System.nanoTime();
        List<Method> tests = findMethods(Teszt.class);
        tests.sort(Comparator.comparing(Method::getName));
        for(Method t : tests)
        {
            runTest(t);
        }
        long ms = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Passed: " + passed + ", Failed: " + failed + ", Errors: " + errors + ", Time: " + ms + " ms");
    }
}
