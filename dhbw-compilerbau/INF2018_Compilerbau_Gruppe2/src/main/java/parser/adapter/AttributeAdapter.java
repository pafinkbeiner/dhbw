package parser.adapter;

import abstrakteSyntax.Attribut;
import abstrakteSyntax.Types;
import parser.JavaParser;

public class AttributeAdapter {
    public static Attribut adapt(JavaParser.AttributeContext ctx) {
        Attribut attribut = new Attribut();
        if (ctx.INT() != null){
            attribut.type = Types.Integer;
        }
        else if (ctx.CHAR() != null){
            attribut.type = Types.Char;
        }
        else if (ctx.BOOL() != null){
            attribut.type = Types.Boolean;
        }
        else {
            attribut.type = ctx.IDENTIFIER(0).getText();
            attribut.name = ctx.IDENTIFIER(1).getText();
            return attribut;
        }
        attribut.name = ctx.IDENTIFIER(0).getText();
        return attribut;
    }
}
