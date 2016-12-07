//import java.lang.*;

public class Assignment {
	Expression expr;
	int idnum;
	public Assignment(){
		char ident=Lexer.ident;
		idnum=Idlist.idnum[ident-'a'];
		if(idnum==-1){
			//error
			System.out.println(ident+" is not declared!");
			System.exit(-1);
		}
		Lexer.lex();
		Lexer.lex();//skip over '='
		expr=new Expression();
		//Lexer.lex();//skip over ';'
		//System.out.println("nextToken="+Token.toString(Lexer.nextToken));
		if(idnum==-1){
			System.out.println(ident+" is not declared!");
			System.exit(-1);
		}else if(idnum<4)
		Code.gen("istore_"+idnum);
		else {
			Code.gen("istore ");
			Code.gen(Integer.toString(idnum));
		}
	}
}