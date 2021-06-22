package ru.geekbrains.april.market.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.april.market.dtos.CommentDto;
import ru.geekbrains.april.market.dtos.OrderDto;
import ru.geekbrains.april.market.dtos.ProductDto;
import ru.geekbrains.april.market.models.Comment;
import ru.geekbrains.april.market.models.Product;
import ru.geekbrains.april.market.models.User;
import ru.geekbrains.april.market.services.CommentService;
import ru.geekbrains.april.market.services.OrderService;
import ru.geekbrains.april.market.services.ProductService;
import ru.geekbrains.april.market.services.UserService;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product_info")
public class CommentController {
    private final CommentService commentService;
    private final ProductService productService;
    private final UserService userService;

    @PostMapping
    @Transactional
    public void createNewComment(Principal principal, @RequestParam(name = "prodId") Long id, @RequestParam String description) {
        User user = userService.findByUsername(principal.getName()).get();
        Product product = productService.findById (id).get ();
        commentService.createNewComment (description, user, product);
    }

    @GetMapping ("/{id}")
    @Transactional
    public List<CommentDto> getAllCommentsForProduct(@PathVariable Long product_id) {
        Product product = productService.findById (product_id).get ();
        return commentService.findAllByProduct (product).stream ().map(CommentDto::new).collect(Collectors.toList());

    }
}
