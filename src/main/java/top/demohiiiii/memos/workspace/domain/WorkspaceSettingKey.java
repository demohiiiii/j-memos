package top.demohiiiii.memos.workspace.domain;

public enum WorkspaceSettingKey {
    WORKSPACE_SETTING_KEY_UNSPECIFIED(0),
    BASIC(1),
    GENERAL(2),
    STORAGE(3),
    MEMO_RELATED(4);

    private final int value;

    private WorkspaceSettingKey(int value) {
        this.value = value;
    }
}
