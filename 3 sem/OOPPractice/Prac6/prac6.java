package OOPPractice.Prac6;

import java.util.Arrays;
import java.util.Comparator;

public class prac6 {
    public static void main(String[] args) {
        Student[] students = new Student[] {
                new Student(1, 10),
                new Student(2, 3),
                new Student(3, 23),
                new Student(4, 75),
                new Student(5, 52),
                new Student(6, 98),
                new Student(7, 47),
        };
        Arrays.sort(students);

        System.out.println("By ID:");
        for (Student s : students)
            System.out.println(s);

        Arrays.sort(students, new SortingStudentsByGPA());

        System.out.println("By GPA:");
        for (Student s : students)
            System.out.println(s);
    }
}

class Student implements Comparable<Student>{
   int iDNumber;
   int GPA;
    Student(int iDNumber, int GPA){
        this.GPA = GPA;
        this.iDNumber = iDNumber;
    }

    @Override
    public int compareTo(Student o) {
        if (iDNumber > o.iDNumber) {
            return 1;
            } else if (iDNumber == o.iDNumber) {
            return 0;
        } else
            return -1;
    }

    public String toString() {
        return String.format("ID: %d, GPA: %d", iDNumber, GPA);
    }
}

class SortingStudentsByGPA implements Comparator<Student> {
    public int compare(Student o1, Student o2) {
        if (o1.GPA < o2.GPA) {
            return -1;
        } else if (o1.GPA == o2.GPA) {
            return 0;
        } else
            return 1;
    }

    public boolean equals(Object obj) {
        return this == obj;
    }
}