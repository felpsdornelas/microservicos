package com.iftm.start_example.models.dto;

import com.iftm.start_example.models.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
     private String id;
     private String name;
     private int age;
     private Address address;
}
