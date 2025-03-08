package com.example.labs;

public class Lab9Job {
    int id;
    String name;
    
    public Lab9Job(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Lab9Job[] SeedData() {
        return new Lab9Job[] {
            new Lab9Job(1, "Developer"),
            new Lab9Job(2, "Designer"),
            new Lab9Job(3, "Tester"),
            new Lab9Job(4, "Manager"),
            new Lab9Job(5, "Director")
        };
    }
}
