
class Euler
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
        double q, i, t;
        q = q0;
        i = i0;
        t = t0;
    
        for(int j = 0; j < N; j++) {
        	System.out.println("i(" + t + ")=" + i);
        	q += i * h; 
            i += f(q, i) * h;
            t += h;
        }

    }
    
    public static void main (String[] args) throws java.lang.Exception
    {
        Euler euler = new Euler();
        
        euler.calc();
    }
}