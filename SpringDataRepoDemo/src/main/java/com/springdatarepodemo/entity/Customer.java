package com.springdatarepodemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Tên không được để trống")
    @Size(min = 1, max = 20, message = "Tên phải có 1 - 20 ký tự")
    private String name;

    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Email không đúng định dạng, VD: example@gmail.com")
    private String email;
    @NotEmpty(message = "Địa chỉ không được để trống")
    private String address;

    @ManyToOne
    private Type type;

    public Customer() {
    }

    public Customer(Long id, String name, String email, String address, Type type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.type = type;
    }

    public Customer(Long id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}

/*
 Regex hay được là mẫu chuỗi: "abc", "cde" là cách tạo khuôn mẫu của chuỗi và khi dữ liệu vào
 mà có regex thì sẽ phải tuân mẫu đó.
*/
