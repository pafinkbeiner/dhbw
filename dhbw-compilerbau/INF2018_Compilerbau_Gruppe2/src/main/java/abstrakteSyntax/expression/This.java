package abstrakteSyntax.expression;

import abstrakteSyntax.Klasse;
import abstrakteSyntax.Scope;
import abstrakteSyntax.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import org.objectweb.asm.MethodVisitor;

public class This extends Expression {

    public void typeCheck(Scope variables, ArrayList<Klasse> classList){
        this.type = Types.Void;
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
        This o = (This) obj;
        return Objects.equals(o.type, this.type) && Objects.equals(o.type, this.type);
    }
}
