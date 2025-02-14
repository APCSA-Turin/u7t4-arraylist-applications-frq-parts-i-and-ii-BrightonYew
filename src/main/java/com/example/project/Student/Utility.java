package com.example.project.Student;
import java.util.ArrayList;
import java.util.Arrays;

public class Utility {

    public static ArrayList<Student> sortStudents(ArrayList<Student> list){
        ArrayList<Student> newarr = new ArrayList<Student>();
        Student earliestStudent = new Student("AAAA", "AAAAA", 1);
        int removeIndex = 0;

        boolean lastEqual = false;
        boolean firstEqual = false;

        while(list.size() > 0) { //repeats until there are no students left
            earliestStudent = new Student("ZZZZZZZZZZZ", "ZZZZZZZZZZZZ", 1);
            removeIndex = 0;
            for (int j = 0; j < list.size(); j++) { //goes through the entire list

                lastEqual = false;
                firstEqual = false;

                if (earliestStudent.getLastName().compareTo(list.get(j).getLastName()) >= 0) { //compares the current element to the "earliest student"
                    if (earliestStudent.getLastName().equals(list.get(j).getLastName()) && earliestStudent.getFirstName().compareTo(list.get(j).getFirstName()) >= 0) { //if it equals and the first name is (earlier / later) ????
                        lastEqual = true;
                        if (earliestStudent.getGpa() == list.get(j).getGpa() && earliestStudent.getGpa() > list.get(j).getGpa()) { //if first names equal, compare gpa
                            firstEqual = true;

                            earliestStudent = list.get(j);
                            removeIndex = j;
                        }
                        if (!firstEqual) { //comparasion for first name does not occur if they equal, and gpa is considered
                            earliestStudent = list.get(j);
                            removeIndex = j; 
                        }
                    }
                    if (!firstEqual && !lastEqual) { //comparasion for last name does not occur if they equal, and gpa / first name is considered
                        earliestStudent = list.get(j); //if the current element is earlier than "earliest student" set earliest student to current element
                        removeIndex = j; //takes where the element is for removal later
                    }
                }
            }

            newarr.add(earliestStudent);
            list.remove(removeIndex);
            
        }
        return newarr;
    }

    public static int compare(Student stu1, Student stu2) {
        return 0;
    }

}
