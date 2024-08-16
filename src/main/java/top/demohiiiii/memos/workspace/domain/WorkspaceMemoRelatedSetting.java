package top.demohiiiii.memos.workspace.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkspaceMemoRelatedSetting extends WorkspaceSettingValue {
    private boolean disallowPublicVisibility;
    private boolean displayWithUpdate_time;
    private int contentLengthLimit;
    private boolean enableAutoCompact;
    private boolean enableDoubleClickEdit;
    private boolean enableLinkPreview;
}
