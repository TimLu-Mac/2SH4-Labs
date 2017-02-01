/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

/**
 *
 * @author super
 */
public class JavaApplication4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // parameters inpt here
        
        int arr[]  = {1,2,3,5,6}; // this list
        
        int uni1[] = {0,4,5,8,10,20};
        int uni2[] = {0,2,3}; // for testing union
        
        int inter1[] = {0,2,5};
        int inter2[] = {1,3,5,6,8,10};
        int inter3[] = {0,10,100}; //test intersection
        
        int diff1[] = {1,2,3,5,6,8};
        int diff2[] = {1,2,3}; // test difference
        int arr1[]  = {0,1,2};
        int arr2[]  = {1,2,3,4};
        int arr3[]  = {0,1};
        int arr4[]  = {6,7};
        SLLSet listObj100 = new SLLSet(arr1);
        SLLSet listObj99  = new SLLSet(arr2);
        SLLSet listObj98  = new SLLSet(arr3);
        SLLSet listObj97  = new SLLSet(arr4);
        SLLSet listObj96  = new SLLSet();
        SLLSet Array[]    = {listObj100,listObj99,listObj98,listObj97,listObj96}; // test static SLLSet union(sArray)
        
        int in    = 2;
        int notin = 0; // test isIn
        
        int notadd    = 3;
        int addmiddle = 4;
        int addlast   = 7;
        int addfirst  = 0;  // test add
        
        int notremove    = 10;
        int removemiddle = 5;
        int removelast   = 6;
        int removefirst  = 1;  // test remove
        
///////////////////////////////  end parameter ///////////////////////////////////////        
        
        
        //test constructor 1
        SLLSet listObj1= new SLLSet();
        System.out.println("Test 1 - Constructor 1:\n"+"List:\n"+ listObj1.toString());
        System.out.println("size = "+listObj1.getSize());
        System.out.println("*************************************************************");
       
        //test constructor 2 with sorted input without repetitions      
        SLLSet listObj2= new SLLSet(arr);
        System.out.println("Test 2 - Constructor 2 (sorted input):\n"+"List:\n"+listObj2.toString());
        System.out.println("size="+listObj2.getSize());
        System.out.println("*************************************************************");
        
        //test copy
        SLLSet copied= listObj2.copy();
        copied.add(100);
        System.out.println("Test 3 - Copy(Change in copy should not affect the initial set):\n"+"Copy List:\n"+copied.toString());
        System.out.println("size="+copied.getSize());
        System.out.println("Initial "+"List:\n"+listObj2.toString());
        System.out.println("size="+listObj2.getSize());
        System.out.println("*************************************************************");
        
        //test isIn
        System.out.println("Test 4 - isIn(in):\n"+in+" is in the list?\n"+listObj2.isIn(in));
        System.out.println("*************************************************************");
        System.out.println("Test 5 - isIn(not in):\n"+notin+" is in the list?\n"+listObj2.isIn(notin));
        System.out.println("*************************************************************");
        
        //test add
        listObj2.add(notadd);
        System.out.println("Test 6 - add(the value is in the list, then do nothing):  "+notadd+"\n"+"List:\n"+listObj2.toString());
        System.out.println("size="+listObj2.getSize());
        System.out.println("*************************************************************");  
        listObj2.add(addmiddle);
        System.out.println("Test 7 - add(middle):  "+addmiddle+"\n"+"List:\n"+listObj2.toString());
        System.out.println("size="+listObj2.getSize());
        System.out.println("*************************************************************");  
        listObj2.add(addlast);
        System.out.println("Test 8 - add(last):  "+addlast+"\n"+"List:\n"+listObj2.toString());
        System.out.println("size="+listObj2.getSize());
        System.out.println("*************************************************************");    
        listObj2.add(addfirst);
        System.out.println("Test 9 - add(first): "+addfirst+"\n"+"List:\n"+listObj2.toString());
        System.out.println("size="+listObj2.getSize());
        System.out.println("*************************************************************"); 
        
        //test remove
        listObj2= new SLLSet(arr);
        listObj2.remove(notremove);
        System.out.println("Test 10 - remove(the value is not in the list, then do nothing):  "+notremove+"\n"+"List:\n"+listObj2.toString());
        System.out.println("size="+listObj2.getSize());
        System.out.println("*************************************************************");  
        listObj2.remove(removemiddle);
        System.out.println("Test 11 - remove(middle):  "+removemiddle+"\n"+"List:\n"+listObj2.toString());
        System.out.println("size="+listObj2.getSize());
        System.out.println("*************************************************************");  
        listObj2.remove(removelast);
        System.out.println("Test 12 - remove(last):  "+removelast+"\n"+"List:\n"+listObj2.toString());
        System.out.println("size="+listObj2.getSize());
        System.out.println("*************************************************************");    
        listObj2.remove(removefirst);
        System.out.println("Test 13 - remove(first):  "+removefirst+"\n"+"List:\n"+listObj2.toString());
        System.out.println("size="+listObj2.getSize());
        System.out.println("*************************************************************"); 
        SLLSet emp = new SLLSet();
        emp.remove(removefirst);
        System.out.println("Test 14 - remove(from empty list):  "+removefirst+"\n"+"List:\n"+emp.toString());
        System.out.println("size="+emp.getSize());
        System.out.println("*************************************************************"); 
        
        // test union
        listObj2= new SLLSet(arr);
        SLLSet listObj3= new SLLSet();
        SLLSet listObj4 = listObj2.union(listObj3);
        System.out.println("Test 15 - union(s list is empty):\n"+"List:\n"+listObj4.toString());
        System.out.println("size="+listObj4.getSize());        
        System.out.println("*************************************************************");  
        SLLSet listObj5= new SLLSet(uni1);
        SLLSet listObj6 = listObj2.union(listObj5);
        System.out.println("Test 16 - union():\n"+"List:\n"+listObj6.toString());
        System.out.println("size="+listObj6.getSize());
        System.out.println("This list is: "+listObj2.toString());
        System.out.println("s list is: "+listObj5.toString());
        System.out.println("*************************************************************");    
        SLLSet listObj7= new SLLSet(uni2);
        SLLSet listObj8 = listObj2.union(listObj7);
        System.out.println("Test 17 - union():\n"+"List:\n"+listObj8.toString());
        System.out.println("size="+listObj8.getSize());
        System.out.println("This list is: "+listObj2.toString());
        System.out.println("s list is: "+listObj7.toString());
        System.out.println("*************************************************************");       
        SLLSet listObj40 = listObj3.union(listObj2);
        System.out.println("Test 18 - union(this list is empty):\n"+"List:\n"+listObj40.toString());
        System.out.println("size="+listObj40.getSize());
        System.out.println("*************************************************************");         
       
        // test intersection
        listObj2= new SLLSet(arr);
        SLLSet listObj9= new SLLSet();
        SLLSet listObj10 = listObj2.intersection(listObj9);
        System.out.println("Test 19 - intersection(s list is empty):\n"+"List:\n"+listObj10.toString());
        System.out.println("size="+listObj10.getSize());
        System.out.println("*************************************************************");  
        SLLSet listObj11= new SLLSet(inter1);
        SLLSet listObj12 = listObj2.intersection(listObj11);
        System.out.println("Test 20 - intersection():\n"+"List:\n"+listObj12.toString());
        System.out.println("size="+listObj12.getSize());
        System.out.println("This list is: "+listObj2.toString());
        System.out.println("s list is: "+listObj11.toString());
        System.out.println("*************************************************************");    
        SLLSet listObj13= new SLLSet(inter2);
        SLLSet listObj14 = listObj2.intersection(listObj13);
        System.out.println("Test 21 - intersection():\n"+"List:\n"+listObj14.toString());
        System.out.println("size="+listObj14.getSize());
        System.out.println("This list is: "+listObj2.toString());
        System.out.println("s list is: "+listObj13.toString());        
        System.out.println("*************************************************************");  
        SLLSet listObj15= new SLLSet(inter3);
        SLLSet listObj16 = listObj2.intersection(listObj15);
        System.out.println("Test 22 - intersection(no elements in common):\n"+"List:\n"+listObj16.toString());
        System.out.println("size="+listObj16.getSize());
        System.out.println("This list is: "+listObj2.toString());
        System.out.println("s list is: "+listObj15.toString());        
        System.out.println("*************************************************************");    
        SLLSet listObj50 = listObj9.intersection(listObj2);
        System.out.println("Test 23 - intersection(this list is empty):\n"+"List:\n"+listObj50.toString());
        System.out.println("size="+listObj50.getSize());       
        System.out.println("*************************************************************");         
                       
        // test difference
        listObj2= new SLLSet(arr);
        SLLSet listObj17= new SLLSet();
        SLLSet listObj18 = listObj2.difference(listObj17);
        System.out.println("Test 24 - difference(s list is empty):\n"+"List:\n"+listObj18.toString());
        System.out.println("size="+listObj18.getSize());
        System.out.println("*************************************************************");  
        SLLSet listObj19= new SLLSet(diff1);
        SLLSet listObj20 = listObj2.difference(listObj19);
        System.out.println("Test 25 - difference(this list is in s list):\n"+"List:\n"+listObj20.toString());
        System.out.println("size="+listObj20.getSize());
        System.out.println("This list is: "+listObj2.toString());
        System.out.println("s list is: "+listObj19.toString());        
        System.out.println("*************************************************************");    
        SLLSet listObj21= new SLLSet(diff2);
        SLLSet listObj22 = listObj2.difference(listObj21);
        System.out.println("Test 26 - difference():\n"+"List:\n"+listObj22.toString());
        System.out.println("size="+listObj22.getSize());
        System.out.println("This list is: "+listObj2.toString());
        System.out.println("s list is: "+listObj21.toString());          
        System.out.println("*************************************************************");
        SLLSet listObj1000 = listObj17.difference(listObj2);
        System.out.println("Test 27 - difference(this list is empty):\n"+"List:\n"+listObj1000.toString());
        System.out.println("size="+listObj1000.getSize());       
        System.out.println("*************************************************************");           
        
        // test union(sArray)
        SLLSet listObj23 = SLLSet.union(Array);
        System.out.println("Test 28 - union(sArray):\n"+"List:\n"+listObj23.toString());
        System.out.println("size="+listObj23.getSize());
        System.out.println("*************************************************************"); 
    } 
}
/*
int array1[] = {2,4,6};
        int array2[] = {6,8};
        int array3[] = {8,10,12};
        SLLSet test1, test2, test3, union12, union13, union23, inter12, inter13, inter23, diff12,diff13, diff23, unionArray;
        int arrTest1[], arrTest2[], arrTest3[], arrUnion12[], arrUnion13[], arrUnion23[], arrInter12[], arrInter13[], arrInter23[], arrDiff12[], arrDiff13[], arrDiff23[];
        SLLSet array4[] = new SLLSet[3];
        boolean in = false;
        
        System.out.println("array1.length = "+array1.length);
        test1 = new SLLSet(array1);
        System.out.println(test1.toString());
        arrTest1 = test1.toArray();
        System.out.println("The array of test1 is:");
        for(int i = 0; i < arrTest1.length; i++)
            System.out.print(arrTest1[i]+" ");
        if(test1.isIn(4) == true)
            System.out.println("\n4 does exist in test1");
        else
            System.out.println("\n4 does not exist in test1");
        test1.remove(7);
        System.out.println("Test if 7 was removed from test1: "+test1.toString());
        test1.add(7);
        System.out.println("Test if 7 was added to test1: "+test1.toString());
        test1.remove(7);
        System.out.println("Test if 7 was removed from test1: "+test1.toString());
        
                
        System.out.println("array2.length = "+array2.length);
        test2 = new SLLSet(array2);
        System.out.println(test2.toString());
        
        System.out.println("array3.length = "+array3.length);
        test3 = new SLLSet(array3);
        System.out.println(test3.toString());
        
        System.out.println("----------------------------------------------------------------------------------------");
        //Test the Union of test1 and test2
        System.out.println("Finding the union of array1 and array2.");
        union12 = test1.union(test2);
        System.out.println(union12.toString());

        //Test the Union of test1 and test3
        System.out.println("Finding the union of array1 and array3.");
        union13 = test1.union(test3);
        System.out.println(union13.toString());

        //Test the Union of test2 and test3
        System.out.println("Finding the union of array2 and array3.");
        union23 = test2.union(test3);
        System.out.println(union23.toString());

        
        System.out.println("----------------------------------------------------------------------------------------");
        
        System.out.println("Finding the intersect of array1 and array2.");
        inter12 = test1.intersection(test2);
        System.out.println(inter12.toString());
        
        System.out.println("Finding the intersect of array1 and array3.");
        inter13 = test1.intersection(test3);
        System.out.println(inter13.toString());
        
        System.out.println("Finding the intersect of array2 and array3.");
        inter23 = test2.intersection(test3);
        System.out.println(inter23.toString());
        
        System.out.println("----------------------------------------------------------------------------------------");
        
        System.out.println("Finding the difference of array1 and array2.");
        diff12 = test1.difference(test2);
        System.out.println(diff12.toString());
        
        System.out.println("Finding the difference of array1 and array3.");
        diff13 = test1.difference(test3);
        System.out.println(diff13.toString());
        
        System.out.println("Finding the difference of array2 and array3.");
        diff23 = test2.difference(test3);
        System.out.println(diff23.toString());
        
        System.out.println("----------------------------------------------------------------------------------------");
        
        array4[0] = test1;
        array4[1] = test2;
        array4[2] = test3;
        
        System.out.println("Find the union of array4");
        unionArray = SLLSet.union(array4);
        System.out.println(unionArray.toString());
*/