/**
 * Created by IntelliJ IDEA.
 * User: janik
 * Date: 23. 2. 2022
 * Time: 12:47
 */
public class Main {

    public static void main(String[] args) {
        Student janech = new Student("Jan", "Janech", "1001120");
        StudijnaSkupina studijnaSkupina = new StudijnaSkupina("5ZYI99");
        studijnaSkupina.pridaj(janech);
    }
}
