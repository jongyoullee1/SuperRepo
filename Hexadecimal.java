/*
Jongyoul Lee & Zion Lin
APCS1 pd9
HW44 -- This or That or Fourteen Other Things
2015--12--8
*/
public class Hexadecimal {

    private int _decNum;
    private String _hexNum;
  	private final static String HEXDIGITS = "0123456789ABCDEF";


    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _hexNum to "0"
      =====================================*/
    public Hexadecimal() { 
	_decNum = 0;
	_hexNum = "0";
    }


    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _hexNum to equiv string of bits
      =====================================*/
    public Hexadecimal( int n ) {
	_decNum = n;
	_hexNum = decToHex(n);
    }


    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative Hexadecimal number
      post: sets _hexNum to input, _decNum to decimal equiv
      =====================================*/
    public Hexadecimal( String s ) {
	_decNum = hexToBin(s);
	_hexNum = s;
    }


    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of digits from 0-F representing value of this Object
      =====================================*/
    public String toString() { 
	return _hexNum; 
    }


    /*=====================================
      String decToHex(int) -- converts base-10 input to Hexadecimal
      pre:  n >= 0
      post: returns String of bits
      eg  decToHex(0) -> "0"
      decToHex(1) -> "1"
      decToHex(2) -> "2"
      decToHex(3) -> "3"
      decToHex(14) -> "E"
      =====================================*/
    public static String decToHex( int n ) 
    {
	String retStr = ""; //init return String

	if ( n < 16 )
	    retStr = HEXDIGITS.substring(n,n+1);
	else 
	    while( n > 0 ) {
		retStr = HEXDIGITS.substring(n % 16, n % 16 +1) + retStr;
		n /= 16;
	    }
	return retStr;
    }


    /*=====================================
      String decToHexR(int) -- converts base-10 input to Hexadecimal, recursively
      pre:  n >= 0
      post: returns String of bits
      eg  decToHexR(0) -> "0"
      decToHexR(1) -> "1"
      decToHexR(2) -> "2"
      decToHexR(3) -> "3"
      decToHexR(14) -> "E"
      =====================================*/
    public static String decToHexR( int n ) 
    { 
	String retStr; //declare return String

	//Base cases: n is single digit, 0|1
	if ( n < 16 ) retStr = HEXDIGITS.substring(n,n+1);
	//Recursive reduction:
	else 
	    retStr = decToHexR( n/16 ) + HEXDIGITS.substring(n%16,(n%16)+1);
	return retStr;
    }


    /*=====================================
      String hexToBin(String) -- converts base-10 input to Hexadecimal
      pre:  s represents non-negative Hexadecimal number
      post: returns decimal equivalent as int
      eg  
      hexToBin("0") -> 0
      hexToBin("1") -> 1
      hexToBin("10") -> 16
      hexToBin("11") -> 17
      hexToBin("1110") -> 4368
      =====================================*/
    public static int hexToBin( String s ) { 
        int a = 0;
        int b = 1;
        String c = s;
        while (c.length() > 0){
            a += HEXDIGITS.indexOf(c.substring(c.length()-1))* b;
	    b *= 16;
            c = c.substring(0,(c.length()-1));
        }
        return a;
    }


    /*=====================================
      String hexToBinR(String) -- converts base-10 input to Hexadecimal, recursively
      pre:  s represents non-negative Hexadecimal number
      post: returns decimal equivalent as int
      eg  
      hexToBinR("0") -> 0
      hexToBinR("1") -> 1
      hexToBinR("10") -> 16
      hexToBinR("11") -> 17
      hexToBinR("1110") -> 4368
      =====================================*/
    public static int hexToDecR( String s ) { 
        int a = 0; 
        if (s.length() > 0){
            a = HEXDIGITS.indexOf(s.substring(0,1)) * (int)(Math.pow(16,s.length()-1)) + hexToDecR(s.substring(1));
        }
        return a;
    }



    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Hexadecimal
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal Hexadecimal values
      =============================================*/
    public boolean equals( Object other ) 
    { 
	return this == other //check for aliases
	    ||
	    (other instanceof Hexadecimal
	     && this._decNum == ((Hexadecimal)other)._decNum);
    }


    /*=============================================
      int compareTo(Object) -- tells which of two Hexadecimal objects is greater
      pre:  other is instance of class Hexadecimal
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/
    public int compareTo( Object other ) 
    {

	if ( ! (other instanceof Hexadecimal) )
	    throw new ClassCastException("\ncompareTo() input not Hexadecimal");

	return this._decNum - ((Hexadecimal)other)._decNum;
    }


    //main method for testing
    public static void main( String[] args ) 
    {
	  System.out.println();
	  System.out.println( "Testing ..." );

	  Hexadecimal b1 = new Hexadecimal(5);
	  Hexadecimal b2 = new Hexadecimal(5);
	  Hexadecimal b3 = b1;
	  Hexadecimal b4 = new Hexadecimal(7);

	  System.out.println( b1 );
	  System.out.println( b2 );
	  System.out.println( b3 );       
	  System.out.println( b4 );       

	  System.out.println( "\n==..." );
	  System.out.println( b1 == b2 ); //should be false
	  System.out.println( b1 == b3 ); //should be true

	  System.out.println( "\n.equals()..." );
	  System.out.println( b1.equals(b2) ); //should be true
	  System.out.println( b1.equals(b3) ); //should be true
	  System.out.println( b3.equals(b1) ); //should be true
	  System.out.println( b4.equals(b2) ); //should be false
	  System.out.println( b1.equals(b4) ); //should be false

	  System.out.println( "\n.compareTo..." );
	  System.out.println( b1.compareTo(b2) ); //should be 0
	  System.out.println( b1.compareTo(b3) ); //should be 0
	  System.out.println( b1.compareTo(b4) ); //should be neg
	  System.out.println( b4.compareTo(b1) ); //should be pos
      
      System.out.println( decToHex(0) ); //-> 0
	  System.out.println( decToHex(1) ); //-> 1
	  System.out.println( decToHex(10) ); // -> A
	  System.out.println( decToHex(16) ); //-> 10
	  System.out.println( decToHex(32) ); //-> 20

	  System.out.println( decToHexR(0) ); //-> 0
	  System.out.println( decToHexR(1) ); //-> 1
	  System.out.println( decToHexR(10) ); //-> A
	  System.out.println( decToHexR(16) ); //-> 10
	  System.out.println( decToHexR(32) ); //-> 20

	  System.out.println( hexToBinR("0") ); //-> 0
	  System.out.println( hexToBinR("1") ); //-> 1
	  System.out.println( hexToBinR("10") ); // -> 2
	  System.out.println( hexToBinR("11") ); //-> 3
	  System.out.println( hexToBinR("1110") ); //-> 14

	  System.out.println( hexToBin("0") ); //-> 0
	  System.out.println( hexToBin("1") ); //-> 1
	  System.out.println( hexToBin("10") ); //-> 2
	  System.out.println( hexToBin("11") ); //-> 3
	  System.out.println( hexToBin("1110") ); //-> 14

	/*=========================================
	  =========================================*/

    }//end main()

} //end class
