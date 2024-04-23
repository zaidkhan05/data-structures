
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

class CourseDoesNotExistException extends RuntimeException{
    public CourseDoesNotExistException(String id){
        super("Course with ID " + id + " does not exist");
    }
}

class CourseOfferingDoesNotExistException extends RuntimeException{
    public CourseOfferingDoesNotExistException(String id){
        super("Course offering with ID " + id + " does not exist");
    }
}

class UnsatisfiableRegistrationException extends Exception{
    public UnsatisfiableRegistrationException(String id, String reason){
        super("Cannot fulfill registration for student " + id + ": " + reason);
    }
}

class Course implements Comparable<Course>{
    private final String id;
    private final String name;
    private final int creditHours;

    private Course(String id, String name, int creditHours){
        this.id = id;
        this.name = name;
        this.creditHours = creditHours;
    }

    public static Course fromID(String id){
        try{
            File file = new File("course-" + id + ".txt");
            Scanner sc = new Scanner(file);
            String name = sc.nextLine();
            int creditHours = Integer.parseInt(sc.nextLine());
            sc.close();
            return new Course(id, name, creditHours);
        }catch(FileNotFoundException e){
            throw new CourseDoesNotExistException(id);
        }
    }

    public String getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getCreditHours(){
        return creditHours;
    }

    public boolean equals(Object obj){
        if(obj instanceof Course){
            Course c = (Course) obj;
            return id.equals(c.id);
        }
        return false;
    }

    public int compareTo(Course c){
        return id.compareTo(c.id);
    }
}

class CourseOffering implements Comparable<CourseOffering>{
    private final String id;
    private final Course course;
    private final String semester;
    private final int occupiedSeats;
    private final int totalSeats;

    private static File courseOfferingsFile;
    private static CourseOffering[] courseOfferings;

    private CourseOffering(String id, Course course, String semester, int occupiedSeats, int totalSeats){
        this.id = id;
        this.course = course;
        this.semester = semester;
        this.occupiedSeats = occupiedSeats;
        this.totalSeats = totalSeats;
    }

    public static void loadCourseOfferings(File file) throws FileNotFoundException{
        courseOfferingsFile = file;
        courseOfferings = new CourseOffering[0];
        try{
            Scanner sc = new Scanner(file);
            int n = 0;
            while(sc.hasNextLine()){
                n++;
                sc.nextLine();
            }
            sc.close();
            sc = new Scanner(file);
            CourseOffering[] temp = new CourseOffering[n];
            for(int i = 0; i < n; i++){
                String[] parts = sc.nextLine().split(",");
                Course course = Course.fromID(parts[1]);
                temp[i] = new CourseOffering(parts[0], course, parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
            }
            sc.close();
            courseOfferings = temp;
        }catch(FileNotFoundException e){
            courseOfferingsFile = null;
            courseOfferings = new CourseOffering[0];
            throw e;
        }
    }

    public static void saveCourseOfferings() throws FileNotFoundException{
        if(courseOfferingsFile == null){
            throw new IllegalStateException("The course offerings are not loaded");
        }
        try{
            PrintWriter pw = new PrintWriter(new FileWriter(courseOfferingsFile));
            for(CourseOffering co : courseOfferings){
                pw.println(co.id + "," + co.course.getID() + "," + co.semester + "," + co.occupiedSeats + "," + co.totalSeats);
            }
            pw.close();
        }catch(IOException e){
            throw new FileNotFoundException();
        }
    }
    public static CourseOffering getCourseOffering(String id){
        int l = 0, r = courseOfferings.length - 1;
        while(l <= r){
            int m = (l + r) / 2;
            int cmp = courseOfferings[m].id.compareTo(id);
            if(cmp == 0){
                return courseOfferings[m];
            }else if(cmp < 0){
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        throw new CourseOfferingDoesNotExistException(id);
    }

    public void addStudent(){
        if(occupiedSeats == totalSeats){
            throw new IllegalStateException("The course offering " + id + " is full");
        }
    }

    public void removeStudent(){
        if(occupiedSeats == 0){
            throw new IllegalStateException("The course offering " + id + " is empty");
        }
    }

    public String getID(){
        return id;
    }
    public Course getCourse(){
        return course;
    }
    public String getSemester(){
        return semester;
    }
    public int getOccupiedSeats(){
        return occupiedSeats;
    }
    public int getTotalSeats(){
        return totalSeats;
    }

    public boolean equals(Object obj){
        if(obj instanceof CourseOffering){
            CourseOffering co = (CourseOffering) obj;
            return id.equals(co.id);
        }
        return false;
    }

    public int compareTo(CourseOffering co){
        return id.compareTo(co.id);
    }
}

class Student{
    private final String id;
    private Course[] takenCourses;
    private CourseOffering[] registrations;

    private Student(String id, Course[] takenCourses, CourseOffering[] registrations){
        this.id = id;
        this.takenCourses = takenCourses;
        this.registrations = registrations;
    }

    public static Student fromID(String id) throws FileNotFoundException{
        try{
            File file = new File("student-" + id + ".txt");
            Scanner sc = new Scanner(file);
            String[] courseIDs = sc.nextLine().split(" ");
            Course[] takenCourses = new Course[courseIDs.length];
            for(int i = 0; i < courseIDs.length; i++){
                takenCourses[i] = Course.fromID(courseIDs[i]);
            }
            String[] courseOfferingIDs = sc.nextLine().split(" ");
            CourseOffering[] registrations = new CourseOffering[courseOfferingIDs.length];
            for(int i = 0; i < courseOfferingIDs.length; i++){
                registrations[i] = CourseOffering.getCourseOffering(courseOfferingIDs[i]);
            }
            sc.close();
            return new Student(id, takenCourses, registrations);
        }catch(FileNotFoundException e){
            return new Student(id, new Course[0], new CourseOffering[0]);
        }
    }

    private void updateFile() throws FileNotFoundException{
        try{
            PrintWriter pw = new PrintWriter(new FileWriter("student-" + id + ".txt"));
            for(Course c : takenCourses){
                pw.print(c.getID() + " ");
            }
            pw.println();
            for(CourseOffering co : registrations){
                pw.print(co.getID() + " ");
            }
            pw.println();
            pw.close();
        }catch(IOException e){
            throw new FileNotFoundException();
        }
    }

    public String getID(){
        return id;
    }
    public Course[] getTakenCourses(){
        return takenCourses;
    }
    public CourseOffering[] getRegistrations(){
        return registrations;
    }

    public boolean equals(Object obj){
        if(obj instanceof Student){
            Student s = (Student) obj;
            return id.equals(s.id);
        }
        return false;
    }

    public void passAllCourses() throws FileNotFoundException{
        Course[] oldTakenCourses = takenCourses;
        CourseOffering[] oldRegistrations = registrations;
        try{
            for(CourseOffering co : registrations){
                takenCourses = Arrays.copyOf(takenCourses, takenCourses.length + 1);
                takenCourses[takenCourses.length - 1] = co.getCourse();
            }
            Arrays.sort(takenCourses);
            updateFile();
        }catch(FileNotFoundException e){
            takenCourses = oldTakenCourses;
            registrations = oldRegistrations;
            throw e;
        }
    }
    public void updateRegistration(CourseOffering[] newRegistrations) throws FileNotFoundException, UnsatisfiableRegistrationException{
        int totalCredits = 0;
        for(Course c : takenCourses){
            totalCredits += c.getCreditHours();
        }
        for(CourseOffering co : newRegistrations){
            for(Course c : takenCourses){
                if(co.getCourse().equals(c)){
                    throw new UnsatisfiableRegistrationException(id, "courses already taken (" + c.getID() + ")");
                }
            }
            if(co.getOccupiedSeats() == co.getTotalSeats()){
                throw new UnsatisfiableRegistrationException(id, "courses full (" + co.getCourse().getID() + ")");
            }
            totalCredits += co.getCourse().getCreditHours();
        }
        if(totalCredits > 18){
            throw new UnsatisfiableRegistrationException(id, "registration exceeds 18 credit hours");
        }
        CourseOffering[] oldRegistrations = registrations;
        try{
            for(CourseOffering co : newRegistrations){
                co.addStudent();
            }
            for(CourseOffering co : registrations){
                co.removeStudent();
            }
            registrations = newRegistrations;
            updateFile();
            CourseOffering.saveCourseOfferings();
        }catch(Exception e){
            for(CourseOffering co : newRegistrations){
                co.removeStudent();
            }
            for(CourseOffering co : oldRegistrations){
                co.addStudent();
            }
            registrations = oldRegistrations;
            throw e;
        }
    }
}

public class RegistrationSystem{
    public static void main(String[] args){
        try{
            CourseOffering.loadCourseOfferings(new File(args[0]));
            Scanner sc = new Scanner(System.in);
            while(true){
                System.out.print("> ");
                String[] parts = sc.nextLine().split(" ");
                if(parts.length == 0){
                    break;
                }
                try{
                    if(parts[0].equals("register")){
                        Student s = Student.fromID(parts[1]);
                        CourseOffering[] cos = new CourseOffering[parts.length - 2];
                        for(int i = 2; i < parts.length; i++){
                            cos[i - 2] = CourseOffering.getCourseOffering(parts[i]);
                        }
                        s.updateRegistration(cos);
                    }else if(parts[0].equals("pass")){
                        Student s = Student.fromID(parts[1]);
                        s.passAllCourses();
                    }
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
            sc.close();
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
