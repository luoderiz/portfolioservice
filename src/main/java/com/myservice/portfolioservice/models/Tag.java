package com.myservice.portfolioservice.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tag_id;

    @NotBlank(message = "Tag should not be null or blank")
    @Size(min = 3, max = 45, message = "Tag must be between 3 and 45 characters")
    private String tag;

    public Tag() {
    }

    public Integer getTag_id() {
        return tag_id;
    }

    public void setTag_id(Integer id) {
        this.tag_id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
