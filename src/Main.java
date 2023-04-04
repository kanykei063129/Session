import classes.Pharmacy;
import service.PharmacyService;
import serviceImpl.MedicineServiceImpl;
import serviceImpl.PersonServiceImpl;
import serviceImpl.PharmacyServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Pharmacy> pharmacies = new ArrayList<>();
        PharmacyServiceImpl pharmacyService = new PharmacyServiceImpl();
        PersonServiceImpl personService = new PersonServiceImpl();
        MedicineServiceImpl medicineService = new MedicineServiceImpl();
        while (true) {
            System.out.println("""
                    1 -> Add new pharmacy.
                    2 -> Get pharmacy by id.
                    3 -> Update pharmacy by id.
                    4 -> Get pharmacy by address.
                    5 -> Get all pharmacy.
                    6 -> Delete pharmacy by id.
                    7 -> Add person to pharmacy.
                    8 -> Find person by id.
                    9 -> Get all pharmacy staff.
                    10 -> Update person name.
                    11 -> Delete person from pharmacy.
                    12 -> Add medicine to pharmacy.
                    13 -> Find medicine by id.
                    14 -> Get all medicine.
                    15 -> Delete medicine.
                    """);
            System.out.println("Choose command: ");
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            switch (number) {
                case 1 -> System.out.println(pharmacyService.addPharmacy(pharmacies));
                case 2 -> System.out.println(pharmacyService.getPharmacyById(pharmacies));
                case 3 -> System.out.println(pharmacyService.updatePharmacyId(pharmacies));
                case 4 -> System.out.println(pharmacyService.getPharmacyByAddress(pharmacies));
                case 5 -> System.out.println(pharmacyService.getAllPharmacy(pharmacies));
                case 6 -> pharmacyService.deletePharmacyById(pharmacies);
                case 7 -> System.out.println(personService.addPersonToPharmacy(pharmacies));
                case 8 -> System.out.println(personService.findPersonById(pharmacies));
                case 9 -> System.out.println(personService.getAllPharmacyStaff(pharmacies));
                case 10 -> System.out.println(personService.updatePersonName(pharmacies));
                case 11 -> personService.deletePersonFromPharmacy(pharmacies);
                case 12 -> System.out.println(medicineService.addMedicineToPharmacy(pharmacies));
                case 13 -> System.out.println(medicineService.findMedicineByName(pharmacies));
                case 14 -> System.out.println(medicineService.getAllMedicine(pharmacies));
                case 15 -> medicineService.deleteMedicine(pharmacies);
            }
        }
    }
}
