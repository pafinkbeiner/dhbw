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

public class If extends Statement {
	public Expression expression;
	public Statement statement;
	public Statement maybeStatement;

	@Override
	public void typeCheck(Scope variables, ArrayList<Klasse> classList) throws TypeException {

		if(this.expression == null || this.statement == null) throw new TypeException("Statement or Expression in If condition was undefined");

		//Check Types for each element 
		this.expression.typeCheck(variables, classList);
		this.statement.typeCheck(variables, classList);

		if(this.maybeStatement != null){
			this.maybeStatement.typeCheck(variables, classList);
		}

		if(this.expression.type.equals(Types.Boolean)){
			if(this.maybeStatement != null){
				if(this.statement.type.equals(this.maybeStatement.type)){
					this.type = this.statement.type;
					// or this.type = this.maybeStatement.type;
				}else{
					throw new TypeException("Types do not equal in if condition");
				}
			}else{
				//Nur If kein Else
				this.type = this.statement.type;
			}
		}else{
			throw new TypeException("Type of expression doesn´t equal boolean");
		}
	}

	@Override
	public void codeGen(MethodVisitor methodVisitor, HashMap<String, Integer> variablen)
	{
		Label l0 = new Label();
		Label end = new Label();

		expression.codeGen(methodVisitor, variablen);
		methodVisitor.visitJumpInsn(Opcodes.IFEQ, l0);
		statement.codeGen(methodVisitor, variablen);
		methodVisitor.visitJumpInsn(Opcodes.GOTO, end);
		methodVisitor.visitLabel(l0);
		if(maybeStatement != null)
		{
			maybeStatement.codeGen(methodVisitor, variablen);
		}
		methodVisitor.visitJumpInsn(Opcodes.GOTO, end);
		methodVisitor.visitLabel(end);
	}

	@Override
	public boolean equals(Object o)
	{
		if ( this == o )
		{
			return true;
		}
		If anIf = (If) o;
		return Objects.equals(expression, anIf.expression) && Objects.equals(statement, anIf.statement)
				&& Objects.equals(maybeStatement, anIf.maybeStatement) && Objects.equals(this.type, anIf.type);
	}

}
