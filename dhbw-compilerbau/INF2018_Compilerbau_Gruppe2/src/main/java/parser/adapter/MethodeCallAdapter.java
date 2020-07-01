package parser.adapter;

import abstrakteSyntax.expression.*;
import abstrakteSyntax.stmtExpr.MethodCall;
import parser.JavaParser;

import java.util.ArrayList;

public class MethodeCallAdapter {

    public static MethodCall adapt(JavaParser.MethodeCallContext ctx){
        MethodCall methodCall = new MethodCall();
        methodCall.methode = ctx.IDENTIFIER().getText();
        methodCall.parameter = new ArrayList<>();
        for (JavaParser.MethodeCallContentContext content : ctx.methodeCallContent()){
            if(content.This() != null) {
                This thisExpression = new This();
                methodCall.parameter.add(thisExpression);
            }
            else if(content.Super() != null) {
                Super superExpression = new Super();
                methodCall.parameter.add(superExpression);
            }
            else if (content.instVar() != null){
                methodCall.parameter.add(InstVarAdapter.adapt(content.instVar()));
            }
            else if (content.localOrFieldVar() != null){
                methodCall.parameter.add(LocalOrFieldVarAdapter.adapt(content.localOrFieldVar()));
            }
            else if (content.unary() != null){
                methodCall.parameter.add(UnaryAdapter.adapt(content.unary()));
            }
            else if (content.newExpression() != null){
                StmtExprExpr stmtExprExpr = new StmtExprExpr();
                stmtExprExpr.stmtExpr = NewExpressionAdapter.adapt(content.newExpression());
                methodCall.parameter.add(stmtExprExpr);
            }
        }
        return methodCall;
    }
}
