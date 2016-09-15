import java.io.*;

class exo2{
	public static void main(String [] args){

		final String FILE_NAME;
		final String WORD_TO_FIND;
		String str;
		int count = 0;
		BufferedReader br;
		File file;
		int lastIndex;

		if ( args.length < 2 ){
			System.out.println("set valid parameters: java exo2 [file name] [the word to find] ");
			System.exit(1);
		}

		FILE_NAME = args[0];
		WORD_TO_FIND = args[1];
		
		file = new File(FILE_NAME);

		try {
			if(!file.exists()){
				System.out.println("File does not exist !!");
				System.exit(1);
			}
		} catch(SecurityException e){
			System.out.println("Err exits() method : " + e.getMessage());
		}


		try {

			br = new BufferedReader(new FileReader(file));
			boolean stop = false;

			do {
				str = br.readLine();
				if (str == null){
					stop = true;
					str = "";
				}
				lastIndex = 0;
				while (lastIndex != -1){
					lastIndex = str.indexOf(WORD_TO_FIND,lastIndex);

					if(lastIndex != -1){
						count++;
						lastIndex += WORD_TO_FIND.length();
					}
				}

			}while (!stop);
			br.close();

			System.out.println("the file " + FILE_NAME + "has " + count + " occurence of the word " + WORD_TO_FIND);

		}catch(IOException e){
			System.out.println("Err : "+ e.getMessage());
		}



	}
}