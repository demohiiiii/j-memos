package top.demohiiiii.memos.memo.domain;

import com.mybatisflex.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "memo_relation")
public class MemoRelation implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer memoId;

    private Integer relatedMemoId;

    private MemoRelationType type;

}
