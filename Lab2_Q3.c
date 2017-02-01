/* Student Name: Tim Tianyu Lu
 * Lab Section: 06
 * Lab 2, Question 3
 */

#include <stdio.h>
#include <stdlib.h>

#define N 5//assume the number of columns for the matrix is equal to 5

int is_toeplitz(int a[][N], int m);
/*
 * 
 */
int main(int argc, char** argv) {
    int test[][N] = {
        {9,2,1,0,4},
        {7,9,2,1,0},
        {3,7,9,2,1},
        {5,13,7,9,2}};
    is_toeplitz(test, 4)?printf("The matrix is a Toeplitz matrix"):printf("The matrix is a not Toeplitz matrix");
    return (EXIT_SUCCESS);
}

//this function checks a matrix if it is a Toeplitz matrix
//note that the two loops end 1 element before the boundary of the array. This is because the loops will already check those elements in their natural procedure
//the values of the top right and bottom left corners are also irrelevant in making a Toeplitz matrix
int is_toeplitz(int a[][N], int m){
    int i = 0, j = 0;
    do{
        do{
            if(a[i][j] != a[i+1][j+1])//checks if the an element is equal to its diagonal
                return 0;//if it's not return 0 which is false
            j++;
        }while(j < N-1);
        i++;
        j=0;
    }while(i < m-1);
    return 1;//if i reach this point than the matrix must be a Toeplitz matrix therefor return 1
}
