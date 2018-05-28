/*
 * http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_3_B&lang=jp
 */
import java.util.*;

class Task {
	String name;
	int time;
	int endTime;
	Task(String name, int time) {
		this.name = name;
		this.time = time;
	}
	void setEndTime(int x) {
		this.endTime = x;
	}
}

public class Main {
	
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int q = scan.nextInt();
		//Task[] tasks = new Task[n];
		LinkedList<Task> tasks = new LinkedList<Task>();
		for (int i = 0; i < n; i++) {
			String name = scan.next();
			int time = scan.nextInt();
			//tasks[i] = new Task(name, time);
			tasks.add(new Task(name, time));
		}

		Task[] result = new Task[n];
		int topOfResult = 0;
		
		int time = 0;
		int idx = 0;
		while (topOfResult < n) {
			Task task = tasks.pop();
			if (task.time > q) {
				task.time -= q;
				time += q;
				tasks.add(task);
			} else if (task.time > 0) {
				time += task.time;
				task.time = 0;
				task.setEndTime(time);
				result[topOfResult++] = task;
			}
			if (++idx >= n) idx = 0;
		}
		
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i].name + " " + result[i].endTime);
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}

}
