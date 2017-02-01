/*  Student Name: Tim Lu
 *  Student Number: 001421596
 *  Lab Section: 06
 *  Lab 3 Question 2
 * Question Summary
 * This program manages the grades of students in a class and represents the 
 * information of each student in a structure type named student. 
 * The members of this structure should be:
 * - an integer that represents the student's ID number
 * - an array of 15 characters storing the first name
 * - an array of 15 characters storing the last name
 * - an integer that represents the project 1 grade
 * - an integer that represents the project 2 grade
 * - a floating point representing the final course grade
 */

#include <stdio.h>
#include <stdlib.h>

typedef struct{
    int studentID;
    char firstName[15];
    char lastName[15];
    int grade1;
    int grade2;
    float gradeFinal;
} student;

/* -filename represents a string which stores the name of the inputfile.
 * -
 */
student **create_class_list( char *filename, int *sizePtr);

/* -list is a pointer to the beginning of the array of pointers which represent 
 *  the class list
 * -size represents the number of students in the list which I assume to be 
 *  larger or equal to 0
 * -idNo represents the student's id that the function is searching for
 * 
 * This function searches for a student depending on their student ID and 
 * returns their position in the student list but if the student is not found 
 * the function returns -1;
 */
int find( int idNo, student **list, int size);

/* -list is a pointer to the beginning of the array of pointers representing 
 *  the class list
 * -size is a parameter which represents the number of students in the list
 * -filename represents the name of a text file
 * 
 * This function reads the project 1 and project 2 grades from the textfile and
 * inputs them in the class list. The file contains the information for each 
 * student on a separate line, first the ID number, then the project 1 grade 
 * followed by the project 2 grade, all separated by white spaces.
 * Not the following file will not be sorted and therefor ID numbers do not 
 * appear in increasing order so the find() function should be used.
 */
void input_grades( char *filename, student **list, int size);

void compute_final_course_grades(student **list, int size);

void output_final_course_grades(char *filename);

void print_list( student **list, int size);

void withdraw(int idNo, student **list, int *sizePtr);

void destroy_list(student **list, int *sizePtr);

char **read_words(const char *input_filename, int *nPtr);

int main(int argc, char** argv) {
    student **p;
    char filename[] = "Data.txt";
    char filename2[] = "Data2.txt";
    char filename3[] = "Data3.txt";
    char filename4[] = "Data4.txt";
    int size=0,j=0,k=0;
    p=create_class_list(filename,&size);
    input_grades(filename2,p,3);
    printf("size is: %d\n",size);
    compute_final_course_grades(p, size);
    print_list( p, size);
    output_final_course_grades(filename3);
    withdraw(9000,p,&size);
    printf("\n\n\n\n\n---------------------after withdraw---------------------\n");
    print_list( p, size);
    printf("end\n");
    destroy_list(p,&size);
    printf("size: %d\n",size);
    return (EXIT_SUCCESS);
}

/* this function creates the class list
 */
student **create_class_list(char *filename,int *sizePtr){
    student **ptr=NULL; 
    int size,j=0,k=0;
    FILE *input_file=fopen(filename,"r");//opens the file name in this test case it is Data.txt
    fscanf(input_file,"%d",&size);
    *sizePtr = size;
    ptr = (student**)calloc(size,sizeof(student*));//allocates the memory for the class list
    for(int i = 0; i<size;i++){
        ptr[i] = (student*)calloc(1,sizeof(student));
        fscanf(input_file,"%d",&(ptr[i]->studentID));
        fscanf(input_file,"%s",&(ptr[i]->firstName));
        fscanf(input_file,"%s",&(ptr[i]->lastName));
    }
    fclose(input_file);
    return ptr;
}

/* this following function searches for a student with the id save in idNo
 * -idNo represents the student's id we are searching for
 * -student **list represents a pointer which points at the class list
 * -size represents the class lists
*/
int find( int idNo, student **list, int size){
    for(int i = 0; i < size; i++){//this function ideally runs through the class list
        if((list[i]->studentID)==idNo)//if the studentID at the ith interval of the list is equal to idNo then this function returns the position of the list
            return i;
    }
    return -1;//if the id does not exist the function returns -1
}

//this function read the project 1 and 2 grades from a txt file
//each line in the input file contains a student id, the grade of the 1st project, and the grades of the 2nd project seperated by white spaces
void input_grades( char *filename, student **list, int size){
    FILE *input_file=fopen(filename,"r");
    int i=0,j =0,temp=0,temp2=0,grade1=0,grade2=0;
    while(i < size){
        fscanf(input_file,"%d",&temp);
        temp2=find(temp,list,size);
        if(temp2!=-1){
            fscanf(input_file,"%d",&grade1);
            fscanf(input_file,"%d",&grade2);
            (list[temp2]->grade1)=grade1;
            (list[temp2]->grade2)=grade2;
        }
        i++;
    }
    fclose(input_file);
}

//the following function calculates the value of the final grade from the average from the project grades
//it than saves the calculated value into the gradeFinal variable in the structure
void compute_final_course_grades(student **list, int size){
    for(int i=0; i<size; i++){
        (list[i]->gradeFinal)=((list[i]->grade1)+(list[i]->grade2))/2.0;
    }
}

/* this function outputs the final grades
 * these final grades are read from a seperate file
 * the first line in the file is the number of students
 * the lines after have the student ID and the final mark seperated by white spaces
 */
void output_final_course_grades(char *filename){
    FILE *input_file=fopen(filename,"r");
    int tempSize, id;
    float grade;
    fscanf(input_file,"%d",&tempSize);
    for(int i=0; i<tempSize;i++){
        fscanf(input_file,"%d",&id);
        fscanf(input_file,"%f",&grade);
        printf("%d's final grade is %f\n",id,grade);
    }
    fclose(input_file);
}

/* The following function prints the class list 
 */
void print_list( student **list, int size){
    int j=0,k=0;
    for(int i = 0;i<size;i++){//the loop goes from the start of the list to the size of the list
        printf("The student id is %d\n",(list[i]->studentID));
        
        printf("First Name is ");
        for(j=0;(j<15)&&((list[i]->firstName[j])!=0);j++){
            printf("%c",(list[i]->firstName[j]));
        }
        printf("\n");
        
        printf("Last Name is ");
        for(k=0;(k<15)&&((list[i]->lastName[k])!=0);k++){
            printf("%c",(list[i]->lastName[k]));
        }
        printf("\n");
        
        printf("The project 1 grade is %d\n",(list[i]->grade1));
        printf("The project 2 grade is %d\n",(list[i]->grade2));
        printf("The final grade of the project is %f\n",(list[i]->gradeFinal));
    }
}

/* withdraw is a function used for when a student drops the class
 * this student is no longer considered in the class
 */
void withdraw(int idNo, student **list, int *sizePtr){
    int tempPos = find( idNo, list, *sizePtr);//first we find if the student that dropped the courses was ever in the course in the first place
    if(tempPos!=-1){//if the student is in the class 
        for(int i=tempPos;i<*sizePtr;i++){//we go through from the position the the dropped person is and up to the end of the rest of the list
          list[i] = list[i+1];//the ith element will than reference the next memory location
        }
        list[(*sizePtr)-1] = NULL;//this line makes the last element equal to null because all the element have been shifted to replace the withdrawn student
        *sizePtr=*sizePtr-1; //the size is than decreased by 1 since a student is withdrawn  
        free((list[*sizePtr]));//this function frees the last element of the list because it's no longer pointing to anything because of the line 2 lines above
    }
}

/*The following function frees the memory reserved for the class list and resets 
 * size pointer used for the class list
 */
void destroy_list(student **list, int *sizePtr){
    free(list);
    *sizePtr = 0;
}