package top.demohiiiii.memos.workspace.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class S3Config {
    private String accessKeyId;
    private String accessKeySecret;
    private String endpoint;
    private String region;
    private String bucket;
}
