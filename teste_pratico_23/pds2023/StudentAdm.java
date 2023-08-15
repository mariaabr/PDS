import java.util.ArrayList;

public class StudentAdm {
    private Student student;
    private ArrayList<Monitor> monitors = new ArrayList<Monitor>();
    
    public StudentAdm(Student s) {
        this.student = s;
    }

    public void addScore(String className, double score) {
        student.addScore(className, (Double) score);

        notify(student);
    }

    public void attach(Monitor monitor){
        monitors.add(monitor);
    }

    public void notify(Student student){
        for(Monitor monitor : monitors){ // falta adicionar o monitores aqui dentro para dar o update
            monitor.update(student);
        }
    }

    public Student getStudent() {
        return student;
    }
}








