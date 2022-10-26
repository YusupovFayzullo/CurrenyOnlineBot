package Entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Customer {
    private String chatId;
    private String lastName;
    private String firstName;
    private String phoneNumber;
}
