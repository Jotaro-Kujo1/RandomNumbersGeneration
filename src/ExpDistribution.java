import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExpDistribution {
    private float lambd;
    private float e;
    private Generator gen;
    private List<Float> results;

    public ExpDistribution(){
        lambd = 0.77f;
        e = 2.711828f;
        gen = new Generator();
        results = new ArrayList<Float>();
    }
    public void distribution(){
        float tmp;
        float tmpX;
        //float res;
        List <Float> getFl = gen.generation();
        for(int i=0;i<getFl.size();i++){
            tmp = 0;
            tmpX = 0;
            //res = 0;
            tmp = getFl.get(i);
            tmpX = (-1 * (float)Math.log(tmp))/lambd;
            //res = 1 - (lambd * (float)Math.pow(e,tmpX*(-lambd)));
            results.add(tmpX);
        }
        System.out.println(" Показательное распределение: ");
        displayInfo();
    }

    public void displayInfo(){
        Iterator<Float> iter = results.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }

}
