import com.circuit.api.*;
import com.circuit.impl.FactoryImpl;
import junit.framework.TestCase;
import org.junit.Assert;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 20184743
 */
public class DoubleCircuitTest extends TestCase {
    private Factory factory;
    
    public DoubleCircuitTest(String testName) {
        super(testName);
    }
    
    protected void setUp() throws Exception {
        factory = new FactoryImpl();
    }

    protected void tearDown() throws Exception {
    }
    
    /** First of all create a circuit which will evaluate
     * expression (x1 and x2) or not(x1). Hold the circuit
     * in some variable.
     *
     * Feed this circuit with x1=true, x2=false, assert result is false
     *
     * Feed the same circuit with x1=false, x2=true, assert result is true
     *
     * Feed the same circuit with x1=0.0, x2=1.0, assert result is 1.0
     *
     * Feed the same circuit with x1=0.5, x2=0.5, assert result is 0.625
     *
     * Feed the same circuit with x1=0.0, x2=2.0, make sure it throws an exception
     */
    public void testX1andX2orNotX1() {
        TypedPin<Double> x1 = factory.createPin(false);
        TypedPin<Double> x2 = factory.createPin(false);
        
        Gate and = factory.createAnd(x1, x2);
        Gate not = factory.createNot(x1);
        TypedGate<Double> result = factory.createOr(and, not);
        
        // Case 1
        x1.setValue(true);
        Assert.assertFalse(result.getVal());
        
        // Case 2
        x1.setValue(false);
        x2.setValue(true);
        Assert.assertTrue(result.getVal());
        
        // Case 3
        x1.setValue(0.0);
        x2.setValue(1.0);
        Assert.assertTrue(result.getValue().equals(1.0));
        
        // Case 4
        x1.setValue(0.5);
        x2.setValue(0.5);
        Assert.assertTrue(result.getValue().equals(0.625));
        
        // Case 5
        x1.setValue(0.0);
        x2.setValue(2.0);
                
        try {
            result.getValue();
            Assert.fail("Exception is expected.");
        } catch(IllegalStateException e) {
            // We are good
        }
    }
    
    /** Ensure that one variable cannot be filled with two different values.
     * Create a circuit for x1 and x1. Make sure that for any usage of your
     * API that would not lead to x1 * x1 result, an exception is thrown.
     * For example if there was a way to feed the circuit with two different 
     * values 0.3 and 0.5 an exception is thrown indicating that this is 
     * improper use of the circuit.
     */
    public void testImproperUseOfTheCircuit() {
        TypedPin<Double> x1 = factory.createPin(false);
        x1.setValue(0.5);
        TypedGate<Double> and = factory.createAnd(x1, x1);
        
        x1.setValue(0.3);
        Assert.assertNotEquals(and.getValue(), 0.5 * 0.3, 0.0);
    }

    /** Write your own element type called "gte" that will have two inputs and one output.
     * The output value will be 1 if x1 >= x2 and 0 otherwise. 
     * 
     * Create 
     * circuit for following expression: (x1 and not(x1)) gte x1
     *
     * Feed the circuit with 0.5 and verify the result is 0
     *
     * Feed the same circuit with 1 and verify the result is 0
     *
     * Feed the same circuit with 0 and verify the result is 1
     */
    public void testGreaterThanElement() {
        TypedPin<Double> x1 = factory.createPin(false);
        x1.setValue(0.5);
        TypedGate<Double> result = new Gte(factory.createAnd(x1, factory.createNot(x1)), x1);
        
        // Case 1
        Assert.assertEquals(0.0, result.getValue(), 0.0);
        
        // Case 2
        x1.setValue(1.0);
        Assert.assertEquals(0.0, result.getValue(), 0.0);
        
        // Case 3
        x1.setValue(0.0);
        Assert.assertEquals(1.0, result.getValue(), 0.0);
    }
    
    class Gte implements TypedGate<Double> {

        private TypedGate<Double> op1, op2;
        
        public Gte(TypedGate<Double> op1, TypedGate<Double> op2) {
            this.op1 = op1;
            this.op2 = op2;
        }
        
        @Override
        public Boolean getVal() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Double getValue() {
            return op1.getValue() >= op2.getValue() ? 1.0 : 0.0;
        }
    }
}
