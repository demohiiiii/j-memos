package top.demohiiiii.memos.inbox;

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
public class InboxMessage implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private IbmType type;
    private Integer activityId;
}
