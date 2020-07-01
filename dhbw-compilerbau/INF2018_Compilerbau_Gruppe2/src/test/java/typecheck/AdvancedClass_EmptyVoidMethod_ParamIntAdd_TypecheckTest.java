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
public class AdvancedClass_EmptyVoidMethod_ParamIntAdd_TypecheckTest
{

    private Klasse klasse;
    private Klasse clazz;

    @BeforeAll
    public void setUp()
    {
        ParserObjects helper = new ParserObjects();
        clazz = helper.advancedClass_EmptyVoidMethod_ParamIntAdd();
        TypecheckObjects object = new TypecheckObjects();
        klasse = object.advancedClass_EmptyVoidMethod_ParamIntAdd();
    }

    /**
     * class AdvancedClass_EmptyVoidMethod_ParamIntAdd { boolean b; void method(int i){ i = i++; } }
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
