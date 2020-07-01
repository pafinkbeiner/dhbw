package parser;

import static org.junit.jupiter.api.Assertions.assertTrue;
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
public class AdvancedClass_VoidMethod_Bool_ParserTest
{
    private StringsOfClasses helper;
    private Klasse klasse;

    @BeforeAll
    public void setUp()
    {
        helper = new StringsOfClasses();
        ParserObjects object = new ParserObjects();
        klasse = object.advancedClass_VoidMethod_Bool();
    }

    /**
     * class AdvancedClass_VoidMethod_Bool{ boolean b; void method(int i, boolean d){ i = i+1; d = !false; } }
     */
    @Test
    public void ParserTest()
    {

        final String clazz = helper.readJavaClass("/AdvancedClass_VoidMethod_Bool.java");

        if ( !clazz.equals("") )
        {
            try
            {
                assertTrue(klasse.equals(new JavaToAST().compile(clazz)
                                                 .get(0)));
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
