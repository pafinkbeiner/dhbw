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
public class AdvancedClass_NestedCondition_ParserTest
{
    private StringsOfClasses helper;
    private Klasse klasse;

    @BeforeAll
    public void setUp()
    {
        helper = new StringsOfClasses();
        ParserObjects object = new ParserObjects();
        klasse = object.advancedClass_NestedCondition();
    }

    /**
     * class AdvancedClass_NestedCondition { char nesting(boolean controll, int calculator) { if(controll != true) { if
     * (calculator == 0) { calculator = 10; return 'n'; } else { calculator = 3; return 'y'; } } else { return 'n'; } }
     * }
     */
    @Test
    public void ParserTest()
    {

        final String clazz = helper.readJavaClass("/AdvancedClass_NestedCondition.java");

        if ( !clazz.equals("") )
        {
            try
            {
                assertEquals(klasse,
                             new JavaToAST().compile(clazz)
                                     .get(0));
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
