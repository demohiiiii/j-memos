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
public class WorkspaceGeneralSetting extends WorkspaceSettingValue {
    private String additionalScript;
    private String additionalStyle;
    private WorkspaceCustomProfile customProfile;
}
