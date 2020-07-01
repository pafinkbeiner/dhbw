/*
 *
 *  * (c) 2015 - 2020 ENisco GmbH & Co. KG
 *
 */

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
public class ComplicatedClass_MethodCall_TypecheckTest
{
    private Klasse klasse;
    private Klasse clazz;

    @BeforeAll
    public void setup()
    {
        ParserObjects helper = new ParserObjects();
        clazz = helper.complicatedClass_MethodCall();
        TypecheckObjects object = new TypecheckObjects();
        klasse = object.complicatedClass_MethodCall();
    }

    /**
     * class ComplicatedClass_MethodCall { ComplicatedClass_MethodCall(int a, int b){ doMath(a,b); } int doMath(int
     * zahl1, int zahl2) { return (zahl1 + zahl2)*3; } }
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
