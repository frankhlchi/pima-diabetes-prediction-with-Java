package extrapackage;
import java.math.BigDecimal;
import java.util.ArrayList;


public class ArrayPriorityQueue implements PriorityQueue{
	
	

	private ArrayList<PriorityQueueNode> queue;
	
	public ArrayPriorityQueue(){
		queue = new ArrayList<PriorityQueueNode>();
	}

	@Override
	public void insert(Integer key, double value) {
		queue.add(new PriorityQueueNode(key, value));
		
	}

	@Override
	public Object removeMin() {
		int size = queue.size();
		int index = 0;
		int min = queue.get(0).key;
		Object minobject;
		for (int i =1 ; i<size; i++){
			if(min > queue.get(i).key){
				min = queue.get(i).key;
				index =i;
			}		
		}
		minobject = queue.get(index).value;
		queue.remove(index);
		return minobject;
	}

	@Override
	public Integer min() {
		int size = queue.size();
		int index = 0;
	    double min = queue.get(0).value;
		Integer minkey;
		for (int i =1 ; i<size; i++){
			if(min > queue.get(i).value){
				min = queue.get(i).value;
				index =i;
			}		
		}
		minkey = queue.get(index).key;
		queue.remove(index);
		return minkey;
	}

	@Override
	public int size() {
		
		return queue.size();
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	class PriorityQueueNode implements Comparable<PriorityQueueNode>{
		 public Integer key;
	     public double value;
	     
	     public PriorityQueueNode(Integer key,double value){
	    	 this.key=key;
	    	 this.value =value;   	 
	    	 
	     }

		@Override
		public int compareTo(PriorityQueueNode arg0) {
			// TODO Auto-generated method stub
			return this.key.compareTo(arg0.key);
		}
	}

}
