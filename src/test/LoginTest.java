package test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

import common.configration.DBConfig;
import common.utils.Utils;
import login.LoginService;

public class LoginTest {

	private LoginService loginService;

	@Before
	public void initialization() {

		try {
			Connection conn = (Connection) DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME,
					DBConfig.DB_PASSWORD);

			String sql1 = "INSERT INTO  Staff(fullName, password, isPasswordUpdated, mobileNumber, email, createTime,workHourLimit, preferredName, homeAddress)VALUES('test','12345','1','0491000000','123@123.com','"
					+ Utils.getCurrentTime() + "','1','xxx','xxx')";
			Statement statement1 = conn.createStatement();
			statement1.executeUpdate(sql1);

			String sql2 = "INSERT INTO shiftManager(fullName, password, isPasswordUpdated, mobileNumber, email, createTime) VALUES('test2','12345','1','0491000000','123@123.com','"
					+ Utils.getCurrentTime() + "')";

			Statement statement2 = conn.createStatement();
			statement2.executeUpdate(sql2);

			conn.close();
			statement1.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}

		loginService = new LoginService();

	}

	@Test
	public void testStaffLogin_noExistEmail() {

		String email = "456@456.com";
		String password = "12345";
		String result = loginService.staffLogin(email, password);
		assertEquals("no such staff in database!", result);

	}

	@Test
	public void testStaffLogin_incorrectPassword() {

		String email = "123@123.com";
		String password = "123456";
		String result = loginService.staffLogin(email, password);
		assertEquals("the password entered is incorrect.", result);

	}

	@Test
	public void testStaffLogin_success() {

		String email = "123@123.com";
		String password = "12345";
		String result = loginService.staffLogin(email, password);
		assertEquals("000", result);

	}

	@Test
	public void testManagerLogin_noExistEmail() {

		String email = "456@456.com";
		String password = "12345";
		String result = loginService.managerLogin(email, password);
		assertEquals("no such manager in database!", result);

	}

	@Test
	public void testManagerLogin_incorrectPassword() {

		String email = "123@123.com";
		String password = "123456";
		String result = loginService.managerLogin(email, password);
		assertEquals("the password entered is incorrect.", result);

	}

	@Test
	public void testManagerLogin_success() {

		String email = "123@123.com";
		String password = "12345";
		String result = loginService.managerLogin(email, password);
		assertEquals("000", result);

	}
}
