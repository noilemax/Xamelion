package com.javarush.test.level29.lesson15.big01.human;

public class Teacher extends UniversityPerson
{
    private int numberOfStudents;

    @Override
    public String getPosition()
    {
        return "Преподаватель";
    }


    public Teacher(String name, int age, int numberOfStudents)
    {
        super(name, age);
        this.name = name;
        this.age = age;
        this.numberOfStudents = numberOfStudents;
    }


    @Override
    public void live()
    {
        teach();
    }

    public void teach()
    {
    }


}
