// Generated from E:/02_Eigene_Dateien/INF2018_Compilerbau_Gruppe2/INF2018_Compilerbau_Gruppe2/src/main/java/parser\Java.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JavaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JavaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JavaParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(JavaParser.DocumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#klasse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKlasse(JavaParser.KlasseContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(JavaParser.ContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(JavaParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(JavaParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(JavaParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(JavaParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#localVarDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVarDecl(JavaParser.LocalVarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(JavaParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#newExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpression(JavaParser.NewExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#newContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewContent(JavaParser.NewContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#methodeCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodeCall(JavaParser.MethodeCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#methodeCallStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodeCallStatement(JavaParser.MethodeCallStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#methodeCallContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodeCallContent(JavaParser.MethodeCallContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#binary1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary1(JavaParser.Binary1Context ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#binary2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary2(JavaParser.Binary2Context ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(JavaParser.UnaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(JavaParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#instVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstVar(JavaParser.InstVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#instVarContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstVarContent(JavaParser.InstVarContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#localOrFieldVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalOrFieldVar(JavaParser.LocalOrFieldVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#returnParser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnParser(JavaParser.ReturnParserContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#whileParser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileParser(JavaParser.WhileParserContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#ifParser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfParser(JavaParser.IfParserContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#elseParser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseParser(JavaParser.ElseParserContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaParser#forParser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForParser(JavaParser.ForParserContext ctx);
}