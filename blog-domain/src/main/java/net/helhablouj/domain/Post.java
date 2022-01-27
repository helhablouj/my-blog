package net.helhablouj.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String slug;

    @Transient // first X words of the body
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String excerpt;

    private String body;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public String getExcerpt() {
        int excerptLength = (body.length() > 150) ? 150 : body.length();
        return body.substring(0, excerptLength) + "...";
    }
}
