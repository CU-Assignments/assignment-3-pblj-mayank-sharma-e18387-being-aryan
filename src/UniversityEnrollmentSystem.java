import java.util.*;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

class UniversityEnrollmentSystem {
    private static final int MAX_CAPACITY = 2;
    private static final Map<String, String> prerequisites = new HashMap<>();
    private static final List<String> enrolledStudents = new ArrayList<>();
    
    static {
        prerequisites.put("Advanced Java", "Core Java");
    }
    
    public static void enrollStudent(String student, String course, String completedCourse) throws CourseFullException, PrerequisiteNotMetException {
        if (enrolledStudents.size() >= MAX_CAPACITY) {
            throw new CourseFullException("Error: Course is full.");
        }
        if (prerequisites.containsKey(course) && !prerequisites.get(course).equals(completedCourse)) {
            throw new PrerequisiteNotMetException("Error: Complete " + prerequisites.get(course) + " before enrolling in " + course + ".");
        }
        enrolledStudents.add(student);
        System.out.println("Enrollment successful: " + student + " enrolled in " + course);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter student name: ");
            String student = scanner.nextLine();
            
            System.out.print("Enroll in Course: ");
            String course = scanner.nextLine();
            
            System.out.print("Completed Prerequisite Course: ");
            String completedCourse = scanner.nextLine();
            
            enrollStudent(student, course, completedCourse);
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
