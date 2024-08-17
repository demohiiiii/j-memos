package top.demohiiiii.memos.memo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import top.demohiiiii.memos.workspace.domain.WorkspaceProfile;

@RestController
@RequestMapping("v1/memos")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class MemoController {
    private MemoService memoService;

    @PostMapping()
    public ListMemosResponse getWorkspaceProfile(@RequestParam int pageSize, @RequestParam String pageToken, @RequestBody MemoFilter filter) {
        return memoService.listMemos(pageSize, pageToken, filter);
    }
}
