import java.util.*;
public class Main{
static final int MOD=1000000007;
public static int solve(List<Integer>A){
long ans=0;
int n=A.size();
for(int bit=0;bit<32;bit++){
long count1=0;
for(int x:A){
if((x&(1<<bit))!=0)count1++;
}
long count0=n-count1;
ans=(ans+(count1*count0*2)%MOD)%MOD;
}
return(int)ans;
}
public static void main(String[]args){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
List<Integer>vec=new ArrayList<>();
for(int i=0;i<n;i++)vec.add(sc.nextInt());
System.out.println(solve(vec));
sc.close();
}
}

