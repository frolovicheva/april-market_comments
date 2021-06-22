package ru.geekbrains.april.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.april.market.models.*;
import ru.geekbrains.april.market.repositories.CommentRepository;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public List<Comment> findAllByProduct(Product product) { return commentRepository.findAllByProduct (product);
    }

   public void createNewComment (String description, User user, Product product){
        Comment comment = new Comment ();
        comment.setDescription (description);
        comment.setUser (user);
        comment.setProduct (product);
        commentRepository.save (comment);
    }
}
