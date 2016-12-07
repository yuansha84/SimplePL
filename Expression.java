
public class Expression {
	Term t;
	Expression e;
	char op;

	public Expression() {
		t = new Term();
		if (Lexer.nextToken == Token.ADD_OP || Lexer.nextToken == Token.SUB_OP) {
			op = Lexer.nextChar;
			Lexer.lex();
			e = new Expression();
			Code.gen(Code.opcode(op));	 
		}
	}
	
}
