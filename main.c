/* Student Name: Tim Tianyu Lu
 * Student Number: 001421596
 * Lab Section: 06
 * Lab 2 Question 5
 */

#include <stdio.h>
#include <stdlib.h>
#define A 3
#define B 6
#define C 10

void string_copy(const char source[], char destination[], int n);
void print_array(const char a[]);

int main(int argc, char** argv) {
    char strWord[] = {'h','e','l','l','o','\0'};
    char strCopy1[A], strCopy2[B], strCopy3[C];
    string_copy(strWord, strCopy1, A);
    string_copy(strWord, strCopy2, B);
    string_copy(strWord, strCopy3, C);
    
    print_array(strWord);
    print_array(strCopy1);
    print_array(strCopy2);
    print_array(strCopy3);
    return (EXIT_SUCCESS);
}

/* This function copies the values held in the variable source[] and places it 
 * destination array. If the destination array is not large enough to hold the whole amount
 * than the destination array must hold the prefix of the source[] values
 */
void string_copy(const char source[], char destination[], int n){
    int i;
    for(i = 0; source[i] != 0 && i < (n-1); i++)//loop will exit before it reaches the final element of the destination array or when the source reaches the null character in one of it's element
        destination[i] = source[i];//end of for loop
    destination[i]=0;//since i increments even when the loop exits element after the loop exits will hold the value of the null character
}//end of function string_copy

//all this function does is it prints out the values in the array
void print_array(const char a[]){
    int i;
    for(i = 0; a[i] != 0; i++)
        printf("%c",a[i]);//end of for loop
    printf("\n");
}//end of function print_arrays