package top.demohiiiii.memos.memo;

import lombok.Builder;
import lombok.Data;
import top.demohiiiii.memos.common.RowStatus;
import top.demohiiiii.memos.memo.domain.Visibility;

import java.util.List;

@Data
@Builder
public class FindMemo {
    private Integer id;
    private String uid;
    private RowStatus rowStatus;
    private Integer creatorId;
    private Long createdTsAfter;
    private Long createdTsBefore;
    private Long updatedTsAfter;
    private Long updatedTsBefore;
    private List<String> contentSearch;
    private List<Visibility> visibilityList;
    private String raw;
    private List<String> tagSearch;
    private boolean hasLink;
    private boolean hasTaskList;
    private boolean hasCode;
    private boolean hasIncompleteTasks;
    private boolean excludeContent;
    private boolean excludeComments;
    private boolean random;
    private Integer limit;
    private Integer offset;
    private boolean orderByUpdatedTs;
    private boolean orderByPinned;
    private boolean orderByTimeAsc;
}
