package com.piseth.java.school;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.piseth.java.school.model.Person2;
import com.piseth.java.school.service.PersonService2;
import com.piseth.java.school.service.PersonServiceImpl2;

/******************************************************************************************
លំហាត់ទី៣

តាមរយៈលំហាត់ទី១ ចូរ Design Database ហើយដាក់ទិន្នន័យក្នុង table។
>> រាប់ចំនួនមនុស្សប្រុសនិងមនុស្សស្រី
>> តើអ្នកណាខ្លះចិញ្ចឹមសត្វលើសពី១ប្រភេទ?
>> អ្នកណាខ្លះចិញ្ចឹមឆ្មា?
>> តើប្រុសឬស្រីដែលចូលចិត្តចិញ្ចឹមឆ្មាជាងគេ?
>> តើមានអ្នកដែលអត់ចិញ្ចឹមសត្វដែរឬទេ?
>> មនុស្សដែលមានអាយុតិចជាងគេឈ្មោះអ្វី?​
  
******************************************************************************************/


public class PersonApplication2 {
	
	private final PersonService2 personService2 = new PersonServiceImpl2();

	public static void main(String[] args) {
		PersonApplication2 application = new PersonApplication2();
		try {
			//>> រាប់ចំនួនមនុស្សប្រុសនិងមនុស្សស្រី
			application.showNumberOfPeopleByGender2();		
			//>> តើអ្នកណាខ្លះចិញ្ចឹមសត្វលើសពី១ប្រភេទ?
			application.showNumberOfPetMoreThan2();
			//>> អ្នកណាខ្លះចិញ្ចឹមឆ្មា?
			application.showPeopleByPetType2();
			//>> តើប្រុសឬស្រីដែលចូលចិត្តចិញ្ចឹមឆ្មាជាងគេ?
			application.showGenderOfPeopleWhoLikeCatTheMost();
			//>> តើមានអ្នកដែលអត់ចិញ្ចឹមសត្វដែរឬទេ?
			application.showIfThereIsPersonWhoDoesNotHavePet();
			//>> មនុស្សដែលមានអាយុតិចជាងគេឈ្មោះអ្វី?
			application.displayYoungestPerson();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//----------------------------------------------------------------------------------------------------------//
	public void showNumberOfPeopleByGender2() throws SQLException {	
		System.out.println("=========== Count number of people by gender ==========");
		Map<String, Integer> countNumberOfPeopleByGender;
		countNumberOfPeopleByGender = personService2.countNumberOfPeopleByGender();
		System.out.println(countNumberOfPeopleByGender);
	}
	
	//
	public void showNumberOfPetMoreThan2() throws SQLException {	
		System.out.println("\n=========== People who raise pet more than ==========");
		List<Person2> findByNumberOfPetMoreThan = personService2.findByNumberOfPetMoreThan(1);
		findByNumberOfPetMoreThan.forEach(p -> System.out.println(p.toString()));
	}
	
	//
	public void showPeopleByPetType2() throws SQLException {
		System.out.println("\n=========== People who raise CAT ==========");
		List<Person2> findByPetType = personService2.findByPetType("cat");
		findByPetType.forEach(p -> System.out.println(p.toString()));
		
	}
	
	//
	public void showGenderOfPeopleWhoLikeCatTheMost() throws SQLException {
		System.out.println("\n=========== Gender Which like cat the most ==========");
		String mostFavouriteGenderToHavePet = personService2.mostFavouriteGenderToHavePet("cat");
		System.out.println(mostFavouriteGenderToHavePet);
	}
	
	//
	public void showIfThereIsPersonWhoDoesNotHavePet() throws SQLException {
		System.out.println("\n=========== Is there any person who doesn't have pet? ==========");
		boolean hasPersonWhoDoesNotHavePet = personService2.hasPersonWhoDoesNotHavePet();
		System.out.println(hasPersonWhoDoesNotHavePet);
	}
	
	//
	public void displayYoungestPerson() throws SQLException {
		System.out.println("\n=========== The youngest person is ==========");
		Person2 youngestPerson = personService2.youngestPerson();
		System.out.println(youngestPerson.getName());
	}

}
