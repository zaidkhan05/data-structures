<<<<<<< HEAD
import java.util.*;
=======

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
>>>>>>> fd51e9b0182ae72f6099fa296519a8278e2c5014

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

class RegistrationSystem{
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


// public class quiz{

//     public static void main(String args[])
//     {


//     }
    
    
// }

/*
 You will write seven classes: Course, CourseOffering, Student, RegistrationSystem,
CourseDoesNotExistException, CourseOfferingDoesNotExistException, and
UnsatisfiableRegistrationException. Each will be written in its own file (named accordingly).
 You must use constructor chaining when it’s applicable:
o If a class has N constructors, it will use “this” constructor chaining N-1 times
o A class will use “super” constructor chaining at most once. It may only be used in
the constructor that has all the appropriate parameters. You will use it if and
only if, in that constructor, the implicit “super” constructor chaining is not
appropriate
 Visibility for required elements:
o All classes must be public
o All methods and constructors must be public unless otherwise noted in their
description
o All variables must be private
 The throws declaration in method headers should include checked exceptions only
 Student-written exception classes should extend from Exception or RuntimeException,
depending on whether they are checked or unchecked exceptions. Other classes should
not extend any class explicitly
 File I/O Note: Make sure that you close() the Scanners and PrintWriters whenever
you’re done with them - you don’t want to keep any resources open
 You may add to aid you (if you want)
o Methods, if they are private
o Variables, if they are private static final
 You may not add any other classes or constructors
CourseDoesNotExistException
 This is an unchecked exception class to inform that a course does not exist (there is no file
associated with it). It will only have a 1-arg constructor taking a String (a course ID) and
producing an exception with the message "Course with ID [id] does not exist" (without square
brackets)
CourseOfferingDoesNotExistException
 This is an unchecked exception class to inform that a course offering does not exist (there is no
file associated with it). It will only have a 1-arg constructor taking a String (a course offering
ID) and producing an exception with the message "Course offering with ID [id] does not exist"
(without square brackets)
UnsatisfiableRegistrationException
 This is a checked exception class to inform that the student cannot perform the requested
registration. It will have a 2-arg constructor taking two Strings (a student ID and a reason) and
producing an exception with the message "Cannot fulfill registration for student [id]: [reason]"
(without square brackets)
Course
 This is a class that manages some information for courses. A Course is Comparable (should be
comparable to other Courses). It will have:
o The following instance variables: id (String), name (String), creditHours (int).
All attributes will never change and should be marked accordingly.
o A private 3-arg constructor that takes all the instance variables in order and sets them.
o A static Course fromID(String) method that creates an instance of a Course
based on the information of a course in a file. It receives an id and looks up the course
information in the file course-[id].txt (without square brackets). The file will have the
course name in the first line and the course credits in the second line. If the course
doesn’t exist (because the file isn’t present), the method should propagate a
CourseDoesNotExistException with the appropriate message.
o Getters for all instance variables
o An equals method. A Course is equal to another if they have the same id (as there
aren’t multiple courses with the same id but different name/creditHours)
o A compareTo method. It should be such that courses can ordered by their id in
ascending order.
CourseOffering
 This is a class that manages some information for course offerings. A CourseOffering is
Comparable (should be comparable to other CourseOfferings). It will have:
o The following instance variables: id (String), course (Course), semester (String),
occupiedSeats (int), totalSeats (int). All attributes except occupiedSeats will
never change and should be marked accordingly.
o The following class variables: courseOfferingsFile (File), courseOfferings
(CourseOffering[]). The first should be initialized to null, and the second should
be initialized to a 0-length CourseOffering array.
o A private 5-arg constructor that takes all the instance variables in order and sets them.
o A static void loadCourseOfferings(File) method that takes a file and sets
the class variables. The file will be a CSV file (without a header row) such that each line
is formatted "id,courseID,semester,occupiedSeats,totalSeats" (without
quotation marks), and it is guaranteed that none of the String values will have a comma.
 As soon as the method starts executing, set courseOfferingsFile to the passed
parameter and courseOfferings to a 0-length array, which will be the
resulting state of the class variables if the method throws an exception.
 After that, attempt to retrieve the information of all courses (including creating
Course instances from the courseID), producing an array with all the course
offerings. You will then sort the array and store it in courseOfferings. If the
file doesn’t exist, propagate a FileNotFoundException.
 Note 1: even if many CourseOfferings share courseID, you should still
create multiple instances of Course for them – don’t cache an instance.
Additionally, it’s acceptable to read the course information file multiple
times for that courseID. In short: you should not apply any
optimizations to speed up the loading process.
 Note 2: There are two main approaches to loading the file, and both are
equally acceptable. Both of these treat the difficulty imposed by the fact
that arrays have a fixed length. In L17, we will learn about a better way
to handle an ordered sequence of elements (which can change in size)
o Approach 1: scan the file once to know how many offerings
there are, create the array with the correct length, and then
scan it again to create the instances. Make sure to close the first
Scanner before creating another for the same File.
o Approach 2: scan the file only once, and each time you create a
new offering, create a new array with an increased length, copy
the offerings already parsed, and put the new one at the end
o A static void saveCourseOfferings() method that writes the CourseOfferings
from courseOfferings to the File in courseOfferingsFile, using the format
described for the loading method. This method should propagate
FileNotFoundException (as PrintWriter can throw it in some scenarios, such as
failure to create the file) and IllegalStateException (this is an unchecked exception in the
Java API and doesn’t need to be imported since it’s in java.lang)
 If courseOfferingsFile is null, throw an IllegalStateException with the
message "The course offerings are not loaded"
 Note: the file should end in a single newline after the last course offering
information, except when the file is empty because there are no course
offerings.
o A static CourseOffering getCourseOffering(String) method that returns a
CourseOffering by looking for the course offering id in courseOfferings. The method
should throw a CourseOfferingDoesNotExistException with the appropriate
message if the course offering doesn’t exist.
 Note: this method should execute the lookup quickly, in O(log n) time for n
course offerings. We reserve the right to manually deduct points if the
implementation does a linear search.
o A void addStudent() method to increase the number of occupied seats in the
course offering. It should throw an IllegalStateException with the message "The course
offering [id] is full" (without square brackets) if the class offering is already full.
o A void removeStudent() method to decrease the number of occupied seats in the
course offering. It should throw an IllegalStateException with the message "The course
offering [id] is empty" (without square brackets) if the class offering has no occupied
seats.
o Getters for all instance variables
o An equals method. A CourseOffering is equal to another if they have the same id
(as there aren’t multiple courses with the same id but other different attributes)
o A compareTo method. It should be such that course offerings can ordered by their id
in ascending order.
Student
 This is a class that manages some information for students. It will have:
o The following instance variables: id (String), takenCourses (Course[]),
registrations (CourseOffering[]). The id will never change and should be
marked accordingly.
o A private 3-arg constructor that takes all the instance variables in order and sets them.
o A static Student fromID(String) method that creates an instance of a Student
based on the information of a student in a file, and in some scenarios may propagate a
FileNotFoundException. It receives an id and looks up the course information in the
file student-[id].txt (without square brackets).
 If the file exists, it will first load all the courses in order, and then all the course
offerings in order.
 The file will have the IDs for the courses taken in the first line (space
separated if there are multiple - course IDs won’t have spaces) and the
course offerings IDs for the registrations in the second line (again, space
separated and each ID won’t have a space).
 If any exception occurs during the loading, the first will be propagated
(that is, it should stop loading other courses or course offerings)
 If the file doesn’t exist, it return a student with no courses taken or registered
for. Before first returning the value, it should update the student file (this could
throw a FileNotFoundException, in that case, propagate it).
o A private void updateFile() method to save the information of the student in the
correct file (in the format specified in the fromID method). It may propagate a
FileNotFoundException if it cannot create update the student file.
o Getters for all instance variables
o An equals method. A Student is equal to another if they have the same id (as there
aren’t multiple students with the same id)
o A void passAllCourses() method that adds all the courses the student was
registered for to takenCourses, and removes all course offerings from registered.
It should also sort the array of passed courses and update the student information file
and may propagate a FileNotFoundException if it cannot update the file.
 If it cannot save the file, it should undo the operation by restoring the two
modified arrays to the previous values. Keep a copy of them.
 Tip: use a try-finally without a catch block, and add a way to determine if the try
succeeded to the code. This way, you can run some code even if the method will
propagate an exception without adding a catch block.
 Note: this isn’t a perfect recovery operation – far from it. It’s a best-effort
procedure to maintain the in-memory information intact, but it might deviate
from the information stored in files. A real-world, production-level application
would use a DBMS for data storage and let it handle this lower-level aspect.
o A void updateRegistration(CourseOffering[]) method to update the student
registration. This method may propagate a FileNotFoundException or an
UnsatisfiableRegistrationException.
 It will perform a series of checks, throwing an
UnsatisfiableRegistrationException for the first that fails.
 If the student tries to register for more than 18 credits, the exception
reason will be "registration exceeds 18 credit hours"
 If one or more course offerings are associated with a course the student
already took, the reason will be "courses already taken ([course IDs of
the repeated courses, in sorted order and separated by a comma and
space when multiple])" (without square brackets). For example:
o "courses already taken (CS1301, CS1331)"
 If any of the course offerings the student is trying to register is full, and
the student isn’t already registered in it, the reason will be "courses full
([course IDs of the courses that are full, in sorted order and separated
by a comma and space when multiple])" (without square brackets). For
example:
o "courses full (CS1301, CS1331)"
 If all the checks pass, the registration will proceed in two steps. The first should
always succeed, but the second may fail:
 1) Update the necessary instances. Some CourseOffering instances may
need to have the student added or removed – be careful with this
operation. The Student instance also needs the registered array
updated (you can store the parameter directly)
 2) Save the student information file first, and then the course offerings
file.
o If this part succeeds, the registration is successful, and the
method returns
o If this part fails, the system needs to undo the operations from
the first step (similar to passAllCourses, but a bit more
complex):
 If a student was added to a course offering, they need
to be removed from it
 If a student was removed from a course offering, they
need to be added back to it
 The registered array needs to have its old value
restored (store it in a temporary variable before
updating it)
 Then, the exception can be propagated
RegistrationSystem
 This class coordinates the system, and its only method is a main method. The main method
should propagate FileNotFoundException if the first step fails (this can cause the program
to terminate abruptly)
o Load the course offerings. The filename is passed as the first argument and only
argument to the program (args array). If this fails, propagate the
FileNotFoundException
o If that succeed, it will have a loop to read from the command line commands to execute.
It will print "> " and wait for a command in the same line. There are two types of
command (which are always typed correctly):
 register [student id] [any number, possibly zero, of course offerings ids]
 pass [student id]
o The code should first create the Student instance, and, if necessary, the CourseOffering
instances (in the order listed). It should then call one of the methods of Student
accordingly.
 If the operation fails with an exception (including FileNotFoundException),
the method should print the exception message in its own line and keep
prompting the command line for more commands. Tip: catch the Exception
class, which covers all exceptions (other than Errors, which we don’t want to
catch).
o If the user presses enter without a command, the program should break the loop, close
the Scanner and end the program
Testing Your Solution
You can test your solution by creating the files needed by the application and interfacing with
the commands in RegistrationSystem’s main method.
 */