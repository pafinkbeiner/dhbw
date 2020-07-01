package abstrakteSyntax.expression;

import java.util.ArrayList;
import java.util.HashMap;

import abstrakteSyntax.Klasse;
import abstrakteSyntax.Scope;
import abstrakteSyntax.Types;

import java.util.Objects;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class Bool extends Expression {
	public boolean bool;

	public void typeCheck(Scope variables, ArrayList<Klasse> classList){
		this.type = Types.Boolean;
	}

	@Override
	public void codeGen(MethodVisitor methodVisitor, HashMap<String, java.lang.Integer> variablen)
	{
		if(bool)
		{
			methodVisitor.visitInsn(Opcodes.ICONST_1);
		}
		else
		{
			methodVisitor.visitInsn(Opcodes.ICONST_0);
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

		Bool bool1 = (Bool) o;
		return bool == bool1.bool && Objects.equals(this.type, bool1.type);
	}
}
