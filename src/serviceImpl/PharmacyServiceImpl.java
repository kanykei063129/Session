package serviceImpl;

import classes.Pharmacy;
import exceptions.MyException;
import service.PharmacyService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PharmacyServiceImpl implements PharmacyService {
    private static int counter;

    @Override
    public Pharmacy addPharmacy(List<Pharmacy> pharmacies) {
        Pharmacy pharmacy = new Pharmacy();
        boolean isTrue = true;
        while (isTrue) {
            try {
                System.out.println("         *Welcome*");
                System.out.print("Enter pharmacy name: ");
                String name = new Scanner(System.in).nextLine();
                System.out.print("Enter pharmacy address: ");
                String address = new Scanner(System.in).nextLine();
                pharmacy.setName(name);
                pharmacy.setAddres(address);
                pharmacy.setPeople(new ArrayList<>());
                pharmacy.setMedicines(new ArrayList<>());
                if (!pharmacies.isEmpty()) {
                    for (Pharmacy p : pharmacies) {
                        if (p.getName().equalsIgnoreCase(name)) {
                            isTrue = false;
                            pharmacy.setId(++counter);
                            pharmacies.add(pharmacy);
                            throw new MyException("Same pharmacy name!");
                        } else {
                            pharmacy.setId(++counter);
                            pharmacies.add(pharmacy);
                            isTrue = false;
                            return pharmacy;
                        }
                    }
                } else {
                    pharmacy.setId(++counter);
                    pharmacy.setName(name);
                    pharmacy.setAddres(address);
                    pharmacies.add(pharmacy);
                    isTrue = false;
                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }
        return pharmacy;
    }

    @Override
    public Pharmacy getPharmacyById(List<Pharmacy> pharmacies) {
        try {
            System.out.print("Enter pharmacy id: ");
            int id = new Scanner(System.in).nextInt();
            boolean isFalse = false;
            for (Pharmacy p : pharmacies) {
                if (p.getId() == id) {
                    isFalse = false;
                    return p;
                } else {
                    isFalse = true;
                }
            }
            if (isFalse) {
                throw new MyException("Pharmacy with id: " + id + " not found!");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Write only numbers");
        }
        return null;
    }
//11,13,14,15
    @Override
    public List<Pharmacy> getAllPharmacy(List<Pharmacy> pharmacies) {
        return pharmacies;
    }

    @Override
    public List<Pharmacy> getPharmacyByAddress(List<Pharmacy> pharmacies) {
        List<Pharmacy> pharmacies1 = new ArrayList<>();
        try {
            int counter = 0;
            System.out.print("Enter pharmacy address: ");
            String address = new Scanner(System.in).nextLine();
            for (Pharmacy p : pharmacies) {
                if (p.getAddres().equalsIgnoreCase(address)) {
                    pharmacies1.add(p);
                } else {
                    counter++;
                }
            }

            if (counter > 0) {
                throw new MyException("Pharmacy with address: " + address + " not found!");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return pharmacies1;
    }

    @Override
    public Pharmacy updatePharmacyId(List<Pharmacy> pharmacies) {
        try {
            System.out.print("Enter pharmacy id: ");
            int id = new Scanner(System.in).nextInt();
            boolean isTrue = true;
            for (Pharmacy p : pharmacies) {
                if (p.getId() == id) {
                    isTrue = true;
                    System.out.print("Enter new pharmacy name: ");
                    String name = new Scanner(System.in).nextLine();
                    p.setName(name);
                    return p;
                } else {
                    isTrue = false;
                }
            }
            if (!isTrue) {
                throw new MyException("Pharmacy with id: " + id + " not found!");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Write only numbers!");
        }
        return null;
    }

    @Override
    public void deletePharmacyById(List<Pharmacy> pharmacies) {
        try {
            boolean isTrue = true;
            System.out.print("Enter pharmacy id: ");
            int id = new Scanner(System.in).nextInt();
            for (int i = 0; i < pharmacies.size(); i++) {
                if (pharmacies.get(i).getId() == id) {
                    isTrue = true;
                    pharmacies.remove(pharmacies.get(i));
                    System.out.println("Pharmacy with id: " + id + " deleted!");
                } else {
                    isTrue = false;
                }
            }

            if (!isTrue) {
                throw new MyException("Pharmacy with id: " + id + " not found!");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Write only numbers!");
        }
    }
}
        //2,3,6,8,9,11,13,12,15,