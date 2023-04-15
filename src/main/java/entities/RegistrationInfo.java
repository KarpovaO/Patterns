package entities;

import lombok.*;

@Data
@RequiredArgsConstructor
public class RegistrationInfo {
    private final String city;
    private final String name;
    private final String phone;

}
