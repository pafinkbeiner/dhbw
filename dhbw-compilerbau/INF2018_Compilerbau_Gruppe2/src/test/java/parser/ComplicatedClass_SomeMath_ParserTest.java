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
public class ComplicatedClass_SomeMath_ParserTest
{
    private StringsOfClasses helper;
    private Klasse klasse;

    @BeforeAll
    public void setUp()
    {
        helper = new StringsOfClasses();
        ParserObjects object = new ParserObjects();
        klasse = object.complicatedClass_SomeMath();

    }

    /**
     * class ComplicatedClass_SomeMath { int a; int b;
     * ComplicatedClass_SomeMath(int a, int b) { this.a = a; this.b = b; }
     * int add() { return this.a + this.b; }
     * int substract() { return this.a - this.b; }
     * int multiply() { return this.a * this.b; }
     * int divide() { return this.a / this.b; }
     * void setA(int a) { this.a = a; }
     * void setB(int b) { this.b = b; } }
     */
    @Test
    public void ParserTest()
    {
        String clazz = helper.readJavaClass("/ComplicatedClass_SomeMath.java");

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
