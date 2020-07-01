import static org.junit.jupiter.api.Assertions.fail;

import abstrakteSyntax.Klasse;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import parser.converter.JavaToAST;

public class CodeGenTest
{
    @Test
    public void generateClassFileTest()
            throws IOException
    {
            ArrayList<Klasse> absSyntax = new JavaToAST().compile("class A{}");
            absSyntax.get(0).codeGen();
    }
}
