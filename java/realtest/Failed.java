package realtest;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;

/**
 * @author shmilyiselephant
 * @date 17.02.20
 * @decription
 */
public class Failed {

    public static boolean judgeSquareNum(int n) {
        double tmp = 0;
        for (int i = 0; i <= Math.sqrt(n); i++) {
            tmp = Math.sqrt(n - i*i);
            if (tmp - (int)tmp == 0) return true;
        }
        return false;
    }

    public static void combine(int n, int k, List<Integer> d, int num) {
        int i = n;
        if (k > n) return;
        System.out.printf("*******[n=%d,k=%d,d=%s,num=%d,i=%d]\n",n,k,d.toString(),num,i);
        while (i >= k) {
            d.set(num-k, i);
            if (k > 1) combine(i-1, k-1, d, num);
            else {
                int j = 0;
                while (j < num) {
                    System.out.printf("%d ", d.get(j));
                    j++;
                }
                System.out.printf("======[n=%d,k=%d,d=%s,num=%d,i=%d]\n",n,k,d.toString(),num,i);
            }
            i--;
        }
    }

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int test = in.nextInt();
        //System.out.println(judgeSquareNum(test));
        //int n=4;// 1,2,3,4,5
        //int k=2;//取出3个数
        //List<Integer> d = new ArrayList<>(k);
        ////初始化list
        //for(int i=0;i<k;i++)
        //{
        //    d.add(0);
        //}
        //combine(n, k, d, k);
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("4",0);
        map.put("1",1);
        map.put("2",2);
        map.put("0",0);
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        
    }
}
