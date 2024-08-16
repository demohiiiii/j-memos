package top.demohiiiii.memos.memo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Property implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String tags;
    private boolean hasLink;
    private boolean hasTaskList;
    private boolean hasCode;
    private boolean hasIncompleteTasks;
}
