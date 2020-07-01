package abstrakteSyntax.expression;

import java.util.ArrayList;
import java.util.HashMap;

import abstrakteSyntax.Klasse;
import abstrakteSyntax.Scope;
import abstrakteSyntax.Types;

import java.util.Objects;
import org.objectweb.asm.MethodVisitor;

public class CompString extends Expression {
	public String string;

	public void typeCheck(Scope variables, ArrayList<Klasse> classList){
		this.type = Types.String;
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
	public boolean equals(Object o)
	{
		if ( this == o )
		{
			return true;
		}
		CompString that = (CompString) o;
		return Objects.equals(string, that.string);
	}

}
