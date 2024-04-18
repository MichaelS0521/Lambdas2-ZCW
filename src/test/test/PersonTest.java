import Lambdas.CheckPerson;
import Lambdas.Person;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class PersonTest {

    @Test
    public void testPersonInstanceOfTester() {
        Person person = new Person("Michael", LocalDate.of(2002,5,21), Person.Sex.MALE, "zipcodeIsFun@gmail.com");

        Assert.assertTrue(person instanceof CheckPerson);
    }

    @Test
    public void testGetAge() {
        Person person = new Person("Michael", LocalDate.of(2002,5,21), Person.Sex.MALE, "zipcodeIsFun@gmail.com");
        person.networkingAttendance.add(person);

        int expectedAge = 21;
        int actualAge = person.getAge();

        Assert.assertEquals(expectedAge, actualAge);
    }

    @Test
    public void testGetBirthday() {
        Person person = new Person("Michael", LocalDate.of(2002,5,21), Person.Sex.MALE, "zipcodeIsFun@gmail.com");
        person.networkingAttendance.add(person);

        LocalDate expectedDate = LocalDate.of(2002, 5, 21);

        Assert.assertEquals(expectedDate, person.getBirthday());
    }


    @Test
    public void testGetName() {
        Person person = new Person("Michael", LocalDate.of(2002,5,21), Person.Sex.MALE, "zipcodeIsFun@gmail.com");
        person.networkingAttendance.add(person);

        String expectedPerson = "Michael";

        Assert.assertEquals(expectedPerson, person.getName());
    }

    @Test
    public void testGetGender() {
        Person person = new Person("Michael", LocalDate.of(2002,5,21), Person.Sex.MALE, "zipcodeIsFun@gmail.com");
        person.networkingAttendance.add(person);

        Person.Sex expectedPerson = Person.Sex.MALE;

        Assert.assertEquals(expectedPerson, person.getGender());
    }

    @Test
    public void testGetGmail() {
        Person person = new Person("Michael", LocalDate.of(2002,5,21), Person.Sex.MALE, "zipcodeIsFun@gmail.com");
        person.networkingAttendance.add(person);

        String expectedPerson = "zipcodeIsFun@gmail.com";

        Assert.assertEquals(expectedPerson, person.getEmailAddress());
    }

    @Test
    public void testSetName() {
        Person person = new Person("", LocalDate.of(2002,5,21), Person.Sex.MALE, "zipcodeIsFun@gmail.com");

        person.setName("Smith");

        String expectedName = "Smith";

        Assert.assertEquals(expectedName, person.getName());
    }

    @Test
    public void testSetBirthday() {
        Person person = new Person("Michael", LocalDate.of(2002,5,21), Person.Sex.MALE, "zipcodeIsFun@gmail.com");

        person.setBirthday(LocalDate.of(2006,5,15));

        LocalDate expectedDate = LocalDate.of(2006, 5, 15);

        Assert.assertEquals(expectedDate, person.getBirthday());
    }

    @Test
    public void testSetGender() {
        Person person = new Person("Michael", LocalDate.of(2002,5,21), Person.Sex.MALE, "zipcodeIsFun@gmail.com");

        person.setGender(Person.Sex.FEMALE);


        Assert.assertEquals(Person.Sex.FEMALE, person.getGender());
    }

    @Test
    public void testSetGmail() {
        Person person = new Person("Michael", LocalDate.of(2002,5,21), Person.Sex.MALE, "zipcodeIsFun@gmail.com");

        person.setEmailAddress("lambdas@gmail.com");

        String expectedEmail = "lambdas@gmail.com";

        Assert.assertEquals(expectedEmail, person.getEmailAddress());
    }

    @Test
    public void testToString() {
        Person person = new Person("Michael", LocalDate.of(2002,5,21), Person.Sex.MALE, "zipcodeIsFun@gmail.com");
        person.networkingAttendance.add(person);

        String expectedString = person.toString();

        Assert.assertEquals(expectedString, person.printPerson());
    }

    @Test
    public void testAgeCheckOne() {
        Person person = new Person("Michael", LocalDate.of(2002,5,21), Person.Sex.MALE, "zipcodeIsFun@gmail.com"); //21
        Person person2 = new Person("John", LocalDate.of(2006,5,21), Person.Sex.MALE, "johniscool@gmail.com"); //17

        person.networkingAttendance.add(person); //21
        person.networkingAttendance.add(person2); //17

        String expectedString = person.toString();

        Assert.assertEquals(expectedString, person.printPersonsOlderThan(person.networkingAttendance, 20));
    }

    @Test
    public void testAgeCheckTwo() {
        Person person = new Person("Michael", LocalDate.of(2002,5,21), Person.Sex.MALE, "zipcodeIsFun@gmail.com"); //21
        Person person2 = new Person("John", LocalDate.of(2006,5,21), Person.Sex.MALE, "johniscool@gmail.com"); //17

        person.networkingAttendance.add(person); //21
        person.networkingAttendance.add(person2); //17

        String expectedString = person.toString();

        Assert.assertEquals(expectedString, person.printPersonsWithinAgeRange(person.networkingAttendance, 18, 24));
    }

    @Test
    public void testCheckGender() {
        Person person = new Person("Michael", LocalDate.of(2002,5,21), Person.Sex.MALE, "zipcodeIsFun@gmail.com"); //21
        Person person2 = new Person("Nicole", LocalDate.of(2006,5,21), Person.Sex.FEMALE, "nicole@gmail.com"); //17

        person.networkingAttendance.add(person); //21
        person.networkingAttendance.add(person2); //17

        String expectedString = person.toString();

        Assert.assertEquals(expectedString, person.printPersons(person.networkingAttendance));
    }
}
