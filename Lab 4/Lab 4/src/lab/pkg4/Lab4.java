/* Student Name: Tim Lu
 * Lab Section: 06
 * Lab 4 Question 1 Test Class
 */
package lab.pkg4;

/**
 *
 * @author super
 */
public class Lab4 {

    public static void main(String[] args) {
        /******** parameters are here ************/
        /****     Test Matrix      *****/    
        // for constructor1
        int invalid_row1 = -1, invalid_col1 = -2;
        int invalid_row2 = 1,  invalid_col2 = 0;        
        int valid_row = 3,     valid_col = 4;
        // for constructor2
        int[][] data = {{1,2,3,4,5},{6,7,8,9,0},{0,0,1,2,3},{0,0,0,4,5}};
        // for getElement, this method gets elements from 'data' matrix above
        int getvalid_row = 1, getvalid_col = 3;
        int getinvalid_row = 10, getinvalid_col = 2;
        // for subMatrix, the submatrix is obtained from 'data' matrix above
        int subvalid_row = 3, subvalid_col = 3;
        int subinvalid_row = 3, subinvalid_col = 6;
        // for isUpper, matrix 'Upper1' is uppertriangular, and matrix 'notUpper1', 'notUpper2' are not    
        int[][] Upper1 = {{1,4,5},{0,9,8},{0,0,7},{0,0,0}};
        int[][] notUpper1 = {{1,4,1,4},{0,7,6,5},{0,1,4,9}};
        int[][] notUpper2 = {{1,4,1},{1,9,1},{0,2,4}}; // not a square matrix
        // foe addTo    
        int[][] add_to_data = {{3,4,5}, {1,2,3}, {0,0,0},{1,2,1}}; // add to 'data' matrix, dimension not match
        int[][] add_to_above = {{1,0,-1}, {2,1,0}, {2,2,2},{0,-1,0}}; // add to 'add_to_data' matrix
        // for sum()
        int size=4;
        Matrix[] arr = new Matrix[size];
        for(int i=0; i<size; i++)
            arr[i]=new Matrix(2,3);
        arr[2]= new Matrix(3,3);     // invalid, due to dimension do not match
        
        Matrix[] arr2 = new Matrix[3];  // valid, can change the matrices here
        int[][] temp1={{1,-1,2}, {1,0,-2}};
        int[][] temp2={{1,0,1}, {0,1,2}};
        int[][] temp3={{0,3,-1}, {0,0,1}};
        arr2[0] = new Matrix(temp1);
        arr2[1] = new Matrix(temp2);
        arr2[2] = new Matrix(temp3);
        // for setElement, operates on 'data' matrix
        int value = 100;
        int setvalid_row = 0, setvalid_col = 0;
        int setinvalid_row = 10, setinvalid_col = 10;
        // for copy, copy data matrix to a new matrix, and modify the new matrix will not change data matrix
        Matrix origin = new Matrix(valid_row,valid_col); // create an original matrix
        Matrix copied = origin.copy();  // make a copy
        copied.setElement(50,0,0);   // modify the copied matrix
        
        ////////////////////////////////////////////////////////////////////////
        
        /****     Test LowerTriangularMatrix      *****/
        // for constructor1    
        int size_invalid = -5, size_valid = 4;
        // for constructor2 
        int[][] con2_11 = {{1,2,3,4,5},{0,6,7,8,9},{0,0,10,11,12},{0,0,0,13,14},{0,0,0,0,15}};
        int[][] con2_21 = {{10,9,8,7},{0,6,5,4},{0,0,3,2},{0,0,0,1}};
        int[][] notupp = {{1,0,0},{2,2,0},{3,3,3}};
        Matrix con2_1 = new Matrix(con2_11);
        Matrix con2_2 = new Matrix(con2_21);
        Matrix not = new Matrix(notupp);
        // getDim() method gets dimensions of con2_21 and con2_11
    
        // the first getElement() prints out con2_11, the second is for invalid position
    
        // for setElement, 
        int value1 = 100, value2 = 100;
        int setvalid_row1 = 3, setvalid_col1 = 4; // operates on con2_11
        int setvalid_row2 = 2, setvalid_col2 = 2;  //operates on con2_21
        int setinvalid_row1 = 7, setinvalid_col1 = 7;
        int setinvalid_row2 = 4, setinvalid_col2 = 0; // upper triangular part
        // fullMatrix() prints out con2_21 and con2_11 in 2D format
    
        /******** end parameters ****************/
    
		System.out.println("*** Test Class Matrix - 40' for this part ***" );
                System.out.println("*** The mark for each test case is indicated after the case number ***" );
                // test constructor1; invalid inputs
		Matrix a = new Matrix(invalid_row1,invalid_col1);
		System.out.println("No.1(1')->Test costructor1--invalid inputs: (" +invalid_row1 + "," + invalid_col1 + ")");
		System.out.println(a.toString());
		System.out.println("");
		
		// test constructor1; invalid inputs
		Matrix b = new Matrix(invalid_row2,invalid_col2);
		System.out.println("No.2(1')->Test costructor1--invalid inputs: (" +invalid_row2 + "," + invalid_col2 + ")");
		System.out.println(b.toString());
		System.out.println("");
				
		// test constructor1; valid inputs
		Matrix d = new Matrix(valid_row,valid_col);
		System.out.println("No.3(1')->Test costructor1--valid inputs: (" +valid_row + "," + valid_col + ")");
		System.out.println(d.toString());
		System.out.println("");
		
		//test constructor2;
		Matrix f = new Matrix(data);
		System.out.println("No.4(2')->Test costructor2-- " + data.length +"-by-"+ data[0].length +" array" );
		System.out.println(f.toString());
		System.out.println("");
		
		
		//test getElement(); Indices begin with 0
		
		try {
			System.out.println("No.5(1')->Test getElement(" + getvalid_row+ ","+ getvalid_col +"), Note that Indices begin with 0" );
			System.out.println(f.getElement(1, 3));			

			System.out.println("No.6(1')->Test getElement(" + getinvalid_row+ ","+ getinvalid_col +"), invalid indexes" );
			System.out.println(f.getElement(10, 2));	// invalid indexes
		}
		catch (IndexOutOfBoundsException e){
			System.out.println(e);
		}
		System.out.println("");
		
		System.out.println("No.7(2')->Test setElement() -- invalid operation (" + value+","+setinvalid_row+","+setinvalid_col+")" );
                System.out.println(f.setElement(value,setinvalid_row,setinvalid_col));
                System.out.println(f.toString());                
                System.out.println("No.8(2')->Test setElement() -- valid operation(" + value+","+setvalid_row+","+setvalid_col+")" );
                System.out.println(f.setElement(value,setvalid_row,setvalid_col));
                System.out.println(f.toString());		
		
                System.out.println("No.9(1')->Test copy()");
                System.out.println("copied matrix after modification");
                System.out.println(copied.toString());
                System.out.println("original matrix");
                System.out.println(origin.toString());
                
		System.out.println("No.10(3')->Test addTo() -- invalid operation");                
                Matrix m = new Matrix(add_to_data);
                try{
                    m.addTo(f);
                    System.out.println(m);
                }catch (ArithmeticException e){
			System.out.println(e);
			System.out.println("");
		}
                
                System.out.println("No.11(3')->Test addTo() -- valid operation");
                Matrix m1 = new Matrix(add_to_above);
                try{
                    m.addTo(m1);
                    System.out.println(m);
                }catch (ArithmeticException e){
			System.out.println(e);
			System.out.println("");
		}                
                                
                //test subMatrix()		
		try {
			System.out.println("No.12(3')->Test subMatrix(), valid inputs: (" +subvalid_row + "," + subvalid_col + ")");
			Matrix y = f.subMatrix(subvalid_row,subvalid_col);
			System.out.println(y.toString());
			System.out.println("");

			System.out.println("No.13(3')->Test subMatrix(), invalid inputs: (" +subinvalid_row + "," + subinvalid_col + ")");
			System.out.println(f.subMatrix(subinvalid_row,subinvalid_col));
		}
		catch (ArithmeticException e){
			System.out.println(e);
			System.out.println("");
		}
		
		
		//test isUpperTr()	
		System.out.println("No.14(3')->Test isUpperTr(), return true");           	
        	Matrix v = new Matrix(Upper1);
		System.out.println(v.toString());
		System.out.println(v.isUpperTr());
                System.out.println("");

		System.out.println("No.15(3')->Test isUpperTr(), return false");		
        	Matrix n = new Matrix(notUpper1);
		System.out.println(n.toString()); 
		System.out.println(n.isUpperTr());
                System.out.println("");

		System.out.println("No.16(3')->Test isUpperTr(), return false (non-square matrix)");		
        	Matrix p = new Matrix(notUpper2);
		System.out.println(p.toString()); 
		System.out.println(p.isUpperTr());
                System.out.println("");

		
		System.out.println("No.17(3')->Test sum() -- invalid operation");
                try{
                    System.out.println(Matrix.sum(arr).toString());
                }
                catch (ArithmeticException e){
			System.out.println(e);
			System.out.println("");
		}
                
                System.out.println("No.18(3')->Test sum() -- valid operation");
                try{
                    System.out.println(Matrix.sum(arr2).toString());
                }
                catch (ArithmeticException e){
			System.out.println(e);
			System.out.println("");
		}
		


                
             System.out.println("*** Test Class UpperTriangularMatrix - 20' for this part ***" ); 

		// test constructor1; invalid input
		UpperTriangularMatrix m11 = new UpperTriangularMatrix(size_invalid);
		System.out.println("NO.1(1')->Test costructor1--invalid input (" + size_invalid + ")" );
		System.out.println(m11.toString());
				
				
		// test constructor1; valid input
		UpperTriangularMatrix m2 = new UpperTriangularMatrix(size_valid);
		System.out.println("NO.2(1')->Test costructor1--valid input(" + size_valid + ")" );
		System.out.println(m2.toString());
                System.out.println("1D representation");
		m2.print1DArray();
                System.out.println("\n");
                		
		//test constructor2;
                UpperTriangularMatrix m3 = new UpperTriangularMatrix(con2_1);
		System.out.println("NO.3(2')->Test costructor2-valid" );
		System.out.println(m3.toString());
                System.out.println("1D representation");
                m3.print1DArray();
                System.out.println("\n");
                
                //test constructor2;
                System.out.println("NO.4(2')->Test costructor2-invalid" );
                System.out.println("The matrix \n"+not.toString()+"is not upper triangular, should throw exception");
                try{
                    UpperTriangularMatrix m5 = new UpperTriangularMatrix(not);		
                }
                catch (IllegalArgumentException e){
			System.out.println(e);
			System.out.println("");
		}                
                
                //test getDim()
                UpperTriangularMatrix m4 = new UpperTriangularMatrix(con2_2);	
                System.out.println("NO.5(1' for each)->Test getDim()" );
                System.out.println("Dimension of con2_1 is:" );
                System.out.println(m3.getDim());
                System.out.println("Dimension of con2_2 is:" );
                System.out.println(m4.getDim());
                System.out.println("");
		
		//test getElement()
                
		try {
                        System.out.println("NO.6(1')->Test getElement() - should print out con2_1" );
                        for(int i=0; i<m3.getDim(); i++){
                        for(int j=0; j<m3.getDim(); j++)
                        System.out.print(m3.getElement(i,j) + "  ");
                        System.out.println("");
                        }// end for i
                        System.out.println("");
                
			System.out.println("NO.7(1')->Test getElement() - invalid position " );
			System.out.println(m3.getElement(setinvalid_row, setinvalid_col));	// invalid indexes
		}
		catch (IndexOutOfBoundsException e){
			System.out.println(e);
		}
		System.out.println("");
                
                //tets setElement()
                try {
                        System.out.println("NO.8(2' for each)->Test setElement() - valid positions" );
                        m3.setElement(value1, setvalid_row1, setvalid_col1);
                        System.out.println("(" + value1 + "," + setvalid_row1 + "," + setvalid_col1 +")" );
                        System.out.print(m3);
                        System.out.println("");
                        System.out.println("(" + value2 + "," + setvalid_row2 + "," + setvalid_col2 +")" );
                        m4.setElement(value2, setvalid_row2, setvalid_col2);
                        System.out.print(m4);
                
			System.out.println("NO.9(2')->Test setElement() - invalid position " );
                        m3.setElement(value1, setinvalid_row1, setinvalid_col1);
			System.out.print(m3);	// invalid indexes
		}
		catch (IndexOutOfBoundsException e){
			System.out.println(e);
		}
                catch (IllegalArgumentException e){
			System.out.println(e);
                        System.out.println("Pay attention! This is a lower triangular matrix!");
		}
		System.out.println("");
                
                try {
                                     
			System.out.println("NO.10(2')->Test setElement() - attempt to change a value from the lower part " );
                        m3.setElement(-1, setinvalid_row2, setinvalid_col2);
			System.out.print(m3);	// invalid indexes
		}
		catch (IndexOutOfBoundsException e){
			System.out.println(e);
		}
                catch (IllegalArgumentException e){
			System.out.println(e);
                        System.out.println("Pay attention! This is a lower triangular matrix!");
		}
		System.out.println("");
		
                //test fullMatrix()
                 System.out.println("NO.11(1' for each)->Test fullMatrix()");
                m3 = new UpperTriangularMatrix(con2_1);
                m4 = new UpperTriangularMatrix(con2_2);
                System.out.println("print out con2_2");
                System.out.print(m4.fullMatrix().toString());
                System.out.println("");
                System.out.println("print out con2_1");
                System.out.print(m3.fullMatrix().toString());

    }
}

/*
//Test Constructor 1 with invalid inputs: (-1,2) the constructor should set -1 to 3;
        Matrix matTest1 = new Matrix(-1,2);
        System.out.println("matTest1 looks like\n"+matTest1.toStringMat());
        
        //Test Constructor 1 with invalid inputs (1,0) the constructor should set the columns to 3
        Matrix matTest2 = new Matrix(1,0);
        System.out.println("matTest2 looks like\n"+matTest2.toStringMat());
        
        //Test Constructor 1 with valid inputs: (3,4)
        Matrix matTest3 = new Matrix(3,4);
        System.out.println("matTest3 looks like\n"+matTest3.toStringMat());
        
        //Test Constructor 2 with 4 by 5 array
        int test4[][] = {{1,1,1,1,1},{2,2,2,8,2},{0,0,1,7,1},{0,0,0,1,1}};
        Matrix matTest4 = new Matrix(test4);
        System.out.println("matTest4 looks like\n"+matTest4.toStringMat());
        
        //Test getElement(1,3) with test4 matrix, should get 8
        int testGet1 = matTest4.getElement(1, 3);
        System.out.println("testGet1 returned a value of "+testGet1);
        
        //Test getElement(10,2), invalid indexes
        //-should get java.lang.IndexOutOfBoundsException: Invalid indexes.
        try{
            int testGet2 = matTest4.getElement(10, 2);
            System.out.println("testGet2 = "+testGet2);
        }catch(IndexOutOfBoundsException e){
            System.out.println("testGet2 returned an error called: "+e);
        }
        
        //Test subMatrix(), with valid inputs: (2,3)
        // should get the following 1  1  1  1
        //                          2  2  2  8
        //                          0  0  1  7
        Matrix matTest5 = matTest4.subMatrix(2, 3);
        System.out.println("matTest5 looks like\n"+matTest5.toStringMat());
        
        //Test subMatrix(), invalid inputs (3,6):
        //-should get java.lang.ArithmeticException: Submatrix not defined
        try{
            Matrix matTest6 = matTest4.subMatrix(3,6);
            System.out.println("matTest6 looks like\n"+matTest6.toStringMat());
        }catch(ArithmeticException e){
            System.out.println("matTest6 returned an error called: "+e);
        }
        
        //Test isUpperTr() with the following matrix
        //  1  2  3  4
        //  0  5  6  7
        //  0  0  8  0
        //should return true
        int table7[][] = {{1,2,3,4},{0,5,6,7},{0,0,8,0}};
        Matrix matTest7 = new Matrix(table7);
        System.out.println("The isUpperTr() function of matTest7 returned "+matTest7.isUpperTr());
        
        //Test isUpperTr() with the following matrix
        //  2  0  0  0
        //  0  9  6  8
        //  5  0  4  4
        //  0  0  0  9
        //should return false
        int table8[][] = {{2,0,0,0},{0,9,6,8},{5,0,4,4},{0,0,0,9}};
        Matrix matTest8 =  new Matrix(table8);
        System.out.println("The isUpperTr() function of matTest8 returned "+matTest8.isUpperTr());
        
        //Test addTo() with this matrix on the 4 by 5 matrix 
        //  2  0  0  0  4
        //  0  2  1  1  4
        //  0  0  2  1  4
        //  0  0  0  2  6
        //The function should opperate normally
        int table9[][] = {{2,0,0,0,4},{0,2,1,1,4},{0,0,2,1,4},{0,0,0,2,6}};
        Matrix matTest9 =  new Matrix(table9);
        matTest4.addTo(matTest9);
        System.out.println("matTest4 now looks like\n"+matTest4.toStringMat());
        
        //Test addTo() with the following matrix
        //  3  4  5
        //  2  4  6
        //  0  0  0
        //  2  4  2
        //function should throw an exception and have an invalid operation
        int table10[][] = {{3,4,5},{2,4,6},{0,0,0},{2,4,2}};
        Matrix matTest10 = new Matrix(table10);
        try{
            matTest4.addTo(matTest10);
        }catch(ArithmeticException e){
            System.out.println("the addTo function of matTest4 threw the this error "+e);
        }
        matTest10.addTo(matTest10);
        System.out.println("matTest4 now looks like\n"+matTest10.toStringMat());
        
        //Test sum() function with this matrix array
        //     matArray[0]    matArray[1]    matArray[2]   matArray[3]* 
        //  |  2  4  5  6  |  3  6  9  0  |  2  3  5  4  | 7  8  |
        //  |  5  6  1  7  |  2  4  6  5  |  4  8  6  2  | 9  1  |
        //  |  1  5  6  2  |  7  8  5  1  |  1  6  3  4  |
        //  |  3  2  7  3  |  8  6  1  7  |  1  9  7  9  |
        int ArrayEle0[][] = {{1,1,1,1,1},{2,2,2,8,2},{0,0,1,7,1},{0,0,0,1,1}};
        Matrix matArrayEle0 =  new Matrix(ArrayEle0);
        int ArrayEle1[][] = {{1,1,1,1,1},{2,2,2,8,2},{0,0,1,7,1},{0,0,0,1,1}};
        Matrix matArrayEle1 = new Matrix(ArrayEle1);
        int ArrayEle2[][] = {{1,1,1,1,1},{2,2,2,8,2},{0,0,1,7,1},{0,0,0,1,1}};
        Matrix matArrayEle2 = new Matrix(ArrayEle2);
        int ArrayEle3[][] = {{7,8},{9,1}};
        Matrix matArrayEle3 =  new Matrix(ArrayEle3);
        Matrix matArrayTest11[] = {matArrayEle0,matArrayEle1,matArrayEle2};
        Matrix matArrayTest12[] = {matArrayEle0,matArrayEle1,matArrayEle2,matArrayEle3};
        Matrix matTest11 = Matrix.sum(matArrayTest11);
        Matrix matTest12 = Matrix.sum(matArrayTest12);
        
        try{
            System.out.println("matTest11 looks like ");
        }catch(ArithmeticException e){
            System.out.println("The static sum function returned this error "+e);
        }
*/
