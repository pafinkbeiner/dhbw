grammar Java;

document: klasse+;

klasse : KeywordKlasse IDENTIFIER (EXTENDS IDENTIFIER)? LBRACE content RBRACE;

content :  ( attribute ';' | method )*;

method : (INT | CHAR | BOOL | VOID)? IDENTIFIER '(' attribute? ')' '{' block '}'
        | (INT | CHAR | BOOL | VOID)? IDENTIFIER '(' (attribute ',')* attribute ')' '{' block '}';

block: statement*;

statement: whileParser | returnParser ';'| localVarDecl | assign | ifParser | forParser | methodeCallStatement | instVar ';';

assign : ( localOrFieldVar | instVar ) '=' (newExpression | expression) ';';
localVarDecl : attribute ';';

expression : unary | binary1 | binary2 | methodeCall;
newExpression : NewKeyword IDENTIFIER '(' newContent? ')'
               | NewKeyword IDENTIFIER '(' newContent ( ',' (newContent) )* ')';
newContent : This | Super | unary | methodeCall;

methodeCall : IDENTIFIER '(' methodeCallContent? ')'
               | IDENTIFIER '(' ( methodeCallContent ',' )* methodeCallContent ')';
methodeCallStatement : methodeCall ';';

methodeCallContent : (instVar | localOrFieldVar | unary| newExpression | This | Super );

binary1 : binary1 op=('*'|'/'|'%') binary1
          | binary1 op=('+'|'-') binary1
          | pre=('-'|'+'|'--'|'++') '(' binary1 ')'
          | '(' binary1 ')'
          | unary;

binary2 : binary2 op=('==' | '!=') binary2
          | binary1 op=('==' | '>=' | '<=' | '<' | '>' | '!=') binary1
          | binary2 AND binary2
          | binary2 OR binary2
          | NOT '(' binary2 ')'
          | '(' binary2 ')'
          | unary;

unary : pre=('-'|'+'|'!'|'--'|'++')? (VALUE | instVar | localOrFieldVar) post=('++'|'--')?;

attribute : (INT | BOOL | CHAR | IDENTIFIER) IDENTIFIER;

instVar: instVarContent ('.' instVarContent)+;
instVarContent: methodeCall | This | Super | IDENTIFIER ;

localOrFieldVar: Super | This | IDENTIFIER;

returnParser: ReturnKeyword (expression | newExpression) ;

whileParser : WhileKeyword '(' expression ')' ('{' block '}' | statement);

ifParser : IfKeyword '(' expression ')' ('{' block '}' | statement) elseParser?;
elseParser : MaybeKeyword ('{' block '}' | statement);
forParser : ForKeyword '(' attribute? ';' binary2? ';' block ')' '{' block '}';

KeywordKlasse: 'class';
EXTENDS: 'extends';
INT: 'int';
BOOL: 'boolean';
CHAR: 'char';
VOID: 'void';
ReturnKeyword: 'return';
WhileKeyword: 'while';
IfKeyword: 'if';
ForKeyword: 'for';
MaybeKeyword: 'else';
NewKeyword: 'new';
This: 'this';
Super: 'super';
LBRACE: '{';
RBRACE: '}';
MUL: '*' ;
DIV: '/' ;
MOD: '%';
ADD: '+' ;
SUB: '-' ;
NOT: '!';
INC: '++';
DEC: '--';
AND: '&&';
OR: '||';
BOOLOPERATION: '==' | '>=' | '<=' | '<' | '>' | '!=';
VALUE: [0-9]+ | '\'' [a-zA-Z0-9] '\'' | 'true' | 'false' | 'null';
IDENTIFIER: [a-zA-Z][_a-zA-Z0-9]*;
WS: [ \t\r\n] -> skip;
