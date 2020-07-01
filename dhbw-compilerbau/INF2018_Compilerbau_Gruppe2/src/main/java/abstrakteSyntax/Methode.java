package abstrakteSyntax;

import abstrakteSyntax.statements.Block;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import org.objectweb.asm.MethodVisitor;

public class Methode
{
    public String name;
    public ArrayList<Attribut> parameter;
    public Block body;
    public String rueckgabetyp;

    public void typeCheck(Scope variables, ArrayList<Klasse> classList) throws TypeException {

        //DEBUG
        //if(this.rueckgabetyp.equals(Types.Standard)){
        //    this.rueckgabetyp = Types.Void;
        //}

        HashMap<String, String> hashMap = new HashMap<>();
        Scope scope = new Scope(variables);

        if ( parameter != null )
        {
            for ( Attribut attr : parameter )
            {
                hashMap.put(attr.name, attr.type);
            }

            scope.variables = hashMap;
        }

        if ( this.body != null )
        {
            this.body.typeCheck(scope, classList);

            if(this.rueckgabetyp.equals(Types.Standard) && this.body.type.equals(Types.Void)){
                //Konstruktor Block has Type Block
            }else{
                if ( !this.rueckgabetyp.equals(this.body.type))
                {
                    throw new TypeException("Return value of method does not match return value of body in Methode");
                }
            }
        }
        //this.rueckgabetyp = this.body.type;
    }

    public void codeGen(MethodVisitor methodVisitor)
    {
        HashMap<String, Integer> variablen = new HashMap<>();

        for(int i = 0; i < parameter.size(); i++)
        {
            variablen.put(parameter.get(i).name, i);
        }

        methodVisitor.visitCode();

        body.codeGen(methodVisitor, variablen);

        methodVisitor.visitMaxs(0, 0);

        methodVisitor.visitEnd();
    }

    @Override
    public boolean equals(Object o)
    {
        if ( this == o )
        {
            return true;
        }

        Methode methode = (Methode) o;
        return name.equals(methode.name) && Objects.equals(parameter, methode.parameter) && Objects.equals(body,
                                                                                                           methode.body)
                && Objects.equals(rueckgabetyp, methode.rueckgabetyp);
    }

}
