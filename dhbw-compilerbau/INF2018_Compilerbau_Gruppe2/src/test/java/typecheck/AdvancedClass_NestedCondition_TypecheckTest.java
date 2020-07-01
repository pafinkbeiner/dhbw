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
public class AdvancedClass_NestedCondition_TypecheckTest
{
    private Klasse clazz;
    private Klasse klasse;

    @BeforeAll
    public void setUp()
    {
        ParserObjects helper = new ParserObjects();
        clazz = helper.advancedClass_NestedCondition();
        TypecheckObjects object = new TypecheckObjects();
        klasse = object.advancedClass_NestedCondition();
    }

    /**
     * class AdvancedClass_NestedCondition { char nesting(boolean controll, int calculator) { if(controll != true) { if
     * (calculator == 0) { calculator = 10; return 'n'; } else { calculator = 3; return 'y'; } } else { return 'n'; } }
     * }
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
