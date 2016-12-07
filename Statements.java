
public class Statements {

	Statement stmt;
	Statements stmts;
	
	public Statements(){
		stmt=new Statement();
		//System.out.println("nextToken="+Token.toString(Lexer.nextToken));
		if(Lexer.nextToken==Token.ID||Lexer.nextToken==Token.LEFT_BRACE||Lexer.nextToken==Token.KEY_IF||Lexer.nextToken==Token.KEY_FOR)//have statements following
			stmts=new Statements();
	}
}
