/* Student Name: Tim Tianyu Lu
 * Student ID: 001421596
 * Lab Section: 06
 * Lab 2 Question 7*/

#include <stdio.h>
#include <stdlib.h>
#define K1 3 //this constant holds the size of the 1st efficiency vector
#define K2 3 //this constant holds the size of the 2nd efficiency vector
#define K3 6 //this constant holds the size of the 3rd efficiency vector which will be the sum of the 1st and 2nd efficiency vector
#define G 8  //this constant holds the size of the original vectors and the largest possible size of the reconstructed vector

void efficient( const int source[], int val[], int pos[], int size);
void reconstruct(int source[], int m, const int val[], const int pos[], int n);
void print_array(const int a[], int m);
void addEff(int val1[], int val2[], int val3[], int pos1[], int pos2[], int pos3[], int k1, int k2);
int arrayDone(int a[], int n);

int main(int argc, char** argv) {
    //int source1[] = {0,0,23,0,-7,0,0,48};
    //int source2[] = {52,19,0,7,0,0,0,0};
    //answer should be{52,12,23,7,-7,0,0,48};
    int result[G] = {0};
    int val1[K1] = {23, -7, 48}, val2[K2] = {52, -7, 7}, val3[K3] = {0};
    int pos1[K1] = {2, 4, 7}, pos2[K2] = {2, 4, 7}, pos3[K3] = {0};
    
    addEff(val1, val2, val3, pos1, pos2, pos3, K1, K2);
    reconstruct(result, G, val3, pos3, K3);
    printf("val3: "); print_array(val3, K3);
    //val3 should be {52,12,23,7,-7,48};
    printf("pos3: "); print_array(pos3, K3);
    //pos3 should be {0,1,2,3,4,7};
    printf("result: "); print_array(result,G);
    //result should be {52,12,23,7,-7,0,0,48}
    return (EXIT_SUCCESS);
}

/*This function reconstructs the source array from the values stored in the val and pos function
  m represents the size of the source array and n represents the size of the val and pos array*/
void reconstruct(int source[], int m, const int val[], const int pos[], int n){
    for(int i = 0; i < m; i++){
        source[i] = 0;//first the function assumes the array value at element i is 0
        for(int j = 0; j < n; j++){//in this for loop it checks if this index of the array should contain a different value and if it does it's changed. This is done by going through all the elements of the pos array
            if(i == pos[j]){
                source[i] = val[j];
                break;
            }//end of if statement
        }//end of inner for loop
    }//end of outer for loop
}//end of reconstruct function

void print_array(const int a[], int m){
    //this function prints the values of the arrays
    for(int i = 0; i < m; i++)
        printf("%d ", a[i]);
    printf("\n");
}

//This function will add two efficient vectors and store the resulting values in the arrays val3 and pos3 
//The function however does not know the size of val3 and pos3
//val1[] & pos1[] are the sparse vectors of the first source vector
//val2[] & pos2[] are the sparse vectors of the second source vector
//val3[] & pos3[] are the sparse vectors of the sum vector
//k1 and k2 are the number of non zero elements in both source vectors
//in order to work around the function not knowing the maximum length of the sparse vectors for the sum vector
//we consider that the maximum length of the resultant is the sum of k1 and k2
//we also know that the beginning of each sparse vector starts with the earliest non zero vector
void addEff(int val1[], int val2[], int val3[], int pos1[], int pos2[], int pos3[], int k1, int k2){
    int j, k;//j and k are counters to represent the element of the 1st and 2nd sparse vectors are being inspected
    int flag1 = 0, flag2 = 0;//these booleans represent if an array is completed flag1 is for sparse vector 1 and flag 2 is for sparse vector 2
    int tempPos1 = 0, tempPos2 = 0;//these are temporary values for the position value that is being inspected
    /*-The following loop will run through each value of the position efficiency vectors
     * -it will exit if i becomes equal or greater than k1+k2 because that is the largest possible value for i
     * -it will also exit if both efficiency vectors have been used
     * -i represents the value of the 3rd sparse vector that is being added
     */
    for(int i = 0; (i < (k1+k2) && (flag1 != 1 || flag2 != 1)); i++){
        /*-The following for loop does the following
         -it checks for the next unused position in the vector
         -it knows that a position has not been used in the vector if the value of the position is -1*/
        for(j = 0; j < k1; j++){//this for loop runs through all the elements of the position vector for the first sparse vectors
            //j represents the element of pos1 and val1 that is being inspected
            if(pos1[j] != -1){
                tempPos1 = pos1[j];
                break;
            }else//this particular if statement is for when a position sparse vector has been completely used and is no longer necessary for the rest for calculation the tempPos value is set to the largest possible value
                tempPos1 = k1+k2+1;
        }//
        for(k = 0; k < k2; k++){//this  for loop runs through all the elements of the position vector for the second sparse vectors
            //k represents the element of pos2 and val2 that is being inspected
            if(pos2[k] != -1){
                tempPos2 = pos2[k];
                break;
            }else
                tempPos2 = k1+k2+1;
        } 
        if(tempPos1 < tempPos2){//if value of the first position is less than the value of the second position than the first position takes precedence of the other position
            val3[i] += val1[j];//as a result the value at the ith element of val3 is incremented by the jth value of val1
            pos3[i] = tempPos1;//the ith element of the pos3 is made equal to the value of tempPos
            pos1[j] = -1;//that element of the sparse vector is now used so that element of the position vector is set to -1 to represent being used
        }else if(tempPos2 < tempPos1){//the same process for the 2nd position vector is used here
            val3[i] += val2[k];
            pos3[i] = tempPos2;
            pos2[k] = -1;
        }else{//in the situation where both temp position values are equal the following is executed
            if(val1[j]+val2[k] != 0){//the values at those positions are added together and checked if they equal to 0
                //if they are not 0 the sum is saved into the correct element of val3
                val3[i] += (val1[j]+val2[k]);
                pos3[i] = tempPos1;
            }else//if it is not those position are considered used and the function moves on
                i--;//since at the end of the loop i accumulates by 1 i must subtract the value of i once to cancel out the accumulation
            pos1[j] = -1; 
            pos2[k] = -1;
        }
        flag1 = arrayDone(pos1, k1);//at the end of the loop the function checks if an array is completed
        flag2 = arrayDone(pos2, k2);
    }//end of for loop
}

/*this array checks if my add efficiency function is finished with a vector
 if can tell this because if all the values in the position values are -1 which is a value this program assigns when a position has been used.
 if all a position vector is filled with -1 than the vector must be completed because it doesn't not make logical sense in this case for a vector to have a -1 position*/
int arrayDone(int a[], int n){
    for(int i = 0; i < n; i++){
        if(a[i] != -1)
            return 0;
    }
    return 1;
}
