
public class ComparisonExpr {

	Expression lexpr;
	Expression rexpr;
	public char op;
	
	public ComparisonExpr(){
		lexpr=new Expression();
		op=Lexer.nextChar;
		Lexer.lex();
		rexpr=new Expression();
		
	}
}
