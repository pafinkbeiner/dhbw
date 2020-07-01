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
public class AdvancedClass_EmptyVoidMethod_ParamIntAdd_ParserTest
{
    StringsOfClasses helper;
    public Klasse klasse;

    @BeforeAll
    public void setUp()
    {
        helper = new StringsOfClasses();
        ParserObjects object = new ParserObjects();
        klasse = object.advancedClass_EmptyVoidMethod_ParamIntAdd();
    }

    /**
     * class AdvancedClass_EmptyVoidMethod_ParamIntAdd { boolean b; void method(int i){ i = i++; } }
     */
    @Test
    public void ParserTest()
    {

        final String clazz = helper.readJavaClass("/AdvancedClass_EmptyVoidMethod_ParamIntAdd.java");

        if ( !clazz.equals("") )
        {
            try
            {
                Klasse compiledCLazz = new JavaToAST().compile(clazz)
                    .get(0);
                assertEquals(klasse,compiledCLazz
                             );
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
