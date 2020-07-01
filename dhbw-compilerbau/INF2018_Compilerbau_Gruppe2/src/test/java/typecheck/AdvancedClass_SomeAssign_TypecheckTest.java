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
public class AdvancedClass_SomeAssign_TypecheckTest
{
    private Klasse clazz;
    private Klasse klasse;

    @BeforeAll
    public void setUp()
    {
        ParserObjects helper = new ParserObjects();
        clazz = helper.advancedClass_SomeAssigns();
        TypecheckObjects object = new TypecheckObjects();
        klasse = object.advancedClass_SomeAssigns();
    }

    /**
     * class AdvancedClass_SomeAssigns { void assign(int zahl1, int zahl2, int zahl3, boolean validator) { zahl1 = 100;
     * if ( zahl2 < zahl1 ) { zahl2 = zahl2 * 3; zahl1 = zahl2 + zahl1; zahl3 = 1000 - zahl1; validator = true; } else {
     * zahl3 = 500 - zahl1; zahl2 = zahl1 * zahl3 - 30; } } }
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
