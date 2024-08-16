package top.demohiiiii.memos.memo;

import lombok.Builder;
import lombok.Data;
import top.demohiiiii.memos.memo.domain.Memo;

import java.util.List;

@Data
@Builder
public class ListMemosResponse {
    private List<Memo> memos;
    private String nextPageToken;
}
