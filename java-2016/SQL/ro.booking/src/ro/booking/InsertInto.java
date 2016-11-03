package ro.booking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

/**
 * This test, insert into DB with the help of PreparedStatement.
 * 
 * @author Ovidiu
 *
 */

public class InsertInto {

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

		String insertIntoAccomodation = "INSERT INTO ACCOMODATION"
				+ "(ID, TYPE, BED_TYPE, MAX_GUESTS, DESCRIPTION) VALUES" + "(?, ?, ?, ?, ?)";

		try (PreparedStatement ps = conn.prepareStatement(insertIntoAccomodation)) {
			ps.setInt(1, 5);
			ps.setString(2, "DOUBLE");
			ps.setString(3, "DOUBLE");
			ps.setInt(4, 2);
			ps.setString(5, "NICE ONE");

			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Cannot execute query: " + e.getMessage());
		}

		String insertIntoRoomFair = "INSERT INTO ROOM_FAIR" + "(ID, VALUE, SEASON) VALUES" + "(?, ?, ?)";

		try (PreparedStatement ps = conn.prepareStatement(insertIntoRoomFair)) {
			ps.setInt(1, 5);
			ps.setDouble(2, 50.00);
			ps.setString(3, "SUMMER");

			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Cannot execute query: " + e.getMessage());
		}
		String insertIntoAccomodationFairRelation = "INSERT INTO ACCOMODATION_FAIR_RELATION"
				+ "(ID, ID_ACCOMODATION, ID_ROOM_FAIR) VALUES" + "(?, ?, ?)";

		try (PreparedStatement ps = conn.prepareStatement(insertIntoAccomodationFairRelation)) {
			ps.setInt(1, 5);
			ps.setInt(2, 5);
			ps.setInt(3, 5);

			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Cannot execute query: " + e.getMessage());
		}

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
