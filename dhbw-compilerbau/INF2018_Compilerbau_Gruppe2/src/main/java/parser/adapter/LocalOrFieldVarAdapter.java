package parser.adapter;

import abstrakteSyntax.expression.Expression;
import abstrakteSyntax.expression.LocalOrFieldVar;
import abstrakteSyntax.expression.Super;
import abstrakteSyntax.expression.This;
import parser.JavaParser;

public class LocalOrFieldVarAdapter {
    public static Expression adapt(JavaParser.LocalOrFieldVarContext ctx){
        if (ctx.This() != null){
            return new This();
        }
        else if (ctx.Super() != null){
            return new Super();
        }
        LocalOrFieldVar localOrFieldVar = new LocalOrFieldVar();
        localOrFieldVar.name = ctx.IDENTIFIER().getText();
        return localOrFieldVar;
    }
}