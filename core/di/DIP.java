package baekjoon;

//case 3 : Injection by abstract
public class Computer {

    private final CPU cpu;

    public Computer(CPU cpu) {
        this.cpu = cpu;
    }

}

class CPU implements CPURecipe{

    private int core;

    public CPU(int core) {
        this.core = core;
    }

    @Override
    public CPU singleCore() {
        return new CPU(1);
    }

    @Override
    public CPU dualCore() {
        return new CPU(2);
    }

}

interface CPURecipe{
    CPU singleCore();
    CPU dualCore();
}