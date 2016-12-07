
public class Declaration {

	Idlist idlist;
	
	public Declaration(){
		Lexer.lex();//skip "int"
		idlist=new Idlist();
		Lexer.lex();//skip ';'
	}
	
}
