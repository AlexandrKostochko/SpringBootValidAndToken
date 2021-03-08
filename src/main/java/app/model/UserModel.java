package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    @Pattern(regexp = "\\w{5,10}")
    private String userName;
    @Pattern(regexp = "\\S{6,15}", message = "length from 6 to 15, don't use space")
    private String password;
}
