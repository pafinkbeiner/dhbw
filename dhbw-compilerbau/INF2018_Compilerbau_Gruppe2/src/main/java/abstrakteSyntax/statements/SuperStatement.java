package abstrakteSyntax.statements;

import abstrakteSyntax.Klasse;
import abstrakteSyntax.Scope;
import abstrakteSyntax.TypeException;
import abstrakteSyntax.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class SuperStatement extends Statement {

    @Override
    public void typeCheck(Scope variables, ArrayList<Klasse> classList) throws TypeException {
        this.type = Types.Void;
    }

    @Override
    public void codeGen(MethodVisitor methodVisitor, HashMap<String, Integer> variablen)
    {
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
        methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        methodVisitor.visitInsn(Opcodes.RETURN);
    }

    @Override
    public boolean equals(Object obj) {
        SuperStatement o = (SuperStatement) obj;
        return Objects.equals(this.type, o.type) && Objects.equals(this.type, o.type);
    }
}
