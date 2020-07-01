package parser.adapter;
import abstrakteSyntax.expression.BinaryInt;
import abstrakteSyntax.expression.Expression;
import abstrakteSyntax.expression.Unary;
import parser.JavaParser;

public class BinaryIntAdapter {
    public static Expression adapt(JavaParser.Binary1Context ctx) {
        if(ctx.unary() != null) {
            return UnaryAdapter.adapt(ctx.unary());
        } else if (ctx.binary1().size() == 1) {
            if (ctx.pre != null){
                Unary unary = new Unary();
                unary.vorzeichen = ctx.pre.getText();
                unary.zahl = adapt(ctx.binary1(0));
                return unary;
            }
            return adapt(ctx.binary1(0));
        }
        BinaryInt binaryInt = new BinaryInt();
        binaryInt.rechenzeichen = getRechenzeichen(ctx);
        binaryInt.zahl1 = adapt(ctx.binary1(0));
        binaryInt.zahl2 = adapt(ctx.binary1(1));
        return binaryInt;
    }
    public static String getRechenzeichen(JavaParser.Binary1Context ctx) {
        if (ctx.ADD() != null) {
            return ctx.ADD().getText();
        } else if (ctx.SUB() != null) {
            return ctx.SUB().getText();
        } else if (ctx.DIV() != null) {
            return ctx.DIV().getText();
        } else if (ctx.MOD() != null) {
            return ctx.MOD().getText();
        } else {
            return ctx.MUL().getText();
        }
    }
}
