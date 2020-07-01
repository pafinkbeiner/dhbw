package abstrakteSyntax.expression;

import java.util.ArrayList;
import java.util.HashMap;

import abstrakteSyntax.Klasse;
import abstrakteSyntax.Scope;
import abstrakteSyntax.TypeException;

import org.objectweb.asm.MethodVisitor;

public abstract class Expression {
	public String type;

	public abstract void typeCheck(Scope variables, ArrayList<Klasse> classList) throws TypeException;
	public abstract void codeGen(MethodVisitor methodVisitor, HashMap<String, java.lang.Integer> variablen);
	public abstract void codeGenAssignLeftStart(MethodVisitor methodVisitor, HashMap<String, java.lang.Integer> variablen);
	public abstract void codeGenAssignLeftEnd(MethodVisitor methodVisitor, HashMap<String, java.lang.Integer> variablen);
}
