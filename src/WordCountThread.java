import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class WordCountThread {
	static HashMap<String,Integer> wordMap = new HashMap<String, Integer>();
	public static void main(String []args) throws IOException, InterruptedException{
			
			FileReader f = new FileReader("ParaText.txt");
		    BufferedReader br = new BufferedReader(f) ;
		    String line = br.readLine();
		   // Thread readerThread = new WorkerThread();
		    
		    while(line!= null){
		    	String[] words = line.split(" ");
		    	Thread readerThread = new WorkerThread(words,wordMap);
		    	readerThread.start();
		    	readerThread.join();
		    	line= br.readLine();
		    	
		    }
		    displayWordMap();
	
	}

	private static void displayWordMap() {
		Set<String> keys = wordMap.keySet();
		for(String i : keys)
		   System.out.println("\n"+i+"--->"+wordMap.get(i));	
	}
	

}
