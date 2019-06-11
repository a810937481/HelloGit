package bbs.domain;

public class Forum {

    private Integer forum_id;
    private String name;
    private String description;
    private String image;

    public Forum(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public Forum(){}

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
