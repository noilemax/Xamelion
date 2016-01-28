package com.javarush.test.level29.lesson15.big01.human;

import java.util.List;

public class University
{
    private List<Student> students;
    private String name;
    private int age;

    public University(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade)
    {
        //TODO:
        if (!students.isEmpty())
        {
            for (Student student : students)
            {
                if (student.getAverageGrade() == averageGrade)
                {
                    return student;
                }
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade()
    {
        //TODO:
        if (!students.isEmpty())
        {
            Student student = students.get(0);
            for (Student current : students)
            {
                if (current.getAverageGrade() > student.getAverageGrade())
                {
                    student = current;
                }
            }
            return student;
        }
        return null;
    }

    public Student getStudentWithMinAverageGrade()
    {
        //TODO:
        if (!students.isEmpty())
        {
            Student student = students.get(0);
            for (Student current : students)
            {
                if (current.getAverageGrade() < student.getAverageGrade())
                {
                    student = current;
                }
            }
            return student;
        }
        return null;
    }

    public void expel(Student student)
    {
        if (students.contains(student))
        {
            students.remove(student);
        }
    }

    public List<Student> getStudents()
    {
        return students;
    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}
//Разделение запроса и модификатора. Раздели метод
//        getStudentWithMinAverageGradeAndExpel на Student getStudentWithMinAverageGrade() и
//        void expel(Student student). Первый метод должен возвратить студента с
//        минимальным средним балом, а второй - отчислить переданного студента (удалять из
//        списка students).