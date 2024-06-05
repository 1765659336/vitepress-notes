package com.interfac.detail;

public class Main {
    public static void main(String[] args) {

    }
}

interface AA {
    public void a();
}

interface BB {
    public void b();
}

interface CC extends AA,BB{
    public void c();
}

class test implements CC{

    @Override
    public void a() {

    }

    @Override
    public void b() {

    }

    @Override
    public void c() {

    }
}
