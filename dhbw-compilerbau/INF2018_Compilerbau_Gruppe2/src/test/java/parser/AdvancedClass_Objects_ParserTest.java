package parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import abstrakteSyntax.Klasse;
import helper.ParserObjects;
import helper.StringsOfClasses;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import parser.converter.JavaToAST;

@TestInstance(Lifecycle.PER_CLASS)
public class AdvancedClass_Objects_ParserTest
{
    ArrayList<Klasse> klassen;
    StringsOfClasses helper;

    @BeforeAll
    public void setup()
    {
        helper = new StringsOfClasses();
        ParserObjects objects = new ParserObjects();
        klassen = objects.advancedClass_Objects();
    }

    @Test
    public void ParserTest()
    {
        final String syntax = helper.readJavaClass("/SimpleClass.java") + " " + helper.readJavaClass("/AdvancedClass_Objects.java");

        if ( !syntax.equals(" "))
        {

            ArrayList<Klasse> clazzes = new JavaToAST().compile(syntax);
            try
            {
                assertEquals(klassen.size(), clazzes.size());
                assertEquals(klassen.get(0), clazzes.get(0));
                assertEquals(klassen.get(1), clazzes.get(1));
            }
            catch ( Exception e )
            {
                fail(e);
            }
        }
        else
        {
            fail("Cannot read java resource file");
        }
    }
}
