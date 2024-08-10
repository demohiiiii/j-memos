package top.demohiiiii.memos.user;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.demohiiiii.memos.common.RowStatus;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "user")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private Long createdTs;

    private Long updatedTs;

    private RowStatus rowStatus;

    private String username;

    private MemosRole role;

    private String email;

    private String nickname;

    private String passwordHash;

    private String avatarUrl;

    private String description;

}
