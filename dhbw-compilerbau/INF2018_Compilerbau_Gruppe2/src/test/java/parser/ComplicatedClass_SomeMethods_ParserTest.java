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
class ComplicatedClass_SomeMethods_ParserTest
{
    private StringsOfClasses helper;
    private Klasse klasse;

    @BeforeAll
    public void setUp()
    {
        helper = new StringsOfClasses();
        ParserObjects object = new ParserObjects();
        klasse = object.complicatedClass_SomeMethods();

    }

    /**
     * class ComplicatedClass_SomeMethods { int add(int a, int b) { return a+b; }
     * int sub(int a, int b) { return a-b; }
     * int loops(boolean b, int i) { while(i>5) { b = false; i = i--; }
     * return i; }
     * }
     */
    @Test
    public void ParserTest()
    {
        String clazz = helper.readJavaClass("/ComplicatedClass_SomeMethods.java");

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
