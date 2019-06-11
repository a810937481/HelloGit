package com.book_task003.po;

public class Orders {

    private Integer id;
    private String number;

    public Orders(String number){
        this.number = number;
    }

    public Orders(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }

}
