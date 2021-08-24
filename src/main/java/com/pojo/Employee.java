package com.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder(setterPrefix = "set")
@Getter
@Setter
public class Employee {

    private int id;
    private String fname;
    private String lname;
}
