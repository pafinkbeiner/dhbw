// Generated from E:/02_Eigene_Dateien/INF2018_Compilerbau_Gruppe2/INF2018_Compilerbau_Gruppe2/src/main/java/parser\Java.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, KeywordKlasse=13, EXTENDS=14, INT=15, BOOL=16, 
		CHAR=17, VOID=18, ReturnKeyword=19, WhileKeyword=20, IfKeyword=21, ForKeyword=22, 
		MaybeKeyword=23, NewKeyword=24, This=25, Super=26, LBRACE=27, RBRACE=28, 
		MUL=29, DIV=30, MOD=31, ADD=32, SUB=33, NOT=34, INC=35, DEC=36, AND=37, 
		OR=38, BOOLOPERATION=39, VALUE=40, IDENTIFIER=41, WS=42;
	public static final int
		RULE_document = 0, RULE_klasse = 1, RULE_content = 2, RULE_method = 3, 
		RULE_block = 4, RULE_statement = 5, RULE_assign = 6, RULE_localVarDecl = 7, 
		RULE_expression = 8, RULE_newExpression = 9, RULE_newContent = 10, RULE_methodeCall = 11, 
		RULE_methodeCallStatement = 12, RULE_methodeCallContent = 13, RULE_binary1 = 14, 
		RULE_binary2 = 15, RULE_unary = 16, RULE_attribute = 17, RULE_instVar = 18, 
		RULE_instVarContent = 19, RULE_localOrFieldVar = 20, RULE_returnParser = 21, 
		RULE_whileParser = 22, RULE_ifParser = 23, RULE_elseParser = 24, RULE_forParser = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"document", "klasse", "content", "method", "block", "statement", "assign", 
			"localVarDecl", "expression", "newExpression", "newContent", "methodeCall", 
			"methodeCallStatement", "methodeCallContent", "binary1", "binary2", "unary", 
			"attribute", "instVar", "instVarContent", "localOrFieldVar", "returnParser", 
			"whileParser", "ifParser", "elseParser", "forParser"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'('", "')'", "','", "'='", "'=='", "'!='", "'>='", "'<='", 
			"'<'", "'>'", "'.'", "'class'", "'extends'", "'int'", "'boolean'", "'char'", 
			"'void'", "'return'", "'while'", "'if'", "'for'", "'else'", "'new'", 
			"'this'", "'super'", "'{'", "'}'", "'*'", "'/'", "'%'", "'+'", "'-'", 
			"'!'", "'++'", "'--'", "'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "KeywordKlasse", "EXTENDS", "INT", "BOOL", "CHAR", "VOID", "ReturnKeyword", 
			"WhileKeyword", "IfKeyword", "ForKeyword", "MaybeKeyword", "NewKeyword", 
			"This", "Super", "LBRACE", "RBRACE", "MUL", "DIV", "MOD", "ADD", "SUB", 
			"NOT", "INC", "DEC", "AND", "OR", "BOOLOPERATION", "VALUE", "IDENTIFIER", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Java.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class DocumentContext extends ParserRuleContext {
		public List<KlasseContext> klasse() {
			return getRuleContexts(KlasseContext.class);
		}
		public KlasseContext klasse(int i) {
			return getRuleContext(KlasseContext.class,i);
		}
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitDocument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitDocument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_document);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(52);
				klasse();
				}
				}
				setState(55); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==KeywordKlasse );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KlasseContext extends ParserRuleContext {
		public TerminalNode KeywordKlasse() { return getToken(JavaParser.KeywordKlasse, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(JavaParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(JavaParser.IDENTIFIER, i);
		}
		public TerminalNode LBRACE() { return getToken(JavaParser.LBRACE, 0); }
		public ContentContext content() {
			return getRuleContext(ContentContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(JavaParser.RBRACE, 0); }
		public TerminalNode EXTENDS() { return getToken(JavaParser.EXTENDS, 0); }
		public KlasseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_klasse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterKlasse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitKlasse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitKlasse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KlasseContext klasse() throws RecognitionException {
		KlasseContext _localctx = new KlasseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_klasse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(KeywordKlasse);
			setState(58);
			match(IDENTIFIER);
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(59);
				match(EXTENDS);
				setState(60);
				match(IDENTIFIER);
				}
			}

			setState(63);
			match(LBRACE);
			setState(64);
			content();
			setState(65);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContentContext extends ParserRuleContext {
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public List<MethodContext> method() {
			return getRuleContexts(MethodContext.class);
		}
		public MethodContext method(int i) {
			return getRuleContext(MethodContext.class,i);
		}
		public ContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContentContext content() throws RecognitionException {
		ContentContext _localctx = new ContentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << VOID) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(71);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(67);
					attribute();
					setState(68);
					match(T__0);
					}
					break;
				case 2:
					{
					setState(70);
					method();
					}
					break;
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(JavaParser.IDENTIFIER, 0); }
		public TerminalNode LBRACE() { return getToken(JavaParser.LBRACE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(JavaParser.RBRACE, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public TerminalNode INT() { return getToken(JavaParser.INT, 0); }
		public TerminalNode CHAR() { return getToken(JavaParser.CHAR, 0); }
		public TerminalNode BOOL() { return getToken(JavaParser.BOOL, 0); }
		public TerminalNode VOID() { return getToken(JavaParser.VOID, 0); }
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_method);
		int _la;
		try {
			int _alt;
			setState(108);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << VOID))) != 0)) {
					{
					setState(76);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << VOID))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(79);
				match(IDENTIFIER);
				setState(80);
				match(T__1);
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(81);
					attribute();
					}
				}

				setState(84);
				match(T__2);
				setState(85);
				match(LBRACE);
				setState(86);
				block();
				setState(87);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << VOID))) != 0)) {
					{
					setState(89);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << VOID))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(92);
				match(IDENTIFIER);
				setState(93);
				match(T__1);
				setState(99);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(94);
						attribute();
						setState(95);
						match(T__3);
						}
						} 
					}
					setState(101);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				}
				setState(102);
				attribute();
				setState(103);
				match(T__2);
				setState(104);
				match(LBRACE);
				setState(105);
				block();
				setState(106);
				match(RBRACE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << ReturnKeyword) | (1L << WhileKeyword) | (1L << IfKeyword) | (1L << ForKeyword) | (1L << This) | (1L << Super) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(110);
				statement();
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public WhileParserContext whileParser() {
			return getRuleContext(WhileParserContext.class,0);
		}
		public ReturnParserContext returnParser() {
			return getRuleContext(ReturnParserContext.class,0);
		}
		public LocalVarDeclContext localVarDecl() {
			return getRuleContext(LocalVarDeclContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public IfParserContext ifParser() {
			return getRuleContext(IfParserContext.class,0);
		}
		public ForParserContext forParser() {
			return getRuleContext(ForParserContext.class,0);
		}
		public MethodeCallStatementContext methodeCallStatement() {
			return getRuleContext(MethodeCallStatementContext.class,0);
		}
		public InstVarContext instVar() {
			return getRuleContext(InstVarContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		try {
			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				whileParser();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				returnParser();
				setState(118);
				match(T__0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(120);
				localVarDecl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(121);
				assign();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(122);
				ifParser();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(123);
				forParser();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(124);
				methodeCallStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(125);
				instVar();
				setState(126);
				match(T__0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignContext extends ParserRuleContext {
		public LocalOrFieldVarContext localOrFieldVar() {
			return getRuleContext(LocalOrFieldVarContext.class,0);
		}
		public InstVarContext instVar() {
			return getRuleContext(InstVarContext.class,0);
		}
		public NewExpressionContext newExpression() {
			return getRuleContext(NewExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(130);
				localOrFieldVar();
				}
				break;
			case 2:
				{
				setState(131);
				instVar();
				}
				break;
			}
			setState(134);
			match(T__4);
			setState(137);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NewKeyword:
				{
				setState(135);
				newExpression();
				}
				break;
			case T__1:
			case This:
			case Super:
			case ADD:
			case SUB:
			case NOT:
			case INC:
			case DEC:
			case VALUE:
			case IDENTIFIER:
				{
				setState(136);
				expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(139);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalVarDeclContext extends ParserRuleContext {
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public LocalVarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVarDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterLocalVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitLocalVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitLocalVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVarDeclContext localVarDecl() throws RecognitionException {
		LocalVarDeclContext _localctx = new LocalVarDeclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_localVarDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			attribute();
			setState(142);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public Binary1Context binary1() {
			return getRuleContext(Binary1Context.class,0);
		}
		public Binary2Context binary2() {
			return getRuleContext(Binary2Context.class,0);
		}
		public MethodeCallContext methodeCall() {
			return getRuleContext(MethodeCallContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expression);
		try {
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				unary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				binary1(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(146);
				binary2(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(147);
				methodeCall();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewExpressionContext extends ParserRuleContext {
		public TerminalNode NewKeyword() { return getToken(JavaParser.NewKeyword, 0); }
		public TerminalNode IDENTIFIER() { return getToken(JavaParser.IDENTIFIER, 0); }
		public List<NewContentContext> newContent() {
			return getRuleContexts(NewContentContext.class);
		}
		public NewContentContext newContent(int i) {
			return getRuleContext(NewContentContext.class,i);
		}
		public NewExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterNewExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitNewExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitNewExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewExpressionContext newExpression() throws RecognitionException {
		NewExpressionContext _localctx = new NewExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_newExpression);
		int _la;
		try {
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				match(NewKeyword);
				setState(151);
				match(IDENTIFIER);
				setState(152);
				match(T__1);
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << This) | (1L << Super) | (1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << INC) | (1L << DEC) | (1L << VALUE) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(153);
					newContent();
					}
				}

				setState(156);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				match(NewKeyword);
				setState(158);
				match(IDENTIFIER);
				setState(159);
				match(T__1);
				setState(160);
				newContent();
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(161);
					match(T__3);
					{
					setState(162);
					newContent();
					}
					}
					}
					setState(167);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(168);
				match(T__2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewContentContext extends ParserRuleContext {
		public TerminalNode This() { return getToken(JavaParser.This, 0); }
		public TerminalNode Super() { return getToken(JavaParser.Super, 0); }
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public MethodeCallContext methodeCall() {
			return getRuleContext(MethodeCallContext.class,0);
		}
		public NewContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterNewContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitNewContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitNewContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewContentContext newContent() throws RecognitionException {
		NewContentContext _localctx = new NewContentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_newContent);
		try {
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				match(This);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				match(Super);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(174);
				unary();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(175);
				methodeCall();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodeCallContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(JavaParser.IDENTIFIER, 0); }
		public List<MethodeCallContentContext> methodeCallContent() {
			return getRuleContexts(MethodeCallContentContext.class);
		}
		public MethodeCallContentContext methodeCallContent(int i) {
			return getRuleContext(MethodeCallContentContext.class,i);
		}
		public MethodeCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodeCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterMethodeCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitMethodeCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitMethodeCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodeCallContext methodeCall() throws RecognitionException {
		MethodeCallContext _localctx = new MethodeCallContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_methodeCall);
		int _la;
		try {
			int _alt;
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				match(IDENTIFIER);
				setState(179);
				match(T__1);
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NewKeyword) | (1L << This) | (1L << Super) | (1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << INC) | (1L << DEC) | (1L << VALUE) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(180);
					methodeCallContent();
					}
				}

				setState(183);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				match(IDENTIFIER);
				setState(185);
				match(T__1);
				setState(191);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(186);
						methodeCallContent();
						setState(187);
						match(T__3);
						}
						} 
					}
					setState(193);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				}
				setState(194);
				methodeCallContent();
				setState(195);
				match(T__2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodeCallStatementContext extends ParserRuleContext {
		public MethodeCallContext methodeCall() {
			return getRuleContext(MethodeCallContext.class,0);
		}
		public MethodeCallStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodeCallStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterMethodeCallStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitMethodeCallStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitMethodeCallStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodeCallStatementContext methodeCallStatement() throws RecognitionException {
		MethodeCallStatementContext _localctx = new MethodeCallStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_methodeCallStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			methodeCall();
			setState(200);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodeCallContentContext extends ParserRuleContext {
		public InstVarContext instVar() {
			return getRuleContext(InstVarContext.class,0);
		}
		public LocalOrFieldVarContext localOrFieldVar() {
			return getRuleContext(LocalOrFieldVarContext.class,0);
		}
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public NewExpressionContext newExpression() {
			return getRuleContext(NewExpressionContext.class,0);
		}
		public TerminalNode This() { return getToken(JavaParser.This, 0); }
		public TerminalNode Super() { return getToken(JavaParser.Super, 0); }
		public MethodeCallContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodeCallContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterMethodeCallContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitMethodeCallContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitMethodeCallContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodeCallContentContext methodeCallContent() throws RecognitionException {
		MethodeCallContentContext _localctx = new MethodeCallContentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_methodeCallContent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(202);
				instVar();
				}
				break;
			case 2:
				{
				setState(203);
				localOrFieldVar();
				}
				break;
			case 3:
				{
				setState(204);
				unary();
				}
				break;
			case 4:
				{
				setState(205);
				newExpression();
				}
				break;
			case 5:
				{
				setState(206);
				match(This);
				}
				break;
			case 6:
				{
				setState(207);
				match(Super);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Binary1Context extends ParserRuleContext {
		public Token pre;
		public Token op;
		public List<Binary1Context> binary1() {
			return getRuleContexts(Binary1Context.class);
		}
		public Binary1Context binary1(int i) {
			return getRuleContext(Binary1Context.class,i);
		}
		public TerminalNode SUB() { return getToken(JavaParser.SUB, 0); }
		public TerminalNode ADD() { return getToken(JavaParser.ADD, 0); }
		public TerminalNode DEC() { return getToken(JavaParser.DEC, 0); }
		public TerminalNode INC() { return getToken(JavaParser.INC, 0); }
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public TerminalNode MUL() { return getToken(JavaParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(JavaParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(JavaParser.MOD, 0); }
		public Binary1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterBinary1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitBinary1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitBinary1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Binary1Context binary1() throws RecognitionException {
		return binary1(0);
	}

	private Binary1Context binary1(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Binary1Context _localctx = new Binary1Context(_ctx, _parentState);
		Binary1Context _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_binary1, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(211);
				((Binary1Context)_localctx).pre = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << INC) | (1L << DEC))) != 0)) ) {
					((Binary1Context)_localctx).pre = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(212);
				match(T__1);
				setState(213);
				binary1(0);
				setState(214);
				match(T__2);
				}
				break;
			case 2:
				{
				setState(216);
				match(T__1);
				setState(217);
				binary1(0);
				setState(218);
				match(T__2);
				}
				break;
			case 3:
				{
				setState(220);
				unary();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(231);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(229);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						_localctx = new Binary1Context(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary1);
						setState(223);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(224);
						((Binary1Context)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
							((Binary1Context)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(225);
						binary1(6);
						}
						break;
					case 2:
						{
						_localctx = new Binary1Context(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary1);
						setState(226);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(227);
						((Binary1Context)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((Binary1Context)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(228);
						binary1(5);
						}
						break;
					}
					} 
				}
				setState(233);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Binary2Context extends ParserRuleContext {
		public Token op;
		public List<Binary1Context> binary1() {
			return getRuleContexts(Binary1Context.class);
		}
		public Binary1Context binary1(int i) {
			return getRuleContext(Binary1Context.class,i);
		}
		public TerminalNode NOT() { return getToken(JavaParser.NOT, 0); }
		public List<Binary2Context> binary2() {
			return getRuleContexts(Binary2Context.class);
		}
		public Binary2Context binary2(int i) {
			return getRuleContext(Binary2Context.class,i);
		}
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public TerminalNode AND() { return getToken(JavaParser.AND, 0); }
		public TerminalNode OR() { return getToken(JavaParser.OR, 0); }
		public Binary2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterBinary2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitBinary2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitBinary2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Binary2Context binary2() throws RecognitionException {
		return binary2(0);
	}

	private Binary2Context binary2(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Binary2Context _localctx = new Binary2Context(_ctx, _parentState);
		Binary2Context _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_binary2, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(235);
				binary1(0);
				setState(236);
				((Binary2Context)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) ) {
					((Binary2Context)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(237);
				binary1(0);
				}
				break;
			case 2:
				{
				setState(239);
				match(NOT);
				setState(240);
				match(T__1);
				setState(241);
				binary2(0);
				setState(242);
				match(T__2);
				}
				break;
			case 3:
				{
				setState(244);
				match(T__1);
				setState(245);
				binary2(0);
				setState(246);
				match(T__2);
				}
				break;
			case 4:
				{
				setState(248);
				unary();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(262);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(260);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
					case 1:
						{
						_localctx = new Binary2Context(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary2);
						setState(251);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(252);
						((Binary2Context)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__5 || _la==T__6) ) {
							((Binary2Context)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(253);
						binary2(8);
						}
						break;
					case 2:
						{
						_localctx = new Binary2Context(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary2);
						setState(254);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(255);
						match(AND);
						setState(256);
						binary2(6);
						}
						break;
					case 3:
						{
						_localctx = new Binary2Context(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary2);
						setState(257);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(258);
						match(OR);
						setState(259);
						binary2(5);
						}
						break;
					}
					} 
				}
				setState(264);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryContext extends ParserRuleContext {
		public Token pre;
		public Token post;
		public TerminalNode VALUE() { return getToken(JavaParser.VALUE, 0); }
		public InstVarContext instVar() {
			return getRuleContext(InstVarContext.class,0);
		}
		public LocalOrFieldVarContext localOrFieldVar() {
			return getRuleContext(LocalOrFieldVarContext.class,0);
		}
		public TerminalNode SUB() { return getToken(JavaParser.SUB, 0); }
		public TerminalNode ADD() { return getToken(JavaParser.ADD, 0); }
		public TerminalNode NOT() { return getToken(JavaParser.NOT, 0); }
		public List<TerminalNode> DEC() { return getTokens(JavaParser.DEC); }
		public TerminalNode DEC(int i) {
			return getToken(JavaParser.DEC, i);
		}
		public List<TerminalNode> INC() { return getTokens(JavaParser.INC); }
		public TerminalNode INC(int i) {
			return getToken(JavaParser.INC, i);
		}
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitUnary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_unary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << INC) | (1L << DEC))) != 0)) {
				{
				setState(265);
				((UnaryContext)_localctx).pre = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << INC) | (1L << DEC))) != 0)) ) {
					((UnaryContext)_localctx).pre = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(271);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(268);
				match(VALUE);
				}
				break;
			case 2:
				{
				setState(269);
				instVar();
				}
				break;
			case 3:
				{
				setState(270);
				localOrFieldVar();
				}
				break;
			}
			setState(274);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(273);
				((UnaryContext)_localctx).post = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INC || _la==DEC) ) {
					((UnaryContext)_localctx).post = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(JavaParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(JavaParser.IDENTIFIER, i);
		}
		public TerminalNode INT() { return getToken(JavaParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(JavaParser.BOOL, 0); }
		public TerminalNode CHAR() { return getToken(JavaParser.CHAR, 0); }
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << IDENTIFIER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(277);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstVarContext extends ParserRuleContext {
		public List<InstVarContentContext> instVarContent() {
			return getRuleContexts(InstVarContentContext.class);
		}
		public InstVarContentContext instVarContent(int i) {
			return getRuleContext(InstVarContentContext.class,i);
		}
		public InstVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterInstVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitInstVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitInstVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstVarContext instVar() throws RecognitionException {
		InstVarContext _localctx = new InstVarContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_instVar);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			instVarContent();
			setState(282); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(280);
					match(T__11);
					setState(281);
					instVarContent();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(284); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstVarContentContext extends ParserRuleContext {
		public MethodeCallContext methodeCall() {
			return getRuleContext(MethodeCallContext.class,0);
		}
		public TerminalNode This() { return getToken(JavaParser.This, 0); }
		public TerminalNode Super() { return getToken(JavaParser.Super, 0); }
		public TerminalNode IDENTIFIER() { return getToken(JavaParser.IDENTIFIER, 0); }
		public InstVarContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instVarContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterInstVarContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitInstVarContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitInstVarContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstVarContentContext instVarContent() throws RecognitionException {
		InstVarContentContext _localctx = new InstVarContentContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_instVarContent);
		try {
			setState(290);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(286);
				methodeCall();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(287);
				match(This);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(288);
				match(Super);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(289);
				match(IDENTIFIER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalOrFieldVarContext extends ParserRuleContext {
		public TerminalNode Super() { return getToken(JavaParser.Super, 0); }
		public TerminalNode This() { return getToken(JavaParser.This, 0); }
		public TerminalNode IDENTIFIER() { return getToken(JavaParser.IDENTIFIER, 0); }
		public LocalOrFieldVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localOrFieldVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterLocalOrFieldVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitLocalOrFieldVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitLocalOrFieldVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalOrFieldVarContext localOrFieldVar() throws RecognitionException {
		LocalOrFieldVarContext _localctx = new LocalOrFieldVarContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_localOrFieldVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << This) | (1L << Super) | (1L << IDENTIFIER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnParserContext extends ParserRuleContext {
		public TerminalNode ReturnKeyword() { return getToken(JavaParser.ReturnKeyword, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NewExpressionContext newExpression() {
			return getRuleContext(NewExpressionContext.class,0);
		}
		public ReturnParserContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnParser; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterReturnParser(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitReturnParser(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitReturnParser(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnParserContext returnParser() throws RecognitionException {
		ReturnParserContext _localctx = new ReturnParserContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_returnParser);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(ReturnKeyword);
			setState(297);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case This:
			case Super:
			case ADD:
			case SUB:
			case NOT:
			case INC:
			case DEC:
			case VALUE:
			case IDENTIFIER:
				{
				setState(295);
				expression();
				}
				break;
			case NewKeyword:
				{
				setState(296);
				newExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileParserContext extends ParserRuleContext {
		public TerminalNode WhileKeyword() { return getToken(JavaParser.WhileKeyword, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(JavaParser.LBRACE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(JavaParser.RBRACE, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileParserContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileParser; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterWhileParser(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitWhileParser(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitWhileParser(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileParserContext whileParser() throws RecognitionException {
		WhileParserContext _localctx = new WhileParserContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_whileParser);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			match(WhileKeyword);
			setState(300);
			match(T__1);
			setState(301);
			expression();
			setState(302);
			match(T__2);
			setState(308);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(303);
				match(LBRACE);
				setState(304);
				block();
				setState(305);
				match(RBRACE);
				}
				break;
			case INT:
			case BOOL:
			case CHAR:
			case ReturnKeyword:
			case WhileKeyword:
			case IfKeyword:
			case ForKeyword:
			case This:
			case Super:
			case IDENTIFIER:
				{
				setState(307);
				statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfParserContext extends ParserRuleContext {
		public TerminalNode IfKeyword() { return getToken(JavaParser.IfKeyword, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(JavaParser.LBRACE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(JavaParser.RBRACE, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ElseParserContext elseParser() {
			return getRuleContext(ElseParserContext.class,0);
		}
		public IfParserContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifParser; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterIfParser(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitIfParser(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitIfParser(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfParserContext ifParser() throws RecognitionException {
		IfParserContext _localctx = new IfParserContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_ifParser);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			match(IfKeyword);
			setState(311);
			match(T__1);
			setState(312);
			expression();
			setState(313);
			match(T__2);
			setState(319);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(314);
				match(LBRACE);
				setState(315);
				block();
				setState(316);
				match(RBRACE);
				}
				break;
			case INT:
			case BOOL:
			case CHAR:
			case ReturnKeyword:
			case WhileKeyword:
			case IfKeyword:
			case ForKeyword:
			case This:
			case Super:
			case IDENTIFIER:
				{
				setState(318);
				statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(322);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(321);
				elseParser();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseParserContext extends ParserRuleContext {
		public TerminalNode MaybeKeyword() { return getToken(JavaParser.MaybeKeyword, 0); }
		public TerminalNode LBRACE() { return getToken(JavaParser.LBRACE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(JavaParser.RBRACE, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ElseParserContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseParser; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterElseParser(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitElseParser(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitElseParser(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseParserContext elseParser() throws RecognitionException {
		ElseParserContext _localctx = new ElseParserContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_elseParser);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			match(MaybeKeyword);
			setState(330);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(325);
				match(LBRACE);
				setState(326);
				block();
				setState(327);
				match(RBRACE);
				}
				break;
			case INT:
			case BOOL:
			case CHAR:
			case ReturnKeyword:
			case WhileKeyword:
			case IfKeyword:
			case ForKeyword:
			case This:
			case Super:
			case IDENTIFIER:
				{
				setState(329);
				statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForParserContext extends ParserRuleContext {
		public TerminalNode ForKeyword() { return getToken(JavaParser.ForKeyword, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode LBRACE() { return getToken(JavaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(JavaParser.RBRACE, 0); }
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public Binary2Context binary2() {
			return getRuleContext(Binary2Context.class,0);
		}
		public ForParserContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forParser; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterForParser(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitForParser(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaVisitor ) return ((JavaVisitor<? extends T>)visitor).visitForParser(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForParserContext forParser() throws RecognitionException {
		ForParserContext _localctx = new ForParserContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_forParser);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			match(ForKeyword);
			setState(333);
			match(T__1);
			setState(335);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(334);
				attribute();
				}
			}

			setState(337);
			match(T__0);
			setState(339);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << This) | (1L << Super) | (1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << INC) | (1L << DEC) | (1L << VALUE) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(338);
				binary2(0);
				}
			}

			setState(341);
			match(T__0);
			setState(342);
			block();
			setState(343);
			match(T__2);
			setState(344);
			match(LBRACE);
			setState(345);
			block();
			setState(346);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return binary1_sempred((Binary1Context)_localctx, predIndex);
		case 15:
			return binary2_sempred((Binary2Context)_localctx, predIndex);
		}
		return true;
	}
	private boolean binary1_sempred(Binary1Context _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean binary2_sempred(Binary2Context _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u015f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\6\28\n\2\r\2\16\29\3\3\3\3\3\3\3\3\5\3@\n\3\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4J\n\4\f\4\16\4M\13\4\3\5\5\5P\n\5\3"+
		"\5\3\5\3\5\5\5U\n\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5]\n\5\3\5\3\5\3\5\3\5\3"+
		"\5\7\5d\n\5\f\5\16\5g\13\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5o\n\5\3\6\7\6r\n"+
		"\6\f\6\16\6u\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7"+
		"\u0083\n\7\3\b\3\b\5\b\u0087\n\b\3\b\3\b\3\b\5\b\u008c\n\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\5\n\u0097\n\n\3\13\3\13\3\13\3\13\5\13\u009d"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00a6\n\13\f\13\16\13\u00a9"+
		"\13\13\3\13\3\13\5\13\u00ad\n\13\3\f\3\f\3\f\3\f\5\f\u00b3\n\f\3\r\3\r"+
		"\3\r\5\r\u00b8\n\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00c0\n\r\f\r\16\r\u00c3"+
		"\13\r\3\r\3\r\3\r\5\r\u00c8\n\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\5\17\u00d3\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\5\20\u00e0\n\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00e8\n\20\f"+
		"\20\16\20\u00eb\13\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\5\21\u00fc\n\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\7\21\u0107\n\21\f\21\16\21\u010a\13\21\3\22\5\22\u010d"+
		"\n\22\3\22\3\22\3\22\5\22\u0112\n\22\3\22\5\22\u0115\n\22\3\23\3\23\3"+
		"\23\3\24\3\24\3\24\6\24\u011d\n\24\r\24\16\24\u011e\3\25\3\25\3\25\3\25"+
		"\5\25\u0125\n\25\3\26\3\26\3\27\3\27\3\27\5\27\u012c\n\27\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0137\n\30\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\5\31\u0142\n\31\3\31\5\31\u0145\n\31\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\5\32\u014d\n\32\3\33\3\33\3\33\5\33\u0152\n\33"+
		"\3\33\3\33\5\33\u0156\n\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\2\4"+
		"\36 \34\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\2\f\3"+
		"\2\21\24\4\2\"#%&\3\2\37!\3\2\"#\3\2\b\r\3\2\b\t\3\2\"&\3\2%&\4\2\21\23"+
		"++\4\2\33\34++\2\u0181\2\67\3\2\2\2\4;\3\2\2\2\6K\3\2\2\2\bn\3\2\2\2\n"+
		"s\3\2\2\2\f\u0082\3\2\2\2\16\u0086\3\2\2\2\20\u008f\3\2\2\2\22\u0096\3"+
		"\2\2\2\24\u00ac\3\2\2\2\26\u00b2\3\2\2\2\30\u00c7\3\2\2\2\32\u00c9\3\2"+
		"\2\2\34\u00d2\3\2\2\2\36\u00df\3\2\2\2 \u00fb\3\2\2\2\"\u010c\3\2\2\2"+
		"$\u0116\3\2\2\2&\u0119\3\2\2\2(\u0124\3\2\2\2*\u0126\3\2\2\2,\u0128\3"+
		"\2\2\2.\u012d\3\2\2\2\60\u0138\3\2\2\2\62\u0146\3\2\2\2\64\u014e\3\2\2"+
		"\2\668\5\4\3\2\67\66\3\2\2\289\3\2\2\29\67\3\2\2\29:\3\2\2\2:\3\3\2\2"+
		"\2;<\7\17\2\2<?\7+\2\2=>\7\20\2\2>@\7+\2\2?=\3\2\2\2?@\3\2\2\2@A\3\2\2"+
		"\2AB\7\35\2\2BC\5\6\4\2CD\7\36\2\2D\5\3\2\2\2EF\5$\23\2FG\7\3\2\2GJ\3"+
		"\2\2\2HJ\5\b\5\2IE\3\2\2\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\7"+
		"\3\2\2\2MK\3\2\2\2NP\t\2\2\2ON\3\2\2\2OP\3\2\2\2PQ\3\2\2\2QR\7+\2\2RT"+
		"\7\4\2\2SU\5$\23\2TS\3\2\2\2TU\3\2\2\2UV\3\2\2\2VW\7\5\2\2WX\7\35\2\2"+
		"XY\5\n\6\2YZ\7\36\2\2Zo\3\2\2\2[]\t\2\2\2\\[\3\2\2\2\\]\3\2\2\2]^\3\2"+
		"\2\2^_\7+\2\2_e\7\4\2\2`a\5$\23\2ab\7\6\2\2bd\3\2\2\2c`\3\2\2\2dg\3\2"+
		"\2\2ec\3\2\2\2ef\3\2\2\2fh\3\2\2\2ge\3\2\2\2hi\5$\23\2ij\7\5\2\2jk\7\35"+
		"\2\2kl\5\n\6\2lm\7\36\2\2mo\3\2\2\2nO\3\2\2\2n\\\3\2\2\2o\t\3\2\2\2pr"+
		"\5\f\7\2qp\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2t\13\3\2\2\2us\3\2\2\2"+
		"v\u0083\5.\30\2wx\5,\27\2xy\7\3\2\2y\u0083\3\2\2\2z\u0083\5\20\t\2{\u0083"+
		"\5\16\b\2|\u0083\5\60\31\2}\u0083\5\64\33\2~\u0083\5\32\16\2\177\u0080"+
		"\5&\24\2\u0080\u0081\7\3\2\2\u0081\u0083\3\2\2\2\u0082v\3\2\2\2\u0082"+
		"w\3\2\2\2\u0082z\3\2\2\2\u0082{\3\2\2\2\u0082|\3\2\2\2\u0082}\3\2\2\2"+
		"\u0082~\3\2\2\2\u0082\177\3\2\2\2\u0083\r\3\2\2\2\u0084\u0087\5*\26\2"+
		"\u0085\u0087\5&\24\2\u0086\u0084\3\2\2\2\u0086\u0085\3\2\2\2\u0087\u0088"+
		"\3\2\2\2\u0088\u008b\7\7\2\2\u0089\u008c\5\24\13\2\u008a\u008c\5\22\n"+
		"\2\u008b\u0089\3\2\2\2\u008b\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e"+
		"\7\3\2\2\u008e\17\3\2\2\2\u008f\u0090\5$\23\2\u0090\u0091\7\3\2\2\u0091"+
		"\21\3\2\2\2\u0092\u0097\5\"\22\2\u0093\u0097\5\36\20\2\u0094\u0097\5 "+
		"\21\2\u0095\u0097\5\30\r\2\u0096\u0092\3\2\2\2\u0096\u0093\3\2\2\2\u0096"+
		"\u0094\3\2\2\2\u0096\u0095\3\2\2\2\u0097\23\3\2\2\2\u0098\u0099\7\32\2"+
		"\2\u0099\u009a\7+\2\2\u009a\u009c\7\4\2\2\u009b\u009d\5\26\f\2\u009c\u009b"+
		"\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00ad\7\5\2\2\u009f"+
		"\u00a0\7\32\2\2\u00a0\u00a1\7+\2\2\u00a1\u00a2\7\4\2\2\u00a2\u00a7\5\26"+
		"\f\2\u00a3\u00a4\7\6\2\2\u00a4\u00a6\5\26\f\2\u00a5\u00a3\3\2\2\2\u00a6"+
		"\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00aa\3\2"+
		"\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ab\7\5\2\2\u00ab\u00ad\3\2\2\2\u00ac"+
		"\u0098\3\2\2\2\u00ac\u009f\3\2\2\2\u00ad\25\3\2\2\2\u00ae\u00b3\7\33\2"+
		"\2\u00af\u00b3\7\34\2\2\u00b0\u00b3\5\"\22\2\u00b1\u00b3\5\30\r\2\u00b2"+
		"\u00ae\3\2\2\2\u00b2\u00af\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b1\3\2"+
		"\2\2\u00b3\27\3\2\2\2\u00b4\u00b5\7+\2\2\u00b5\u00b7\7\4\2\2\u00b6\u00b8"+
		"\5\34\17\2\u00b7\u00b6\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\3\2\2\2"+
		"\u00b9\u00c8\7\5\2\2\u00ba\u00bb\7+\2\2\u00bb\u00c1\7\4\2\2\u00bc\u00bd"+
		"\5\34\17\2\u00bd\u00be\7\6\2\2\u00be\u00c0\3\2\2\2\u00bf\u00bc\3\2\2\2"+
		"\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c4"+
		"\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00c5\5\34\17\2\u00c5\u00c6\7\5\2\2"+
		"\u00c6\u00c8\3\2\2\2\u00c7\u00b4\3\2\2\2\u00c7\u00ba\3\2\2\2\u00c8\31"+
		"\3\2\2\2\u00c9\u00ca\5\30\r\2\u00ca\u00cb\7\3\2\2\u00cb\33\3\2\2\2\u00cc"+
		"\u00d3\5&\24\2\u00cd\u00d3\5*\26\2\u00ce\u00d3\5\"\22\2\u00cf\u00d3\5"+
		"\24\13\2\u00d0\u00d3\7\33\2\2\u00d1\u00d3\7\34\2\2\u00d2\u00cc\3\2\2\2"+
		"\u00d2\u00cd\3\2\2\2\u00d2\u00ce\3\2\2\2\u00d2\u00cf\3\2\2\2\u00d2\u00d0"+
		"\3\2\2\2\u00d2\u00d1\3\2\2\2\u00d3\35\3\2\2\2\u00d4\u00d5\b\20\1\2\u00d5"+
		"\u00d6\t\3\2\2\u00d6\u00d7\7\4\2\2\u00d7\u00d8\5\36\20\2\u00d8\u00d9\7"+
		"\5\2\2\u00d9\u00e0\3\2\2\2\u00da\u00db\7\4\2\2\u00db\u00dc\5\36\20\2\u00dc"+
		"\u00dd\7\5\2\2\u00dd\u00e0\3\2\2\2\u00de\u00e0\5\"\22\2\u00df\u00d4\3"+
		"\2\2\2\u00df\u00da\3\2\2\2\u00df\u00de\3\2\2\2\u00e0\u00e9\3\2\2\2\u00e1"+
		"\u00e2\f\7\2\2\u00e2\u00e3\t\4\2\2\u00e3\u00e8\5\36\20\b\u00e4\u00e5\f"+
		"\6\2\2\u00e5\u00e6\t\5\2\2\u00e6\u00e8\5\36\20\7\u00e7\u00e1\3\2\2\2\u00e7"+
		"\u00e4\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2"+
		"\2\2\u00ea\37\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ed\b\21\1\2\u00ed\u00ee"+
		"\5\36\20\2\u00ee\u00ef\t\6\2\2\u00ef\u00f0\5\36\20\2\u00f0\u00fc\3\2\2"+
		"\2\u00f1\u00f2\7$\2\2\u00f2\u00f3\7\4\2\2\u00f3\u00f4\5 \21\2\u00f4\u00f5"+
		"\7\5\2\2\u00f5\u00fc\3\2\2\2\u00f6\u00f7\7\4\2\2\u00f7\u00f8\5 \21\2\u00f8"+
		"\u00f9\7\5\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00fc\5\"\22\2\u00fb\u00ec\3"+
		"\2\2\2\u00fb\u00f1\3\2\2\2\u00fb\u00f6\3\2\2\2\u00fb\u00fa\3\2\2\2\u00fc"+
		"\u0108\3\2\2\2\u00fd\u00fe\f\t\2\2\u00fe\u00ff\t\7\2\2\u00ff\u0107\5 "+
		"\21\n\u0100\u0101\f\7\2\2\u0101\u0102\7\'\2\2\u0102\u0107\5 \21\b\u0103"+
		"\u0104\f\6\2\2\u0104\u0105\7(\2\2\u0105\u0107\5 \21\7\u0106\u00fd\3\2"+
		"\2\2\u0106\u0100\3\2\2\2\u0106\u0103\3\2\2\2\u0107\u010a\3\2\2\2\u0108"+
		"\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109!\3\2\2\2\u010a\u0108\3\2\2\2"+
		"\u010b\u010d\t\b\2\2\u010c\u010b\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u0111"+
		"\3\2\2\2\u010e\u0112\7*\2\2\u010f\u0112\5&\24\2\u0110\u0112\5*\26\2\u0111"+
		"\u010e\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0110\3\2\2\2\u0112\u0114\3\2"+
		"\2\2\u0113\u0115\t\t\2\2\u0114\u0113\3\2\2\2\u0114\u0115\3\2\2\2\u0115"+
		"#\3\2\2\2\u0116\u0117\t\n\2\2\u0117\u0118\7+\2\2\u0118%\3\2\2\2\u0119"+
		"\u011c\5(\25\2\u011a\u011b\7\16\2\2\u011b\u011d\5(\25\2\u011c\u011a\3"+
		"\2\2\2\u011d\u011e\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f"+
		"\'\3\2\2\2\u0120\u0125\5\30\r\2\u0121\u0125\7\33\2\2\u0122\u0125\7\34"+
		"\2\2\u0123\u0125\7+\2\2\u0124\u0120\3\2\2\2\u0124\u0121\3\2\2\2\u0124"+
		"\u0122\3\2\2\2\u0124\u0123\3\2\2\2\u0125)\3\2\2\2\u0126\u0127\t\13\2\2"+
		"\u0127+\3\2\2\2\u0128\u012b\7\25\2\2\u0129\u012c\5\22\n\2\u012a\u012c"+
		"\5\24\13\2\u012b\u0129\3\2\2\2\u012b\u012a\3\2\2\2\u012c-\3\2\2\2\u012d"+
		"\u012e\7\26\2\2\u012e\u012f\7\4\2\2\u012f\u0130\5\22\n\2\u0130\u0136\7"+
		"\5\2\2\u0131\u0132\7\35\2\2\u0132\u0133\5\n\6\2\u0133\u0134\7\36\2\2\u0134"+
		"\u0137\3\2\2\2\u0135\u0137\5\f\7\2\u0136\u0131\3\2\2\2\u0136\u0135\3\2"+
		"\2\2\u0137/\3\2\2\2\u0138\u0139\7\27\2\2\u0139\u013a\7\4\2\2\u013a\u013b"+
		"\5\22\n\2\u013b\u0141\7\5\2\2\u013c\u013d\7\35\2\2\u013d\u013e\5\n\6\2"+
		"\u013e\u013f\7\36\2\2\u013f\u0142\3\2\2\2\u0140\u0142\5\f\7\2\u0141\u013c"+
		"\3\2\2\2\u0141\u0140\3\2\2\2\u0142\u0144\3\2\2\2\u0143\u0145\5\62\32\2"+
		"\u0144\u0143\3\2\2\2\u0144\u0145\3\2\2\2\u0145\61\3\2\2\2\u0146\u014c"+
		"\7\31\2\2\u0147\u0148\7\35\2\2\u0148\u0149\5\n\6\2\u0149\u014a\7\36\2"+
		"\2\u014a\u014d\3\2\2\2\u014b\u014d\5\f\7\2\u014c\u0147\3\2\2\2\u014c\u014b"+
		"\3\2\2\2\u014d\63\3\2\2\2\u014e\u014f\7\30\2\2\u014f\u0151\7\4\2\2\u0150"+
		"\u0152\5$\23\2\u0151\u0150\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0153\3\2"+
		"\2\2\u0153\u0155\7\3\2\2\u0154\u0156\5 \21\2\u0155\u0154\3\2\2\2\u0155"+
		"\u0156\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0158\7\3\2\2\u0158\u0159\5\n"+
		"\6\2\u0159\u015a\7\5\2\2\u015a\u015b\7\35\2\2\u015b\u015c\5\n\6\2\u015c"+
		"\u015d\7\36\2\2\u015d\65\3\2\2\2*9?IKOT\\ens\u0082\u0086\u008b\u0096\u009c"+
		"\u00a7\u00ac\u00b2\u00b7\u00c1\u00c7\u00d2\u00df\u00e7\u00e9\u00fb\u0106"+
		"\u0108\u010c\u0111\u0114\u011e\u0124\u012b\u0136\u0141\u0144\u014c\u0151"+
		"\u0155";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}