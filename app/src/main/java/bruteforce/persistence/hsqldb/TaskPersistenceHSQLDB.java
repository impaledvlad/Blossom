package bruteforce.persistence.hsqldb;

import android.annotation.TargetApi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bruteforce.persistence.TaskPersistence;
import bruteforce.objects.Task;
public class TaskPersistenceHSQLDB implements TaskPersistence{

    private final String dbPath;


    public TaskPersistenceHSQLDB(final String dbPath){
        this.dbPath = dbPath;
    }

    /**
     connection()

     Purpose: connect to the hsql database
     Parameters: None
     Returns: Connection
     */
    private Connection connection() throws SQLException{
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    /**
     fromResultSet(final ResultSet rs)

     Purpose: covert the result form hsql database to task object
     Parameters: final Result rs
     Returns: Task
     */
    private Task fromResultSet(final ResultSet rs) throws SQLException{
        final String userName = rs.getString("useName");
        final String passWord = rs.getString("name");
        final java.util.Date date = new java.util.Date(rs.getDate("deadline").getTime());
        final boolean complete = rs.getBoolean("completed");
        final int taskId = rs.getInt("taskID");
        final int priority = rs.getInt("priority");
        return new Task(userName,passWord,date,complete,priority);
    }


    /**
     insertTask

     Purpose: insert a new task to our database
     Parameters: Task currentTask
     Returns: None
     */
    @Override
    @TargetApi(19)
    public void insertTask(Task currentTask){
        try(final Connection connection=connection()){
            final PreparedStatement statement = connection.prepareStatement("INSERT INTO tasks Value(?,?,?,?,?,?)");
            statement.setString(1,currentTask.getUsername());
            statement.setString(2,currentTask.getName());
            statement.setDate(3,new java.sql.Date(currentTask.getDeadline().getTime()));
            statement.setBoolean(4,currentTask.getCompleted());
            statement.setInt(5,currentTask.getTaskID());
            statement.setInt(6,currentTask.getPriority());
            statement.execute();
        }catch (final SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    /**
     updateTask

     Purpose: update a task in our database
     Parameters: Task currentTask
     Returns: boolean true if success, false if not
     */
    @Override
    @TargetApi(19)
    public boolean updateTask(Task currentTask){
        try (final Connection connection = connection()) {
            final PreparedStatement statement = connection.prepareStatement("UPDATE tasks SET taskName = ?, date = ?, completed = ?, priority = ?, WHERE userName = ? AND taskId = ?");
            statement.setString(1,currentTask.getName());
            statement.setDate(2,new java.sql.Date(currentTask.getDeadline().getTime()));
            statement.setBoolean(3,currentTask.getCompleted());
            statement.setInt(4,currentTask.getPriority());
            statement.setString(5,currentTask.getUsername());
            statement.setInt(6,currentTask.getTaskID());
            statement.executeUpdate();
            return true;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    /**
     deleteTask

     Purpose: delete a task in our database
     Parameters: Task currentTask
     Returns: boolean true if success, false if not
     */
    @Override
    @TargetApi(19)
    public boolean deleteTask(Task currentTask){
        try (final Connection connection = connection()) {
            final PreparedStatement statement = connection.prepareStatement("DELETE FROM tasks WHERE userName = ? AND taskId = ?");
            statement.setString(1, currentTask.getUsername());
            statement.setInt(2,currentTask.getTaskID());
            statement.executeUpdate();
            return true;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    /**
     getTasks

     Purpose: get a list of task from that user in our database
     Parameters: String accountName
     Returns: List<Task>
     */
    @Override
    @TargetApi(19)
    public List<Task> getTasks(String accountName){
        List<Task> newTasks = new ArrayList<>();
        try (final Connection connection = connection()) {
            final PreparedStatement statement = connection.prepareStatement("SELECT * FROM tasks WHERE userName = ?");
            statement.setString(1, accountName);
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                newTasks.add(fromResultSet(resultSet));
            }
            return newTasks;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }
}
