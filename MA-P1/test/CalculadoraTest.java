import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by sergio on 23/02/17.
 */
public class CalculadoraTest {

    private Calculadora cal = new Calculadora();

    @Test
    public void sumar1() throws Exception {
        assertEquals(0, cal.sumar(""));
    }

    @Test
    public void sumar2() throws Exception {
        assertEquals(1, cal.sumar("1"));
    }

    @Test
    public void sumar3() throws Exception {
        assertEquals(3, cal.sumar("1,2"));
    }

    @Test
    public void sumar4() throws Exception {
        assertEquals(1, cal.sumar(" 1 "));
    }

    @Test
    public void sumar5() throws Exception {
        assertEquals(12, cal.sumar(" 1 , 1 1 "));
    }

    @Test
    public void sumar6() throws Exception {
        assertEquals(159, cal.sumar(" 1 , 15 8"));
    }

    @Test
    public void sumar7() throws Exception {
        try {
            cal.sumar(null);
            fail();
        } catch (CalculadoraException e) {
        }
    }

    @Test
    public void sumar9() throws Exception {
        try {
            cal.sumar("1,2,");
            fail();
        } catch (CalculadoraException e) {
        }
    }

    @Test
    public void sumar10() throws Exception {
        try {
            cal.sumar(" ,");
            fail();
        } catch (CalculadoraException e) {
        }
    }

    @Test
    public void sumar11() throws Exception {
        try {
            cal.sumar(" , , ");
            fail();
        } catch (CalculadoraException e) {
        }
    }

    @Test
    public void sumar12() throws Exception {
        try {
            cal.sumar("a");
            fail();
        } catch (CalculadoraException e) {
        }
    }

    @Test
    public void sumar14() throws Exception {
        try {
            cal.sumar("1,a");
            fail();
        } catch (CalculadoraException e) {
        }
    }

    @Test
    public void sumar15() throws Exception {
        try {
            cal.sumar("4e2");
            fail();
        } catch (CalculadoraException e) {
        }
    }

    @Test
    public void sumar16() throws Exception {
        try {
            cal.sumar("4^2");
            fail();
        } catch (CalculadoraException e) {
        }
    }

    @Test
    public void sumar17() throws Exception {
        try {
            cal.sumar("2.3");
            fail();
        } catch (CalculadoraException e) {
        }
    }

    @Test
    public void sumar18() throws Exception {
        assertEquals(-1, cal.sumar("-1"));
    }

    @Test
    public void sumar19() throws Exception {
        assertEquals(1, cal.sumar("-1,2"));
    }

    @Test
    public void sumar20() throws Exception {
        assertEquals(-1, cal.sumar(" - 1 "));
    }


    @Test
    public void sumar21() throws Exception {
        assertEquals(3, cal.sumar(" 1 \n 1, 1 "));
    }

    @Test
    public void sumar22() throws Exception {
        assertEquals(8, cal.sumar(" 1 , -1 \n 8"));
    }

    @Test
    public void sumar23() throws Exception {
        assertEquals(4, cal.sumar(" 1 , 1, 1, 1"));
    }

    @Test
    public void sumar24() throws Exception {
        assertEquals(8, cal.sumar("//e\n 1 e -1 e 8"));
    }

    @Test(expected = CalculadoraException.class)
    public void sumar25() throws Exception {
        assertEquals(8, cal.sumar("//e\n 1 e -1 \n 8"));
    }

}