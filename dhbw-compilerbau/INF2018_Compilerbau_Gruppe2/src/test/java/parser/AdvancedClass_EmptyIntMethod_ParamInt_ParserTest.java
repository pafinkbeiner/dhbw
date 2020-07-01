/*
 *
 *  * (c) 2015 - 2020 ENisco GmbH & Co. KG
 *
 */

package parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import abstrakteSyntax.Attribut;
import abstrakteSyntax.Klasse;
import abstrakteSyntax.Methode;
import abstrakteSyntax.Types;
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
public class AdvancedClass_EmptyIntMethod_ParamInt_ParserTest
{

    StringsOfClasses helper;
    Klasse klasse;

    @BeforeAll
    public void setUp()
    {
        helper = new StringsOfClasses();
        ParserObjects object = new ParserObjects();
        klasse = object.advancedClass_EmptyIntMethod_ParamInt();
    }

    /**
     * class AdvancedClass_EmptyIntMethod_ParamInt
     * {
     *     int method(int i){
     *         return i;
     *     }
     * }
     */
    @Test
    public void ParserTest()
    {

        final String clazz = helper.readJavaClass("/AdvancedClass_EmptyIntMethod_ParamInt.java");

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
