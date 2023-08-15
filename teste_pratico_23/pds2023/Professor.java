public class Professor extends Monitor{
    private String className;
    private String name;

    public Professor(StudentAdm adm, String name, String className) {
        this.name = name;
        this.className = className;
        adm.attach(this);
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public void update(Student student){
        if(student.getScore(this.className) != null){
            System.out.println("Professor " + this.name + " of " + this.className + " class evaluated student " + student.getName() + "(" + student.getId() + ") with score: " + student.getScore(this.className));
        }
    }
}
