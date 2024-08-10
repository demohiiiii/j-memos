package top.demohiiiii.memos.activity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityMemoCommentPayload {
    private Integer memoId;
    private Integer relatedMemoId;
}
