package top.demohiiiii.memos.workspace;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.demohiiiii.memos.workspace.domain.WorkspaceProfile;

@RestController
@RequestMapping("v1/workspace")
@AllArgsConstructor
public class WorkspaceController {

    private WorkspaceService workspaceService;

    @GetMapping("/profile")
    public WorkspaceProfile getWorkspaceProfile() {
        return workspaceService.getWorkspaceProfile();
    }
}
