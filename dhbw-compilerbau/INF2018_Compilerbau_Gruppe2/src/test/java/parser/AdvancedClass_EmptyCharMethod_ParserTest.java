package parser;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import abstrakteSyntax.Klasse;
import abstrakteSyntax.Methode;
import abstrakteSyntax.Types;
import abstrakteSyntax.expression.Char;
import abstrakteSyntax.expression.LocalOrFieldVar;
import abstrakteSyntax.expression.Unary;
import abstrakteSyntax.statements.Block;
import abstrakteSyntax.statements.Return;
import abstrakteSyntax.statements.Statement;
import abstrakteSyntax.statements.SuperStatement;
import helper.ParserObjects;
import helper.StringsOfClasses;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import parser.converter.JavaToAST;

@TestInstance(Lifecycle.PER_CLASS)
public class AdvancedClass_EmptyCharMethod_ParserTest
{

    StringsOfClasses helper;
    public Klasse klasse;

    @BeforeAll
    public void setUp()
    {
        helper = new StringsOfClasses();
        ParserObjects object = new ParserObjects();
        klasse = object.advancedClass_EmptyCharMethod();
    }

    /**
     * class AdvancedClass_EmptyCharMethod { char method(){ return 'B'; } }
     */
    @Test
    public void ParserTest()
    {

        String clazz = helper.readJavaClass("/AdvancedClass_EmptyCharMethod.java");

        if ( !clazz.equals("") )
        {
            try
            {
                Klasse compiledClass = new JavaToAST().compile(clazz)
                        .get(0);
                assertTrue(klasse.equals(compiledClass));
            }
            catch ( Exception e )
            {
                fail(e);
            }
        }
        else
        {
            fail("Could not read java resource file");
        }
    }

}
