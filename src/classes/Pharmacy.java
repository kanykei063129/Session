package classes;

import java.util.List;

public class Pharmacy {
    private  int id;
    private String name;
    private String addres;
    private List<Person>people;
    private List<Medicine>medicines;

    public Pharmacy(int id, String name, String addres, List<Person> people, List<Medicine> medicines) {
        this.id = id;
        this.name = name;
        this.addres = addres;
        this.people = people;
        this.medicines = medicines;
    }

    public Pharmacy() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addres='" + addres + '\'' +
                ", people=" + people +
                ", medicines=" + medicines +
                '}';
    }
}
