package top.demohiiiii.memos.activity;

import com.mybatisflex.annotation.EnumValue;

public enum ActivityType {
    ActivityTypeMemoComment("MEMO_COMMENT"),
    ActivityTypeVersionUpdate("VERSION_UPDATE");


    @EnumValue
    final String name;

    ActivityType(String name){
        this.name = name;
    }
}
