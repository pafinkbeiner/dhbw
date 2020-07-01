package abstrakteSyntax;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class Klasse{
	public String name;
	public ArrayList<Methode> methoden;
	public ArrayList<Attribut> attribute;
	public Klasse superklasse;

	public Klasse() {
		methoden = new ArrayList<>();
	}

	public void typeCheck(ArrayList<Klasse> classList) throws TypeException {

		//Add class variables to hashMap
		HashMap<String, String> hashMap = new HashMap<>();
		Scope variables = new Scope(null);

		if ( this.attribute != null )
		{
			for ( Attribut attr : attribute )
			{
				hashMap.put(attr.name, attr.type);
			}
			
			variables.variables = hashMap;
		}

		//Typecheck Methods
		for ( Methode methode : methoden )
		{
			methode.typeCheck(variables, classList);
		}
	}

	public void codeGen()
			throws IOException
	{
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

		if(superklasse == null)
		{
			cw.visit(Opcodes.V1_4, Opcodes.ACC_PUBLIC, name, null, "java/lang/Object", null);
		}
		else
		{
			cw.visit(Opcodes.V1_4, Opcodes.ACC_PUBLIC, name, null, superklasse.name, null);
		}

		for ( Methode methode : methoden )
		{
			MethodVisitor methodVisitor = cw.visitMethod(Opcodes.ACC_PUBLIC, name.equals(methode.name) ? "<init>" : methode.name,
														 methode.rueckgabetyp == null || methode.rueckgabetyp.equals(
																 "void") ? "()V" : (methode.rueckgabetyp.equals("int") ? "()I" : (methode.rueckgabetyp.equals("char") ? "()C" : (methode.rueckgabetyp.equals("boolean") ? "()Z" : "()L"+methode.rueckgabetyp))),
														 null,
														 null);

			methode.codeGen(methodVisitor);
		}

		cw.visitEnd();

		File file = new File(name + ".class");
		OutputStream os = new FileOutputStream(file);
		os.write(cw.toByteArray());
		os.close();
	}

	@Override
	public boolean equals(Object o)
	{
		if ( this == o )
		{
			return true;
		}

		Klasse klasse = (Klasse) o;
		return name.equals(klasse.name) && Objects.equals(methoden, klasse.methoden) && Objects.equals(attribute,
																									   klasse.attribute)
				&& Objects.equals(superklasse, klasse.superklasse);
	}

}
