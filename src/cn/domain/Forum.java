package cn.domain;

public class Forum {

    private Integer forum_id;
    private String name;

    public Forum(String name) {
        this.name = name;
    }

    public Forum(){ }

    public Integer getForum_id() {
        return forum_id;
    }

    public void setForum_id(Integer forum_id) {
        this.forum_id = forum_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Forum{" +
                "forum_id=" + forum_id +
                ", name='" + name + '\'' +
                '}';
    }
}
