package abstrakteSyntax.stmtExpr;

import static org.objectweb.asm.Opcodes.DUP;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.NEW;

import java.util.ArrayList;
import java.util.HashMap;

import abstrakteSyntax.Klasse;
import abstrakteSyntax.Scope;
import abstrakteSyntax.TypeException;
import abstrakteSyntax.Types;
import abstrakteSyntax.expression.Expression;
import abstrakteSyntax.expression.StmtExprExpr;
import abstrakteSyntax.statements.StmtExprStmt;

import java.util.Objects;
import org.objectweb.asm.MethodVisitor;

public class New extends StmtExpr {
    public ArrayList<Expression> expressions;
    public String className;

    public New(){
        expressions = new ArrayList<>();
    }

    @Override
    public void typeCheck(Scope variables, ArrayList<Klasse> classList) throws TypeException {

        if(this.expressions == null) throw new TypeException("Expression in new was undefined");

        for(Expression expr: expressions){
            expr.typeCheck(variables, classList);
        }

        this.type = Types.Void;
        //this.type = className;
    }

    @Override
    public void codeGen(MethodVisitor methodVisitor, HashMap<String, java.lang.Integer> variablen)
    {
        String parameterString = "";

        methodVisitor.visitTypeInsn(NEW, className);
        methodVisitor.visitInsn(DUP);

        for(Expression parameter : expressions)
        {
            parameter.codeGen(methodVisitor, variablen);
            parameterString += (parameter.type.equals("int") ? "I" : (parameter.type.equals("boolean") ? "Z" : (parameter.type.equals("char") ? "C" : "L"+parameter.type+";")));
        }

        methodVisitor.visitMethodInsn(INVOKESPECIAL, className, "", "("+parameterString+")V", false);
    }

    @Override
    public boolean equals(Object o)
    {
        if ( this == o )
        {
            return true;
        }

        New aNew = (New) o;
        return Objects.equals(expressions, aNew.expressions) && Objects.equals(className, aNew.className);
    }

}
