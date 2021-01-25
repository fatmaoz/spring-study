package com.cybertek.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @ManyToMany(mappedBy = "tags", cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(name="post_tag_rel",joinColumns = {@JoinColumn(name = "post_id")},inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private Set<Tag> tags = new HashSet<>();
    //ManyToMany yaparken List yerine Set kullanmak daha iyi performans acisindan
    public Post(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
