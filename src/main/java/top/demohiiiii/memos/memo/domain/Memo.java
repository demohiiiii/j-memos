package top.demohiiiii.memos.memo.domain;

import top.demohiiiii.memos.common.RowStatus;

public class Memo {
    private Integer id;

    private String uid;

    private Integer creatorId;

    private Long createdTs;

    private Long updatedTs;

    private RowStatus rowStatus;

    private String content;

    private Visibility visibility;

    private String tags;

    private String payload;

    boolean pinned;

    Integer parentId;
}
