package typecheck;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.MockitoAnnotations.initMocks;

import abstrakteSyntax.Attribut;
import abstrakteSyntax.Klasse;
import abstrakteSyntax.Methode;
import abstrakteSyntax.Types;
import abstrakteSyntax.expression.BinaryInt;
import abstrakteSyntax.expression.Bool;
import abstrakteSyntax.expression.Integer;
import abstrakteSyntax.expression.LocalOrFieldVar;
import abstrakteSyntax.expression.Unary;
import abstrakteSyntax.statements.Block;
import abstrakteSyntax.statements.Statement;
import abstrakteSyntax.statements.StmtExprStmt;
import abstrakteSyntax.statements.SuperStatement;
import abstrakteSyntax.stmtExpr.Assign;
import helper.ParserObjects;
import helper.TypecheckObjects;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import parser.AdvancedClass_VoidMethod_Bool_ParserTest;

@TestInstance(Lifecycle.PER_CLASS)
public class AdvancedClass_VoidMethod_Bool_TypecheckTest
{
   private Klasse clazz;
   private Klasse klasse;

    @BeforeAll
    public void setUp()
    {
        ParserObjects helper = new ParserObjects();
        clazz = helper.advancedClass_VoidMethod_Bool();
        TypecheckObjects object = new TypecheckObjects();
        klasse = object.advancedClass_VoidMethod_Bool();
    }

    /**
     * class AdvancedClass_VoidMethod_Bool{ boolean b; void method(int i, boolean d){ i = i+1; d = !false; } }
     */
    @Test
    public void TypecheckTest(){
        try
        {
            //class list
            ArrayList<Klasse> klassen = new ArrayList<>();
            klassen.add(clazz);

            clazz.typeCheck(klassen);
            assertTrue(klasse.equals(clazz));
        }
        catch ( Exception e )
        {
            fail(e);
        }
    }
}
