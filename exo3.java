import java.io.*;
class exo3{
	public static void main(String [] args){
		final String FILE_NAME;
		final String FOLOWING_BYTE_TO_FIND;
		FileInputStream fis;
		File file;
		int count;
		int lastIndex;

		if( args.length == 0){
			System.out.println("missed parameter: exo3 [File name] [Bytes to find]");
			return;
		}

		FILE_NAME = args[0];
		FOLOWING_BYTE_TO_FIND = args[1];

		String [] bytes = FOLOWING_BYTE_TO_FIND.split(",");

		file = new File(FILE_NAME);

		if ( !file.exists() ){
			System.out.println("file does not exist");
			return;
		}

		try {
			fis = new FileInputStream(file);
			
		} catch( IOException e ){
			System.out.println("Err : " + e.getMessage());
		}
	}
}