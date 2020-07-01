package parser.adapter;

import abstrakteSyntax.expression.BinaryBool;
import abstrakteSyntax.expression.Expression;
import abstrakteSyntax.expression.Unary;
import parser.JavaParser;

public class BinaryBoolAdapter {
    public static Expression adapt(JavaParser.Binary2Context ctx) {
        BinaryBool binaryBool = new BinaryBool();
        if(ctx.unary() != null) {
            return UnaryAdapter.adapt(ctx.unary());
        } else if(ctx.binary1() != null) {
            binaryBool.rechenzeichen = getRechenzeichen(ctx);
            binaryBool.zahl1 = BinaryIntAdapter.adapt(ctx.binary1(0));
            binaryBool.zahl2 = BinaryIntAdapter.adapt(ctx.binary1(1));
            return binaryBool;
        } else if(ctx.binary2().size() == 1) {
            if(ctx.NOT() != null) {
                Unary unary = new Unary();
                unary.vorzeichen = ctx.NOT().getText();
                unary.zahl = adapt(ctx.binary2(0));
                return unary;
            }
            return adapt(ctx.binary2(0));
        }
        binaryBool.rechenzeichen = getRechenzeichen(ctx);
        binaryBool.zahl1 = adapt(ctx.binary2(0));
        binaryBool.zahl2 = adapt(ctx.binary2(1));
        return binaryBool;
    }

    public static String getRechenzeichen(JavaParser.Binary2Context ctx) {
        if (ctx.op != null) {
            return ctx.op.getText();
        } else if (ctx.AND() != null) {
            return ctx.AND().getText();
        } else {
            return ctx.OR().getText();
        }
    }
}
