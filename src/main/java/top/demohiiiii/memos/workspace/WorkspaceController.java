package top.demohiiiii.memos.workspace;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.demohiiiii.memos.workspace.domain.WorkspaceProfile;
import top.demohiiiii.memos.workspace.service.WorkspaceService;
import top.demohiiiii.memos.workspace.service.WorkspaceSettingDto;

@RestController
@RequestMapping("v1/workspace")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class WorkspaceController {

    private WorkspaceService workspaceService;

    @GetMapping("/profile")
    public WorkspaceProfile getWorkspaceProfile() {
        return workspaceService.getWorkspaceProfile();
    }

    @GetMapping("/settings/{name}")
    public WorkspaceSettingDto getWorkspaceProfile(@PathVariable String name) {
        return workspaceService.getWorkspaceSetting(name);
    }
}
