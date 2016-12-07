
public class Compound {

	Statements stmts;
	
	public Compound(){
		Lexer.lex();//skip over '{'
		stmts=new Statements();
		//System.out.println("nextToken="+Token.toString(Lexer.nextToken));
		Lexer.lex();//skip over '}'
		//Lexer.lex();
	}
}
