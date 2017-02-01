/* Student Name: Tim Lu
 * Lab Section: 06
 * Lab 4 UpperTriangularMatrix class
 */

package lab.pkg4;
/**The Upper Triangular 
 *
 * @author super
 */
public class UpperTriangularMatrix {
    
    private int matSize;
    private int matArray[];
    
    
    /**This is the constructor for the Upper Triangular Matrix
     * If n <= 0 than we change n to 1 and initialize the matrix as an all-zero n-by-n matrix
     * we also assume that this matrix is n-by-n
     * @param n represents the n size of rows
     */
    public UpperTriangularMatrix(int n){
        if(n<=0){
            n = 1;
            this.matArray = new int[n*(n+1)/2];
            this.matArray[0] = 0;
            this.matSize = n;
        }else{
            this.matArray = new int[n*(n+1)/2];
            this.matSize = n;
            for(int i = 0; i < n*(n+1)/2; i++)
                this.matArray[i] = 0;
        }
    }
        
    /**
     * this constructor initialized the Upper Triangular Matrix object to represent the triangular
     * matrix upTrim. If upTriM is not an Upper Triangular Matrix the function throws and exception
     * @param upTriM is an object of the class Matrix
     */
    public UpperTriangularMatrix(Matrix upTriM)throws IllegalArgumentException{
        Matrix temp = upTriM.copy();
        boolean end = false;
        int count = 1, internal = 0;
        if(upTriM.isUpperTr()== true){
            while(end == false){
                try{
                    temp.getElement(count,0);
                    count++;
                }catch(IndexOutOfBoundsException e){
                    end = true;
                }
            }
            this.matSize = count;
            this.matArray = new int[this.matSize*(this.matSize+1)/2];
            for(int i = 0; i < count; i++){
                for(int j = i; j < count; j++){
                    this.matArray[internal] = temp.getElement(i, j);
                    internal++;
                }
            }
        }else
            throw new IllegalArgumentException("This is not an upper triangular matrix");
            
    }
    
    /**This is the function getDim which returns the number of rows of this matrix
     * @return rows which holds the integer values of the upper triangular matrix
     */
    public int getDim(){
        return matSize;
    }
    
    /**The function getElement returns the element stored in the ith row and jth element
     * @param i this is the ith row of the element that we search for
     * @param j this is the jth column of the element that we search for
     * @return
     * @throws IndexOutOfBoundsException
     */
    public int getElement(int i, int j) throws IndexOutOfBoundsException{
        int ele;
        Matrix matTemp = this.fullMatrix();
        try{
            ele = matTemp.getElement(i, j);
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Invalid index");
        }        
        return ele;
    }
    
    /**This function sets the element of a matrix
     * This function searches for the element in the ith row and the jth column and sets the value stored there to the value of x
     * @param x is the value that we wish to set as
     * @param i is the ith row that the element is stored in
     * @param j is the jth column that the element is stored in
     * @throws IndexOutOfBoundsException This exception is thrown if the element we wish to see does not exist within array dimensions
     * @throws IllegalArgumentException This exception is thrown if the x value is not 0 if it exists in the lower bounds of the array
     */
    public void setElement(int x, int i, int j) throws IndexOutOfBoundsException, IllegalArgumentException{
        boolean success;
        int internal =0;
        Matrix matTemp = this.fullMatrix();
        if(((i>=1)&&(i<=(this.matSize-1)))&&((j>=0)&&(j<=(i-1)))){
            throw new IllegalArgumentException("Incorrect argument due to lower tri");
        }success = matTemp.setElement(x, i, j);
        if(success == false)
            throw new IndexOutOfBoundsException("Incorrect argument");
        for(int a = 0; a < this.matSize; a++){
            for(int b = a; b < this.matSize; b++){
                this.matArray[internal] = matTemp.getElement(a, b);
                internal++;
            }
        }
    }
    
    /**fullMatrix returns a matrix object that stores all the elements including the zeros
     * @return m, m is the variable of type matrix that stores the triangular matrix
     */
    public Matrix fullMatrix(){
        Matrix m = new Matrix(this.matSize, this.matSize);
        int count = 0;
        for(int i = 0; i < this.matSize; i++){
            for(int j = i; j < this.matSize; j++){
                m.setElement(this.matArray[count], i, j);
                count++;
            }
        }
        return m;
    }
    
    /**this function prints the elements of the one dimensional array that 
     * stored the elements of the upper triangular part. Each element is separated by two spaces
     */
    public void print1DArray(){
        for(int i = 0; i < this.matSize*(this.matSize+1)/2; i++){
            System.out.print(this.matArray[i]+"  ");
        }
        System.out.println("");
    }
    
    /**This function returns a string representing this upper triangular matrix. 
     * The string should show all elements of the full matrix with each row on a separate line.
     * @return matrix, this string will hold the string representation of the matrix
     */
    public String toString(){
        Matrix matTemp = this.fullMatrix();
        String matrix = matTemp.toString();
        return matrix;
    }
}
