package com.dailpe.application.Models;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "user")
public class User {
    
    @Id
    @Column(name = "user_id",unique = true)
    private String userId;

    @Column(name="full_name",nullable = false,length = 50)
    @NotBlank
    @Length(max=50)
    private String fullName;

    @Column(name="mob_num",nullable = false,unique = true,length = 13)
    @Pattern( regexp = "^(\\+\\d{1,2})?\\d{10}$")
    private String mobileNumber;

    @Column(name="pan_num",nullable = false,unique = true,length = 11)
    @Pattern(regexp = "^([A-Z]{5}\\d{4}[A-Z])$")
    private String panNumber;

    @Column(name="manager_id",nullable = true)
    private String managetId;

    @Column(name="created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(name="updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name="is_active")
    private boolean isActive;
}
