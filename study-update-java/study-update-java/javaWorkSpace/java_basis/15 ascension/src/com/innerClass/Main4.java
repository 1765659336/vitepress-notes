package com.innerClass;

public class Main4 {
    public static void main(String[] args) {
        Father4 father4 = new Father4();
    }
}

interface IFS {
    public void way();
}

class Father4 {
    {
        Father4.say(new IFS(){
            @Override
            public void way() {
                System.out.println("way");
            }
        });
    }
    public static void say(IFS ifs){
        ifs.way();
    }
}
