/* Student Name: Tim Lu
 * Lab Section: 06
 * Lab 4 Question 1 Matrix Class 
 */
package lab.pkg4;

/** This is the public class Matrix
 * It has the following instance fields
 * - an integer to store the number of rows
 * - an integer to store the number of columns
 * - a two dimensional array of integers to store the matrix elements
 */
public class Matrix {
    private int row;
    private int col;
    private int mat[][];
    
    /**This is the first Matrix Constructor
     * It will construct a matrix out of the dimensions provided to it
     * all elements within that array will be set to 0
     * @param row represents the number of rows of the matrix
     * @param col represents the number of columns of the matrix
     */
    public Matrix(int row, int col){
        if(row <= 0)
            this.row = 3;
        else
            this.row = row;
        if(col <= 0)
            this.col = 3;
        else
            this.col = col;
        this.mat = new int[this.row][this.col];
        for(int i=0; i<this.row; i++){
            for(int j=0;j<this.col;j++){
                this.mat[i][j] = 0;
            }
        }
    }
    
    /** This is the second Matrix Constructor
     * This matrix creates a matrix based on the array that was passed to it
     * @param table is the array that the matrix will attempt to copy
     * - the .length function will be used to find the size
     */
    public Matrix(int [][] table){
        this.row = table.length;
        this.col = table[0].length;
        System.out.println("row = "+this.row);
        System.out.println("Col = "+this.col);
        this.mat = new int[this.row][this.col];
        for(int i = 0; i < this.row; i++){
            for(int j = 0; j < this.col; j++){
                this.mat[i][j] = table[i][j];
            }
        }
    }
    
    /** This is the getElement function for the matric class
     * This function returns the element stored in the ith row and jth col
     * @param i represents the ith row of the matrix
     * @param j represents the jth row of the matrix
     * @return ele which contains the corresponding element
     * @throws IndexOutOfBoundsException, this exception is thrown if the element does not lie within the bounds of the matrix
     */
    public int getElement(int i, int j) throws IndexOutOfBoundsException{
        int ele = 0;
        if((i>this.row)||(j>this.col)||(i<0)||(j<0)){
            //System.out.print("The location of the element is not a valid location withing the matrix\n");
            throw new IndexOutOfBoundsException("The location of the element is not a valid location within the matrix");
        }else
            ele = this.mat[i][j];
        return ele;
    }
    
    /**This is the setElement function
     * This function changes the value stored at the element of the matrix
     * @param x this is the value of the matrix that we wish to set at the correct element
     * @param i represents the ith row of the matrix
     * @param j represents the jth row of the matrix
     * @return true if the element we wish to change exits, if it does not it returns false
     */
    public boolean setElement(int x, int i, int j){
        boolean exist;
        if((i>this.row)||(j>this.col)||(i<0)||(j<0))
            exist = false;
        else{
            this.mat[i][j] = x;
            exist = true;
        }
        return exist;
    }
    
    /** This is the Copy function
     * This function returns a copy of this matrix
     * @return the matrix that was copied
     */
    public Matrix copy(){
        Matrix a = new Matrix(this.mat);
        return a;
    }
    
    /** This is the addTo function
     * This function attempts to add a matrix to the current matrix
     * @param m is the matrix we would like to add to the current matrix
     * @throws ArithmeticException We throw this error if the element does not exist in this matrix
     */
    public void addTo(Matrix m) throws ArithmeticException{
        if((this.row != m.row)||(this.col != m.col)){
            throw new ArithmeticException("Invalid operation");
        }else{
            for(int i = 0; i<this.row; i++){
                for(int j = 0; j<this.col;j++){
                    this.mat[i][j] = this.mat[i][j]+m.mat[i][j];
                }
            }
        }
    }
    
    /**This is the subMatrix function 
     * this function returns a new matrix which represents a submatrix of this matrix
     * the submatrix is formed from rows 0 to i and columns 0 through j
     * this function first checks if i and j are within and required range and 
     * throws an exception if they are not.
     * @param i the ith row that the submatrix goes up to
     * @param j the jth column that the submatrix goes up to
     * @return s which is the submatrix;
     * @throws ArithmeticException 
     */
    public Matrix subMatrix(int i, int j) throws ArithmeticException{
        Matrix a = null;
        int temp;
        if((i>this.row)||(j>this.col)||(i<0)||(j<0)){
            throw new ArithmeticException("Submatrix not defined");
        }else{
            a = new Matrix(i+1, j+1);
            for(int b = 0; b <= i; b++){
                for(int c = 0; c <= j; c++){
                    //temp = this.getElement(b,c);
                    a.setElement(this.getElement(b,c),b,c);
                }
            }
        }
        return a;
    }
    
    /**This function checks if this matrix is Upper Triangular
     * if it is not upper triangular the function will false, if it does it returns true
     * @return is
     */
    public boolean isUpperTr(){
        for(int i = 1; i < this.row; i++){
            for(int j = 0; j < i; j++){
               if(this.mat[i][j] !=0)
                   return false;
            }
            //if(this.mat[i][i] == 0)
            //    return false;
        }
        return true;
    }
    
    /** This function returns the new matrix which represents the sum of all matrices in matArray
     * In the situation that the matrices in the matArray have different dimensions
     * @param matArray this is an array whose elements are matrices
     * @return s which is the sum of all the matrix elements in matArray
     * @throws ArithmeticException 
     */
    public static Matrix sum(Matrix[] matArray) throws ArithmeticException{
        Matrix s = new Matrix(matArray[0].row, matArray[0].col);
        for(int i = 0; i < matArray.length; i++){
            if(matArray[0].row != matArray[i].row)
                throw new ArithmeticException("Row dimmensions are not equal\n");
            if(matArray[0].col != matArray[i].col)
                throw new ArithmeticException("Column dimmensions are not equal\n");
            s.addTo(matArray[i]);
        }
        return s;
    }
    
    /** This function converts this matrix into a string and saves it into a string variable called matrix which will be returned
     * @return matrix which is a string that represents the matrix
     */
    public String toString(){//I change this function's to toStringMat from toString because I kept getting a function overwrite warning from java.lang.object which i did not want.
        String matrix = "";
        for(int i = 0; i < this.row; i++){
            for(int j = 0; j < this.col; j++){
                matrix += Integer.toString(this.mat[i][j])+"  ";
            }
            matrix += "\n";
        }
        return matrix;
    }    
}
