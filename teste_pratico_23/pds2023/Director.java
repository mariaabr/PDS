public class Director extends Monitor{
    private Course degreeName;
    private StudentAdm stud;

    public Director (StudentAdm st, Course degree) {
        this.degreeName = degree;
        this.stud = st;
        if(stud.getStudent().getCourse().equals(degreeName)){
            st.attach(this);
        } else {
            System.out.println("Error: Director's course must be the same as student's course");
        }
        
    }

    public Course getCourseName() {
        return degreeName;
    }

    @Override
    public void update(Student student){
            System.out.println(degreeName + "director reports that student" + student.getName() + "(" + student.getId() + ") has changed the overall grade: " + student.getOverallGrade());
    }

    @Override
    public String getName() {
        return "director";
    }
}
