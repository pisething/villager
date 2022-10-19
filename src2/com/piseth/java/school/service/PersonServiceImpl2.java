package com.piseth.java.school.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.piseth.java.school.model.Person2;

public class PersonServiceImpl2 implements PersonService2{
	
	DbConnection dbcon = new DbConnection();
	Connection con = dbcon.DbConnect();
	PreparedStatement pstm;
	ResultSet rs;
	
	@Override
	public Map<String, Integer> countNumberOfPeopleByGender() throws SQLException {		
		pstm = con.prepareStatement("SELECT gender, count(DISTINCT name) FROM villagers GROUP BY gender");
		rs = pstm.executeQuery();
		Map<String, Integer> mapGender = new LinkedHashMap<>();
		while (rs.next()) {
			mapGender.putIfAbsent(rs.getString(1), rs.getInt(2));
		}
		return mapGender;		
	}

	@Override
	public List<Person2> findByNumberOfPetMoreThan(int minNum) throws SQLException {
		pstm = con.prepareStatement("SELECT a.name, a.gender, a.age, string_agg(b.type, ',') pet_list "
				+ "FROM villagers a, pets b "
				+ "WHERE a.pet_id = b.id "
				+ "GROUP BY a.name, a.gender, a.age "
				+ "HAVING COUNT(*) > ?");
		pstm.setInt(1, minNum);
		return listOfPeople();
	}

	@Override
	public List<Person2> findByPetType(String pet) throws SQLException {
		pstm = con.prepareStatement("SELECT a.* FROM ("
				+ "SELECT a.name, a.gender, a.age, string_agg(b.type, ',') pet_list FROM villagers a, pets b "
				+ "WHERE a.pet_id = b.id "
				+ "GROUP BY a.name, a.gender, a.age) a "
				+ "WHERE a.pet_list ILIKE ?");
		pstm.setString(1, "%"+ pet +"%");
		return listOfPeople();
	}
	
	//Get list of people
	private List<Person2> listOfPeople() throws SQLException{
		rs = pstm.executeQuery();
		ArrayList<Person2> personList = new ArrayList<>();
		while (rs.next()) {
			Person2 person = new Person2(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
			personList.add(person);
		}
		return personList;
	}
	//

	@Override
	public String mostFavouriteGenderToHavePet(String pet) throws SQLException {
		pstm = con.prepareStatement("SELECT a.gender FROM ("
				+ "SELECT gender, count(*) total_person FROM villagers "
				+ "WHERE pet_id = (SELECT id FROM pets WHERE type ILIKE ?) "
				+ "GROUP BY gender) a "
				+ "ORDER BY total_person DESC "
				+ "LIMIT 1");
		pstm.setString(1, pet);
		rs = pstm.executeQuery();
		String gender = null;
		if (rs.next()) {
			gender = rs.getString(1);
		}
		return gender;
	}

	@Override
	public boolean hasPersonWhoDoesNotHavePet() throws SQLException {
		pstm = con.prepareStatement("SELECT EXISTS (SELECT * FROM villagers WHERE pet_id IS NULL)");
		rs = pstm.executeQuery();
		boolean noPet = false;
		if (rs.next()) {
			noPet = rs.getBoolean(1);
		}
		return noPet;
	}

	@Override
	public Person2 youngestPerson() throws SQLException {
		pstm = con.prepareStatement("SELECT * FROM villagers ORDER BY age ASC LIMIT 1");
		rs = pstm.executeQuery();
		Person2 youngest = null;
		if (rs.next()) {
			youngest = new Person2(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
		}
		return youngest;
	}

}
