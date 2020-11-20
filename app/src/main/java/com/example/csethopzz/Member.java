package com.example.csethopzz;

public class Member {
    private String id,name,feedback;

   public Member(){

    }

    public Member(String id, String name, String feedback) {
        this.id = id;
        this.name = name;
        this.feedback = feedback;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFeedback() {
        return feedback;
    }
}
