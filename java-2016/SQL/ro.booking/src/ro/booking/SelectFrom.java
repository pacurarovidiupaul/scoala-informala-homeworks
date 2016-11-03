package ro.booking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

/**
 * This test, is joining two tables based on the third one.
 * 
 * @author Ovidiu
 *
 */

public class SelectFrom {

	@Test
	public void test() {

		try {
			Class.forName("org.postgresql.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection conn = connect("postgresql", "localhost", 5432, "Booking", "postgres", "Z80Spectrum");

		if (conn == null)
			return;

		String sqlQuery = "select accomodation.type, room_fair.value from accomodation,room_fair,accomodation_fair_relation"
				+ " where accomodation_fair_relation.id=room_fair.id and accomodation.id = room_fair.id";
		final String format = "%20s%20s\n";

		try (PreparedStatement ps = conn.prepareStatement(sqlQuery)) {

			try (ResultSet rs = ps.executeQuery()) {

				boolean hasResults = rs.next();
				if (hasResults) {
					System.out.format(format, "type", "value");
					do {
						System.out.format(format, rs.getString("type"), rs.getString("value"));
					} while (rs.next());
				} else {
					System.out.println("No results");
				}
			} catch (SQLException e) {
				System.err.println("Cannot execute query: " + e.getMessage());
			}

		} catch (SQLException e) {
			System.err.println("Cannot execute query: " + e.getMessage());
		}

		try {
			conn.close();
		} catch (SQLException e) {
		}
		// }
	}

	private static Connection connect(String type, String host, int port, String dbName, String user, String pw) {

		Connection conn = null;
		DriverManager.setLoginTimeout(60);
		try {
			String url = new StringBuilder().append("jdbc:").append(type).append("://").append(host).append(":")
					.append(port).append("/").append(dbName).append("?user=").append(user).append("&password=")
					.append(pw).toString();

			System.out.println("URL:" + url);
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.err.println("Cannot connect to the database: " + e.getMessage());
		}

		return conn;
	}

}
