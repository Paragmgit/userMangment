package com.example.userMangment.model;


import java.sql.Timestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="user_table")
public class User {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Integer userId;
     
     private String userName;
     
     @NotNull(message = "Date of Birth is required")
	 @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$",message =" Date of Birth must be yyyy-MM-dd format")
     private String dateOfBirth;
     
     @NotBlank(message="Email is requried")
	 @Email(message ="Invalid email format")
     private String email;
	 
     @NotBlank(message = " phone no is requried")
     @Pattern(regexp = "^\\+\\d{2}\\d{10}$")
     private String PhoneNo;
     
     private Timestamp date;
	 private Timestamp time;
}
