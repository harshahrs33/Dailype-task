package com.dailpe.application.Dtos;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Update {
    @JsonAlias("full_name")
    private String fullName;

    @JsonAlias("mob_num")
    private String mobileNumber;

    @JsonAlias("pan_num")
    private String panNumber;

    @JsonAlias("manager_id")
    private String managetId;

}
