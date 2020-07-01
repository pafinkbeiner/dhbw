package parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import abstrakteSyntax.Klasse;
import helper.ParserObjects;
import helper.StringsOfClasses;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import parser.converter.JavaToAST;

@TestInstance(Lifecycle.PER_CLASS)
public class WrongAssign_ParserTest
{
    private StringsOfClasses helper;
    private ParserObjects parserObjects;
    private Klasse klasse;

    @BeforeAll
    public void setUp()
    {
        parserObjects = new ParserObjects();
        helper = new StringsOfClasses();
        klasse = parserObjects.wrongAssing();
    }

    /**
     * class WrongAssign { int a; WrongAssign(char c) { a = c; } }
     */
    @Test
    public void ParseTest()
    {

        try
        {
            assertEquals(klasse,
                         new JavaToAST().compile(helper.readJavaClass("/WrongAssign.java"))
                                 .get(0));
        }
        catch ( Exception e )
        {
            fail(e);
        }

    }
}
