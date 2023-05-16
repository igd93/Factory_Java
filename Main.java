import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import java.util.logging.*;

public class Main {

    private static final String testID = "ts";
    private static final String hrID = "hr";
    private static final String devID = "dv";
    private static final String itID = "sp";


    public static List<Worker> getSortedWorkersByDep(List<Worker> workers, String depID) {


        //We filter out the employees out of the list of all employees of a specified department
        //Eliminate all the other departments from the Departments list, leaving with only primary one.


        return workers.stream()
                .filter(w -> w.getAllDepartments().stream()
                        .anyMatch(department -> Objects.equals(department.getId(), depID)))
                .sorted(Comparator.comparing(Worker::getDateOfEmployment))
                .peek(w ->
                        w.setDepartments(w.getAllDepartments()
                                .stream()
                                .filter(dep -> Objects.equals(dep.getId(), depID))
                                .toList())
                )
                .toList();
    }


    public static List<Worker> getSortedWorkersByDepBut(List<Worker> workers, String depID) {

        return workers.stream()
                .filter(w -> w.getAllDepartments().stream()
                        .anyMatch(department -> Objects.equals(department.getId(), depID)))
                .sorted(Comparator.comparing(Worker::getDateOfEmployment))
                .toList();
    }

    /*
    public static List<Worker> filterOutDepartments(List<Worker> workers, String depID) {

        List<Worker> filteredWorkers = workers.stream().peek(w -> w.setDepartments(w.getAllDepartments()
                                                                    .stream()
                                                                    .filter(dep -> Objects.equals(dep.getId(), depID))
                                                                    .toList()))
                                        .toList();
        return filteredWorkers;

    }*/

    public static List<Worker> getWorkerHiredAfterDate(List<Worker> workers, String date) {
        //return all the workers hired after a specified date

        return workers.stream()
                .filter(p -> p.getDateOfEmployment().isAfter(LocalDate.parse(date)))
                .sorted(Comparator.comparing(Worker::getDateOfEmployment))
                .toList();
    }

    public static void printWorkers(List<Worker> workers) {

        AtomicInteger counter = new AtomicInteger(1);
        workers.forEach(w ->
                System.out.println(counter.getAndIncrement() + " " + w)
        );

    }



    private static final Logger logger = Logger.getLogger(Main.class.getName());


    public static void main(String[] args) {

        //setting up the logger level
        logger.setLevel(Level.INFO);

        Department hR= new Department("HR", hrID);
        Department testing = new Department("Testing", testID);
        Department dev = new Department("Development", devID);
        Department support = new Department("IT Support", itID);

        List<Worker> allWorkers = new ArrayList<>();

        Worker worker1 = new Worker("John", "Doe", "Head of HR", "2015-02-04");
        allWorkers.add(worker1);
        Worker worker2 = new Worker("Jane", "Austin", "Software Engineer", "2017-01-10");
        allWorkers.add(worker2);
        Worker worker3 = new Worker("Dana", "White", "Automation Engineer", "2018-09-17");
        allWorkers.add(worker3);
        Worker worker4 = new Worker("Bob", "Milly", "Onboarding HR", "2014-02-01");
        allWorkers.add(worker4);
        Worker worker5 = new Worker("Kate", "Bukowsky", "Java Tester", "2020-07-06");
        allWorkers.add(worker5);
        Worker worker6 = new Worker("Alan", "Smith", "Software Engineer", "2021-04-03");
        allWorkers.add(worker6);
        Worker  worker7= new Worker("Daniel", "Johnson", "Knowledge Architect", "2021-03-04");
        allWorkers.add(worker7);
        Worker worker8 = new Worker("Frank", "Lenny", "Automation Engineer", "2013-08-01");
        allWorkers.add(worker8);
        Worker worker9 = new Worker("Alex", "Porter", "IT admin", "2019-03-02");
        allWorkers.add(worker9);
        Worker worker10 = new Worker("Ted", "White", "Software Engineer", "2013-12-22");
        allWorkers.add(worker10);
        Worker worker11 = new Worker("Lance", "Vance", "Automation Engineer", "2016-07-01");
        allWorkers.add(worker11);
        Worker worker12 = new Worker("Tommy", "Vercetti", "Software Engineer", "2019-07-07");
        allWorkers.add(worker12);


        //adding workers
        hR.setWorker(worker1);
        hR.setWorker(worker4);

        testing.setWorker(worker2);
        testing.setWorker(worker3);
        testing.setWorker(worker5);
        testing.setWorker(worker6);
        testing.setWorker(worker7);
        testing.setWorker(worker8);
        testing.setWorker(worker9);
        testing.setWorker(worker10);
        testing.setWorker(worker11);
        testing.setWorker(worker12);

        dev.setWorker(worker2);
        dev.setWorker(worker6);
        dev.setWorker(worker10);
        dev.setWorker(worker12);

        support.setWorker(worker7);
        support.setWorker(worker9);

        //adding departments to workers

        worker1.setDepartment(hR);
        worker2.setDepartment(hR);

        worker2.setDepartment(testing);
        worker3.setDepartment(testing);
        worker5.setDepartment(testing);
        worker6.setDepartment(testing);
        worker7.setDepartment(testing);
        worker8.setDepartment(testing);
        worker9.setDepartment(testing);
        worker10.setDepartment(testing);
        worker11.setDepartment(testing);
        worker12.setDepartment(testing);

        worker2.setDepartment(dev);
        worker6.setDepartment(dev);
        worker10.setDepartment(dev);
        worker12.setDepartment(dev);

        worker7.setDepartment(support);
        worker9.setDepartment(support);


        List<Worker> depWorkers = getSortedWorkersByDep(allWorkers, testID);
        //List<Worker> sorted_workers = filterOutDepartments(depWorkers, testID);
        printWorkers(depWorkers);

        System.out.println("-----------Task 2 ---------------");

        List<Worker> afterWorkers = getWorkerHiredAfterDate(allWorkers, "2015-01-01");
        printWorkers(afterWorkers);
    }
}