
class Runge
{
	double R = 0;
	double L = 3;
    double C = 10;
    double T = 2*Math.PI*Math.sqrt(L*C);
    double q0 = -1;		// 電荷初期値
    double i0 = 0;		// 電流初期値
    double t0 = 0;		// 時間初期値
    double n = 50;		// 分割数
    double N = 5 * n + 1;
    double h = T / n;	// 刻み幅
    
    double f(double q, double i)
    {
    	return -(R/L)*i - q/(L*C);
    }

 
    void calc()
    {
        double q, i, t, kq1, kq2, kq3, kq4, ki1, ki2, ki3, ki4;
        q = q0;
        i = i0;
        t = t0;
        
        for(int j = 0; j < N; j++) {
        	System.out.println("i(" + t + ")=" + i);
        	
        	kq1 = i;
            ki1 = f(q, i);
            
            kq2 = i + h*ki1/2;
            ki2 = f(q + h*kq1/2, i + h*ki1/2);
            
            kq3 = i + h*ki2/2;
            ki3 = f(q + h*kq2/2, i + h*ki2/2);
            
            kq4 = i + h*ki3;
            ki4 = f(q + h*kq3, i + h*ki3);
            
            q += h * (kq1 + 2*kq2 + 2*kq3 + kq4) / 6.0;
            i += h * (ki1 + 2*ki2 + 2*ki3 + ki4) / 6.0;
            
            t += h;
        }
    }
    
    public static void main (String[] args) throws java.lang.Exception
    {
        Runge runge = new Runge();

        runge.calc();
    }
}