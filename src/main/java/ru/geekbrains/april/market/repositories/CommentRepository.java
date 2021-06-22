package ru.geekbrains.april.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.april.market.models.Comment;
import ru.geekbrains.april.market.models.Order;
import ru.geekbrains.april.market.models.Product;
import ru.geekbrains.april.market.models.User;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByProduct(Product product);
}