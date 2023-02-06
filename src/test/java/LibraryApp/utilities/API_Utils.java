package LibraryApp.utilities;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class API_Utils {

    public static Faker faker = new Faker();

    public static Map<String, Object> getRandomUserMap(String role) {
        Map<String, Object> userBodyMap = new LinkedHashMap<>();
        userBodyMap.put("full_name", faker.name().fullName());
        userBodyMap.put("email", faker.internet().emailAddress());
        userBodyMap.put("password", faker.internet().password());
        switch (role.toLowerCase()) {
            case "librarian":
                userBodyMap.put("user_group_id", 2);
                break;

            case "admin":
                userBodyMap.put("user_group_id", 1);
                break;
            case "students":
                userBodyMap.put("user_group_id", 3);
                break;
        }
        userBodyMap.put("status", "ACTIVE");
        userBodyMap.put("start_date", LocalDate.now());
        userBodyMap.put("end_date", LocalDate.of(LocalDate.now().getYear() + 1, LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth()));
        userBodyMap.put("address", faker.address().fullAddress());

        return userBodyMap;

    }
}
