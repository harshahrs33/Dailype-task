package com.dailpe.application.Dtos;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteUser {
    @JsonAlias("user_id")
    private String userId;

    @JsonAlias("mob_num")
    private String mobNum;
}
