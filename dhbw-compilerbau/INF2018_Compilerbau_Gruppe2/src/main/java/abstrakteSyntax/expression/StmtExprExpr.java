package abstrakteSyntax.expression;

import abstrakteSyntax.Klasse;
import abstrakteSyntax.Scope;
import abstrakteSyntax.TypeException;
import abstrakteSyntax.Types;
import abstrakteSyntax.stmtExpr.New;
import abstrakteSyntax.stmtExpr.StmtExpr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import org.objectweb.asm.MethodVisitor;

public class StmtExprExpr extends Expression {
	public StmtExpr stmtExpr;

	@Override
	public void typeCheck(Scope variables, ArrayList<Klasse> classList) throws TypeException {

		if(this.stmtExpr == null) throw new TypeException("StmtExpr is undefined in StmtExprExpr");

		this.stmtExpr.typeCheck(variables, classList);

		//DEBUG
		if(this.stmtExpr instanceof New){
			stmtExpr.type = ((New)stmtExpr).className;
		}

		this.type = this.stmtExpr.type;

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

		StmtExprExpr that = (StmtExprExpr) o;
		return Objects.equals(stmtExpr, that.stmtExpr) && Objects.equals(this.type, that.type);
	}

}
