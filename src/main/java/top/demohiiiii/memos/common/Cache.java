package top.demohiiiii.memos.common;

public class Cache {
    public static String getUserSettingCacheKey(Integer userID, String key) {
        return String.format("%d-%s", userID, key);
    }
}
