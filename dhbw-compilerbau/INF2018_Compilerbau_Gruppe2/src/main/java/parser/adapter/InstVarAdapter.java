package parser.adapter;

import abstrakteSyntax.expression.*;
import abstrakteSyntax.stmtExpr.MethodCall;
import parser.JavaParser;

import java.util.ArrayList;
import java.util.List;

public class InstVarAdapter {
    public static Expression adapt(JavaParser.InstVarContext ctx){
        if (ctx.instVarContent(ctx.instVarContent().size()-1).methodeCall() != null){
            return adaptMethodeCall(ctx);
        }
        if (ctx.instVarContent().size() == 1){
           return adaptContent(ctx.instVarContent(0));
        }
        InstVar instVar = new InstVar();
        instVar.first = adaptContent(ctx.instVarContent(0));
        instVar.second = adaptInstVar(ctx.instVarContent(), 1);
        return instVar;
    }

    public static Expression adaptContent(JavaParser.InstVarContentContext ctx) {
        if(ctx.This() != null) {
            return new This();
        } else if(ctx.Super() != null) {
            return new Super();
        } else if (ctx.methodeCall() != null){
            StmtExprExpr stmtExprExpr = new StmtExprExpr();
            stmtExprExpr.stmtExpr = MethodeCallAdapter.adapt(ctx.methodeCall());
            return stmtExprExpr;
        }
        LocalOrFieldVar var = new LocalOrFieldVar();
        var.name = ctx.IDENTIFIER().getText();
        return var;
    }

    public static Expression adaptInstVar(List<JavaParser.InstVarContentContext> ctxList, int count) {
        if(ctxList.size() == count +1) {
            return adaptContent(ctxList.get(count));
        }
        InstVar instVar = new InstVar();
        instVar.first = adaptContent(ctxList.get(count));
        instVar.second = adaptInstVar(ctxList, ++count);
        return instVar;
    }
    public static StmtExprExpr adaptMethodeCall(JavaParser.InstVarContext ctx){
        JavaParser.MethodeCallContext methodeCallContext = ctx.instVarContent(ctx.instVarContent().size()-1).methodeCall();
        StmtExprExpr stmtExprExpr = new StmtExprExpr();
        stmtExprExpr.stmtExpr = MethodeCallAdapter.adapt(methodeCallContext);
        ArrayList<JavaParser.InstVarContentContext> context = new ArrayList<>();
        for (int i = 0; i < ctx.instVarContent().size()-1; i++) {
            context.add(ctx.instVarContent(i));
        }
        ((MethodCall) stmtExprExpr.stmtExpr).expression = adaptInstVar(context, 0);
        return stmtExprExpr;
    }
}
