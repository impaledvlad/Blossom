package bruteforce.persistence.stubs;

import java.util.ArrayList;

public class TaskPersistenceStub implements TaskPersistence {
	
	private List<Task> tasks;
	
	public TaskPersistenceStub() {
		this.tasks = new ArrayList<>();
		
		tasks.add(new Task("Task1", "username1", new Date(2019, 06, 20), false, 1));
		tasks.add(new Task("Task2", "username1", new Date(2019, 07, 20), true, 2));
		
	}
	
	void insertTask(Task currentTask) {
		tasks.add(currentTask);
	}

    Task updateTask(Task currentTask) {
    	
    }

    void deleteTask(Task currentTask) {
    	
    }
}