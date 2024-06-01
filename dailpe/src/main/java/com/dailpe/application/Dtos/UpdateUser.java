package com.dailpe.application.Dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUser {

    @JsonAlias("user_ids")
    private List<String> usreIds;

    @JsonAlias("update_data")
    private List<Update> data;
    
}
