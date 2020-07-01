package abstrakteSyntax.expression;

import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.GETFIELD;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;
import static org.objectweb.asm.Opcodes.PUTFIELD;

import java.util.ArrayList;
import java.util.HashMap;

import abstrakteSyntax.Attribut;
import abstrakteSyntax.Klasse;
import abstrakteSyntax.Scope;
import abstrakteSyntax.TypeException;

import java.util.Objects;
import org.objectweb.asm.MethodVisitor;

public class InstVar extends Expression {
	public Expression first;
	public Expression second;

	@Override
	public void typeCheck(Scope variables, ArrayList<Klasse> classList) throws TypeException {	//ONLY works if both expressions are LocalOrFieldVar!

		String name = ((LocalOrFieldVar)second).name;
		Expression receiver = first;

		if(receiver == null) throw new TypeException("Receiver is undefined in InstVar");

		receiver.typeCheck(variables, classList);

		// z.B.: A a = new A();
		//       a.attr = 5;

		//Iterate through all classes 
		for(int i = 0; i < classList.size(); i++){

			//Reveiver Type == Class Name 
			if(receiver.type.equals(classList.get(i).name)){

				//Get Attributes from Class
				ArrayList<Attribut> attributeList = classList.get(i).attribute;

				//Iterate through Attributes
				for(int y = 0; y < attributeList.size(); y++){

					//Attribute name == var name
					if(attributeList.get(y).name.equals(name)){
						//Load type
						this.type = attributeList.get(y).type;
					}
				}
			}else if(receiver instanceof This){

				//Get Highest Scope
				if(variables.GetParentScope().GetVariablesSize() < 1) throw new TypeException("Scope of local variables is empty InstVar");
				if(variables.GetParentScope().Contains(name)){
					second.type = variables.GetParentScope().Get(name);
					this.type = variables.GetParentScope().Get(name);
				}else{
					throw new TypeException("Could not find variable in scope in InstVar");
				}

				//old
				//if(variables.GetVariablesSize() < 1) throw new TypeException("Scope of local variables is empty InstVar");
				// if(variables.Contains(name)){
				// 	second.type = variables.Get(name);
				// 	this.type = variables.Get(name);
				// }else{
				// 	throw new TypeException("Could not find variable in scope in InstVar");
				// }

			}
		}
	}

	@Override
	public void codeGen(MethodVisitor methodVisitor, HashMap<String, java.lang.Integer> variablen)		//ONLY works if both expressions are LocalOrFieldVar!
	{
		String name = ((LocalOrFieldVar)second).name;
		Expression receiver = first;
		methodVisitor.visitFieldInsn(GETFIELD, receiver.type, name, this.type.equals("char") ? "C" : (this.type.equals("boolean") ? "Z" : (this.type.equals("int") ? "I" : "L"+this.type+";")));
	}

	@Override
	public void codeGenAssignLeftStart(MethodVisitor methodVisitor, HashMap<String, java.lang.Integer> variablen)	//ONLY works if both expressions are LocalOrFieldVar!
	{
		String name = ((LocalOrFieldVar)second).name;
		Expression receiver = first;
		receiver.codeGen(methodVisitor, variablen);
	}

	@Override
	public void codeGenAssignLeftEnd(MethodVisitor methodVisitor, HashMap<String, java.lang.Integer> variablen)		//ONLY works if both expressions are LocalOrFieldVar!
	{
		String name = ((LocalOrFieldVar)second).name;
		Expression receiver = first;
		methodVisitor.visitFieldInsn(PUTFIELD, receiver.type, name, this.type.equals("char") ? "C" : (this.type.equals("boolean") ? "Z" : (this.type.equals("int") ? "I" : "L"+this.type+";")));
	}

	@Override
	public boolean equals(Object o)
	{
		if ( this == o )
		{
			return true;
		}

		InstVar instVar = (InstVar) o;
		return Objects.equals(first, instVar.first) && Objects.equals(second, instVar.second) && Objects.equals(this.type, instVar.type);
	}

}
