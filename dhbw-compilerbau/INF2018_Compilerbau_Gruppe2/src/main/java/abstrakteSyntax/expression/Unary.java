package abstrakteSyntax.expression;

import abstrakteSyntax.Klasse;
import abstrakteSyntax.Scope;
import abstrakteSyntax.TypeException;
import abstrakteSyntax.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class Unary extends Expression {
	public String vorzeichen;
	public String postfix;
	public Expression zahl;

	public void typeCheck(Scope variables, ArrayList<Klasse> classList) throws TypeException {

		if(this.zahl == null) throw new TypeException("Expression is undefined in Unary");

		this.zahl.typeCheck(variables, classList);

		//Unary - Boolean
		if(this.zahl.type.equals(Types.Boolean)){

			if(this.vorzeichen == null || this.vorzeichen.equals(Types.Negation) || this.vorzeichen.equals(Types.Empty)){
				this.type = this.zahl.type;
			}else{
				// Exception - Boolean but wrong vorzeichen value
				throw new TypeException("Type boolean was found but wrong signature in Unary");
			}

		//Unary - Integer
		}else if(this.zahl.type.equals(Types.Integer)){

			if(this.postfix == null || this.postfix.equals(Types.Inkrement) || this.postfix.equals(Types.Dekrement)){
				this.type = this.zahl.type;
			}else{
				if(this.vorzeichen.equals(Types.Addtition) || this.vorzeichen.equals(Types.Subtraction)){
					this.type = this.zahl.type;
				}else{
					// Exception - Integer but wrong vorzeichen or postfix value
					throw new TypeException("Type integer was found but wrong signature in Unary");
				}
			}

		}else if(this.zahl.type.equals(Types.Char)){

			this.type = this.zahl.type;

		}else{
			 new TypeException("No type was found in Unary");
		}
	}

	@Override
	public void codeGen(MethodVisitor methodVisitor, HashMap<String, java.lang.Integer> variablen)
	{
		zahl.codeGen(methodVisitor, variablen);

		if(vorzeichen != null && vorzeichen.equals("-"))
		{
			methodVisitor.visitInsn(Opcodes.INEG);
		}
		else if(vorzeichen != null && vorzeichen.equals("!"))
		{
			Label l0 = new Label();
			Label l1 = new Label();

			methodVisitor.visitJumpInsn(Opcodes.IFNE, l0);
			methodVisitor.visitInsn(Opcodes.ICONST_1);
			methodVisitor.visitJumpInsn(Opcodes.GOTO, l1);
			methodVisitor.visitLabel(l0);
			methodVisitor.visitInsn(Opcodes.ICONST_0);
			methodVisitor.visitJumpInsn(Opcodes.GOTO, l1);
			methodVisitor.visitLabel(l1);
		}
		else if(postfix != null && postfix.equals("++"))
		{
			methodVisitor.visitIincInsn(variablen.get(((LocalOrFieldVar) zahl).name), 1);
		}
		else if(postfix != null && postfix.equals("--"))
		{
			methodVisitor.visitIincInsn(variablen.get(((LocalOrFieldVar) zahl).name), -1);
		}
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
	public boolean equals(Object o)
	{
		if ( this == o )
		{
			return true;
		}

		Unary unary = (Unary) o;
		return Objects.equals(vorzeichen, unary.vorzeichen) && Objects.equals(postfix, unary.postfix) && zahl.equals(
				unary.zahl) && Objects.equals(this.type, unary.type);
	}

}
