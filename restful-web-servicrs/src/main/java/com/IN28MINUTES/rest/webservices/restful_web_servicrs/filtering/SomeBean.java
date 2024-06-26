package com.IN28MINUTES.rest.webservices.restful_web_servicrs.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

//@JsonIgnoreProperties({"field2"}) 
@JsonFilter("SomeBeanFilter")
public class SomeBean {
    private String field1;
    
    private String field2;
    
    private String field3;

    // Default constructor
    public SomeBean() {}

    // Parameterized constructor
    public SomeBean(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    // Getters and Setters
    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }
}
