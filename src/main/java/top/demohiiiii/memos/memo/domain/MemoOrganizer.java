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
@Table(value = "memo_organizer")
public class MemoOrganizer implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer memoId;

    private Integer userId;

    private boolean pinned;

}
