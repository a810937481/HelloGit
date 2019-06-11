package com.student;

public class Student {

    private String name;
    private Integer age;
    private Phone phone;

    public Student(){
        super();
    }

    public Student(String name,Integer age,Phone phone){
        super();
        this.name=name;
        this.age=age;
        this.phone=phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Phone getPhone(){ return  phone; }

    public  void setPhone(Phone phone){ this.phone = phone; }

    public String toString(){
        return "Student [ name= "+ name +",age= "+ age +",phone="+ phone.getBrand() +"]";
    }

}
