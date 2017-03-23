import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class PilaTest {

    private static Pila pila;

    @Before
    public void before(){
        pila = new Pila();
    }


    @Test
    public void push() throws Exception {
        for (int i = 0; i <= 9; i++) {
            pila.push(i);
        }
        assertEquals(9,pila.size());
        assertEquals(40,pila.bytesInMemory());

        pila.push(10);
        assertEquals(10,pila.size());
        assertEquals(80,pila.bytesInMemory());

        pila.push(11);
        assertEquals(11,pila.size());
        assertEquals(80,pila.bytesInMemory());
    }

    @Test
    public void pop() throws Exception {
        for (int i = 0; i <= 11; i++) {
            pila.push(i);
        }
        assertEquals(11,pila.size());
        assertEquals(80,pila.bytesInMemory());

        assertEquals(11,pila.pop());
        assertEquals(80,pila.bytesInMemory());

        assertEquals(10,pila.pop());
        assertEquals(40,pila.bytesInMemory());

        for (int i = 0; i < 10 ; i++) {
            pila.pop();
        }

        assertEquals(0,pila.bytesInMemory());

        pila.push(1);
        assertEquals(40,pila.bytesInMemory());
        pila.pop();

        try {
            //This throws exception
            pila.pop();
            fail();
        } catch (IndexOutOfBoundsException e ){

        }
    }

}