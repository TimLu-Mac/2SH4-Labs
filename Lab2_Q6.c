/* Student Name: Tim Tianyu Lu
 * Student ID: 001421596
 * Lab 2 Question 6*/

#include <stdio.h>
#include <stdlib.h>
#define K 3

void efficient( const int source[], int val[], int pos[], int size);
void reconstruct(int source[], int m, const int val[], const int pos[], int n);
void print_array(const int a[], int m);

int main(int argc, char** argv) {
    int source[] = {0,0,23,0,-7,0,0,48}, val[K] = {0}, pos[K] = {0};
    efficient(source, val, pos, 8);
    source[0] = 10; source[1] = 10; source[2] = 10; source[3] = 10; source[4] = 10; source[5] = 10; source[6] = 10; source[7] = 10; source[8] = 10;
    reconstruct(source, 8, val, pos, K);
    printf("The val vector is : ");
    print_array(val, K);//testing to make sure the values stored in the val array are correct
    printf("The pos vector is : ");
    print_array(pos, K);//testing to make sure the indexes of the non zero values are stored correctly
    return (EXIT_SUCCESS);
}

/*This function computes the efficient representation of a vector by filling in
  the arrays val and position. we are assuming that each vector contains at least
  one non-zero element.
  
 *The parameter size represents the number of components of the vector source[]
  We assume that the size of array pos and val equal the number of non-zero values
  in the vector source*/
void efficient( const int source[], int val[], int pos[], int size){
    int j = 0;
    for(int i = 0; i < size; i++){
        if(source[i] != 0){//if the element doesn't equal to 0 then it's value is stored in the val array and it's position is stored in the pos array
            val[j] = source[i];
            pos[j] = i;
            j++;
        }//end of if statement
    }//end of for loop
}//end of efficient function

/*This function reconstructs the source array from the values stored in the val and pos function
  m represents the size of the source array and n represents the size of the val and pos array*/
void reconstruct(int source[], int m, const int val[], const int pos[], int n){
    for(int i = 0; i < m; i++){
        source[i] = 0;//first the function assumes the array value at element i is 0
        for(int j = 0; j < n; j++){
            //in this for loop it checks if this index of the array should 
            //contain a different value and if it does it's changed. This is 
            //done by going through all the elements of the pos array
            if(i == pos[j]){
                source[i] = val[j];
                break;
            }//end of if statement
        }//end of inner for loop
    }//end of outer for loop
}//end of reconstruct function

//this function just prints the arrays
void print_array(const int a[], int m){
    for(int i = 0; i < m; i++)
        printf("%d ", a[i]);
    printf("\n");
}
