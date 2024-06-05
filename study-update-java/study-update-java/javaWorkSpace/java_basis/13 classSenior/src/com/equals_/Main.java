package com.equals_;

public class Main {
    public static void main(String[] args) {
        /*
        鼠标放在equals方法上面，按住Ctrl+鼠标右键查看该方法在当前jdk版本中的源代码
        public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof String) {
            String aString = (String)anObject;
            if (coder() == aString.coder()) {
                return isLatin1() ? StringLatin1.equals(value, aString.value)
                                  : StringUTF16.equals(value, aString.value);
            }
        }
        return false;
        }
        * */
        "abc".equals("nihao");
    }
}
