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
public class AdvancedClass_VoidMethodIfElseCondition_IntParam_TypecheckTest
{
    private Klasse clazz;
    private Klasse klasse;

    @BeforeAll
    public void setUp()
    {
        ParserObjects helper = new ParserObjects();
        clazz = helper.advancedClass_VoidMethodIfElseCondition_IntParam();
        TypecheckObjects object = new TypecheckObjects();
        klasse = object.advancedClass_VoidMethodIfElseCondition_IntParam();
    }

    /**
     * class AdvancedClass_VoidMethodIfElseCondition_IntParam { char controll; void condition(char c) { if ( c == 'a' )
     * { controll = 'y'; } else { controll = 'n'; } } }
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
