package ims.tests;

import java.sql.SQLException;

import ims.repository.Repository;

public class TestRepository extends Repository {

	public void cleanUp() {
		String sp = "Call CleanUp";
		try {
			callStoredProcedure(sp);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
