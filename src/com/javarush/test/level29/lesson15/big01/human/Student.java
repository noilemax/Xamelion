package com.javarush.test.level29.lesson15.big01.human;

import java.util.Date;

public class Student extends UniversityPerson
{
    private double averageGrade;
    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    @Override
    public String getPosition()
    {
        return "Студент";
    }


    public Student(String name, int age, double averageGrade)
    {
        super(name, age);
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }

    @Override
    public void live()
    {
        learn();
    }

    public void learn()
    {
    }

    public void incAverageGrade(double delta)
    {
        setAverageGrade(getAverageGrade() + delta);
//        double newAverageDate = getAverageGrade() + delta;
//        setAverageGrade(newAverageDate);
    }

    public void setCourse(int course)
    {
        this.course = course;
    }

    public void setAverageGrade(double averageGrade)
    {
        this.averageGrade = averageGrade;
    }

    public void setBeginningOfSession(Date date)
    {
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date)
    {
        endOfSession = date;
    }

    public double getAverageGrade()
    {
        return averageGrade;
    }

    public int getCourse()
    {
        return course;
    }
}
