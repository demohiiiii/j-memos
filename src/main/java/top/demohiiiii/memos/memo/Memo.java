package top.demohiiiii.memos.memo;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.demohiiiii.memos.common.RowStatus;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "memo")
public class Memo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private String uid;

    private Integer creatorId;

    private Long createdTs;

    private Long updatedTs;

    private RowStatus rowStatus;

    private String content;

    private Visibility visibility;

    private String tags;

    private String payload;

}
