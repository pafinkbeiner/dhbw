package abstrakteSyntax.statements;

import abstrakteSyntax.Attribut;
import abstrakteSyntax.Klasse;
import abstrakteSyntax.Scope;
import abstrakteSyntax.TypeException;
import abstrakteSyntax.Types;
import abstrakteSyntax.expression.Expression;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import org.objectweb.asm.MethodVisitor;

public class For extends Statement {
    public Attribut attribut;
    public Expression expression;
    public ArrayList<Statement> statementArray;

    public For() {
        statementArray = new ArrayList<>();
    }

    @Override
    public void codeGen(MethodVisitor methodVisitor, HashMap<String, Integer> variablen) {
    }

    @Override
    public void typeCheck(Scope variables, ArrayList<Klasse> classList)
            throws TypeException
    {

        if ( this.attribut == null || this.expression == null || this.statementArray.size() < 1 )
        {
            throw new TypeException("Ressources in For were undefined");
        }

        for ( Statement statement : statementArray )
        {
            statement.typeCheck(variables, classList);
        }

        //Valued correct type
        this.type = Types.Void;

    }

    @Override
    public boolean equals(Object o)
    {
        if ( this == o )
        {
            return true;
        }

        For aFor = (For) o;
        return Objects.equals(attribut, aFor.attribut) && Objects.equals(expression, aFor.expression) && Objects.equals(
                statementArray,
                aFor.statementArray) && Objects.equals(this.type, aFor.type);
    }

}
