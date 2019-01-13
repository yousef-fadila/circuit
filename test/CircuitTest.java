/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.circuit.api.Factory;
import com.circuit.api.Gate;
import com.circuit.api.Pin;
import com.circuit.impl.FactoryImpl;

/**
 *
 * @author 20184731
 */
import junit.framework.TestCase;

public class CircuitTest extends TestCase {

    /**
     * Custom implementation of Gate, adding some methods to it
     */
    class WeirdGate implements Gate {

        @Override
        public Boolean getVal() {
            return null;
        }

        public Double getDoubleVal(double val) {
            return val * 2;
        }

        public Object getDoubleVal() {
            return new Object();
        }

        public Object getValue() {
            return new Object();
        }
    }

    private Factory factory;
    
    public CircuitTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
        factory = new FactoryImpl();
    }

    protected void tearDown() throws Exception {
    }
    
    public void testX1andX2() {
        Pin x1 = factory.createPin(Boolean.FALSE);
        Pin x2 = factory.createPin(Boolean.FALSE);
        Gate o1 = factory.createAnd(x1, x2);
        assertFalse(o1.getVal());
        
        x1.setValue(Boolean.TRUE);
        x2.setValue(Boolean.FALSE);
        assertFalse(o1.getVal());
         
        x1.setValue(Boolean.TRUE);
        x2.setValue(Boolean.TRUE);
        assertTrue(o1.getVal());
    }
    
    /** 
     * Create a circuit to evaluate (x1 and x2) or x3 and then
     * verify that its result is false for input (false, true, false) and
     * it is true for input (false, false, true).
     */
    public void testX1andX2orX3() {
	    Pin x1 = factory.createPin(Boolean.FALSE);
        Pin x2 = factory.createPin(Boolean.FALSE);
        Pin x3 = factory.createPin(Boolean.FALSE);
        
        Gate o1 = factory.createOr(factory.createAnd(x1, x2),x3);
        assertFalse(o1.getVal());
        
        
        x3.setValue(Boolean.TRUE);
        assertTrue(o1.getVal());
    }

    /** 
     * Create a circuit to evaluate (x1 or not(x1)) and then
     * verify that its result is true for all values of x1.
     */

    public void testAlwaysTrue() {
        Pin x1 = factory.createPin(Boolean.FALSE);
        Gate o1 = factory.createOr(x1, factory.createNot(x1));
        assertTrue(o1.getVal());
        
       x1.setValue(Boolean.TRUE);
       assertTrue(o1.getVal());
    }
}
