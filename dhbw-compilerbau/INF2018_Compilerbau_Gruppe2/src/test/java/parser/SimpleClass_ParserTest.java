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
public class SimpleClass_ParserTest
{
    private StringsOfClasses helper;
    private Klasse klasse;

    @BeforeAll
    public void setUp()
    {
        helper = new StringsOfClasses();
        ParserObjects object = new ParserObjects();
        klasse = object.simpleClass();
    }

    /**
     * Testen mit einer leeren Klasse
     * class SimpleClass{}
     */
    @Test
    public void ParseTest()
    {

        try
        {
            assertEquals(klasse,
                         new JavaToAST().compile(helper.readJavaClass("/SimpleClass.java"))
                                 .get(0));
        }
        catch ( Exception e )
        {
            fail(e);
        }

    }
}
