public class Calculator {
 
	public static double calculate(double num1, double num2, char op) {
		switch(op){
			case '+': 
				return num1+num2;
			case '-':
				return num1-num2;
			case '*':
				return num1*num2;
			case '/':
				// Check for division by 0
				if(num2==0) 
					return Integer.MAX_VALUE;
				else
					return num1/num2;
			case '^':
				// 0^(-X) is undefined
				// Insist students to use for loop to calculate power
				if (num1==0&&num2<=0)
					return Integer.MAX_VALUE;
				else
					{
					double ans = 1;
					if(num2<0) 
					{
						num2=-num2;
						num1=1/num1;
					}
					for(int i=1;i<=num2;++i) 
						ans*=num1;
					return ans;
					}
		
			default:
					// undefined character
				return Integer.MAX_VALUE;
		}
    }
}