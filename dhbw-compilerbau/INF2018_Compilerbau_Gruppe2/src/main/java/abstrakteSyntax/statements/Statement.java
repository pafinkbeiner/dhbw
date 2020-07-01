package abstrakteSyntax.statements;

import java.util.ArrayList;
import java.util.HashMap;

import abstrakteSyntax.Klasse;
import abstrakteSyntax.Scope;
import abstrakteSyntax.TypeException;
import abstrakteSyntax.expression.Expression;
import org.objectweb.asm.MethodVisitor;

public abstract class Statement {
	public String type;

	public abstract void typeCheck(Scope variables, ArrayList<Klasse> classList) throws TypeException;
	public abstract void codeGen(MethodVisitor methodVisitor, HashMap<String, Integer> variablen);
}
