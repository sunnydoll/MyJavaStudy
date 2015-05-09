/*
Student: Zhichao Cao
Email: zc77@drexel.edu
Class: CS 576 - Dependable Software System
Project: Stable Priority Queue 
*/

import java.util.ArrayList;


public class PriorityQueue{
	
	private int length;	//The length of queue
	
	private ArrayList<QueueElement> qList;
    
    protected int indexCount = 0;
    
    //The order of this priority queue is descending
    
    public PriorityQueue() {    	
    	//Constructor of Priority Queue,
    	//the bigger number stand for higher priority in my priority queue.
        qList = new ArrayList<QueueElement>();
        length = 0;
    }
    
	public boolean insert(int p) {
		//Insert an element with the binary search for its position, whose running time is logn
		//And the priority number should be larger than 0
		if(p >= 0) {
			int mid = 0;
			int start = 0;
			int end = qList.size();  //The pair of start and end are the two delimiters for binary search
			QueueElement le = new QueueElement(p);
			if(qList.size() == 0) {			
				qList.add(le);
			}
			else if(qList.size() == 1) {
				if(p == qList.get(0).prio) {
					qList.get(0).equivList.add(0, le);
				}
				else if(p > qList.get(0).prio) {
					qList.add(1, le);
				}
				else {
					qList.add(0, le);
				}
			}
			else {
				if(p < qList.get(0).prio) {
					qList.add(0, le);
				}
				else if(p > qList.get(qList.size() - 1).prio) {
					qList.add(le);
				}
				else if(p == qList.get(0).prio) {
					qList.get(0).equivList.add(le);
				}
				else if(p == qList.get(qList.size() - 1).prio) {
					qList.get(qList.size() - 1).equivList.add(le);
				}
				else {
					while(start <= end) {
						mid = (start + end) / 2;
						if(p > qList.get(mid).prio) {
							start = mid;
						}
						else if(p < qList.get(mid).prio) {
							end = mid;
						}
						else {
							qList.get(mid).equivList.add(le);
							break;
						}
						
						if(start == end - 1) {
							if(p < qList.get(end).prio && p > qList.get(start).prio) {
								qList.add(end, le);
								break;
							}
							else {
								continue;
							}
						}
					}
				}
				
			}
			length++;
			return true;
		}
		else {
			System.out.println("Please use positive number to represent priority, thanks.");
			return false;
		}
	}
	
	public int extractMax() {
		//Remove and return the largest key from the queue
		int max = -1;
		if(qList.size() > 0) {
			max = qList.get(qList.size() - 1).prio;
			if(qList.get(qList.size() - 1).equivList.size() > 0) {
				qList.get(qList.size() - 1).timeStamp = qList.get(qList.size() - 1).equivList.get(0).timeStamp;
				qList.get(qList.size() - 1).equivList.remove(0);
			}
			else {
				qList.remove(qList.size() - 1);
			}
			length--;
			return max;
		}
		else {			
			return max;
		}		
	}
	
	public int extractMin() {
		//Remove and return the the smallest key from the queue
		int min = -1;
		if(qList.size() > 0) {
			min = qList.get(0).prio;
			if(qList.get(0).equivList.size() > 0) {
				qList.get(0).timeStamp = qList.get(0).equivList.get(0).timeStamp;
				qList.get(0).equivList.remove(0);
			}
			else {
				qList.remove(0);
			}
			length--;
			return min;
		}
		else {			
			return min;
		}		
	}
	
	public int returnMin() {
		//Remove and return the the smallest key from the queue
		int min = -1;
		if(qList.size() > 0) {
			min = qList.get(0).prio;
			return min;
		}
		else {			
			return min;
		}		
	}
	
	public int returnMax() {
		//Remove and return the largest key from the queue
		int max = -1;
		if(qList.size() > 0) {
			max = qList.get(qList.size() - 1).prio;			
			return max;
		}
		else {			
			return max;
		}		
	}
	
	public int size() {
		return length;
	}
	
//	public boolean printQueue() {
//		//Print the queue
//		System.out.println("Length: " + length);
//		for(int i = 0; i < qList.size(); i++) {
//			System.out.println("Priority: " + qList.get(i).prio 
//					+ "Time Stamp:" + qList.get(i).timeStamp);
//			for(int j = 0; j < qList.get(i).equivList.size(); j++) {
//				System.out.println("Priority: " + qList.get(i).equivList.get(j).prio
//						+ "Time Stamp:" + qList.get(i).equivList.get(j).timeStamp);
//			}
//		}
//		
//		return true;
//	}
	
	//Class for Linking array, the element in the queue can point to its previous and next element
	public class QueueElement {
        
        int prio;	//The bigger number stand for higher priority
        int timeStamp;
        ArrayList<QueueElement> equivList;  //Saving the equal element in order to make queue stable
        
        public QueueElement(int p) {
        	//Priority of element in the queue
        	equivList = new ArrayList<QueueElement>();
            prio = p;
            indexCount++;
            timeStamp = indexCount;
        }
    }
    
}
