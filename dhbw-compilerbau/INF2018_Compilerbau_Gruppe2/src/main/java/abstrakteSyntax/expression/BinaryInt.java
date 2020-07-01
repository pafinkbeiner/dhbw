package abstrakteSyntax.expression;

import java.util.ArrayList;
import java.util.HashMap;

import abstrakteSyntax.Klasse;
import abstrakteSyntax.Scope;
import abstrakteSyntax.TypeException;
import abstrakteSyntax.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class BinaryInt extends Expression {
	public Expression zahl1;
	public Expression zahl2;
	public String rechenzeichen;

	public void typeCheck(Scope variables, ArrayList<Klasse> classList) throws TypeException {

		if(this.zahl1 == null || this.zahl2 == null || this.rechenzeichen == null) throw new TypeException("Expression is undefined in Binary");

		this.zahl1.typeCheck(variables, classList);
		this.zahl2.typeCheck(variables, classList);

		//Nach VL
		if(this.zahl1.type.equals(Types.Integer) && this.zahl2.type.equals(Types.Integer)){
			if(rechenzeichen.equals(Types.Addtition) || rechenzeichen.equals(Types.Division)
			|| rechenzeichen.equals(Types.Multiplication) || rechenzeichen.equals(Types.Subtraction)
			|| rechenzeichen.equals(Types.Modulo)){
				this.type = Types.Integer;
			}else{
                throw new TypeException("Arithmetic character in BinaryInt was wrongly assigned");
			}
		}else{
            throw new TypeException("Expression types invalid in BinaryInt");
		}
	}

	@Override
	public void codeGen(MethodVisitor methodVisitor, HashMap<String, java.lang.Integer> variablen) {
		zahl1.codeGen(methodVisitor, variablen);
		zahl2.codeGen(methodVisitor, variablen);

		if (rechenzeichen.equals("+")) {
			methodVisitor.visitInsn(Opcodes.IADD);
		}

		if (rechenzeichen.equals("-")) {
			methodVisitor.visitInsn(Opcodes.ISUB);
		}

		if (rechenzeichen.equals("*")) {
			methodVisitor.visitInsn(Opcodes.IMUL);
		}

		if (rechenzeichen.equals("/")) {
			methodVisitor.visitInsn(Opcodes.IDIV);
		}

		if (rechenzeichen.equals("%")) {
			methodVisitor.visitInsn(Opcodes.IREM);
		}
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

		BinaryInt binaryInt = (BinaryInt) o;
		return Objects.equals(zahl1, binaryInt.zahl1) && Objects.equals(zahl2, binaryInt.zahl2) && Objects.equals(
				rechenzeichen,
				binaryInt.rechenzeichen) && Objects.equals(this.type, binaryInt.type);
	}

}
