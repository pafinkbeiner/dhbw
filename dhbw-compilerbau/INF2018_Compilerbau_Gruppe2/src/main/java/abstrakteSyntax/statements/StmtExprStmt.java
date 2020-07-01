package abstrakteSyntax.statements;

import abstrakteSyntax.Klasse;
import abstrakteSyntax.Scope;
import abstrakteSyntax.TypeException;
import abstrakteSyntax.stmtExpr.New;
import abstrakteSyntax.stmtExpr.StmtExpr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import org.objectweb.asm.MethodVisitor;

public class StmtExprStmt extends Statement {
	public StmtExpr stmtExpr;

	@Override
	public void typeCheck(Scope variables, ArrayList<Klasse> classList) throws TypeException {

		if(this.stmtExpr == null) throw new TypeException("Statement Expression in StmtExprStmt was undefined");

		this.stmtExpr.typeCheck(variables, classList);

		this.type = this.stmtExpr.type;
	}

	@Override
	public void codeGen(MethodVisitor methodVisitor, HashMap<String, Integer> variablen)
	{

	}

	@Override
	public boolean equals(Object o)
	{
		if ( this == o )
		{
			return true;
		}

		StmtExprStmt that = (StmtExprStmt) o;
		return Objects.equals(stmtExpr, that.stmtExpr) && Objects.equals(this.type, that.type);
	}

}
