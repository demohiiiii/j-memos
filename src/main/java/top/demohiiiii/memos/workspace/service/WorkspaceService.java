package top.demohiiiii.memos.workspace.service;

import com.mybatisflex.core.query.QueryWrapper;
import io.github.linpeilie.Converter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.demohiiiii.memos.common.Profile;
import top.demohiiiii.memos.user.domain.MemosRole;
import top.demohiiiii.memos.user.service.UserDto;
import top.demohiiiii.memos.user.service.UserService;
import top.demohiiiii.memos.workspace.infrastructure.WorkspaceSettingMapper;
import top.demohiiiii.memos.workspace.domain.WorkspaceProfile;
import top.demohiiiii.memos.workspace.domain.WorkspaceSetting;
import top.demohiiiii.memos.workspace.domain.WorkspaceSettingKey;

import java.util.Optional;

import static top.demohiiiii.memos.workspace.domain.table.WorkspaceSettingTableDef.WORKSPACE_SETTING;

@Service
@AllArgsConstructor
public class WorkspaceService {

    private Profile profile;

    private UserService userService;

    private WorkspaceSettingMapper workspaceSettingMapper;

    private Converter converter;

    public WorkspaceProfile getWorkspaceProfile() {
        Optional<UserDto> instanceOwner = userService.getInstanceOwner();
        return WorkspaceProfile.of(instanceOwner.map(UserDto::getName).orElse(""), profile);
    }

    public WorkspaceSettingDto getWorkspaceSetting(String name) {
        WorkspaceSettingKey workspaceSettingKey = WorkspaceSettingKey.valueOf(name);
        WorkspaceSetting workspaceSetting = workspaceSettingMapper.selectOneByQuery(QueryWrapper.create().select().where(WORKSPACE_SETTING.NAME.eq(workspaceSettingKey)));
        if (workspaceSetting.getName() == WorkspaceSettingKey.STORAGE) {
            Optional<UserDto> currentUser = userService.getCurrentUser();
            if (currentUser.isEmpty() || currentUser.get().getRole() != MemosRole.HOST) {

            }
        }

        return converter.convert(workspaceSetting, WorkspaceSettingDto.class);
    }
}
