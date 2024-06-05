package com.publicProxy;

public class Main {
    public static void main(String[] args) {
        Wedding_services wedding_services = new Wedding_services(new You());
        wedding_services.marry();
    }
}

interface Marry{
    public void marry();
}

class You implements Marry{
    @Override
    public void marry() {
        System.out.println("你结婚娶新娘");
    }
}

class Wedding_services implements Marry{
//    真实用户
    private You user;

    public Wedding_services(You user) {
        this.user = user;
    }

    public void before(){
        System.out.println("布置现场");
    }

    public void after(){
        System.out.println("收拾现场，拿工钱");
    }

    @Override
    public void marry() {
        before();
        user.marry();
        after();
    }
}
