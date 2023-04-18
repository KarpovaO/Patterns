import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@UtilityClass
public class DataGeneratorTest {

    @BeforeEach
    void setUpAll() {
        Faker faker = new Faker(new Locale("ru"));

    }

    public String generateDate(long addDays, String pattern) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }

    @UtilityClass
    public static class Registration {
        public static RegistrationInfoTest generateInfo(String locale) {
            Faker faker = new Faker(new Locale(locale));
            return new RegistrationInfoTest(
                    faker.address().city(),
                    faker.name().fullName(),
                    faker.phoneNumber().phoneNumber()
            );
        }
    }
}
