package top.demohiiiii.memos.memo;

import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import top.demohiiiii.memos.memo.domain.MemoRelation;
import top.demohiiiii.memos.memo.domain.MemoRelationType;

@Data
@AutoMapper(target = MemoRelation.class)
public class MemoRelationDto {
    private String memo;
    private String relatedMemo;
    private MemoRelationType type;
}
