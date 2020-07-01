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
public class ComplicatedClass_MethodCall_ParserTest
{
    StringsOfClasses helper;
    Klasse klasse;

    @BeforeAll
    public void setUp()
    {
        helper = new StringsOfClasses();
        ParserObjects object = new ParserObjects();
        klasse = object.complicatedClass_MethodCall();
    }

    /**
     * class ComplicatedClass_MethodCall { ComplicatedClass_MethodCall(int a, int b){ doMath(a,b); } int doMath(int
     * zahl1, int zahl2) { return (zahl1 + zahl2)*3; } }
     */
    @Test
    public void ParserTest()
    {
        String clazz = helper.readJavaClass("/ComplicatedClass_MethodCall.java");

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
