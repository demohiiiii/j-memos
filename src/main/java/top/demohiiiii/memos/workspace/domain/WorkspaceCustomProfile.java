package top.demohiiiii.memos.workspace.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkspaceCustomProfile {
    private String title;
    private String description;
    private String logoUrl;
    private String locale;
    private String appearance;
}
