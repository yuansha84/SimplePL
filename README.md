# SimplePL
A top-down parser in Java that translates every TinyPL program into a sequence of bytes-codes for a Java Virtual Machine.
TinyPL grammar:
program -> decls stmts end
decls ->  int idlist ';'
idlist -> id [',' idlist ]

stmts -> stmt [ stmts ]
stmt -> assign; | cmpd | cond | loop

assign -> id '=' expr
cmpd -> '{' stmts '}'
cond -> if '(' rexp ')' stmt [ else stmt ]
loop -> for '(' [assign] ';' [rexp] ';' [assign] ')' stmt

rexp -> expr ('<' | '>' | '==' | '!= ') expr
expr -> term  [ ('+' | '-') expr ]
term -> factor [ ('*' | '/') term ]
factor -> int_lit | id | '(' expr ')'

Entry point is in class Parser.
