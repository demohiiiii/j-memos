package top.demohiiiii.memos.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ResourceName {

    public static final String WorkspaceSettingNamePrefix = "settings/";
    public static final String UserNamePrefix = "users/";
    public static final String MemoNamePrefix = "memos/";
    public static final String ResourceNamePrefix = "resources/";
    public static final String InboxNamePrefix = "inboxes/";
    public static final String StorageNamePrefix = "storages/";
    public static final String IdentityProviderNamePrefix = "identityProviders/";
    public static final String ActivityNamePrefix = "activities/";

    public static List<String> getNameParentTokens(String name, String... tokenPrefixes) {
        var parts = name.split("/");
        if (parts.length != 2 * tokenPrefixes.length) {
            throw new RuntimeException();
        }

        List<String> tokens = new ArrayList<>();
        for (int i = 0; i < tokenPrefixes.length; i++) {
            String tokenPrefix = tokenPrefixes[i];
            if (!Objects.equals(String.format("%s/", parts[2 * i]), tokenPrefix)) {

            }

            if (Objects.equals(parts[2 * i + 1] ,"")) {

            }
            tokens.add(parts[2 * i + 1]);
        }

        return tokens;
    }

    public static long extractActivityIDFromName(String name){
        List<String> tokens = getNameParentTokens(name, ActivityNamePrefix);
        return Long.parseLong(tokens.getFirst());
    }
}
