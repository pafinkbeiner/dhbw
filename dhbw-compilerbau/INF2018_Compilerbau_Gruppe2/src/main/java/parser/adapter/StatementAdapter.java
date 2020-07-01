package parser.adapter;

import abstrakteSyntax.Attribut;
import abstrakteSyntax.expression.StmtExprExpr;
import abstrakteSyntax.statements.*;
import parser.JavaParser;


public class StatementAdapter {
    public static Statement adapt(JavaParser.StatementContext ctx)
    {
     if (ctx.assign() != null){
         StmtExprStmt stmtExprStmt = new StmtExprStmt();
         stmtExprStmt.stmtExpr = AssignAdapter.adapt(ctx.assign());
         return stmtExprStmt;
     }
     else if (ctx.localVarDecl() != null){
         LocalVarDecl localVarDecl = new LocalVarDecl();
         Attribut attribut = AttributeAdapter.adapt(ctx.localVarDecl().attribute());
         localVarDecl.name = attribut.name;
         localVarDecl.type = attribut.type;
         return localVarDecl;
     }
     else if (ctx.returnParser() != null){
         Return returnParser = new Return();
         if (ctx.returnParser().expression() != null) {
             returnParser.expression = ExpressionAdapter.adapt(ctx.returnParser().expression());
         }else if (ctx.returnParser().newExpression() != null){
             StmtExprExpr stmtExprExpr = new StmtExprExpr();
             stmtExprExpr.stmtExpr = NewExpressionAdapter.adapt(ctx.returnParser().newExpression());
             returnParser.expression = stmtExprExpr;
         }
         return returnParser;
     }
     else if (ctx.whileParser() != null){
         While whileParser = new While();
         whileParser.expression = ExpressionAdapter.adapt(ctx.whileParser().expression());
         if (ctx.whileParser().block() != null){
             whileParser.statement = BlockAdapter.adapt(ctx.whileParser().block());
         }
         else if (ctx.whileParser().statement() != null){
             whileParser.statement =  adapt(ctx.whileParser().statement());
         }
         return whileParser;
     }
     else if (ctx.ifParser() != null) {
         If ifParser = new If();
         ifParser.expression = ExpressionAdapter.adapt(ctx.ifParser().expression());
         if (ctx.ifParser().block() != null) {
             ifParser.statement = BlockAdapter.adapt(ctx.ifParser().block());
         } else if (ctx.ifParser().statement() != null) {
             ifParser.statement = StatementAdapter.adapt(ctx.ifParser().statement());
         }
         if (ctx.ifParser().elseParser() != null) {
             if (ctx.ifParser().elseParser().block() != null)
                 ifParser.maybeStatement = BlockAdapter.adapt(ctx.ifParser().elseParser().block());
             if (ctx.ifParser().elseParser().statement() != null)
                 ifParser.maybeStatement = StatementAdapter.adapt(ctx.ifParser().elseParser().statement());
         }
         return ifParser;
     }
     else if(ctx.forParser() != null) {
         For forParser = new For();
         if(ctx.forParser().attribute() != null) {
             forParser.attribut = AttributeAdapter.adapt(ctx.forParser().attribute());
         }
         if(ctx.forParser().binary2() != null) {
             forParser.expression = BinaryBoolAdapter.adapt(ctx.forParser().binary2());
         }
         forParser.statementArray.add(BlockAdapter.adapt(ctx.forParser().block(0)));
         forParser.statementArray.add(BlockAdapter.adapt(ctx.forParser().block(1)));
        return forParser;
     }
     else if (ctx.methodeCallStatement() != null){
         StmtExprStmt stmtExprStmt = new StmtExprStmt();
         stmtExprStmt.stmtExpr = MethodeCallAdapter.adapt(ctx.methodeCallStatement().methodeCall());
         return stmtExprStmt;
     }
     else if (ctx.instVar() != null){
         StmtExprStmt stmtExprStmt = new StmtExprStmt();
         stmtExprStmt.stmtExpr = ((StmtExprExpr)InstVarAdapter.adapt(ctx.instVar())).stmtExpr;
         return stmtExprStmt;
     }
     return null;
    }
}
