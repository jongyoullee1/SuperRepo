/*
Jessica Yang, Jongyoul Lee
APCS1 pd9
HW37 -- Rational Equality
2015-11-24
*/
/*
 */
public class Rational {
    private int numerator;
    private int denominator;
    public Rational() {
	    numerator = 0;
	    denominator = 1;
    }
    public Rational(int numer, int denom) {
	    this();
	    if (denom == 0) {
	        System.out.println("ERROR! Rational created with zero denominator");
	    } else {
	        numerator = numer;
	        denominator = denom;
    	}
    }
    public String toString() {
    	return numerator + "/" + denominator;
    }
    public double floatValue() {
    	return (double)numerator / denominator;
    }
    public void multiply (Rational s) {
        this.numerator=this.numerator*s.numerator;
        this.denominator=this.denominator*s.denominator;
    }
    public void divide (Rational s) {
        Rational a = new Rational(s.denominator,s.numerator);
        this.multiply(a);
    }
    public void add(Rational s) {
	numerator=numerator * s.denominator + denominator * s.numerator;
	denominator = denominator * s.denominator;
    }
    public void subtract(Rational s) {
	Rational r = new Rational (-s.numerator,s.denominator);
	this.add(r);
    }
    
      // Finds the GCD of two integer inputs recursively.
    public static int gcdER (int a, int b){
        if ((a == b) || (b == 0)){
            return a;} //returns the GCD.
        else if (a < b){
            return gcdER (b,a);} //If b is greater than a, the function will be run again with both values swapped.
        else{
            return gcdER (b , (a-b));
        }
    } //Recalls the function with b and the difference between a and b.
    
    public void reduce(){
        int GCD = gcdER (this.numerator, this.denominator);
        numerator /= GCD;
        denominator /= GCD;
    }
    
  
    
    public int compareTo (Rational s){
        int crossC= this.numerator * s.denominator; //this is the calling fraction
        int crossP= this.denominator * s.numerator; //this is the parameter fraction
        if (crossC== crossP){
            return 0;
        }
        else if (crossC > crossP){
            return 1738;
        }
        else{
            return -1738;
        }
    }
    
    public boolean equals(Rational s){
    	return this.compareTo(s)==0 && (s instanceof Rational);
    }
    
    
    public static void main(String[] args) {
        /*=============================================
        =============================================*/
        
        //Tests multiplication and division functions
        System.out.println("Multiplying and dividing");
        Rational s = new Rational(1,2); 
        //s.multiply(s);
        System.out.println(s);
        Rational t = new Rational(2,3); 
        Rational u = new Rational(1,2); 
        t.divide(u);
        System.out.println(t);
        
        
        //Tests addition and subtraction functions
        System.out.println("Adding and subtracting");
	    Rational v = new Rational(2,3); 
        Rational w = new Rational(1,2); 
        Rational x = new Rational (7,6);
        v.add(w);
        System.out.println(v);
        v.subtract (x);
        System.out.println(v);
        
        
        //Tests reducting function
        System.out.println ("Reducing");
        Rational y = new Rational (2,4);
        System.out.println ("Before: " + y);
        y.reduce();
        System.out.println ("After:  " + y);
         
        
        //Tests compareTo function
        System.out.println ("Comparing");
        Rational z = new Rational (2,5);
        System.out.println (w.compareTo(z)); //should return positive number
        System.out.println (w.compareTo(y)); //should return zero.
        System.out.println (y.compareTo(x)); //should return negative number

      	//Tests Equals
      	System.out.println(y.equals(x));//should return false
       	System.out.println(s.equals(u));//should return true     	
      	System.out.println(y.compareTo(x));//should return -1738
       	System.out.println(s.compareTo(u));//should return 0
        double i = 1/2;
      	System.out.println(s.equals(i));
       
    }
}
