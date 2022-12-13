package com.example.hello.dto;

public class MemberDto {
    private String name;
    private String email;
    private String organization;

    //getter and setter
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

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override //컨트롤러의 메서드에서 쿼리 파라미터의 key와 매핑됨
    public String toString() {
        return "MemberDto{" +
                "name='" + name +'\'' +
                ", email='" + email + '\'' +
                ", organization='" + organization + '\'' +
                '}';
    }

}
