// import java.util.*;

// public class one
// {
//     public static void main(String[] args)
//     {
//         double disc=0.1, total;
//         int x;
//         Scanner sc=new Scanner(System.in);

//         System.out.println("Tell the quantity:\n");
//         x=sc.nextInt();
        
//         total = x*100;
//         System.out.println("The total is : " +total);

//         if(total>1000)
//         {
//             double apply_disc = total - total*disc;
//             System.out.println("You are eligible for the discount of 10%.\nThe price after discount is : " +apply_disc);
//         }

//         else if(total==1000)
//         {
//             double half_disc = total - total*0.05;
//             System.out.println("You are eligible for the discount of 5%. \nThe price for you is : " +half_disc);
//         }

//         else
//         {
//             System.out.println("Enter an amount which is feasible for availing the discount!! ");
//         }

//     }
// }




import java.util.*;

public class one{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        sc.close();

        int ret = add(a, b);
        System.out.println(ret);
    }

    public static int add(int g, int h){
        return g+h;
    }
}