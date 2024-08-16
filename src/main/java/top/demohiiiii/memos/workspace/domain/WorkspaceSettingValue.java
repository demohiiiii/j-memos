package top.demohiiiii.memos.workspace.domain;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS,
        include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "class")
public abstract class WorkspaceSettingValue {
}
