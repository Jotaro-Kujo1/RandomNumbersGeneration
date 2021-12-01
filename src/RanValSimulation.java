import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RanValSimulation {
    private int a;
    private int b;
    private Generator gen;
    private List<Float> results;

    public RanValSimulation(){
        //a и b согласно варианту, у меня 6
        a = 4;
        b = 6;
        gen = new Generator();
        results = new ArrayList<Float>();
    }

    public void simulation(){
        float tmp;
        float res;
        List <Float> getFl = gen.generation();
        for(int i=0;i<getFl.size();i++){
            tmp = 0;
            res = 0;
            tmp = getFl.get(i);
            res = a + (b-a) * tmp;
            results.add(res);
        }
        System.out.println(" Последовательность случайных величин на интервале от " + a + " до " + b);
        displayInfo();
    }

    public void displayInfo(){
        Iterator<Float> iter = results.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
