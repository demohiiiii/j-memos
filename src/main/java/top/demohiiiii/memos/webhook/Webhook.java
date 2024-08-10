package top.demohiiiii.memos.webhook;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.demohiiiii.memos.common.RowStatus;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "webhook")
public class Webhook implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private Long createdTs;

    private Long updatedTs;

    private RowStatus rowStatus;

    private Integer creatorId;

    private String name;

    private String url;

}
