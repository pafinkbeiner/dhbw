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
public class AdvancedClass_EmptyCharMethod_ParamChar_ParserTest
{
    StringsOfClasses helper;
    Klasse klasse;

    @BeforeAll
    public void setUp()
    {
        helper = new StringsOfClasses();
        ParserObjects object = new ParserObjects();
        klasse = object.advancedClass_EmptyCharMethod_ParamChar();

    }

    /**
     * class AdvancedClass_EmptyCharMethod_ParamChar { char method (char c, char a){ return c; } }
     */
    @Test
    public void ParserTest()
    {
        String clazz = helper.readJavaClass("/AdvancedClass_EmptyCharMethod_ParamChar.java");

        if ( !clazz.equals("") )
        {
            try
            {
                Klasse compiledClass = new JavaToAST().compile(clazz)
                        .get(0);
                assertEquals(klasse, compiledClass);
            }
            catch ( Exception e )
            {
                fail(e);
            }
        }
        else
        {
            fail("Could not read java resource file");
        }
    }
}
