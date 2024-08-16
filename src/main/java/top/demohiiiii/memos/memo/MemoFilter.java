package top.demohiiiii.memos.memo;

import lombok.Data;
import top.demohiiiii.memos.common.RowStatus;
import top.demohiiiii.memos.memo.domain.Visibility;

import java.util.List;

@Data
public class MemoFilter {
    private List<String> contentSearch;
    private List<Visibility> visibilities;
    private List<String> tagSearch;
    private boolean orderByPinned;
    private boolean orderByTimeAsc;
    private Long displayTimeBefore;
    private Long displayTimeAfter;
    private String creator;
    private RowStatus rowStatus;
    private boolean random;
    private Integer limit;
    private boolean includeComments;
    private boolean hasLink;
    private boolean hasTaskList;
    private boolean hasCode;
    private boolean hasIncompleteTasks;
}
