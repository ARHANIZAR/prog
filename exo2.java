class exo2{
	public static void main(String [] args){
		final String FILE_NAME;
		final String WORD_TO_FIND;
		String str;
		int count;
		BufferedReader br;

		if ( args.lentgh == 0 ){
			System.out.println("set valid parameters: java exo2 [file name] [the word to find] ");
			return;
		}

		FILE_NAME = args[0];
		WORD_TO_FIND = args[1];
		try {

			if(!file.isExists()){
				System.out.println("File does not exist !!");
				return;
			}

			br = new BufferedReader(new FileReader(FILE_NAME));

			str = br.read
		}catch(IOException e){
			System.out.println("Err : "+ e.getMessage());
		}



	}
}