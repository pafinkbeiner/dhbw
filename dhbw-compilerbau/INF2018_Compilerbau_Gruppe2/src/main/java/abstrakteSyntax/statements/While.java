package abstrakteSyntax.statements;

import abstrakteSyntax.Klasse;
import abstrakteSyntax.Scope;
import abstrakteSyntax.TypeException;
import abstrakteSyntax.Types;
import abstrakteSyntax.expression.Expression;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class While extends Statement {
	public Expression expression;
	public Statement statement;

	@Override
	public void typeCheck(Scope variables, ArrayList<Klasse> classList) throws TypeException {

		if(this.expression == null || this.statement == null) throw new TypeException("Statement or Expression in While was undefined");

		this.expression.typeCheck(variables, classList);
		this.statement.typeCheck(variables, classList);
		if(this.expression.type.equals(Types.Boolean)){
			if(this.statement instanceof Block){
				this.type = this.statement.type;
			}else{
				throw new TypeException("Statement in While does not equal Block");
			}
		}else{
			throw new TypeException("Expression in while doesn´t contain a boolean");
		}
	}

	@Override
	public void codeGen(MethodVisitor methodVisitor, HashMap<String, Integer> variablen)
	{
		Label l0 = new Label();
		Label end = new Label();

		methodVisitor.visitJumpInsn(Opcodes.GOTO, l0);
		methodVisitor.visitLabel(l0);
		expression.codeGen(methodVisitor, variablen);
		methodVisitor.visitJumpInsn(Opcodes.IFEQ, end);
		statement.codeGen(methodVisitor, variablen);
		methodVisitor.visitJumpInsn(Opcodes.GOTO, l0);
		methodVisitor.visitLabel(end);
	}

	@Override
	public boolean equals(Object o)
	{
		if ( this == o )
		{
			return true;
		}

		While aWhile = (While) o;
		return Objects.equals(expression, aWhile.expression) && Objects.equals(statement, aWhile.statement)
				&& Objects.equals(this.type, aWhile.type);
	}

}
