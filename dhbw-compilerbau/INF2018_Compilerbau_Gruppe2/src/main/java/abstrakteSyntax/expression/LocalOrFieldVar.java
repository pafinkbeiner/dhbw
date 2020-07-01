package abstrakteSyntax.expression;

import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.ASTORE;
import static org.objectweb.asm.Opcodes.ILOAD;
import static org.objectweb.asm.Opcodes.ISTORE;

import abstrakteSyntax.Klasse;
import abstrakteSyntax.Scope;
import abstrakteSyntax.TypeException;
import abstrakteSyntax.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import org.objectweb.asm.MethodVisitor;

public class LocalOrFieldVar extends Expression {
	public String name;

	public void typeCheck(Scope variables, ArrayList<Klasse> classList) throws TypeException
	{
		if(variables.Contains(name)){
			this.type = variables.Get(name);
		}else{
			throw new TypeException("The Local variable could not get found in LocalorFielVar");
		}
	}

	@Override
	public void codeGen(MethodVisitor methodVisitor, HashMap<String, java.lang.Integer> variablen)
	{
		if(this.type.equals(Types.Integer) || this.type.equals(Types.Char) || this.type.equals(Types.Boolean))
		{
			methodVisitor.visitVarInsn(ILOAD, variablen.get(name));
		}
		else
		{
			methodVisitor.visitVarInsn(ALOAD, variablen.get(name));
		}
	}

	@Override
	public void codeGenAssignLeftStart(MethodVisitor methodVisitor, HashMap<String, java.lang.Integer> variablen)
	{
		if(this.type.equals(Types.Integer) || this.type.equals(Types.Char) || this.type.equals(Types.Boolean))
		{
			methodVisitor.visitVarInsn(ILOAD, variablen.get(name));
		}
		else
		{
			methodVisitor.visitVarInsn(ALOAD, variablen.get(name));
		}
	}

	@Override
	public void codeGenAssignLeftEnd(MethodVisitor methodVisitor, HashMap<String, java.lang.Integer> variablen)
	{
		if(this.type.equals(Types.Integer) || this.type.equals(Types.Char) || this.type.equals(Types.Boolean))
		{
			methodVisitor.visitVarInsn(ISTORE, variablen.get(name));
		}
		else
		{
			methodVisitor.visitVarInsn(ASTORE, variablen.get(name));
		}
	}

	@Override
	public boolean equals(Object o)
	{
		if ( this == o )
		{
			return true;
		}

		LocalOrFieldVar that = (LocalOrFieldVar) o;
		return name.equals(that.name) && Objects.equals(that.type, this.type);
	}
}
