package top.demohiiiii.memos.memo;

import com.mybatisflex.core.query.QueryWrapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.demohiiiii.memos.memo.domain.MemoRelation;
import top.demohiiiii.memos.memo.infrastructure.MemoRelationMapper;

import java.util.List;

import static top.demohiiiii.memos.memo.domain.table.MemoRelationTableDef.MEMO_RELATION;

@Service
@AllArgsConstructor
public class MemoRelationService {
    private MemoRelationMapper relationMapper;

    public List<MemoRelation> listRelations(int id) {

        List<MemoRelation> memoRelations = relationMapper.selectListByQuery(QueryWrapper.create().select().where(MEMO_RELATION.MEMO_ID.eq(id)).or(MEMO_RELATION.RELATED_MEMO_ID.eq(id)));
    }
}
