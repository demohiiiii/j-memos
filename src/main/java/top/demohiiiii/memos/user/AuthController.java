package top.demohiiiii.memos.user;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.demohiiiii.memos.user.service.UserDto;
import top.demohiiiii.memos.user.service.UserService;

@RestController
@RequestMapping("v1/auth")
@AllArgsConstructor
public class AuthController {
    private UserService userService;

    @GetMapping("/status")
    public UserDto getAuthStatus() {
        return userService.getCurrentUser().orElseThrow();
    }
}
