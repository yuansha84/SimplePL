
public class Code {
	static String[] code = new String[100];
	static int codeptr = 0;
	
	public static void gen(String s) {
		code[codeptr] = s;
		codeptr++;
	}
	
	public static int getPtr(){
		return codeptr;
	}
	
	public static void setPtr(int p){
		codeptr=p;
	}
	
	public static String getCode(int p){
		if(p>=0&&p<codeptr)
			return code[p];
		else return "";
	}
	
	public static void backpatch(int ptr,String str){
		if(ptr<0){//error
			System.out.println("Wrong back position,should be assigned a correct position!");
			System.exit(-1);
		}
		code[ptr]=str;
	}
	
	//deprecated
	/*public static String intcode(int i) {
		if (i > 127) return "sipush " + i;
		if (i > 5) return "bipush " + i;
		return "iconst_" + i;
	}*/
	
	public static String opcode(char op) {
		switch(op) {
		case '+' : return "iadd";
		case '-':  return "isub";
		case '*':  return "imul";
		case '/':  return "idiv";
		default: return "";
		}
	}
	
	/*public static String idcode(int id){
		if(id==-1){//error,identifier is not declared
			System.out.println("Identifier is not declared!");
			System.exit(-1);
		}
		if(id<=3)
		return "iload_"+id;
		else return "iload "+id;
	}*/
	
	public static void output() {
		for (int i=0; i<codeptr; i++)
			if(code[i].equals("iload ")||code[i].equals("istore ")||code[i].equals("bipush ")){
				String op=code[i+1];
				System.out.println(i+": "+code[i]+op);
				i++;
			}else if(code[i].equals("sipush ")||code[i].equals("goto ")||code[i].startsWith("if_icmp")){
				String op=code[i+1];
				System.out.println(i+": "+code[i]+op);
				i+=2;
			}else
			System.out.println(i+": "+code[i]);
	}
}
