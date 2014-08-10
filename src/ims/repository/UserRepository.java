package ims.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import ims.domain.User;

public class UserRepository extends Repository {

	public void addUser(User user) {
		String sp = "Call addUser(?,?)";
		try {
			callStoredProcedure(sp, user.getEmail(), user.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public User findUserByEmail(String email) {
		String sp = "Call findUserByEmail(?)";
		User user = null;
		try {
			ResultSet rs = callStoredProcedureWithResultSet(sp, email);
			rs.next();
			user = new User();
			user.setId(rs.getInt("id"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
