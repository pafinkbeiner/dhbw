package parser.adapter;

import abstrakteSyntax.expression.StmtExprExpr;
import abstrakteSyntax.expression.Super;
import abstrakteSyntax.expression.This;
import abstrakteSyntax.stmtExpr.New;
import abstrakteSyntax.stmtExpr.StmtExpr;
import parser.JavaParser;

public class NewExpressionAdapter {
    public static StmtExpr adapt(JavaParser.NewExpressionContext ctx) {
        New neu = new New();
        neu.className = ctx.IDENTIFIER().getText();
        for(JavaParser.NewContentContext content : ctx.newContent())
        {
            if(content.This() != null) {
                This thisExpression = new This();
                neu.expressions.add(thisExpression);
            }
            else if(content.Super() != null) {
                Super superExpression = new Super();
                neu.expressions.add(superExpression);
            }
            else if (content.methodeCall() != null){
                StmtExprExpr stmtExprExpr = new StmtExprExpr();
                stmtExprExpr.stmtExpr = MethodeCallAdapter.adapt(content.methodeCall());
                neu.expressions.add(stmtExprExpr);
            }
            else {
                neu.expressions.add(UnaryAdapter.adapt(content.unary()));
            }
        }
        return neu;
    }
}
