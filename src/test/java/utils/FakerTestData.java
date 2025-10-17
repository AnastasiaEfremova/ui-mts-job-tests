package utils;

import net.datafaker.Faker;

import java.util.Locale;

public class FakerTestData {

    private static final Faker faker = new Faker(new Locale("ru"));

    public static String getRandomCity() {
        String[] cities = {"Казань", "Санкт-Петербург", "Новосибирск", "Екатеринбург", "Нижний Новгород"};
        return faker.options().option(cities);
    }

    public static String getRandomJobTitle() {
        String[] jobs = {
                "Java разработчик", "Python разработчик", "Frontend разработчик",
                "QA инженер", "Аналитик данных", "Системный администратор"
        };
        return faker.options().option(jobs);
    }
}