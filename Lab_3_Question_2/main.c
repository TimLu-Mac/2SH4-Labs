/* Student Name: Tim Lu
 * Student Number: 001421596
 * Lab Section: 06
 * Lab 3 Question 1
 * Question Summary
 * Implement a string processing function where it accepts two strings as 
 * and combines them. The function must use dynamic memory allocation.
 * The function must than return the address of the first array element. 
 * Functions from the string library header can not be used.
 */

#include <stdio.h>
#include <stdlib.h>

char *my_strcar(const char *const str1, const char *const str2);

int main(int argc, char** argv) {
    char *string1 = "Hello";
    char *string2 = "User";
    //p
    char *result;
    result = my_strcar(string1, string2);
    for(int i = 0; *(result+i)!=0; i++)
        printf("%c",*(result+i));
    free(result);
    return (EXIT_SUCCESS);
}

//the following function combines str1 and str2
char *my_strcar(const char *const str1, const char *const str2){
    int SL1, SL2;
    char *temp;
    for(SL1 = 0; *(str1+SL1)!= 0; SL1++){
        printf("%c\n",*(str1+SL1));
    }
    for(SL2 = 0; *(str2+SL2)!= 0; SL2++){
        printf("%c\n",*(str2+SL2));
    }
    temp = (char *)malloc ((SL1+SL2+1)*sizeof(char));
    for(int i = 0; i<SL1; i++){
        *(temp+i) = *(str1+i);
    }
    //i++;
    for(int i = 0; i< SL2; i++){
        *(temp+SL1+i) = *(str2+i);
    }
    *(temp+SL1+SL2)=0;
    return temp;
}