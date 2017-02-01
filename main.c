/* Student Name: Tim Tianyu Lu
 * Student ID: 001421596
 * Lab Section: 06
 * Lab 2 Question 1;
 */

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define N 3

void print_vector(double array[], int size);
void add_vectors(double vector1[], double vector2[], double vector3[], int n);
double scalar_prod(double vector1[], double vector2[], int n);
double norm2(double vector1[], int n);

int main(int argc, char** argv) {
    double vecX[N] = {2,4,6}, vecY[N] = {0,1,2}, vecSum[N];
    //double scalProd = 0, norm = 0;
    printf("Vector X is ");
    print_vector(vecX, N);
    printf("Vector Y is ");
    print_vector(vecY, N);
    printf("The vector sum of Vector X and Vector Y is ");
    add_vectors(vecX, vecY, vecSum, N);
    print_vector(vecSum, N);
    printf("The scalar product of Vector X and Vector Y is %f\n", scalar_prod(vecX, vecY, N));
    printf("The L2 norm of Vector X is %f\n", norm2(vecX, N));
    printf("The L2 norm of Vector Y is %f\n", norm2(vecY, N));
    printf("The L2 norm of Vector sum is %f\n", norm2(vecSum, N));
    return (EXIT_SUCCESS);
}

//this is a basic function that will prints vectors
void print_vector(double array[], int size){
    for(int i = 0; i < size; i++)//this for loop runs through every element in an array and prints the element
        printf("%f ", array[i]);
    printf("\n");
}//end of print_vector function

/*this is the add_vectors function
it's adds sums of the values of the ith element of 2 vectors and places that in the ith element of the third vector until the third vector is full
vector1 and vector2 are the two vectors that will be added together
vector 3 will hold the values of the vector sum
n is the size of vector1, vector2, vector3*/
void add_vectors(double vector1[], double vector2[], double vector3[], int n){
    for(int i = 0; i < n; i++)
        vector3[i] = vector1[i] + vector2[i];
}

/*This function returns the scalar product of two vectors that are passed to it. */
double scalar_prod(double vector1[], double vector2[], int n){
    double product = 0;//this is an accumulator for product
    for(int i = 0; i < n; i++){//this loop runs through every element in the first two arrays
        product += vector1[i]*vector2[i];//the ith value of vector1 & vector2 is multiplied together and accumulated in the product
    }
    return product;
}

/*This function calculates the L2 norm of a single vector. It accomplishes this by calling the scalar_prod function by passing 
 the vector is receives twice. The than square roots the returns value before return the norm*/
double norm2(double vector[], int n){
    double norm;
    norm = scalar_prod(vector, vector, n);//
    norm = sqrt(norm);
    return norm;
}