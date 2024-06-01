package com.dailpe.application.Dtos;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonAlias;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUser {



    @NotBlank
    @Length(max=50)
    @JsonAlias("full_name")
    private String fullName;

    @Pattern( regexp = "^(\\+\\d{1,2})?\\d{10}$")
    @JsonAlias("mob_num")
    private String mobileNumber;

    @Pattern(regexp = "^([A-Z]{5}\\d{4}[A-Z])$")
    @JsonAlias("pan_num")
    private String panNumber;

    @JsonAlias("manager_id")
    private String managetId;
}
