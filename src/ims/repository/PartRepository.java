package ims.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Part findPartById(int id) {
		String sp = "Call findPartByID(?)";
		try {
			ResultSet rs = callStoredProcedureWithResultSet(sp, id);
			rs.next();
			Part part = new Part();
			part.setId(rs.getInt("id"));
			part.setName(rs.getString("Name"));
			part.setQuantity(rs.getInt("Quantity"));
			part.setPrice(rs.getDouble("Price"));
			return part;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updatePart(Part part) {
		String sp = "Call updatePart(?,?,?,?)";
		try {
			callStoredProcedure(sp, part.getId(), part.getName(), part.getQuantity(), part.getPrice());
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletePart(int id) {
		String sp = "Call deletePart(?)";
		try {
			callStoredProcedure(sp, id);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Part> getAllParts() {
		String sp ="Call getAllParts";
		List<Part> parts = new ArrayList<Part>();
		try {
			ResultSet rs = callStoredProcedureWithResultSet(sp);
			while(rs.next()) {
				Part p = new Part();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setQuantity(rs.getInt("quantity"));
				p.setPrice(rs.getDouble("price"));
				parts.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return parts;
	}
}
