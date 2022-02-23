/**
 * 23. 2. 2022 - 12:47
 *
 * @author janik
 */
public class Student {
    private final String meno;
    private final String priezvisko;
    private final String osobneCislo;

    public Student(String meno, String priezvisko, String osobneCislo) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.osobneCislo = osobneCislo;
    }

    public String getMeno() {
        return this.meno;
    }

    public String getPriezvisko() {
        return this.priezvisko;
    }

    public String getOsobneCislo() {
        return this.osobneCislo;
    }
}
