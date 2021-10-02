public class FractionalNumberCalculator {
	public static void printCalculationResult(String equation) {
		String[] par_eq = equation.split(" ");
		String[] front = par_eq[0].split("/");
		String[] back = par_eq[2].split("/");

		Frac f = new Frac();
		Frac b = new Frac();

		if(front.length==1){
			f.num = Integer.parseInt(front[0]);
			f.denom = 1;
		}
		else{
			f.num = Integer.parseInt(front[0]);
			f.denom = Integer.parseInt(front[1]);
		}

		if(back.length==1){
			b.num = Integer.parseInt(back[0]);
			b.denom = 1;
		}
		else{
			b.num = Integer.parseInt(back[0]);
			b.denom = Integer.parseInt(back[1]);
		}

		Frac r = new Frac();
		String op = par_eq[1];

		switch(op){
			case "+":
				r.num = f.num * b.denom + f.denom * b.num;
				r.denom = b.denom * f.denom;
				break;
			case "-":
				r.num = f.num * b.denom - f.denom * b.num;
				r.denom = b.denom * f.denom;
				break;
			case "*":
				r.num = f.num * b.num;
				r.denom = f.denom * b.denom;
				break;
			case "/":
				r.num = f.num * b.denom;
				r.denom = f.denom * b.num;
				break;
		}

		r.irr();
		if(r.denom!=1){System.out.println(r.num+"/"+r.denom);}
		else{System.out.println(r.num);}
	}
}

class Frac {
	int num;
	int denom;
	Frac(){}
	Frac(int a){
		this.num = a;
		this.denom = 1;
	}
	Frac(int a, int b){
		this.num = a;
		this.denom = b;
	}
	private static int gcdcalculation(int a, int b){
		if(b==0){return Math.abs(a);}
		return gcdcalculation(Math.abs(b),a%b);
	}
	public void irr(){
		int gcd = this.gcd();
		this.num/=gcd;
		this.denom/=gcd;
	}
	int gcd(){return gcdcalculation(this.num,this.denom);}
}

