package top.demohiiiii.memos.workspace.domain;

import cn.hutool.core.text.CharSequenceUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.demohiiiii.memos.common.Profile;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkspaceProfile {
    private String owner;
    private String version;
    private String mode;
    @JsonProperty("public")
    private boolean pub;
    private boolean passwordAuth;

    public static WorkspaceProfile of(String owner, Profile profile) {
        WorkspaceProfile workspaceProfile = WorkspaceProfile.builder().mode(profile.getMode()).version(profile.getVersion()).pub(profile.isPub()).passwordAuth(profile.isPasswordAuth()).build();
        if (CharSequenceUtil.isNotEmpty(owner)) {
            workspaceProfile.setOwner(owner);
        }
        else {
            workspaceProfile.setPub(false);
            workspaceProfile.setPasswordAuth(false);
        }
        return workspaceProfile;
    }
}
