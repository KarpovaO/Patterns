package utils;

import com.github.javafaker.Faker;
import entities.RegistrationInfo;
import lombok.experimental.UtilityClass;

import java.util.Locale;

@UtilityClass
public class DataGenerator {
    @UtilityClass
    public static class Registration {
        public static RegistrationInfo generateInfo(String locale) {
            Faker faker = new Faker(new Locale(locale));
            return new RegistrationInfo(
                    faker.address().city(),
                    faker.name().fullName(),
                    faker.phoneNumber().phoneNumber()
            );
        }
    }
}
