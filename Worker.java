import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Worker {

    private String name;
    private String familyName;
    private String type;
    private LocalDate dateOfEmployment;
    private List<Department> departmentsBelong; // can belong to different departments at the same time



    public Worker(String name, String familyName, String type, String date){
        this.name = name;
        this.familyName = familyName;
        this.type = type;
        this.dateOfEmployment = LocalDate.parse(date);

        departmentsBelong = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public String getFamilyName() {
        return familyName;
    }

    public String getType(){
        return type;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public List<Department> getAllDepartments() {
        return departmentsBelong;
    }

    public void setDepartment(Department d) {
        departmentsBelong.add(d);
    }

    public void setDepartments(List<Department> departments) {
        departmentsBelong = new ArrayList<>(departments);
    }

    @Override
    public String toString() {
        return "name: " + name + " familyName: " + familyName + "  type: " + type
                + "  dateOfEmployment: " + dateOfEmployment + " Departments: " + departmentsBelong.toString();
    }
}
