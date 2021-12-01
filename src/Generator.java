import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Generator {
    private List<Integer> randomNumbersArray;
    private List<Float> randomNumbersArrayFl;
    private int d;//В конструкторе
    private int [] zValues = {3,11,13,19,21,27,29,37,53,59,61};
    private int t;//t – любое целое число
    private int z;//z взято из набора zValues
    private int n0;//Любое нечетное число и не делящееся на 5
    private int lambd;//Формула

    public Generator(){
        randomNumbersArray = new ArrayList<Integer>();
        randomNumbersArrayFl = new ArrayList<Float>();
        d = (int)2.3;//Т.к. нам надо 10 различных числе то по формуле 5*10^(d-2) = 10, мы находим что d = 2.3
        t = (int)(Math.random() * 100);
        z = randonZet();
        n0 = n0NotFive();
        lambd = 200 * t + z;
    }

    public List<Float> generation(){
        System.out.println(" n0: " + n0);
        System.out.println(" t: " + t);
        System.out.println(" z: " + z);
        randomNumbersArray.add(n0);
        System.out.println(" lambd: " + lambd);
        for(int i=0;i<9;i++){//Тут 9 потому что я до цикла добавил уже первую запись.Получится 10.Всё норм
            int tmp = lambd * randomNumbersArray.get(i) % (int)Math.pow(10,d);
            randomNumbersArray.add(tmp);
        }
        System.out.println(" Числа, высчитанные по формуле до того как взяли 2 значащих разряда :");
        displayInfo();
        System.out.println("\n");
        for(int i=0;i<10;i++){
            float tmp = (float)randomNumbersArray.get(i) / 100;
            randomNumbersArrayFl.add(tmp);
        }
        System.out.println(" После того как взяли 2 значащих разряда: ");
        displayInfoFl();
        return randomNumbersArrayFl;
    }
    private int randonZet(){
        int tmp = (int)(Math.random()*zValues.length);
        return zValues[tmp];
    }
    private int n0NotFive(){
        int tmp;
        tmp = (int)(Math.random() * 100);
        while(tmp!=0){
            if(tmp%2!=0 && tmp%5!=0)break;
            else tmp = (int)(Math.random() * 100);
        }
        return tmp;
    }
    public void displayInfo(){
        Iterator<Integer> iter = randomNumbersArray.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
    public void displayInfoFl(){
        Iterator<Float> iter = randomNumbersArrayFl.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
