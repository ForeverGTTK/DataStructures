package IgorClass;
import java.util.Random;

public class RunTimeCheck {

    static int []sumNum (int n[]){
        int sum[] = new int[n.length];
        int iteration=1;
        sum[0]= n[0];

        for (int i=1; i < n.length;i++){
            sum[i-1]+= n[i];
            iteration++;

        }
        System.out.println("the number of iteration is: "+ iteration + "\t the size of n is: "+ n.length);
        return sum;
    }

    static void printArray (int []n){
        for (int i=0;i<n.length;i++){
            System.out.print(n[i]+", ");
        }
        System.out.println();
        }

    static boolean isPrimeSqrt (int num){
       boolean res;
       int iteration=0;
       for (int i=2; i<Math.sqrt(num);i++){
           iteration++;
           if (num%i == 0){
               System.out.println("the num is:"+ num+"\tthe amount of iteration is: "+iteration +"\tit devides by "+ i);
               return false;
           }
       }
       System.out.println("the num is:"+ num+"\tthe amount of iteration is: "+iteration );

       return true;
   }

    static boolean IsPrime(int num){
        boolean res;
        int iteration=0;
        for (int i=2; i<num;i++){
            iteration++;
            if (num%i == 0){
                System.out.println("the num is:"+ num+"\tthe amount of iteration is: "+iteration +"\tit devides by "+ i);
                return false;
            }
        }
        System.out.println("the num is:"+ num+"\tthe amount of iteration is: "+iteration );

        return true;
    }

    public static void main(String[] args) {
        Random random = new Random();
// array summary
        //        int n[] =new int[10];
//
//        for (int i=0; i<n.length;i++){
//            n[i]= random.nextInt(-50,50);
//        }
//
//        printArray(n);
//        printArray(sumNum(n));

    //    prime check
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(0, 9999999);
            System.out.println("is the num primal ? " + IsPrime(num));
        }



    }

}
