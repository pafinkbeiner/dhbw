package abstrakteSyntax.stmtExpr;

import abstrakteSyntax.Klasse;
import abstrakteSyntax.Scope;
import abstrakteSyntax.TypeException;
import abstrakteSyntax.Types;
import abstrakteSyntax.expression.Expression;
import abstrakteSyntax.expression.Integer;
import abstrakteSyntax.expression.LocalOrFieldVar;

import java.util.ArrayList;
import java.util.HashMap;
import org.objectweb.asm.MethodVisitor;

public class Assign extends StmtExpr {
	public Expression ziel;
	public Expression wert;

	@Override
	public void typeCheck(Scope variables, ArrayList<Klasse> classList) throws TypeException {

		if(this.ziel == null || this.wert == null) throw new TypeException("Expression in Assign was undefined");

		this.wert.typeCheck(variables, classList);
		this.ziel.typeCheck(variables, classList);

		if (this.wert.type.equals(this.ziel.type)) {
			this.type = Types.Void;
		}else{
			throw new TypeException("Type of Expressions do not match in Assign");
		}
	}

	@Override
	public void codeGen(MethodVisitor methodVisitor, HashMap<String, java.lang.Integer> variablen)
	{
		ziel.codeGenAssignLeftStart(methodVisitor, variablen);
		wert.codeGen(methodVisitor, variablen);
		ziel.codeGenAssignLeftEnd(methodVisitor, variablen);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		Assign assign = (Assign) o;
		return ziel.equals(assign.ziel) && wert.equals(assign.wert);
	}

}
