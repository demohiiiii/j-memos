package top.demohiiiii.memos.memo;

import com.mybatisflex.core.query.QueryWrapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.demohiiiii.memos.memo.domain.MemoMapper;

@Service
@AllArgsConstructor
public class MemoService {
    private MemoMapper memoMapper;

    public ListMemosResponse listMemos(int pageSize, String pageToken, MemoFilter filter) {

        QueryWrapper select = QueryWrapper.create().select();

        memoMapper.selectListByQuery()
        return ListMemosResponse.builder().build();
    }
}
