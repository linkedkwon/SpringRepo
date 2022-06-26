package baekjoon;

//case 1 : Inner Object
public class Computer {

    private CPU cpu;

    /**
    public Computer() {
        cpu = new CPU();
    }
    */

    //case 2 : Coupling
    public Computer(int core){
        cpu = new CPU(core);
    }

    public CPU getCpu() {
        return cpu;
    }

}

/**
class CPU{

    private final int core = 2;

    public int getCore() {
        return core;
    }

}
*/

//case 2 : Coupling
class CPU {

    private int core;

    public CPU(int core) {
        this.core = core;
    }

    public int getCore() {
        return core;
    }

}