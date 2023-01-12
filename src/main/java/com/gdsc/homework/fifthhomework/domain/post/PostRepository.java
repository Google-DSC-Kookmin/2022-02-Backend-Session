package com.gdsc.homework.fifthhomework.domain.post;

import com.gdsc.homework.fifthhomework.domain.user.User;
import com.gdsc.homework.fifthhomework.dto.post.response.PostsOrderByIdDescDto;
import com.gdsc.homework.fifthhomework.dto.post.response.PostsOrderByLikesDto;
import net.bytebuddy.TypeCache;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {
    Optional<Post> findByUser(User user);

    List<Post> findAllByOrderByIdDesc();

    List<Post> findAllByOrderByLikeCountDesc();
}
