import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums=new int[n];
        int maxop= sc.nextInt();
        for (int i = 0; i < n; i++) {
            nums[i]= sc.nextInt();
        }
        int l =1;
        int r=0;
        for (int i = 0; i < n; i++) {
            r=Math.max(nums[i],r);
        }
        int ans =0;
        while (l<=r){
            int mid = l+(r-l)/2;
            boolean possible ;
            int ops =0;
            for (int i = 0; i < n; i++) {
                ops+=(nums[i]-1)/mid;
            }
            possible=ops<=maxop;
            if (possible){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }

        }
        System.out.println(ans);
    }

}









































