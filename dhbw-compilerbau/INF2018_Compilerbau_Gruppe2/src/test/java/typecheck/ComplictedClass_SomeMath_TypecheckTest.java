
package typecheck;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import abstrakteSyntax.Klasse;
import helper.ParserObjects;
import helper.TypecheckObjects;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ComplictedClass_SomeMath_TypecheckTest
{
    private Klasse clazz;
    private Klasse klasse;

    @BeforeAll
    public void setUp()
    {
        ParserObjects helper = new ParserObjects();
        clazz = helper.complicatedClass_SomeMath();
        TypecheckObjects object = new TypecheckObjects();
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
    public void TypecheckTest()
    {

        try
        {
            //class list
            ArrayList<Klasse> klassen = new ArrayList<>();
            klassen.add(clazz);

            clazz.typeCheck(klassen);
            assertEquals(klasse, clazz);

        }
        catch ( Exception e )
        {
            fail(e);

        }

    }
}
