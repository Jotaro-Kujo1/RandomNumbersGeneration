public class Main {
    public static void main(String[] args){
        //Generator g = new Generator();
        //g.generation();
        RanValSimulation sim = new RanValSimulation();
        sim.simulation();
        System.out.println("\n");
        ExpDistribution dist = new ExpDistribution();
        dist.distribution();
    }
}
