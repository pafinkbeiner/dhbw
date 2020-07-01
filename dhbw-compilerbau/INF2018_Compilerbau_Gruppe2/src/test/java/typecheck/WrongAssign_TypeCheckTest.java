package typecheck;

import abstrakteSyntax.Klasse;
import abstrakteSyntax.TypeException;
import helper.ParserObjects;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class WrongAssign_TypeCheckTest
{
    private Klasse clazz;
    private Klasse klasse;

    @BeforeAll
    public void setUp()
    {
        ParserObjects helper = new ParserObjects();
        clazz = helper.simpleClass();

    }

    /**
     * class WrongAssign { int a; WrongAssign(char c) { a = c; } }
     */
    @Test
    public void TypecheckTest()

    {
        boolean result = false;
        try
        {
            ArrayList<Klasse> klassen = new ArrayList<>();
            klassen.add(clazz);
            clazz.typeCheck(klassen);
        }
        catch ( TypeException e )
        {
            result = true;
            Assertions.assertTrue(result);
        }

    }
}
