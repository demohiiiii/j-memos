package top.demohiiiii.memos.user.service;

import com.mybatisflex.core.query.QueryWrapper;
import io.github.linpeilie.Converter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.demohiiiii.memos.user.infrastructure.UserMapper;
import top.demohiiiii.memos.user.domain.MemosRole;
import top.demohiiiii.memos.user.domain.User;

import java.util.Optional;

import static top.demohiiiii.memos.user.domain.table.UserTableDef.USER;

@Service
@AllArgsConstructor
public class UserService {

    private UserMapper userMapper;

    private Converter converter;

    public Optional<UserDto> getInstanceOwner() {
        var user = userMapper.selectOneByQuery(QueryWrapper.create().select().where(USER.ROLE.eq(MemosRole.HOST)));
        if (user == null) {
            return Optional.empty();
        }
        return Optional.of(converter.convert(user, UserDto.class));
    }
}
