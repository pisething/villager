package com.piseth.java.school.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.piseth.java.school.model.Person2;

public interface PersonService2 {
	//-------------------------------------Exercise No.3-------------------------------------------//
		Map<String, Integer> countNumberOfPeopleByGender() throws SQLException;
		
		List<Person2> findByNumberOfPetMoreThan(int minNum) throws SQLException;

		List<Person2> findByPetType(String pet) throws SQLException;

		String mostFavouriteGenderToHavePet(String pet) throws SQLException;

		boolean hasPersonWhoDoesNotHavePet() throws SQLException;

		Person2 youngestPerson() throws SQLException;
}
