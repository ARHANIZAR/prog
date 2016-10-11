import java.io.*;
class exo1{
	public static void main(String [] args){
		BufferedReader br;
		BufferedWriter bw;
		String str;
		final String FILE_NAME;
		File file;
		try {

			if(args.length == 0 || args.length > 1 ){
				System.out.println("set valid parameters ");
				return;
			}
			FILE_NAME = args[0];
			file = new File(FILE_NAME);

			if(!file.exists()){
				System.out.println("file does not exist");
				return;
			}

		 	br = new BufferedReader(new InputStreamReader(System.in));
		 	bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));

			do{
				str = br.readLine();
				bw.write(str);

			}while(!str.equals("") && str != null);

			bw.close();

		}catch(IOException e){
			System.out.println("err : "+e.getMessage());
		}
	}
}