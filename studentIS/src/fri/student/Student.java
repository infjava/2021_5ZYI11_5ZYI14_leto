package fri.student;

public class Student {
    private final String meno;
    private final String priezvisko;
    private final String studijnaSkupina;

    public Student(String meno, String priezvisko, String studijnaSkupina) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.studijnaSkupina = studijnaSkupina;
    }

    public String getMeno() {
        return this.meno;
    }

    public String getPriezvisko() {
        return this.priezvisko;
    }

    public String getStudijnaSkupina() {
        return this.studijnaSkupina;
    }

    @Override
    public String toString() {
        return "Student{" +
                "meno='" + meno + '\'' +
                ", priezvisko='" + priezvisko + '\'' +
                ", studijnaSkupina='" + studijnaSkupina + '\'' +
                '}';
    }
}
