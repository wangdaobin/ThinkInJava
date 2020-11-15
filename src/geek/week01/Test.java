package geek.week01;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description : 排序
 * @Author : WDB
 * @Date: 2020-10-22 16:09
 */
public class Test {
    public static void main(String[] args) {
        Student a = new Student("a",10,1000);
        Student b = new Student("a",20,1000);
        Student c = new Student("a",10,800);

        Student[] students = {a,b,c};

        for(int i=1;i<students.length;i++){

        }
    }
}

class Student{
    public String name;
    public int dept;
    public int salary;

    public Student(String name,int dept,int salary){
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
}