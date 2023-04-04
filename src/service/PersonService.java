package service;

import classes.Person;
import classes.Pharmacy;

import java.util.List;

public interface PersonService {
    Person addPersonToPharmacy(List<Pharmacy> pharmacies);

    Person findPersonById(List<Pharmacy> pharmacies);

    List<Person> getAllPharmacyStaff(List<Pharmacy> pharmacies);

    Person updatePersonName(List<Pharmacy> pharmacies);

    void deletePersonFromPharmacy(List<Pharmacy> pharmacies);


}
