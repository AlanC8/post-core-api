package kz.java.postcoreapi.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostModel {
    private String postId;
    @NotNull
    private String clientId;
    @NotNull
    private String postRecipientId;
    @NotNull
    private String postItem;
    private String status;
}
