package bruteforce.persistence.stubs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bruteforce.persistence.TaskPersistence;
import bruteforce.objects.Task;
public class TaskPersistenceStub implements TaskPersistence {
	
	private List<Task> tasks;
	
	public TaskPersistenceStub() {
		this.tasks = new ArrayList<>();
		
		tasks.add(new Task("Task1", "username1", new Date(2019, 06, 20), false, 1));
		tasks.add(new Task("Task2", "username1", new Date(2019, 07, 20), true, 2));
		
	}
	
	public void insertTask(Task currentTask) {
		tasks.add(currentTask);
	}

    public Task updateTask(Task currentTask) {
    	return null;
    }

    public void deleteTask(Task currentTask) {
    	
    }
}