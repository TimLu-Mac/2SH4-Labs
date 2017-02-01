/* 
 * 
 * Lab Section 06
 * Lab Question 1 Class SLLSet
 */
package javaapplication4;

/**
 *
 * @author super
 */
public class SLLSet {
    
    private int setSize;
    private SLLNode head;

    //This function constructs an empty SLLSet with no element
    public SLLSet(){
        //System.out.println("constructor SLLSet() starts");
        this.setSize = 0;
        this.head = new SLLNode(0,null);
        //System.out.println("constructor SLLSet() ends");
    }
    
    /**This function constructs an SLLSet object that contains the elements of the input array
     * The array is assumed to be sorted and does not contain repetitions
     * @param sortedArray is the array that this linked list must copy
     */
    public SLLSet( int[] sortedArray){
        SLLNode newNode, pB, p, pF;
        this.head = new SLLNode(0,null);
        this.setSize = sortedArray.length;
        for(int i = 0; i < sortedArray.length; i++){
            newNode = new SLLNode(sortedArray[i],head.next);
            head.next = newNode;
        }
        //System.out.println(this.toString());
        //reversing the list
        try{
            pB = null;
            p = this.head.next;
            pF = p.next;
        }catch(Exception e){
            System.out.println("This list is empty");
            return;
        }
        while(pF != null){
            p.next = pB;
            //increment step
            pB = p;
            p = pF;
            pF = pF.next;
        }
        p.next = pB;
        this.head.next = p;
    }
          
    public SLLNode getHead(){return this.head;}
    
    public void setHead(SLLNode s){this.head = s;}
    
    /**This function adds e to the front of the SLLSet
     * @param e the node that we wish to add
     */
    public void addFront(int e){
        //System.out.println("void addFront(int e) starts");
        SLLNode newNode = new SLLNode(e, this.head.next);
        this.head.next = newNode;
        this.setSize++;
        //System.out.println("void addFront(int e) ends");
    }
    
    /**This function returns the size of the set
     * @return this.setSize
     */
    public int getSize(){
        return this.setSize;
    }
    
    /**This function returns a deep copy of this SLLSet
     * @return setCopy
     */
    public SLLSet copy(){
        SLLSet setCopy = null;
        int[] temp = this.toArray();
        setCopy = new SLLSet(temp);
        return setCopy;
    }
    
    /**This function creates an array copy of this SLLSet
     * @return arrayCopy
     */
    public int[] toArray(){
        int[] arrayCopy = new int[this.setSize];
        SLLNode p = this.head.next;
        for(int i = 0; p != null; i++, p = p.next){
            arrayCopy[i] = p.value;
        }
        return arrayCopy;
    }
    
    /**This function returns true if v is an element in SLLSet and false otherwise
     * @param v is the element that we are searching for
     * @return exist
     */
    public boolean isIn(int v){
        SLLNode p = head.next;
        while(p != null){
            if(p.value == v)
                return true;
            p = p.next;
        }
        return false;
    }
    
    /**This function adds v to this SLLSet if v does not already exist in this set
     * Note this list is SORTED AND CONTAINS NO REPEATS
     * Steps:
     * - First, check if a node contains the value of v. If a node does the function must exit
     * - Second, check if the next node contains a value greater than v if it does that means all the nodes before must be less than v so we insert the node before v
     * - Third, once the function reaches the end of the loop from checking the elements if p.next is equal to null that means the entire list contains elements that are less than v so we attach the temp node at the end 
     * @param v holds the value of the element that we wish to add
     */
    public void add(int v){
        SLLNode p = this.head;
        SLLNode temp = new SLLNode(v,null);
        while(p.next != null){
            if(p.next.value == v){
                return;
            }else if(p.next.value > v){
                temp.next = p.next;
                p.next = temp;
                this.setSize++;
                return;
            }else
                p = p.next;
        }    
        temp.next = p.next;
        p.next = temp;
        this.setSize++;
    }
    
    /**this function removes the node that contains element v if it exists in this set
     * @param v holds the value of the element that we wish to remove
     */
    public void remove(int v){
        SLLNode p = this.head;
        while(p.next != null){
            if(p.next.value == v){
                p.next = p.next.next;
                this.setSize--;
            }else
                p = p.next;
        }
    }
    
    /**this function returns a new SLLSet that contains the union of this SLLSet and SLLSet s
     * @param s the SLLSet that we will try to form a union with this SLLSet
     * @return SLLUnion
     */
    public SLLSet union(SLLSet s){
        SLLSet SLLUnion = new SLLSet();
        SLLNode p = this.head.next, q = s.head.next, pB, pF;
        while(p!= null || q!= null){
            if(p == null){
                SLLUnion.addFront(q.value);
                q = q.next;
            }else if(q == null){
                SLLUnion.addFront(p.value);
                p = p.next;
            }else{
                if(p.value == q.value){
                    SLLUnion.addFront(p.value);
                    p = p.next;
                    q = q.next;
                }else if(p.value > q.value){
                    SLLUnion.addFront(q.value);
                    q = q.next;
                }else{
                    SLLUnion.addFront(p.value);
                    p = p.next;
                }
            }                
        }
        //this reverses the union list
        try{
            pB = null;
            p = SLLUnion.getHead().next;
            pF = p.next;
        }catch(Exception e){
            System.out.print("This list is empty");
            return SLLUnion;
        }
        while(pF != null){
            p.next = pB;
            //increment step
            pB = p;
            p = pF;
            pF = pF.next;
        }
        p.next = pB;
        //this.head.next = p;
        SLLUnion.getHead().next = p;
        return SLLUnion;
    }
    
    private void reverse(){
        SLLNode pB = null, p = null, pF = null;
        try{
            pB = null;
            p = this.head.next;
            pF = p.next;
        }catch(Exception e){
            System.out.print("This list is empty");
            return;
        }
        while(pF != null){
            p.next = pB;
            //increment step
            pB = p;
            p = pF;
            pF = pF.next;
        }
        p.next = pB;
        this.head.next = p;
    }
    
    /**This function returns a new SLLSet that contains the intersection between this SLLSet and SLLSet s
     * @param s is the SLLSet that we compare with this SLLSet to find the intersection
     * @return SLLIntersect
     */
    public SLLSet intersection(SLLSet s){
        SLLSet SLLIntersect = new SLLSet();
        SLLNode p = this.head.next, q = s.head.next, pB, pF;
        while(p!= null && q!= null){
            if(p.value == q.value){
                SLLIntersect.addFront(p.value);
                p = p.next;
                q = q.next;
            }else if(p.value > q.value)
                q = q.next;
            else
                p = p.next;
        }
        //this reverses the intersect list
        //SLLIntersect.reverse();
        try{
            pB = null;
            p = SLLIntersect.getHead().next;
            pF = p.next;
        }catch(Exception e){
            System.out.print("This list is empty");
            return SLLIntersect;
        }
        while(pF != null){
            p.next = pB;
            //increment step
            pB = p;
            p = pF;
            pF = pF.next;
        }
        p.next = pB;
        //this.head.next = p;
        SLLIntersect.getHead().next = p;
        return SLLIntersect;
    }
    
    /**This function returns a new SLLSet that contains only the differences between this SLLSet and s
     * @param s is the SLLSet that we compare with this SLLSet to find the difference
     * @return SLL
     */
    public SLLSet difference(SLLSet s){
        SLLSet SLLDifference = new SLLSet();
        SLLNode p = this.head.next, q = s.head.next, pB, pF;
        while(p != null){
            if(q == null){
                SLLDifference.addFront(p.value);
                p = p.next;
            }else if(p.value != q.value){
                if(p.value > q.value){
                    SLLDifference.addFront(q.value);
                    q = q.next;
                }else{//the only possible option is that q.value is > p.value
                    SLLDifference.addFront(p.value);
                    p = p.next;
                }
            }else{
                p = p.next;
                q = q.next;
            }
        }
        //now we reverse the list
        try{
            pB = null;
            p = SLLDifference.getHead().next;
            pF = p.next;
        }catch(Exception e){
            System.out.print("This list is empty");
            return SLLDifference;
        }
        while(pF != null){
            p.next = pB;
            //increment step
            pB = p;
            p = pF;
            pF = pF.next;
        }
        p.next = pB;
        //this.head.next = p;
        SLLDifference.getHead().next = p;
        return SLLDifference;
    }
    
    /**This function returns a new object that represents the union of the sets that exist in the array
     * @param sArray is the array that we go through to great the union object
     * @return 
     */
    public static SLLSet union(SLLSet[] sArray){
        SLLSet SLLArrayUnion = new SLLSet();
        SLLSet tempSet1 = null, tempSet2 = null;
        if(sArray.length == 1)
            SLLArrayUnion = sArray[0];
        else{
            tempSet1 = sArray[0];
            for(int i = 1; i <sArray.length; i++){
                tempSet2 = sArray[i];
                tempSet1 = tempSet1.union(tempSet2);
            }
            SLLArrayUnion = tempSet1;
        }            
        return SLLArrayUnion;
    }
    
    /**This function returns a string which represents the set
     * @return 
     */
    public String toString(){
        String strSLLSet = "";
        SLLNode p = this.head.next;
        while(p != null){
            strSLLSet+= p.value+" ";
            p = p.next;
        }
        return strSLLSet;
    }
}
