package bruteforce.persistence.hsqldb;

import android.annotation.TargetApi;

import java.io.Serializable;
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
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    /**
     fromResultSet(final ResultSet rs)

     Purpose: covert the result form hsql database to account object
     Parameters: final Result rs
     Returns: Account
     */
    private Account fromResultSet(final ResultSet rs) throws SQLException{
        final String userName = rs.getString("userName");
        final String passWord = rs.getString("passWord");
        final int points = rs.getInt("points");
        final int waterLevel = rs.getInt("waterlevel");
        final int growthLevel = rs.getInt("growthlevel");
        return new Account(userName,passWord,points,waterLevel,growthLevel);
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
            final PreparedStatement statement = connection.prepareStatement("INSERT INTO accounts Values(?,?,?,?,?)");
            statement.setString(1,currentAccount.getUsername());
            statement.setString(2,currentAccount.getPassword());
            statement.setInt(3,currentAccount.getPoints());
            statement.setInt(4,currentAccount.getPlant().getWaterLevel());
            statement.setInt(5,currentAccount.getPlant().getGrowthLevel());
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
            final PreparedStatement statement = connection.prepareStatement("UPDATE accounts SET password = ?, points = ?, waterlevel = ?, growthlevel = ? WHERE userName = ?");
            statement.setString(1, currentAccount.getPassword());
            statement.setInt(2,currentAccount.getPoints() );
            statement.setInt(3,currentAccount.getPlant().getWaterLevel());
            statement.setInt(4,currentAccount.getPlant().getGrowthLevel());
            statement.setString(5, currentAccount.getUsername());
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
            final PreparedStatement st = connection.prepareStatement("DELETE FROM accounts WHERE userName = ?");
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
            Account account = null;
            if (resultSet.next())
                account = fromResultSet(resultSet);
            return account;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }
}
