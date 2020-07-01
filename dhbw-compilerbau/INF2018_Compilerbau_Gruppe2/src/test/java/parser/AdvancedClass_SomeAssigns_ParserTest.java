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
public class AdvancedClass_SomeAssigns_ParserTest
{
    private StringsOfClasses helper;
    private Klasse klasse;

    @BeforeAll
    public void setUp()
    {
        helper = new StringsOfClasses();
        ParserObjects object = new ParserObjects();
        klasse = object.advancedClass_SomeAssigns();
    }

    /**
     * class AdvancedClass_SomeAssigns { void assign(int zahl1, int zahl2, int zahl3, boolean validator) { zahl1 = 100;
     * if ( zahl2 < zahl1 ) { zahl2 = zahl2 * 3; zahl1 = zahl2 + zahl1; zahl3 = 1000 - zahl1; validator = true; } else {
     * zahl3 = 500 - zahl1; zahl2 = zahl1 * zahl3 - 30; } } }
     */
    @Test
    public void ParserTest()
    {

        final String clazz = helper.readJavaClass("/AdvancedClass_SomeAssigns.java");

        if ( !clazz.equals("") )
        {
            try
            {
                assertEquals(klasse,
                             new JavaToAST().compile(clazz)
                                     .get(0));
            }
            catch ( Exception e )
            {
                fail(e);
            }
        }
        else
        {
            fail("Cannot read java resource file");
        }
    }
}
