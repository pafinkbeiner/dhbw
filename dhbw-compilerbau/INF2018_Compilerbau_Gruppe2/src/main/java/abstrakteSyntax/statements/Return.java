package abstrakteSyntax.statements;

import static org.objectweb.asm.Opcodes.RETURN;

import abstrakteSyntax.Klasse;
import abstrakteSyntax.Scope;
import abstrakteSyntax.TypeException;
import abstrakteSyntax.expression.Expression;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import org.objectweb.asm.MethodVisitor;

public class Return extends Statement {
	public Expression expression;

	@Override
	public void typeCheck(Scope variables, ArrayList<Klasse> classList) throws TypeException {

		if(this.expression == null) throw new TypeException("Return expression was undefined");

		this.expression.typeCheck(variables, classList);
		this.type = this.expression.type;
	}

	@Override
	public void codeGen(MethodVisitor methodVisitor, HashMap<String, Integer> variablen)
	{
		methodVisitor.visitInsn(RETURN);
	}

	@Override
	public boolean equals(Object o)
	{
		if ( this == o )
		{
			return true;
		}

		Return aReturn = (Return) o;
		return expression.equals(aReturn.expression) && Objects.equals(this.type, aReturn.type);
	}

}
