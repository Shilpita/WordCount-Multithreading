import java.util.HashMap;

public class WorkerThread extends Thread {
	HashMap<String, Integer> threadWordMapper ;
    String[] threadWord ;
	public WorkerThread(String[] words, HashMap<String, Integer> wordMap) {
		this.threadWord= words;
		this.threadWordMapper = wordMap;	
	}
    public void run(){
    	for(int i = 0 ; i<threadWord.length; i++){
    		if(threadWordMapper.containsKey(threadWord[i]))
    			threadWordMapper.put(threadWord[i],threadWordMapper.get(threadWord[i])+1);
    		else
    			threadWordMapper.put(threadWord[i],1);
    	}
    }
}
