package com.gdsc.homework.fifthhomework.domain.comment;

import com.gdsc.homework.fifthhomework.domain.post.Post;
import com.gdsc.homework.fifthhomework.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    Optional<Comment> findByUserAndPost(User user, Post post);

    List<Comment> findByPost(Post post);

    List<Comment>findByUser(User user);

    Optional<Comment> findById(Long id);

}
