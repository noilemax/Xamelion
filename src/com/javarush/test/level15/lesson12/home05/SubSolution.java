package com.javarush.test.level15.lesson12.home05;

/**
 * Created by Администратор on 27.10.2015.
 */
public class SubSolution extends Solution

{
    private SubSolution(Number priv1){
        super(priv1);
    }
    private SubSolution(Boolean priv2){
        super(priv2);
    }
    private SubSolution(Float priv3){
        super(priv3);
    }

    public SubSolution(Object pub1)
    {
        super(pub1);
    }

    public SubSolution(String pub2)
    {
        super(pub2);
    }

    public SubSolution(Integer pub3)
    {
        super(pub3);
    }

    protected SubSolution(Character prot1)
    {
        super(prot1);
    }

    protected SubSolution(Double prot2)
    {
        super(prot2);
    }

    protected SubSolution(Exception prot3)
    {
        super(prot3);
    }
    SubSolution(byte noModif1){
        super(noModif1);
    }
    SubSolution(int noModif2){
        super(noModif2);
    }
    SubSolution(double noModif3){
        super(noModif3);
    }
}
