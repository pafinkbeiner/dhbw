package abstrakteSyntax.statements;

import abstrakteSyntax.Klasse;
import abstrakteSyntax.Scope;
import abstrakteSyntax.TypeException;
import abstrakteSyntax.Types;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import org.objectweb.asm.MethodVisitor;

public class Block extends Statement {

	public ArrayList<Statement> block;

	@Override
	public void typeCheck(Scope variables, ArrayList<Klasse> classList) throws TypeException {

		//if(block.size() < 1) throw new TypeException("Statements in block are undefined");
		if(block.size() < 1) {
			this.type = Types.Void;
			return;
		};

		for (Statement stmt : block) {
			stmt.typeCheck(variables, classList);
		}

		// Regel - Block Init
		if (block.size() == 1) {
			this.type = this.block.get(0).type;
		} else {

			// Regel - Block Void
			if (this.block.get(0).type == Types.Void) {

				if (!this.getTypeFromBlock(variables, classList).equals("")) {

					this.type = this.getTypeFromBlock(variables, classList);

				} else {
					throw new TypeException("Block Statements do not contain same return value in Block");
				}
			} else {

				if(this.getTypeFromBlock(variables, classList) != "")
				// Regel Block (// Regel Block LocalVarDecl)
				if (this.block.get(0).type.equals(this.getTypeFromBlock(variables, classList))) {
					this.type = this.block.get(0).type;
				} else {
					throw new TypeException("Block Type could not get evaluated in Block");
				}
			}
		}
	}

	public String getTypeFromBlock(Scope variables, ArrayList<Klasse> classList) throws TypeException {

		Block block1 = new Block();
		block1.block = new ArrayList<Statement>();
		//block1.block.addAll(this.block);
		for (Statement statement : this.block) {
			block1.block.add(statement);
		}

		block1.block.remove(0);
	
		block1.typeCheck(variables, classList);

		Scope localVariables = new Scope(variables);

		if(block.get(0) instanceof LocalVarDecl){
			localVariables.Add(((LocalVarDecl)block.get(0)).name, ((LocalVarDecl)block.get(0)).type);
		}


		//Check and Compare Types
		if (block1.block.size() == 1) {
			return block1.block.get(0).type;
		} else {
			if (block1.type.equals(block1.getTypeFromBlock(variables, classList))) {
				return block1.getTypeFromBlock(variables, classList);
			} else {
				return "";
			}
		}
	}

	@Override
	public void codeGen(MethodVisitor methodVisitor, HashMap<String, Integer> variablen)
	{
		for ( Statement statement : block )
		{
			statement.codeGen(methodVisitor, variablen);
		}
	}

	@Override
	public boolean equals(Object o)
	{
		if ( this == o )
		{
			return true;
		}

		Block block1 = (Block) o;
		return block.equals(block1.block) && Objects.equals(this.type, block1.type);
	}
}
