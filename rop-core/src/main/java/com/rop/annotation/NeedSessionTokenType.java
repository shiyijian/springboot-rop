package com.rop.annotation;

public enum NeedSessionTokenType {
    YES, NO, DEFAULT;

    public static boolean isNeedSessionToken(NeedSessionTokenType type) {
        if (YES == type || DEFAULT == type) {
            return true;
        } else {
            return false;
        }
    }
}
