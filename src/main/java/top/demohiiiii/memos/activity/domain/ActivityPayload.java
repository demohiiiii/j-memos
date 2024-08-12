package top.demohiiiii.memos.activity.domain;

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
public class ActivityPayload implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private ActivityMemoCommentPayload memoComment;
    private ActivityVersionUpdatePayload versionUpdate;
}
