package com.example.project.Student;
import java.util.ArrayList;
import java.util.Arrays;

public class Utility {

    public static ArrayList<Student> sortStudents(ArrayList<Student> list){
        ArrayList<Student> newarr = new ArrayList<Student>();
        Student earliestStudent = new Student("AAAA", "AAAAA", 1);
        int removeIndex = 0;

        boolean lastEqual = false; //these are booleans to make sure other comparasions don't equal
        boolean firstEqual = false;

        while(list.size() > 0) { //repeats until there are no students left
            earliestStudent = new Student("ZZZZZZZZZZZ", "ZZZZZZZZZZZZ", 1); //sets the comparasion to a insanlly easy to override student object
            removeIndex = 0;
            for (int j = 0; j < list.size(); j++) { //goes through the entire list

                lastEqual = false; //resets booleans for each element
                firstEqual = false;

                if (earliestStudent.getLastName().compareTo(list.get(j).getLastName()) >= 0) { //compares the current element to the "earliest student"
                    if (earliestStudent.getLastName().equals(list.get(j).getLastName())) { //if last name equals
                        lastEqual = true; //flags true, so other comparasions don't work
                        if (earliestStudent.getGpa() == list.get(j).getGpa() && earliestStudent.getGpa() > list.get(j).getGpa()) { //if first names equal, compare gpa
                            firstEqual = true; //flags true, so other comparasions don't work
                            if (earliestStudent.getGpa() > list.get(j).getGpa()) { //compares whether gpa is higher
                                earliestStudent = list.get(j); //if the gpa of the comparing element is higher, set it as earlier
                                removeIndex = j;
                            }
                        }
                        if (!firstEqual) { //comparasion for last name does not occur if they equal, and firstname is considered
                            if (earliestStudent.getFirstName().compareTo(list.get(j).getFirstName()) >= 0) { //if 
                            earliestStudent = list.get(j);//if the firstname of the comparing element is earlier, set it as earlier
                            removeIndex = j; 
                            }
                        }
                    }
                    if (!firstEqual && !lastEqual) { //comparasion for last name does not occur if they equal, and gpa / first name is considered
                        earliestStudent = list.get(j); //if the current element is earlier than "earliest student" set earliest student to current element
                        removeIndex = j; //takes where the element is for removal later
                    }
                }
            }

            newarr.add(earliestStudent); //adds the earliest student, then removes it from the list so it is not compared to again
            list.remove(removeIndex);
            
        }
        return newarr;
    }


}
