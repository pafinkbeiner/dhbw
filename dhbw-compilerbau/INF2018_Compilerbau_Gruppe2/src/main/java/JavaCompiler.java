import abstrakteSyntax.Klasse;
import abstrakteSyntax.TypeException;
import parser.JavaParser;
import parser.converter.JavaToAST;

import javax.imageio.IIOException;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaCompiler {
    public static void main (String [] args) throws IOException, TypeException {
        // InputStream InputStream = new FileInputStream(args[0]);
        String input = "class AdvancedClass_Objects{void creation(){SimpleClass object;object = new SimpleClass();}}";
        List<Klasse> absSyntax = new JavaToAST().compile(input);
        ArrayList<Klasse> klassen = new ArrayList<>();
        for (Klasse klasse: absSyntax) {
            klassen.add(klasse);
        }
        for (Klasse klasse: absSyntax) {
            klasse.typeCheck(klassen);
            klasse.codeGen();
        }
    }
}