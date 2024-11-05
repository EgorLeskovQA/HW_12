package utils;
import com.github.javafaker.Faker;

import java.time.LocalDate;

public class RandomUtils {
    Faker faker = new Faker();


    public String firstName() {
        return faker.name().firstName();
    }

    public String lastName() {
        return faker.name().lastName();
    }

    public String userEmail() {
        return faker.internet().emailAddress();
    }

    public String gender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public String userNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String dayOfBirth() {
        return String.format("%02d", faker.number().numberBetween(1, 28));
    }

    public String monthOfBirth() {
        return faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
    }

    public String yearOfBirth() {
        return String.valueOf(faker.number().numberBetween(1900, LocalDate.now().getYear()));
    }

    public String subjects() {
        return faker.options().option("History", "Arts", "Maths", "Social Studies");
    }

    public String pictureRandom() {
        return faker.options().option("tst.jpg", "tst2.jpg","tst3.jpg");
    }

    public String hobbies() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public String address() {
        return faker.address().streetAddress();
    }

    public String state() {
        return faker.options().option("NCR", "Haryana", "Uttar Pradesh", "Rajasthan");
    }

    public String city(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Lucknow", "Merrut", "Agra");
            case "Haryana" -> faker.options().option("Panipap", "Karnal");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaisalmer");
            default -> "";
        };
    }

}
