package top.demohiiiii.memos.workspace.service;

import cn.hutool.core.map.MapUtil;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import top.demohiiiii.memos.workspace.domain.WorkspaceGeneralSetting;
import top.demohiiiii.memos.workspace.domain.WorkspaceSetting;
import top.demohiiiii.memos.workspace.domain.WorkspaceSettingKey;
import top.demohiiiii.memos.workspace.domain.WorkspaceSettingValue;

import java.util.Map;

@Data
@AutoMapper(target = WorkspaceSetting.class)
public class WorkspaceSettingDto {
    private WorkspaceSettingKey name;
    @JsonIgnore
    private WorkspaceSettingValue value;

    @JsonAnyGetter
    public Map<String, Object> any() {
        if (value instanceof WorkspaceGeneralSetting) {
            return MapUtil.of("generalSetting", value);
        }

        return MapUtil.empty();
    }
}
