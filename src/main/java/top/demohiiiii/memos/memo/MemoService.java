package top.demohiiiii.memos.memo;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.query.QueryCondition;
import com.mybatisflex.core.query.QueryMethods;
import com.mybatisflex.core.query.QueryWrapper;
import io.github.linpeilie.Converter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.demohiiiii.memos.memo.domain.Memo;
import top.demohiiiii.memos.memo.infrastructure.MemoMapper;
import top.demohiiiii.memos.memo.domain.MemoRelationType;
import top.demohiiiii.memos.user.service.UserService;

import java.util.ArrayList;
import java.util.List;

import static top.demohiiiii.memos.memo.domain.table.MemoOrganizerTableDef.MEMO_ORGANIZER;
import static top.demohiiiii.memos.memo.domain.table.MemoRelationTableDef.MEMO_RELATION;
import static top.demohiiiii.memos.memo.infrastructure.table.MemoPoTableDef.MEMO_PO;

@Service
@AllArgsConstructor
public class MemoService {
    private MemoMapper memoMapper;
    private UserService userService;
    private Converter converter;

    private static final int DEFAULT_PAGE_SIZE = 10;

    public ListMemosResponse listMemos(int pageSize, String pageToken, MemoFilter filter) {
        FindMemo find = converter.convert(filter, FindMemo.class);
        find.setLimit(10);
        find.setOffset(0);
        return listMemos(find);
    }

    public ListMemosResponse listMemos(FindMemo find) {

        QueryCondition content = QueryCondition.createEmpty();
        if (CollUtil.isNotEmpty(find.getContentSearch())) {
            for (String contentSearch : find.getContentSearch()) {
                content = content.and(MEMO_PO.CONTENT.like(contentSearch));
            }
        }

        QueryCondition tagCondition = QueryCondition.createEmpty();
        if (CollUtil.isNotEmpty(find.getTagSearch())) {
            for (String tag : find.getTagSearch()) {
                tagCondition = tagCondition.and(QueryMethods.raw("JSON_EXTRACT(`memo`.`payload`, '$.property.tags') LIKE ?", "%" + tag + "%"));
            }
        }

        QueryWrapper select = QueryWrapper.create().select(MEMO_PO.ID, MEMO_PO.UID, MEMO_PO.CREATOR_ID, MEMO_PO.CREATED_TS, MEMO_PO.UPDATED_TS, MEMO_PO.ROW_STATUS, MEMO_PO.VISIBILITY, MEMO_PO.PAYLOAD, QueryMethods.ifNull(MEMO_RELATION.RELATED_MEMO_ID, new QueryColumn("0")).as("parent_id"))
                .from(MEMO_PO)
                .leftJoin(MEMO_ORGANIZER).on(MEMO_PO.ID.eq(MEMO_ORGANIZER.MEMO_ID).and(MEMO_PO.CREATOR_ID.eq(MEMO_ORGANIZER.USER_ID)))
                .leftJoin(MEMO_RELATION).on(MEMO_PO.ID.eq(MEMO_RELATION.MEMO_ID).and(MEMO_RELATION.TYPE.eq(MemoRelationType.COMMENT)))
                .where(MEMO_PO.ID.eq(find.getId(), find.getId() != null))
                .and(MEMO_PO.UID.eq(find.getUid(), StrUtil.isNotEmpty(find.getUid())))
                .and(MEMO_PO.CREATOR_ID.eq(find.getCreatorId(), find.getCreatorId() != null))
                .and(MEMO_PO.ROW_STATUS.eq(find.getRowStatus(), find.getRowStatus() != null))
                .and(MEMO_PO.CREATED_TS.lt(find.getCreatedTsBefore(), find.getCreatedTsBefore() != null))
                .and(MEMO_PO.CREATED_TS.gt(find.getCreatedTsAfter(), find.getCreatedTsAfter() != null))
                .and(MEMO_PO.UPDATED_TS.lt(find.getUpdatedTsBefore(), find.getUpdatedTsBefore() != null))
                .and(MEMO_PO.UPDATED_TS.gt(find.getUpdatedTsAfter(), find.getUpdatedTsAfter() != null))
                .and(MEMO_PO.VISIBILITY.in(find.getVisibilityList(), CollUtil.isNotEmpty(find.getVisibilityList())))
                .and(content)
                .and(MEMO_PO.PAYLOAD.eq(find.getRaw(), StrUtil.isNotEmpty(find.getRaw())))
                .and(tagCondition)
                .and(QueryMethods.raw("JSON_EXTRACT(`memo`.`payload`, '$.property.hasLink') IS TRUE").when(find.isHasLink()))
                .and(QueryMethods.raw("JSON_EXTRACT(`memo`.`payload`, '$.property.hasTaskList') IS TRUE").when(find.isHasTaskList()))
                .and(QueryMethods.raw("JSON_EXTRACT(`memo`.`payload`, '$.property.hasCode') IS TRUE").when(find.isHasCode()))
                .and(QueryMethods.raw("JSON_EXTRACT(`memo`.`payload`, '$.property.hasIncompleteTasks') IS TRUE").when(find.isHasIncompleteTasks()))
                .and(MEMO_RELATION.RELATED_MEMO_ID.isNull(find.isExcludeComments()))
                ;

        if (find.isRandom()) {
            select = select.orderBy("RANDOM()");
        } else {
            select = select.orderBy(MEMO_ORGANIZER.PINNED, find.isOrderByPinned() ? false : null)
                    .orderBy(MEMO_PO.UPDATED_TS, find.isOrderByUpdatedTs() ? find.isOrderByTimeAsc() : null)
                    .orderBy(MEMO_PO.CREATED_TS, find.isOrderByUpdatedTs() ? null : find.isOrderByTimeAsc())
                    .orderBy(MEMO_PO.ID, find.isOrderByTimeAsc());
        }

        if (find.getLimit() != null) {
            select = select.limit(find.getLimit());
            if (find.getOffset() != null) {
                select = select.offset(find.getOffset());
            }
        }

        List<Memo> memos = memoMapper.selectListByQueryAs(select, Memo.class);

        List<MemoDto> memoDtos = new ArrayList<>();


        return ListMemosResponse.builder().nextPageToken("").memos(memoDtos).build();
    }
}
