import java.io.*;

public class Program {
	Declaration decls;
	Statements stmts;
	
	public Program(){
		decls=new Declaration();
		stmts=new Statements();
		if(Lexer.nextToken==Token.KEY_END)
			Code.gen("return");
	}
}
