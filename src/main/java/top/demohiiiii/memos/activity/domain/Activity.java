package top.demohiiiii.memos.activity.domain;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.core.handler.JacksonTypeHandler;
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
@Table(value = "activity")
public class Activity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private Integer creatorId;

    private Long createdTs;

    private ActivityType type;

    private ActivityLevel level;

    @Column(typeHandler = JacksonTypeHandler.class)
    private ActivityPayload payload;

}
