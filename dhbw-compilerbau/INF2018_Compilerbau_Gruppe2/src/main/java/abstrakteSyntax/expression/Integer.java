package abstrakteSyntax.expression;

import abstrakteSyntax.Klasse;
import abstrakteSyntax.Scope;
import abstrakteSyntax.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class Integer extends Expression {
	public int integer;

	public void typeCheck(Scope variables, ArrayList<Klasse> classList){
		this.type = Types.Integer;
	}

	@Override
	public void codeGen(MethodVisitor methodVisitor, HashMap<String, java.lang.Integer> variablen)
	{
		methodVisitor.visitIntInsn(Opcodes.BIPUSH, integer);
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

		Integer integer1 = (Integer) o;
		return integer == integer1.integer && Objects.equals(this.type, integer1.type);
	}

}
