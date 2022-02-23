import java.util.ArrayList;

/**
 * 23. 2. 2022 - 12:47
 *
 * @author janik
 */
public class StudijnaSkupina {
    private final String cisloSkupiny;
    private final ArrayList<Student> studenti;

    public StudijnaSkupina(String cisloSkupiny) {
        this.cisloSkupiny = cisloSkupiny;
        this.studenti = new ArrayList<>();
    }

    public String getCisloSkupiny() {
        return this.cisloSkupiny;
    }

    public void pridaj(Student student) {
        this.studenti.add(student);
    }

    public void vypis() {
        for (Student student : this.studenti) {
            System.out.println(student);
        }
    }
}
