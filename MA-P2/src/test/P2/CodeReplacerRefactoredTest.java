package P2;

import java.io.PrintWriter;

/**
 * Created by sergio on 2/03/17.
 */
public class CodeReplacerRefactoredTest {
    @org.junit.Test
    public void substitute() throws Exception {
        CodeReplacerRefactored c = new CodeReplacerRefactored();
        c.substitute("", new PrintWriter( System.out) );

    }

}