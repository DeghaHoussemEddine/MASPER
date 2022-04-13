package application;

import java.util.LinkedList;
import java.util.Queue;

public class presses extends Thread {
	String id;
	int time;
	int t = 0;

	public presses(String s, int t) {
		id = s;
		time =t;
	}

	@Override
	public  void run() {

		System.out.println(" active processes in id= " + id);
		   while(this.time>0){
			   System.out.println("     temps restant  ="+this.time);
			   time--;
			   t++;
			   if(t==2){
			   this.suspend();
			   this.t=0;
			   System.out.println(" active processes in id= " + id);
			   }
		}
		
		   
	}

	public static void main(String[] args) throws InterruptedException {
		Queue<presses> l = new LinkedList<presses>();
		l.add(new presses("p1", 4));
		l.add(new presses("p2", 3));
		//l.add(new presses("p3", 7));
		while(!l.isEmpty()){
			presses p=l.remove();
			if(p.isAlive()){
				p.resume();
			}else{
				p.start();
			}
			Thread.sleep(1500);
			if(p.isAlive())l.add(p);
			else   System.out.println("finch precesses ="+p.id);
		}
		
		System.out.println( "end main");
	}

}
