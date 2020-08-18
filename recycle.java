import java.util.*;
import java.lang.Math;
class recycle
{
public static void main(String args[])
{
double ca0, k, n, r, va0, t, vr;
Scanner re = new Scanner(System.in);
System.out.println("Enter Ca0 value: "); ca0 = re.nextDouble();
System.out.println("Enter initial volume flow rate Va0 value: "); va0 = re.nextDouble();
System.out.println("Enter reaction coefficient k value: "); k = re.nextDouble();
System.out.println("Recycle ratio: "); r = re.nextDouble();
System.out.println("Order of reaction: "); n = re.nextDouble();
System.out.println("Reactor Volume: "); vr = re.nextDouble();
int i,f=1;
double ca1, va1, va2, ca2=0, va3, ca1p,va1p;
va1=0; ca1=0; i=0; ca1p=10; va1p=10;
while(ca1!=ca1p || va1!=va1p)
{
i=i+1;
va2=va1*r;
va1p=va1;
va1 = va0+va2;
t = vr/va1;
va3 = (1-r)*va1;
ca1p=ca1;
ca1 = ((ca0*va0)+(ca2*va2))/(va0+va2);
/*calculating reaction effect*/
if(n==1)
ca2 = ca1*Math.exp(-k*t);
else
{
double p = (-k*t)+(Math.pow(ca1,(1-n)))/(1-n);
ca2 = Math.pow(p*(1-n),1/(1-n));
}
/*over*/

ca1 = Math.round(ca1*10000.0)/10000.0;
va1 = Math.round(va1*10000.0)/10000.0;
ca1p = Math.round(ca1p*10000.0)/10000.0;
va1p = Math.round(va1p*10000.0)/10000.0;
System.out.println("\nIteration: "+i+" Ca2 = "+ca2+" ca1="+ca1+" va1 = "+va1+" va3 = "+va3);
if(i==100)
{
f = 0;
break;
}
}
if(f==0)
System.out.println("not converged");
else
System.out.println("\nNo of cylces taken:"+i+" Exit concentration: "+ca2+"Extent of conversion: "+(ca0-ca2)/ca0);
}
}
