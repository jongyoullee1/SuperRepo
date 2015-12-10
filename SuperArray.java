/*
  Jongyoul Lee & Jessica Yang
  APCS1 pd9
  HW #42 -- Array of Titanium
  2015-12-07
*/
public class SuperArray {

    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private int[] _data;
    //position of last meaningful value
    private int _lastPos;
    //size of this instance of SuperArray
    private int _size;

    //~~~~~METHODS~~~~~
    //default constructor – initializes 10-item array
    public SuperArray()
    {
	_data = new int[10];
	_lastPos = -1; //flag to indicate no lastpos yet
	_size = 0;
    }

    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString()
    {
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
	}
	//shave off trailing comma
	if ( foo.length() > 1 )
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }

    //double capacity of this SuperArray
    private void expand()
    {
	int[] temp = new int[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }

    //accessor -- return value at specified index
    public int get( int index ) { return _data[index]; }

    //mutator -- set value at index to newVal,
    //           return old value at index
    public int set( int index, int newVal )
    {
	int temp = _data[index];
	_data[index] = newVal;
	return temp;
    }

    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add( int newVal ) {
	if (_lastPos+1==_data.length) {
	    expand();
	}
	_lastPos++;
	_size++;
	_data[_lastPos] = newVal;
    }

    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, int newVal ) {
	if (_lastPos+1==_data.length) {
	    expand();
	}
	for ( int i = _lastPos; i>=index;i--) {
	    _data[i+1]=_data[i];
	}
	_data[index]=newVal;
	_lastPos++;
	_size++;
    }

    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index ) {
	for ( int i = _lastPos; i>=index;i--) {
	    _data[i]=_data[i+1];
	}
	_data[_lastPos]=0;
	_lastPos--;
	_size--;
    }

    //return number of meaningful items in _data
    public int size() {
	return _size;
    }

    public boolean isSorted() {
	int counter = 1;
	while ((_data[counter - 1].compareTo(_data[counter]) < 0) && counter < _data.length) 
	    {counter += 1;}
	return (counter == _data.length - 1);
    }

    //linSearch
    public int linSearch (Comparable obj) {
	int counter = 0;
	while (counter < _data.length) {
	    if (obj.compareTo (_data[counter]) == 0) {return counter;}
	    else {counter += 1;}
	}
	return -1;
    }

    //main method for testing
    public static void main( String[] args )
    {
	SuperArray curtis = new SuperArray();
	System.out.println("Printing empty SuperArray curtis...");
	System.out.println(curtis);

	for( int i = 0; i < curtis._data.length; i++ ) {
	    curtis.set(i,i*2);
	    curtis._size++; //necessary bc no add() method yet
	}

	System.out.println("Printing populated SuperArray curtis...");
	System.out.println(curtis);

	System.out.println("testing get()...");
	for( int i = 0; i < curtis._size; i++ ) {
	    System.out.print( "item at index" + i + ":\t" );
	    System.out.println( curtis.get(i) );
	}

	System.out.println("Expanded SuperArray curtis:");
	curtis.expand();
	System.out.println(curtis);

	ListInt mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.add(5);
	mayfield.add(4);
	mayfield.add(3);
	mayfield.add(2);
	mayfield.add(1);

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);

	mayfield.add(3,99);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(2,88);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(1,77);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);

//Test Add-at-Index
	mayfield.add(2,new Binary (56));
	System.out.println("Printing ListInt mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(2,new Binary (58));
	System.out.println("Printing ListInt mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(1,new Binary (57));
	System.out.println("Printing ListInt mayfield post-insert...");
	System.out.println(mayfield);
	
	
	//Test Size 
	System.out.println("Printing ListInt mayfield size");
	System.out.println (mayfield.size());
	
	//isSorted Test
	System.out.println (mayfield.isSorted());

	//linSearch Test
	System.out.println (mayfield.linSearch (new Binary (8)));

	//Testing Get
	System.out.println("Printing ListInt mayfield at index 5");
	System.out.println (mayfield.get(5));
	System.out.println("Printing ListInt mayfield at index 4");
	System.out.println (mayfield.get(4));
	System.out.println("Printing ListInt mayfield at index 3");
	System.out.println (mayfield.get(3));
	System.out.println("Printing ListInt mayfield at index 2");
	System.out.println (mayfield.get(2));
	System.out.println("Printing ListInt mayfield at index 1");
	System.out.println (mayfield.get(1));
	System.out.println("Printing ListInt mayfield at index 0");
	System.out.println (mayfield.get(0)); */


    }//end main

}//end class
