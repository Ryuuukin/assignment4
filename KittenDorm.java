import java.util.ArrayList;
import java.util.List;

class KittenDorm {
    private List<Observer> students = new ArrayList<>();
    private List<Kitten> kittens = new ArrayList<>();

    public List<Observer> getStudents() {
        return students;
    }

    public List<Kitten> getKittens() {
        return kittens;
    }

    public void addObserver(Observer student) {
        students.add(student);
    }

    public void removeObserver(Observer student) {
        students.remove(student);
    }
    public void publishKitten(Kitten kitten) {
        kittens.add(kitten);
        notifyObservers(kitten);
    }

    private void notifyObservers(Kitten kitten) {
        for (Observer student : students) {
            student.update(kitten);
        }
    }
}