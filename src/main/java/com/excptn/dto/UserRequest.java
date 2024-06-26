package com.excptn.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {
    @NotNull(message = "Username shouldn't be null!!!")
    private String name;
    @Email
    @NotBlank
    @Pattern(regexp = ".*\\.com$", message = "Invalid email address!!!")
    private String email;
    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}", message = "Invalid phone number entered")
    private String mobile;
    private String gender;
    @Min(value = 18, message = "Above 18 only!!!")
    @Max(value = 64, message = "Age should be less than 65")
    private int age;
    @NotBlank
    private String nationality;
}
