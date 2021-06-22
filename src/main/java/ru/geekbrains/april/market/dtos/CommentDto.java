package ru.geekbrains.april.market.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.april.market.models.Comment;
import ru.geekbrains.april.market.models.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class CommentDto {
    private Long id;
    private String description;
    private String userName;
    private LocalDateTime createdAt;



    public CommentDto(Comment comment) {
        this.id = comment.getId();
        this.description = comment.getDescription ();
        this.userName = comment.getUser ().getUsername ();
        this.createdAt = comment.getCreatedAt ();
    }
}
