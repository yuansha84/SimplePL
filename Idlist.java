
public class Idlist {

	static int[] idnum=new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};//identifier number
	Idlist lst;
	static int start=1;

	public Idlist(){
		char ch=Lexer.ident;
		idnum[ch-'a']=start;
		start++;
		Lexer.lex();
		if(Lexer.nextToken==Token.COMMA){
			Lexer.lex();
			lst=new Idlist();
		}
	}
}
