package top.demohiiiii.memos.memo;

import lombok.Builder;
import lombok.Data;
import top.demohiiiii.memos.memo.infrastructure.MemoPo;

import java.util.List;

@Data
@Builder
public class ListMemosResponse {
    private List<MemoDto> memos;
    private String nextPageToken;
}
