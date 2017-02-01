/* Student Name: Tim Tianyu Lu
 * Lab Section: 06
 * Lab 2 Question 4
 */

#include <stdio.h>
#include <stdlib.h>

void letter_freq(const char word[], int freq[]);

int main(int argc, char** argv){
    char strWord[]= "helloO world";
    int freq[26];
    letter_freq(strWord, freq);
    for(int i = 0; i < 26; i++)
        printf("The count of '%c' and '%c' is %d\n", ('A'+i),('a'+i),freq[i]);
    return (EXIT_SUCCESS);
}//end of main function

//this function checks the frequency of letter inside words.
void letter_freq(const char word[], int freq[]){
    for(int i = 0; i < 26; i++)
        freq[i] =0;
    for(int i = 0; word[i]!=0; i++){//the array ends when it reaches the end of the string
        for(int j = 'A'; j < 'Z'; j++){//the loop starts at the integer value of 'A' and ends at the integer value of 'Z'
            if(word[i] == j || word[i] == (j-('A'-'a')))//j-('A'-'a') is the conversion to the lowercase letter that corresponds to j
                freq[j-'A']++;//once the function finds a match in the letter it will go to the corresponding section of the freq array and increment it
        } //end of inner for loop
    }//end of outer for loop
}//end of letter_freq function
