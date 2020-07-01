// Generated from C:/Users/gotz/Desktop/4. Semester/Compilerbau/INF2018_Compilerbau_Gruppe2/INF2018_Compilerbau_Gruppe2/src/main/java/parser\Java.g4 by ANTLR 4.8
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JavaParser}.
 */
public interface JavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JavaParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(JavaParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(JavaParser.DocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#klasse}.
	 * @param ctx the parse tree
	 */
	void enterKlasse(JavaParser.KlasseContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#klasse}.
	 * @param ctx the parse tree
	 */
	void exitKlasse(JavaParser.KlasseContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(JavaParser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(JavaParser.ContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(JavaParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(JavaParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(JavaParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(JavaParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(JavaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(JavaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(JavaParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(JavaParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#localVarDecl}.
	 * @param ctx the parse tree
	 */
	void enterLocalVarDecl(JavaParser.LocalVarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#localVarDecl}.
	 * @param ctx the parse tree
	 */
	void exitLocalVarDecl(JavaParser.LocalVarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(JavaParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(JavaParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpression(JavaParser.NewExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpression(JavaParser.NewExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#newContent}.
	 * @param ctx the parse tree
	 */
	void enterNewContent(JavaParser.NewContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#newContent}.
	 * @param ctx the parse tree
	 */
	void exitNewContent(JavaParser.NewContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#methodeCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodeCall(JavaParser.MethodeCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#methodeCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodeCall(JavaParser.MethodeCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#methodeCallStatement}.
	 * @param ctx the parse tree
	 */
	void enterMethodeCallStatement(JavaParser.MethodeCallStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#methodeCallStatement}.
	 * @param ctx the parse tree
	 */
	void exitMethodeCallStatement(JavaParser.MethodeCallStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#methodeCallContent}.
	 * @param ctx the parse tree
	 */
	void enterMethodeCallContent(JavaParser.MethodeCallContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#methodeCallContent}.
	 * @param ctx the parse tree
	 */
	void exitMethodeCallContent(JavaParser.MethodeCallContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#binary1}.
	 * @param ctx the parse tree
	 */
	void enterBinary1(JavaParser.Binary1Context ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#binary1}.
	 * @param ctx the parse tree
	 */
	void exitBinary1(JavaParser.Binary1Context ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#binary2}.
	 * @param ctx the parse tree
	 */
	void enterBinary2(JavaParser.Binary2Context ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#binary2}.
	 * @param ctx the parse tree
	 */
	void exitBinary2(JavaParser.Binary2Context ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnary(JavaParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnary(JavaParser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(JavaParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(JavaParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#instVar}.
	 * @param ctx the parse tree
	 */
	void enterInstVar(JavaParser.InstVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#instVar}.
	 * @param ctx the parse tree
	 */
	void exitInstVar(JavaParser.InstVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#instVarContent}.
	 * @param ctx the parse tree
	 */
	void enterInstVarContent(JavaParser.InstVarContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#instVarContent}.
	 * @param ctx the parse tree
	 */
	void exitInstVarContent(JavaParser.InstVarContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#localOrFieldVar}.
	 * @param ctx the parse tree
	 */
	void enterLocalOrFieldVar(JavaParser.LocalOrFieldVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#localOrFieldVar}.
	 * @param ctx the parse tree
	 */
	void exitLocalOrFieldVar(JavaParser.LocalOrFieldVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#returnParser}.
	 * @param ctx the parse tree
	 */
	void enterReturnParser(JavaParser.ReturnParserContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#returnParser}.
	 * @param ctx the parse tree
	 */
	void exitReturnParser(JavaParser.ReturnParserContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#whileParser}.
	 * @param ctx the parse tree
	 */
	void enterWhileParser(JavaParser.WhileParserContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#whileParser}.
	 * @param ctx the parse tree
	 */
	void exitWhileParser(JavaParser.WhileParserContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#ifParser}.
	 * @param ctx the parse tree
	 */
	void enterIfParser(JavaParser.IfParserContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#ifParser}.
	 * @param ctx the parse tree
	 */
	void exitIfParser(JavaParser.IfParserContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#elseParser}.
	 * @param ctx the parse tree
	 */
	void enterElseParser(JavaParser.ElseParserContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#elseParser}.
	 * @param ctx the parse tree
	 */
	void exitElseParser(JavaParser.ElseParserContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#forParser}.
	 * @param ctx the parse tree
	 */
	void enterForParser(JavaParser.ForParserContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#forParser}.
	 * @param ctx the parse tree
	 */
	void exitForParser(JavaParser.ForParserContext ctx);
}