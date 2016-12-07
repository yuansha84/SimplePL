
public class Factor {
	Expression e;
	int i;
	int id;

	public Factor() {
		switch (Lexer.nextToken) {
		case Token.INT_LIT: // number
			i = Lexer.intValue;
			if (i > 127){//take three bytes
				Code.gen("sipush ");
				Code.gen(Integer.toString(i));
				Code.gen("");
			}else if (i > 5){//take two bytes
				Code.gen("bipush ");
				Code.gen(Integer.toString(i));
			}else Code.gen("iconst_" + i);
			Lexer.lex();
			break;
		case Token.LEFT_PAREN: // '('
			Lexer.lex();
			e = new Expression();
			Lexer.lex(); // skip over ')'
			break;
		case Token.ID:
			char ident=Lexer.ident;
			id=Idlist.idnum[ident-'a'];
			if(id<4)
				Code.gen("iload_"+id);
			else{
				Code.gen("iload ");
				Code.gen(Integer.toString(id));
			}
			Lexer.lex();		
		default:
			break;
		}
	}
}
