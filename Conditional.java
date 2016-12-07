
public class Conditional {

	ComparisonExpr cpr;
	Statement stmt;
	Statement stmtr;//the Compound in else
	
	public Conditional(){
		int m,n;
		Lexer.lex();//skip over "if"
		Lexer.lex();//skip over '('
		cpr=new ComparisonExpr();
		Lexer.lex();//skip over ')'
		switch(cpr.op){
		case '<':
			Code.gen("if_icmpge ");
			break;
		case '>':
			Code.gen("if_icmple ");
			break;
		case '=':
			Code.gen("if_icmpne ");
			break;
		case '!':
			Code.gen("if_icmpeq ");
			break;
		default:
			break;
		}
		n=Code.getPtr();
		Code.gen("");
		Code.gen("");
		stmt=new Statement();
		if(Lexer.nextToken==Token.KEY_ELSE){//have an else part
			Code.gen("goto ");
			m=Code.getPtr();
			Code.gen("");
			Code.gen("");
			Code.backpatch(n, Integer.toString(Code.getPtr()));
			Lexer.lex();
			stmtr=new Statement();
			Code.backpatch(m, Integer.toString(Code.getPtr()));
		}else{
			Code.backpatch(n, Integer.toString(Code.getPtr()));
		}
		
	}
	
	
}
