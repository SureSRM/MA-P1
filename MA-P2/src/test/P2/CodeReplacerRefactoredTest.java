package P2;

import org.junit.*;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CodeReplacerRefactoredTest {

    private static CodeReplacerRefactored c;
    private static ByteArrayOutputStream file;
    private static PrintWriter out;

    @BeforeClass
    public static void beforeClass(){
        c = new CodeReplacerRefactored();
        File template = new File("template.html");
//        template.deleteOnExit();

        try {
            template.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(template));
            out.write("%NAME%\n%INITIALS%");
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Before
    public void before(){
        file = new ByteArrayOutputStream();
        out = new PrintWriter(file);
    }

    @After
    public void after(){
        out.close();
    }

    @Test
    public void substitute() throws Exception {
        c.substitute("Sergio Martin", out );
        assertEquals("Sergio Martin\nSM\n",file.toString());
    }

    @Test
    public void substitute2() throws Exception {
        c.substitute("", out );
        assertEquals("\n\n",file.toString());
    }

    @Test(expected = NullPointerException.class)
    public void substitute3() throws Exception {
        c.substitute("", null );
        assertEquals("\n\n",file.toString());
    }

    @Test
    public void substitute4() throws Exception {
        c.substitute(null, out );
        assertEquals("",file.toString());
    }

    @Test
    public void substitute5() throws Exception {
        c.substitute("1", out );
        assertEquals("1\n1\n",file.toString());
    }

    @Test
    public void substitute6() throws Exception {
        c.substitute("1 2", out );
        assertEquals("1 2\n12\n",file.toString());
    }

    @Test
    public void substitute7() throws Exception {
        c.substitute("Ser\ngio Mar\ntin", out ); // Reads \n as a regular char
        assertEquals("Ser\ngio Mar\ntin\nSM\n",file.toString());
    }

    @Test
    public void substitute8() throws Exception {
        c.substitute("Ser\tgio Mar\ttin", out ); // Reads \n as a regular char
        assertEquals("Ser\tgio Mar\ttin\nSM\n",file.toString());
    }

    @Test
    public void substitute9() throws Exception {
        c.substitute("Érgio Martín", out ); // Reads \n as a regular char
        assertEquals("Érgio Martín\nÉM\n",file.toString());
    }

}