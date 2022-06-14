package com;

import org.springframework.stereotype.Service;

@Service
public class SpringService {

    //case 1 : Inner object
    private SpringRepository springRepoDirect = new SpringRepository();

    //case 2 : Dependency Injection By IoC Container
    private SpringRepository springRepoByIoC;

    public SpringService(SpringRepository springRepoByIoc){
        this.springRepoByIoC = springRepoByIoc;
    }

    public void logic(){
        //...
    }

}