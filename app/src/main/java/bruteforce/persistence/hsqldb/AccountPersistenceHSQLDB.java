package bruteforce.persistence.hsqldb;

import android.annotation.TargetApi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bruteforce.objects.Account;
import bruteforce.persistence.AccountPersistence;

public class AccountPersistenceHSQLDB implements AccountPersistence{

    private final String dbPath;

    public AccountPersistenceHSQLDB(final String dbPath){
        this.dbPath= dbPath;
    }

    /**
     connection()

     Purpose: connect to the hsql database
     Parameters: None
     Returns: Connection
     */
    private Connection connection() throws SQLException{
        return DriverManager.getConnection("jbdc:hsql:file" + dbPath + ";shutdown=true","sa","");
    }

    /**
     fromResultSet(final ResultSet rs)

     Purpose: covert the result form hsql database to account object
     Parameters: final Result rs
     Returns: Account
     */
    private Account fromResultSet(final ResultSet rs) throws SQLException{
        final String userName = rs.getString("useName");
        final String passWord = rs.getString("passWord");
        final int points = rs.getInt("points");
        return new Account(userName,passWord,points);
    }

    /**
     insertAccount

     Purpose: insert a new account to our database
     Parameters: Account currentAccount
     Returns: None
     */
    @Override
    @TargetApi(19)
    public void insertAccount(Account currentAccount){
        try(final Connection connection=connection()){
            final PreparedStatement statement = connection.prepareStatement("INSERT INTO accounts Value(?,?,?)");
            statement.setString(1,currentAccount.getUsername());
            statement.setString(2,currentAccount.getPassword());
            statement.setInt(3,currentAccount.getPoints());
            statement.execute();
        }catch (final SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    /**
     updateAccount

     Purpose: update an account in our database
     Parameters: Account currentAccount
     Returns: boolean true if success,
     */
    @Override
    @TargetApi(19)
    public boolean updateAccount(Account currentAccount) {
        try (final Connection connection = connection()) {
            final PreparedStatement statement = connection.prepareStatement("UPDATE accounts SET password = ?, points = ? WHERE userName = ?");
            statement.setString(1, currentAccount.getPassword());
            statement.setInt(2,currentAccount.getPoints() );
            statement.setString(3, currentAccount.getUsername());
            statement.executeUpdate();
            return true;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    /**
     deleteAccount

     Purpose: delete an account in database
     Parameters: Account currentAccount
     Returns: boolean true if success, false if not
     */
    @Override
    @TargetApi(19)
    public boolean deleteAccount(Account currentAccount) {
        try (final Connection connection = connection()) {
            final PreparedStatement statement = connection.prepareStatement("DELETE FROM tasks WHERE userName = ?");
            statement.setString(1, currentAccount.getUsername());
            statement.executeUpdate();
            final PreparedStatement st = connection.prepareStatement("DELETE FROM accounts WHERE studentID = ?");
            st.setString(1, currentAccount.getUsername());
            st.executeUpdate();
            return true;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    /**
     getAccount

     Purpose: get an account with the given userName from database
     Parameters: String userName
     Returns: boolean true if success, false if not
     */
    @Override
    @TargetApi(19)
    public Account getAccount(String userName){
        try (final Connection connection = connection()) {
            final PreparedStatement statement = connection.prepareStatement("SELECT * FROM accounts WHERE userName = ?");
            statement.setString(1,userName);

            final ResultSet resultSet = statement.executeQuery();
            Account account = fromResultSet(resultSet);
            return account;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }
}
