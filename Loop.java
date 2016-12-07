
public class Loop {

	Assignment assign;
	ComparisonExpr rexp;
	Assignment inc;
	Statement stmt;
	String[] buf4inc;
	public Loop(){
		int m=-1,n=-1;
		int inc_start=-1,inc_end=-1;
		boolean test=false,incr=false;
		Lexer.lex();//skip over "for"
		Lexer.lex();//skip over '('
		if(Lexer.nextToken!=Token.SEMICOLON){//have init assignment
			assign=new Assignment();
			
		}
		n=Code.getPtr();
		Lexer.lex();//skip over ';'
		if(Lexer.nextToken!=Token.SEMICOLON){//have comparison
			test=true;
			rexp=new ComparisonExpr();
			switch(rexp.op){
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
			m=Code.getPtr();
			Code.gen("");
			Code.gen("");
		}
		Lexer.lex();//skip over ';' to inc part
		if(Lexer.nextToken!=Token.RIGHT_PAREN){//have inc part
			incr=true;
			buf4inc=new String[100];
			inc_start=Code.getPtr();
			inc=new Assignment();
			inc_end=Code.getPtr();
			for(int i=0;i<inc_end-inc_start;i++)
				buf4inc[i]=Code.getCode(i+inc_start);
			Code.setPtr(inc_start);
		}
		//System.out.println("nextToken="+Token.toString(Lexer.nextToken)+Lexer.ident);
		Lexer.lex();
		
		stmt=new Statement();
		if(incr){//have inc
			for(int i=0;i<inc_end-inc_start;i++)
				Code.gen(buf4inc[i]);
		}
		Code.gen("goto ");
		Code.gen(Integer.toString(n));
		Code.gen("");
		if(test){//have test
			Code.backpatch(m, Integer.toString(Code.getPtr()));
		}
	}
}
