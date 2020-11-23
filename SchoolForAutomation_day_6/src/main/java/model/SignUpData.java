package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SignUpData {

    private String firstName;

    private String lastName;

    private String password;

    private String email;

    private String phone;

    private String address;
}
