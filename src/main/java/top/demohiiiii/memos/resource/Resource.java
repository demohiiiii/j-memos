package top.demohiiiii.memos.resource;

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
@Table(value = "resource")
public class Resource implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private String uid;

    private Integer creatorId;

    private Long createdTs;

    private Long updatedTs;

    private String filename;

    private byte[] blob;

    private String type;

    private Integer size;

    private Integer memoId;

    private ResourceStorageType storageType;

    private String reference;

    @Column(typeHandler = JacksonTypeHandler.class)
    private ResourcePayload payload;

}
