/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.circuit.api.Factory;
import com.circuit.api.Gate;
import com.circuit.api.Pin;
import com.circuit.impl.FactoryImpl;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 *
 * @author 20184731
 */
import junit.framework.TestCase;

public class CircuitTest extends TestCase {
    private Factory f;
    static {
        // your code shall run without any permissions
    }
    
    public CircuitTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
        f = new FactoryImpl();
    }

    protected void tearDown() throws Exception {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    public void testX1andX2() {
        Pin x1 = f.createPin(Boolean.FALSE);
        Pin x2 = f.createPin(Boolean.FALSE);
        Gate o1 = f.createAnd(x1, x2);
        assertFalse(o1.getVal());
        
        x1.setValue(Boolean.TRUE);
        x2.setValue(Boolean.FALSE);
        assertFalse(o1.getVal());
         
        x1.setValue(Boolean.TRUE);
        x2.setValue(Boolean.TRUE);
        assertTrue(o1.getVal());
        //System.out.println(o1);
                
//        fail("testX1andX2");
    }
    
    /** 
     * Create a circuit to evaluate (x1 and x2) or x3 and then
     * verify that its result is false for input (false, true, false) and
     * it is true for input (false, false, true).
     */
    public void testX1andX2orX3() {
	Pin x1 = f.createPin(Boolean.FALSE);
        Pin x2 = f.createPin(Boolean.FALSE);
        Pin x3 = f.createPin(Boolean.FALSE);
        
        Gate o1 = f.createOr(f.createAnd(x1, x2),x3);
        assertFalse(o1.getVal());
        
        
        x3.setValue(Boolean.TRUE);
        assertTrue(o1.getVal());
    }
    /** 
     * Create a circuit to evaluate (x1 or not(x1)) and then
     * verify that its result is true for all values of x1.
     */

    public void testAlwaysTrue() {
        Pin x1 = f.createPin(Boolean.FALSE);
        Gate o1 = f.createOr(x1,f.createNot(x1));
        assertTrue(o1.getVal());
        
       x1.setValue(Boolean.TRUE);
       assertTrue(o1.getVal());
    }
}
