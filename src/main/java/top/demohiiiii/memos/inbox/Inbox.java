package top.demohiiiii.memos.inbox;

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
import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "inbox")
public class Inbox implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private Long createdTs;

    private Integer senderId;

    private Integer receiverId;

    private InboxStatus status;

    @Column(typeHandler = JacksonTypeHandler.class)
    private InboxMessage message;

}
