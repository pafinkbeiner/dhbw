package abstrakteSyntax.statements;

import abstrakteSyntax.Klasse;
import abstrakteSyntax.Scope;
import abstrakteSyntax.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import org.objectweb.asm.MethodVisitor;

public class LocalVarDecl extends Statement {
	public String name;

	@Override
	public void typeCheck(Scope variables, ArrayList<Klasse> classList)
	{
		//Add local/field variable to scope of current class
		variables.Add(this.name, this.type);
		this.type = Types.Void;
	}

	@Override
	public void codeGen(MethodVisitor methodVisitor, HashMap<String, Integer> variablen)
	{
		int varSize = variablen.size();
		variablen.put(name, varSize);
	}

	@Override
	public boolean equals(Object o)
	{
		if ( this == o )
		{
			return true;
		}

		LocalVarDecl that = (LocalVarDecl) o;
		return Objects.equals(name, that.name) && Objects.equals(this.type, that.type);
	}

}
