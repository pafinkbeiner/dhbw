package parser.converter;

import org.antlr.v4.runtime.*;
import parser.JavaLexer;
import parser.JavaParser;
import parser.adapter.ClassAdapter;
import abstrakteSyntax.Klasse;
import java.util.ArrayList;

public class JavaToAST {

    public ArrayList<Klasse> compile(String input) {
        JavaParser.DocumentContext parseTree = parse(input);
        ArrayList<Klasse> klassen = new ArrayList<>();
        for (JavaParser.KlasseContext klasse: parseTree.klasse())
        {
            klassen.add(ClassAdapter.adapt(klasse));
        }
        return klassen;
    }

    private JavaParser.DocumentContext parse(String input) {
        JavaLexer lexer = new JavaLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);
        return parser.document(); //Parsen
    }

}
