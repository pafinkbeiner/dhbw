package abstrakteSyntax.expression;

import java.util.ArrayList;
import java.util.HashMap;

import abstrakteSyntax.Klasse;
import abstrakteSyntax.Scope;
import abstrakteSyntax.Types;

import java.util.Objects;
import org.objectweb.asm.MethodVisitor;

public class Super extends Expression {

    public void typeCheck(Scope variables, ArrayList<Klasse> classList){
        this.type = Types.Super;
    }

    @Override
    public void codeGen(MethodVisitor methodVisitor, HashMap<String, java.lang.Integer> variablen)
    {

    }

    @Override
    public void codeGenAssignLeftStart(MethodVisitor methodVisitor, HashMap<String, java.lang.Integer> variablen)
    {

    }

    @Override
    public void codeGenAssignLeftEnd(MethodVisitor methodVisitor, HashMap<String, java.lang.Integer> variablen)
    {

    }

    @Override
    public boolean equals(Object obj)
    {
        Super o = (Super) obj;
        return Objects.equals(o.type, this.type);
    }
}
