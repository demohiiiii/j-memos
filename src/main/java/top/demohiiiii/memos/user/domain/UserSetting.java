package top.demohiiiii.memos.user.domain;

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
@Table(value = "user_setting")
public class UserSetting implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer userId;

    private UserSettingKey key;

    private String value;

}
