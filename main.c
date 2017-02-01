/*Student Name: Tim Tianyu Lu
 * Student ID: 001421596
 * Lab Section: 06
 * Lab 2 Question 2
 */
#include <stdio.h>
#include <stdlib.h>

#define N 5//this constant is the value that I assume the dimmensions of the sqaure matrix are

int is_diag_dom(int mat[][N]);
double fabs(double x);

int main(int argc, char** argv) {
    int test[5][5] = {
        {-5,9,0,0,0},
        {1,-6,0,0,0},
        {1,0,-7,0,0},
        {1,0,9,-8,0},
        {1,0,0,0,-9}};
    is_diag_dom(test)?printf("The matrix is diagonally dominant."):printf("The matrix is not diagonally dominant.");
    return (EXIT_SUCCESS);
}

//this function check is a matrix is diagonally dominant
int is_diag_dom(int mat[][N]){
    int diagElem = 0;
    int absValue = 0;
    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            if(i == j)// this if statement saves the diagonal element of a matrix
                diagElem = fabs(mat[i][j]);
            absValue += mat[i][j];//this is an accumulator for the sum of the numbers in a row
        }
        absValue = fabs(absValue);//obtain the absolute value of the sum of the numbers in a row
        if(diagElem < absValue)//if any of the diagonal elements in the matrix is less than the sum of the values in the row
            return 0;//the function exits and returns 0 which means the following matrix is not diagonally dominant
        absValue = 0;//reset the row accumulator
    }
    return 1;//if I reached this point in the function the matrix must be diagonally dominant
}

//this function returns the absolute value of x
double fabs(double x){
    if(x< 0)
        x *= -1;
    return x;
}
