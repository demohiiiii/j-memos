package top.demohiiiii.memos.workspace.domain;

import com.mybatisflex.annotation.Table;
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
@Table(value = "system_setting")
public class WorkspaceSetting implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;

    private String value;

    private String description;

}
