package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
/**
 * The Class DriverManagerConnectionPool.
 */
public class DriverManagerConnectionPool {

	
    /** The free db connections. */
    private static List<Connection> freeDbConnections;

    static {
        freeDbConnections = new LinkedList<Connection>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("DB driver not found:" + e.getMessage());
        }
    }

    
    /**
     * Instantiates a new driver manager connection pool.
     */
    private DriverManagerConnectionPool() {
    }
    /**
     * Creates the DB connection.
     *
     * @return the connection
     * @throws SQLException the SQL exception
     */
    private static synchronized Connection createDBConnection() throws SQLException {
        Connection newConnection = null;

        newConnection = DriverManager.getConnection("jdbc:mysql://localhost/rui?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&" + "user=root&password=salvo96");

		newConnection.setAutoCommit(true);
		
		return newConnection;
	}

	// medoto della classe per ottenere la connessione

    /**
	 * Gets the connection.
	 *
	 * @return the connection
	 * @throws SQLException the SQL exception
	 */
	public static synchronized Connection getConnection() throws SQLException {
		Connection connection;

		if (!freeDbConnections.isEmpty()) {
			connection = (Connection) freeDbConnections.get(0);
			freeDbConnections.remove(0);

			try {
                if (connection.isClosed()) {
					connection = getConnection();
                	}
                } catch (SQLException e) {
				connection.close();
				connection = getConnection();
			}
		} else {
			connection = createDBConnection();
		}

		return connection;
	}

    /**
     * Release connection.
     *
     * @param connection the connection
     * @throws SQLException the SQL exception
     */
    public static synchronized void releaseConnection(Connection connection) throws SQLException {
        if (connection != null) {
			freeDbConnections.add(connection);
        }
	}
}
