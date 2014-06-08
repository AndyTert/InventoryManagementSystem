package ims.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import ims.domain.Part;

public class PartRepository extends Repository {

	public void addPart(Part part) {
		String sp = "Call insertPart(?,?,?)";
		try {
			callStoredProcedure(sp, part.getName(), part.getQuantity(), part.getPrice());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Part findPartByName(String name) {
		String sp = "Call findPartByName(?)";
		try {
			ResultSet rs = callStoredProcedureWithResultSet(sp, name);
			rs.next();
			Part part = new Part();
			part.setId(rs.getInt("id"));
			part.setName(rs.getString("Name"));
			part.setQuantity(rs.getInt("Quantity"));
			part.setPrice(rs.getDouble("Price"));
			return part;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
