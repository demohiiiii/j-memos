package top.demohiiiii.memos.activity;

import com.mybatisflex.annotation.EnumValue;

public enum ActivityLevelInfo {
    ActivityLevel("INFO");

    @EnumValue
    final String name;

    ActivityLevelInfo(String name){
        this.name = name;
    }
}
