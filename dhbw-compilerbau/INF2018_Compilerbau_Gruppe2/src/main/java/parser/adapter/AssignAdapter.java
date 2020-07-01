package parser.adapter;

import abstrakteSyntax.expression.StmtExprExpr;
import abstrakteSyntax.stmtExpr.Assign;
import parser.JavaParser;

public class AssignAdapter {
    public static Assign adapt(JavaParser.AssignContext ctx){
        Assign assign = new Assign();
        if (ctx.localOrFieldVar() != null) {
            assign.ziel = LocalOrFieldVarAdapter.adapt(ctx.localOrFieldVar());
        }
        else if (ctx.instVar() != null) {
            assign.ziel = InstVarAdapter.adapt(ctx.instVar());
        }
        if(ctx.expression() != null) assign.wert = ExpressionAdapter.adapt(ctx.expression());
        else {
            StmtExprExpr stmtExprExpr = new StmtExprExpr();
            stmtExprExpr.stmtExpr = NewExpressionAdapter.adapt(ctx.newExpression());
            assign.wert = stmtExprExpr;
        }
        return assign;
    }
}
