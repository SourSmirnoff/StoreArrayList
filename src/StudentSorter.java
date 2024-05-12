import java.util.ArrayList;

class Student {
    int rollno;
    String name;
    String address;

    // constructor
    public Student(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    // to string method for easy output
    @Override
    public String toString() {
        return "Student: " +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", address='" + address + '\'';
    }
}

// comparator for sorting by name
class NameComparator implements java.util.Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);
    }
}

// comparator for sorting by roll number
class RollNoComparator implements java.util.Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.rollno, s2.rollno);
    }
}

public class StudentSorter {

    // selection sort method
    public static void selectionSort(ArrayList<Student> students, java.util.Comparator<Student> comparator) {
        for (int i = 0; i < students.size() - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < students.size(); j++)
                if (comparator.compare(students.get(j), students.get(min_idx)) < 0)
                    min_idx = j;

            // Swapping the elements
            Student temp = students.get(min_idx);
            students.set(min_idx, students.get(i));
            students.set(i, temp);
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(101, "Amanda", "Boston"));
        students.add(new Student(106, "Victor", "San Francisco"));
        students.add(new Student(105, "John", "New York"));
        students.add(new Student(102, "Alicia", "Miami"));
        students.add(new Student(104, "Zachary", "Seattle"));
        students.add(new Student(103, "Daisy", "Chicago"));
        students.add(new Student(107, "Bruce", "Newark"));
        students.add(new Student(110, "Emma", "Los Angeles"));
        students.add(new Student(109, "Ronald", "Austin"));
        students.add(new Student(108, "Gina", "Portland"));

        System.out.println("Original list:");
        for (Student s : students) {
            System.out.println(s);
        }

        // sorting by name
        System.out.println("\nSorted by Name:");
        selectionSort(students, new NameComparator());
        for (Student s : students) {
            System.out.println(s);
        }

        // sorting by roll number
        System.out.println("\nSorted by Roll Number:");
        selectionSort(students, new RollNoComparator());
        for (Student s : students) {
            System.out.println(s);
        }
    }
}