package de.iritgo.lambda;

public class Person
{
    private final String firstName;
    private final String lastName;
    private final String company;

    private Person(String firstName, String lastName, String company)
    {

        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
    }

    public static _BuildFirstName build ()
    {
        return firstName ->
               lastName ->
               company -> new Person (firstName, lastName, company);
    }

    public interface _BuildFirstName
    {
        _BuildLastName firstName (String firstName);
    }

    public interface _BuildLastName
    {
        _BuildCompany lastName (String lastName);
    }

    public interface _BuildCompany
    {
        Person company (String company);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }
}
