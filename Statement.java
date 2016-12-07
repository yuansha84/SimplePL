
public class Statement {

	Assignment assign;
	Compound cmpd;
	Conditional cond;
	Loop loop;
	
	public Statement(){
		if(Lexer.nextToken==Token.ID){//assignment
			assign=new Assignment();
			Lexer.lex();//skip ';'
		}
		else if(Lexer.nextToken==Token.LEFT_BRACE)//compound
			cmpd=new Compound();
		else if(Lexer.nextToken==Token.KEY_IF)//conditional
			cond=new Conditional();
		else if(Lexer.nextToken==Token.KEY_FOR)//loop
			loop=new Loop();
		else {
			//error detection here
		}
	}
}
