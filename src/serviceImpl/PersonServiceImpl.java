package serviceImpl;

import classes.Person;
import classes.Pharmacy;
import exceptions.MyException;
import service.PersonService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PersonServiceImpl implements PersonService {
    static int counter;

    @Override
    public Person addPersonToPharmacy(List<Pharmacy> pharmacies) {
        try {
            System.out.println("Enter pharmacy id: ");
            int pharmacyId = new Scanner(System.in).nextInt();
            for (Pharmacy p : pharmacies) {
                if (p.getId() == pharmacyId) {
                    System.out.println("Enter first name: ");
                    String name = new Scanner(System.in).nextLine();
                    System.out.println("Enter last name: ");
                    String lastName = new Scanner(System.in).nextLine();
                    System.out.println("Enter email (@): ");
                    String email = new Scanner(System.in).nextLine();
                    if (!email.contains("@")) {
                        throw new MyException("Email must contains '@'!");
                    }

                    boolean isTrue = true;
                    for (Pharmacy pharmacy : pharmacies) {
                        if (pharmacy.getPeople().isEmpty()) {
                            for (Person person : pharmacy.getPeople()) {
                                if (person.getEmail().equals(email)) {
                                    isTrue = true;
                                    throw new MyException("Duplicate email");
                                } else {
                                    isTrue = false;
                                }
                            }
                        } else {
                            Person person = new Person(++counter, name, lastName, email);
                            p.getPeople().add(person);
                            return person;
                        }
                    }

                    if (isTrue) {
                        Person person = new Person(++counter, name, lastName, email);
                        p.getPeople().add(person);
                        return person;
                    }
                }
            }
        } catch (MyException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Person findPersonById(List<Pharmacy> pharmacies) {
        try {
            System.out.print("Enter person id: ");
            int id = new Scanner(System.in).nextInt();
            boolean isFalse = false;
            for (Pharmacy p : pharmacies) {
                for (Person per : p.getPeople()) {
                    if (per.getId() == id) {
                        isFalse = false;
                        return per;
                    } else {
                        isFalse = true;
                    }
                }
            }
            if (isFalse) {
                throw new MyException("Person with id: " + id + " not found!");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Write only numbers");
        }
        return null;
    }

    @Override
    public List<Person> getAllPharmacyStaff(List<Pharmacy> pharmacies) {
        try {
            System.out.print("Enter pharmacy id: ");
            int id = new Scanner(System.in).nextInt();
            for (Pharmacy p : pharmacies) {
                if (p.getId() == id) {
                    return p.getPeople();
                } else {
                    throw new MyException("Not found!");
                }
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Write only numbers!");
        }
        return null;
    }

    @Override
    public Person updatePersonName(List<Pharmacy> pharmacies) {
        try {
            System.out.print("Enter person name: ");
            String name = new Scanner(System.in).nextLine();
            boolean isTrue = true;
            for (Pharmacy p : pharmacies) {
                for (Person per : p.getPeople()) {
                    if (per.getFirstName().equalsIgnoreCase(name)) {
                        isTrue = true;
                        System.out.print("Enter person new name: ");
                        String name1 = new Scanner(System.in).nextLine();
                        per.setFirstName(name1);
                        return per;
                    } else {
                        isTrue = false;
                    }
                }
                if (!isTrue) {
                    throw new MyException("Pharmacy with id: " + name + " not found!");
                }
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
            return null;
        }
    @Override
    public void deletePersonFromPharmacy(List<Pharmacy> pharmacies) {
        try {
            boolean isTrue = true;
            System.out.print("Enter person id: ");
            int id = new Scanner(System.in).nextInt();
            for (Pharmacy ph : pharmacies) {
                for (Person p : ph.getPeople()) {
                        if (p.getId() == id) {
                            isTrue = true;
                            pharmacies.remove(p);
                            System.out.println("Person with id: " + id + " deleted!");
                        } else {
                            isTrue = false;
                        }
                    }
                }
                    if (!isTrue) {
                        throw new MyException("Person with id: " + id + " not found!");
                    }
                } catch(MyException e){
                    System.out.println(e.getMessage());
                } catch(InputMismatchException e){
                    System.out.println("Write only numbers!");
                }
            }
        }