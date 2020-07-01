package parser.adapter;

import abstrakteSyntax.Klasse;
import parser.JavaParser;

import java.util.ArrayList;

public class ContentAdapter {
    public static void adapt(Klasse absSyntax, JavaParser.ContentContext ctx) {
        if (ctx.attribute() != null) {
            absSyntax.attribute = new ArrayList<>();
            for (JavaParser.AttributeContext attribut : ctx.attribute()) {
                absSyntax.attribute.add(AttributeAdapter.adapt(attribut));
            }
        }
        if (ctx.method() != null) {
            absSyntax.methoden = new ArrayList<>();
            for (JavaParser.MethodContext methode:ctx.method()) {
                absSyntax.methoden.add(MethodeAdapter.adapt(methode));
            }
        }
    }
}
