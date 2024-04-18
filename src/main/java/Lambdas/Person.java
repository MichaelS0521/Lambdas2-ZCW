package Lambdas;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Person implements CheckPerson {

    @Override
    public boolean test(Person p) {
        return p.getGender() == Sex.MALE;
    }

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    LocalDate today = LocalDate.now();

    public ArrayList<Person> networkingAttendance = new ArrayList<>();

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getAge() {
        int age = 0;
        for (Person person : networkingAttendance) {
            LocalDate personBirthday = person.birthday;
            Period period = Period.between(personBirthday, today);
            age = period.getYears();
            return age;
        }
//        System.out.println("Person age: " + age);
        return age;
    }

    public String printPerson() {
        for (Person person : networkingAttendance) {
            return person.toString();
        }
        return "";
    }

    public String printPersonsOlderThan(ArrayList<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                return p.printPerson();
            }
        }
        return "";
    }

    public String printPersonsWithinAgeRange(ArrayList<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                return p.printPerson();
            }
        }
        return "";
    }

    public String printPersons(ArrayList<Person> roster) {
        for (Person p : roster) {
            if (p.test(p)) {
                return p.printPerson();
            }
        }
        return "";
    }

    @Override
    public String toString() {
        return "\nName: " + name +
                "\nBirthday: " + birthday +
                "\nGender: " + gender +
                "\nEmail: " + emailAddress;
    }
}