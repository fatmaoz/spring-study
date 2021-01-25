package com.cybertek.bootstrap;


import com.cybertek.entity.Post;
import com.cybertek.entity.Tag;
import com.cybertek.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    @Autowired
    PostRepository postRepository;


    @Override
    public void run(String... args) throws Exception {
        Post post = new Post("ORM","ManyToMany");
        Post post1 = new Post("MVC","Controller");


        Tag tag = new Tag("SpringBoot");
        Tag tag1 = new Tag("JPA");

        post.getTags().add(tag);
        post1.getTags().add(tag1);

        tag.getPosts().add(post);
        post1.getTags().add(tag);

        postRepository.save(post);
        postRepository.save(post1);

    }
}
