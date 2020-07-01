package parser.adapter;

import abstrakteSyntax.Attribut;
import abstrakteSyntax.Methode;
import abstrakteSyntax.Types;
import parser.JavaParser;

import java.util.ArrayList;

public class MethodeAdapter {
   public static Methode adapt(JavaParser.MethodContext ctx){
       Methode methode = new Methode();
       methode.name = ctx.IDENTIFIER().getText();
       if (ctx.INT() != null){
           methode.rueckgabetyp = Types.Integer;
       }
       else if (ctx.CHAR() != null){
           methode.rueckgabetyp = Types.Char;
       }
       else if (ctx.BOOL() != null){
           methode.rueckgabetyp = Types.Boolean;
       }
       else if (ctx.VOID() != null){
           methode.rueckgabetyp = Types.Void;
       }
       else {
           methode.rueckgabetyp = Types.Standard;
       }
       if (ctx.attribute() != null){
           methode.parameter = new ArrayList<Attribut>();
           for (JavaParser.AttributeContext attribut : ctx.attribute()) {
               methode.parameter.add(AttributeAdapter.adapt(attribut));
           }
       }
       if (ctx.block() != null){
           methode.body = BlockAdapter.adapt(ctx.block());
       }
        return methode;
    }
}
