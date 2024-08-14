package top.demohiiiii.memos.user.service;

import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.ReverseAutoMapping;
import lombok.Data;
import top.demohiiiii.memos.common.ResourceName;
import top.demohiiiii.memos.common.RowStatus;
import top.demohiiiii.memos.user.domain.MemosRole;
import top.demohiiiii.memos.user.domain.User;

import java.time.LocalDateTime;

@Data
@AutoMapper(target = User.class)
public class UserDto {
    private Integer id;

    @ReverseAutoMapping(source = "id", target = "name", expression = "java(java.lang.String.format(\"%s%d\", \"" + ResourceName.UserNamePrefix + "\", source.getId()))")
    private String name;

    @ReverseAutoMapping(target = "createTime", expression = "java(java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochSecond(source.getCreatedTs()), java.time.ZoneId.systemDefault()))")
    private LocalDateTime createTime;

    @ReverseAutoMapping(target = "updateTime", expression = "java(java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochSecond(source.getUpdatedTs()), java.time.ZoneId.systemDefault()))")
    private LocalDateTime updateTime;

    private RowStatus rowStatus;

    private String username;

    private MemosRole role;

    private String email;

    private String nickname;

    private String passwordHash;

    private String avatarUrl;

    private String description;
}
