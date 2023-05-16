import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private String id;
    private List<Worker> workers; // list of workers belonging to this department

    public Department(String name, String id) {
        this.name = name;
        this.id = id;
        workers = new ArrayList<>();
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Worker> getWorkers() {

        return workers;
    }

    public void setWorker(Worker worker) {

        workers.add(worker);
    }

    public void setWorkers(List<Worker> workers) {

        workers = new ArrayList<>(workers);
    }

    @Override
    public String toString() {
        return "Name of department: " + name + " Unique id: " + id;
    }
}
