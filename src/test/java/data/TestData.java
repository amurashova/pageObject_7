package data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    Faker faker = new Faker(new Locale("en"));
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String emailAddress = faker.internet().emailAddress();
    public String streetAddress = faker.address().streetAddress();
    public String gender = faker.options().option("Male", "Female", "Other");
    public String number = faker.phoneNumber().subscriberNumber(10);
    public String day = String.format("%s",faker.number().numberBetween(1, 28));
    public String month = faker.options().option("January", "February", "March", "April",
                                                    "May", "June", "July", "August", "September", "October", "November", "December");
    public String year = String.format("%s",faker.number().numberBetween(1900,2100));
    public String subjects = faker.options().option("Chemistry", "Computer Science", "Commerce", "Economics",
            "Civics");
    public String hobbies = faker.options().option("Sports", "Reading", "Music");
    public String picture = faker.options().option("dog.jpg");
    public String state = faker.options().option("NCR", "Haryana", "Rajasthan");
    public String city = getRandomCity();

    public String getRandomCity() {
        if (state.equals("NCR")) city = faker.options().option("Gurgaon", "Noida");
        if (state.equals("Haryana")) city = faker.options().option("Karnal", "Panipat");
        if (state.equals("Rajasthan")) city = faker.options().option("Jaipur", "Jaiselmer");
        return city;
    }

}