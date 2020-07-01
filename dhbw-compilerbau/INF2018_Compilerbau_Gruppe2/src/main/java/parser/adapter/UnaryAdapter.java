package parser.adapter;

import abstrakteSyntax.Types;
import abstrakteSyntax.expression.*;
import parser.JavaParser;

import java.lang.Integer;

public class UnaryAdapter {
    public static Unary adapt(JavaParser.UnaryContext ctx) {
        Unary unary = new Unary();
        if(ctx.pre != null)
        {
            unary.vorzeichen = ctx.pre.getText();
        }
        if (ctx.post != null)
        {
            unary.postfix = ctx.post.getText();
        }

        if (ctx.VALUE() != null)
        {
            String value = ctx.VALUE().getText();
            if (ctx.VALUE().getText().charAt(0) == '\'' )
            {
                Char zeichen = new Char();
                zeichen.type = Types.Char;
                zeichen.character = ctx.VALUE().getText().charAt(1);
                unary.zahl = zeichen;
            } else if(value.equals("null"))
            {
                unary.zahl = new Jnull();
            }
            else if(value.equals("true") || value.equals("false"))
            {
                Bool bool = new Bool();
                bool.type = Types.Boolean;
                bool.bool = !value.equals("false");
                unary.zahl = bool;
            }
            else if (tryParseInt(ctx.VALUE().getText())){
                abstrakteSyntax.expression.Integer integer = new abstrakteSyntax.expression.Integer();
                integer.integer = Integer.parseInt(ctx.VALUE().getText());
                integer.type = Types.Integer;
                unary.zahl = integer;
            }
        }
        else if (ctx.localOrFieldVar() != null){
            LocalOrFieldVar localOrFieldVar = new LocalOrFieldVar();
            localOrFieldVar.name = ctx.localOrFieldVar().getText();
            unary.zahl = localOrFieldVar;
        }
        else if (ctx.instVar() != null){
            unary.zahl = InstVarAdapter.adapt(ctx.instVar());
        }
        return unary;
    }
    public static boolean tryParseInt(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
