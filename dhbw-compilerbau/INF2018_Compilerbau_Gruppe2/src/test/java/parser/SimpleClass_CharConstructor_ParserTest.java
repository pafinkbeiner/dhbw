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
public class SimpleClass_CharConstructor_ParserTest
{
    private StringsOfClasses helper;
    private Klasse klasse;

    @BeforeAll
    public void setUp()
    {
        helper = new StringsOfClasses();
        ParserObjects object = new ParserObjects();
        klasse = object.simpleClass_CharConstructor();

    }

    /**
     * class SimpleClass_EmptyConstructor { SimpleClass_EmptyConstructor() { } }
     */
    @Test
    public void ParserTest()
    {
        String clazz = helper.readJavaClass("/SimpleClass_CharConstructor.java");

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
