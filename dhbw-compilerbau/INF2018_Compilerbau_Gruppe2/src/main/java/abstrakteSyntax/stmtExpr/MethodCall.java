package abstrakteSyntax.stmtExpr;

import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;

import java.util.ArrayList;
import java.util.HashMap;

import abstrakteSyntax.Attribut;
import abstrakteSyntax.Klasse;
import abstrakteSyntax.Methode;
import abstrakteSyntax.Scope;
import abstrakteSyntax.TypeException;
import abstrakteSyntax.Types;
import abstrakteSyntax.expression.Expression;
import java.util.Objects;
import org.objectweb.asm.MethodVisitor;

public class MethodCall extends StmtExpr {
	public Expression expression;
	public String methode;
	public ArrayList<Expression> parameter;

	@Override
	public void typeCheck(Scope variables, ArrayList<Klasse> classList) throws TypeException {

		if (this.methode.equals(""))
			throw new TypeException("Method name in Methode call was undefined");

		// A a = new A();
		// int b = a.meth(true)

		// a->expression
		// meth->methode
		// true->parameter

		// Typecheck Class
		if(this.expression != null)
		this.expression.typeCheck(variables, classList);

		if (this.parameter.size() > 0) {
			// Typecheck Params
			for (Expression expr : parameter) {
				expr.typeCheck(variables, classList);
			}
		}

		if(this.expression != null){
			// Iterate through classes
			for (Klasse cls : classList) {
				if (this.expression.type.equals(cls.name)) {
					// Check if Method is in the class
					for (Methode meth : cls.methoden) {
						if (this.methode.equals(meth.name)) {
							//Check overload of functions
							if(meth.parameter.size() == this.parameter.size()){
								if(meth.parameter.size() == 0){
									//if there are no params to compare
									this.type = meth.rueckgabetyp;
								}else{
									boolean flag = false;
									test: for(int i = 0; i < meth.parameter.size(); i++){
										if(meth.parameter.get(i).type.equals(this.parameter.get(i).type)){
											flag = true;
										}else{
											flag = false;
											//Exit directly after wrong signature was detected, 
											//so the flag cant get overwritten
											break test;
										}
									}
									//Methode with correct signature could get found
									if(flag == true){
										this.type = meth.rueckgabetyp;
									//Methode with correct signature could not get found
									}else{
										throw new TypeException("Method with correct signature could not get found!");
									}
								}
							}
						} else {
							// In der Klasse der Expression wurde keine entsprechende Methode gefunden
							throw new TypeException("No method was found in MethodeCall");
						}
					}
				}
			}
		}else{
			for(Klasse cls: classList){
				for(Methode meth: cls.methoden){
					if(meth.name.equals(methode)){
						this.type = meth.rueckgabetyp;
						return;
					}
				}
			}
		}


		if (this.type.equals(Types.Empty))
			throw new TypeException("Type could not get found in MethodeCall");
	}

	@Override
	public void codeGen(MethodVisitor methodVisitor, HashMap<String, java.lang.Integer> variablen) {
		String parameterString = "";

		for (Expression parameters : this.parameter) {
			parameters.codeGen(methodVisitor, variablen);
			parameterString += (parameters.type.equals("int") ? "I"
					: (parameters.type.equals("boolean") ? "Z"
							: (parameters.type.equals("char") ? "C" : "L" + parameters.type + ";")));
		}

		methodVisitor
				.visitMethodInsn(INVOKEVIRTUAL, expression.type, methode,
						this.type
								.equals("void")
										? "(" + parameterString + ")V"
										: (this.type.equals("char") ? "(" + parameterString + ")C"
												: (this.type.equals("boolean") ? "(" + parameterString + ")Z"
														: (this.type.equals("int") ? "(" + parameterString + ")I"
																: "(" + parameterString + ")L" + this.type + ";"))),
						false);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		MethodCall that = (MethodCall) o;
		return Objects.equals(expression, that.expression) && Objects.equals(methode, that.methode)
				&& Objects.equals(parameter, that.parameter);
	}

}
