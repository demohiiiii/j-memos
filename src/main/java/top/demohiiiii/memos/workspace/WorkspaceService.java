package top.demohiiiii.memos.workspace;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.demohiiiii.memos.common.Profile;
import top.demohiiiii.memos.user.service.UserDto;
import top.demohiiiii.memos.user.service.UserService;
import top.demohiiiii.memos.workspace.domain.WorkspaceProfile;

import java.util.Optional;

@Service
@AllArgsConstructor
public class WorkspaceService {

    private Profile profile;

    private UserService userService;

    public WorkspaceProfile getWorkspaceProfile() {
        Optional<UserDto> instanceOwner = userService.getInstanceOwner();
        return WorkspaceProfile.of(instanceOwner.map(UserDto::getName).orElse(""), profile);
    }
}
