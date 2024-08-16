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
public class WorkspaceStorageSetting extends WorkspaceSettingValue {

    private StorageType storageType;
    private String filepathTemplate;
    private long upload_size_limit_mb;
    private S3Config s3Config;


    public enum StorageType {
        STORAGE_TYPE_UNSPECIFIED,
        DATABASE,
        LOCAL,
        S3
    }
}
