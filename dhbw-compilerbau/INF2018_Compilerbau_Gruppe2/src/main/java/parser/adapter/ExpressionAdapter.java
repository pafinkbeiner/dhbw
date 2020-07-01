package parser.adapter;

import abstrakteSyntax.expression.*;
import parser.JavaParser;


public class ExpressionAdapter {
    public static Expression adapt(JavaParser.ExpressionContext ctx){
        if (ctx.unary() != null){
            return UnaryAdapter.adapt(ctx.unary());
        }
        else if (ctx.binary1() != null){
            return BinaryIntAdapter.adapt(ctx.binary1());
        }
        else if (ctx.binary2() != null){
            return BinaryBoolAdapter.adapt(ctx.binary2());
        }
        else if (ctx.methodeCall() != null){
            StmtExprExpr stmtExprExpr = new StmtExprExpr();
            stmtExprExpr.stmtExpr = MethodeCallAdapter.adapt(ctx.methodeCall());
            return stmtExprExpr;
        }
        return null;
    }

}
