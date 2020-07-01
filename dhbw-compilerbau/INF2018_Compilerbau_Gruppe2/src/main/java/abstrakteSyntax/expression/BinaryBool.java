package abstrakteSyntax.expression;

import abstrakteSyntax.Klasse;
import abstrakteSyntax.Scope;
import abstrakteSyntax.TypeException;
import abstrakteSyntax.Types;

import java.util.Objects;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

import java.util.ArrayList;
import java.util.HashMap;
import org.objectweb.asm.Opcodes;

public class BinaryBool extends Expression {
    public Expression zahl1;
    public Expression zahl2;
    public String rechenzeichen;

    @Override
    public void typeCheck(Scope variables, ArrayList<Klasse> classList) throws TypeException {

        if (this.zahl1 == null || this.zahl2 == null || this.rechenzeichen == null)
            throw new TypeException("Expression is undefined in Binary");

        this.zahl1.typeCheck(variables, classList);
        this.zahl2.typeCheck(variables, classList);

        // Nach VL
        if (this.zahl1.type.equals(Types.Boolean) && this.zahl2.type.equals(Types.Boolean)) {
            if (this.rechenzeichen.equals(Types.and) || this.rechenzeichen.equals(Types.or) || this.rechenzeichen.equals(Types.equal) || this.rechenzeichen.equals(Types.notEqual) ) {
                this.type = Types.Boolean;
            } else {
                throw new TypeException("Arithmetic character in BinaryBool was wrongly assigned");
            }
        } else {
            if (this.zahl1.type.equals(Types.Integer) && this.zahl2.type.equals(Types.Integer)) {
                if (this.rechenzeichen.equals(Types.gt) || this.rechenzeichen.equals(Types.goe)
                        || this.rechenzeichen.equals(Types.st) || this.rechenzeichen.equals(Types.soe)
                        || this.rechenzeichen.equals(Types.equal) || this.rechenzeichen.equals(Types.notEqual)){
                    this.type = Types.Boolean;
                } else {
                    throw new TypeException("Arithmetic character in BinaryBool was wrongly assigned");
                }
            } else {
                if(this.zahl1.type.equals(Types.Char) && this.zahl2.type.equals(Types.Char)){
                    if(this.rechenzeichen.equals(Types.equal) || this.rechenzeichen.equals(Types.notEqual)){
                        this.type = Types.Boolean;
                    }else{
                        throw new TypeException("Arithmetic character in BinaryBool was wrongly assigned");
                    }
                }else{
                    throw new TypeException("Expression types invalid in BinaryBool");
                }
            }
        }
    }

    @Override
    public void codeGen(MethodVisitor methodVisitor, HashMap<String, java.lang.Integer> variablen) {

        if(!(rechenzeichen.equals("&&") || rechenzeichen.equals("||")))
        {
            zahl1.codeGen(methodVisitor, variablen);
            zahl2.codeGen(methodVisitor, variablen);
        }

        if (rechenzeichen.equals("&&")) {

            Label l0 = new Label();
            Label l1 = new Label();

            zahl1.codeGen(methodVisitor, variablen);
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, l0);
            zahl2.codeGen(methodVisitor, variablen);
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, l0);
            methodVisitor.visitInsn(Opcodes.ICONST_1);
            methodVisitor.visitJumpInsn(Opcodes.GOTO, l1);
            methodVisitor.visitLabel(l0);
            methodVisitor.visitInsn(Opcodes.ICONST_0);
            methodVisitor.visitJumpInsn(Opcodes.GOTO, l1);
            methodVisitor.visitLabel(l1);
        }
        else if (rechenzeichen.equals("||")) {

            Label l0 = new Label();
            Label l1 = new Label();

            zahl1.codeGen(methodVisitor, variablen);
            methodVisitor.visitJumpInsn(Opcodes.IFNE, l0);
            zahl2.codeGen(methodVisitor, variablen);
            methodVisitor.visitJumpInsn(Opcodes.IFNE, l0);
            methodVisitor.visitInsn(Opcodes.ICONST_0);
            methodVisitor.visitJumpInsn(Opcodes.GOTO, l1);
            methodVisitor.visitLabel(l0);
            methodVisitor.visitInsn(Opcodes.ICONST_1);
            methodVisitor.visitJumpInsn(Opcodes.GOTO, l1);
            methodVisitor.visitLabel(l1);
        }
        else if (rechenzeichen.equals("<")) {
            compOperation(methodVisitor, Opcodes.IF_ICMPGE);
        }
        else if (rechenzeichen.equals(">")) {
            compOperation(methodVisitor, Opcodes.IF_ICMPLE);
        }
        else if (rechenzeichen.equals(">=")) {
            compOperation(methodVisitor, Opcodes.IF_ICMPLT);
        }
        else if (rechenzeichen.equals("<=")) {
            compOperation(methodVisitor, Opcodes.IF_ICMPGT);
        }
        else if (rechenzeichen.equals("!=")) {
            compOperation(methodVisitor, Opcodes.IF_ICMPEQ);
        }
        else if (rechenzeichen.equals("==")) {
            compOperation(methodVisitor, Opcodes.IF_ICMPNE);
        }
    }

    @Override
    public void codeGenAssignLeftStart(MethodVisitor methodVisitor, HashMap<String, java.lang.Integer> variablen) {

    }

    @Override
    public void codeGenAssignLeftEnd(MethodVisitor methodVisitor, HashMap<String, java.lang.Integer> variablen) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        BinaryBool that = (BinaryBool) o;
        return Objects.equals(zahl1, that.zahl1) && Objects.equals(zahl2, that.zahl2)
                && Objects.equals(rechenzeichen, that.rechenzeichen) && Objects.equals(that.type, this.type);
    }

    private void compOperation(MethodVisitor methodVisitor, int opcode)
    {
        Label l0 = new Label();
        Label l1 = new Label();

        methodVisitor.visitJumpInsn(opcode, l0);
        methodVisitor.visitInsn(Opcodes.ICONST_1);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, l1);
        methodVisitor.visitLabel(l0);
        methodVisitor.visitInsn(Opcodes.ICONST_0);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, l1);
        methodVisitor.visitLabel(l1);
    }
}
