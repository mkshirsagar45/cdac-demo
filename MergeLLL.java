



public class MergeLLL {
	
	node root;
    
	MergeLLL()
	{
		root = null;
	}

    void insertleft(int e)
    {
        node n = new node(e);
        if(root == null)
        {
            root = n;
        }
        else
        {
            n.next = root;
            root = n;
        }
    }
        
    void deleteleft()
    {  
        if(root == null)
        	System.out.println("\nEmpty List");
        else
        {
            node t = root;
            root = root.next;
            System.out.println("\nDeleted Element: "+t.data);
        }
    }
    
    void insertright(int e)
    {
    	node n = new node(e);
        
        if(root == null)
            root = n;
        else
        {
            node t = root;//1
            while(t.next != null)//2
                t = t.next;
            t.next = n;   
        }
    }
   
    void deleteright()
    { 
        if(root == null)
        	System.out.println("\nEmpty List");
        else
        {
            node t = root;
            node t2 = t;
            
            while(t.next != null)
            {
                t2 = t;
                t = t.next;
            }
            
            if(t2.next == null)
            	root = null;
            t2.next = null;
            System.out.println("\nDeleted Element: " + t.data);
        }
    }
    
    void print()
    { 
        if(root == null)
        	System.out.println("\nEmpty List");
        else
        {
            node t = root;
            System.out.printf("\nList Elements: ");
            
            while(t != null)
            {
                System.out.print(t.data + " ");
                t = t.next;
            }
        }
    }
   


	static MergeLLL mergelists(MergeLLL list1, MergeLLL list2)
    {
		MergeLLL list3 = new MergeLLL();
    	node r1 = list1.root;
    	node r2 = list2.root;
    	node r3 = null;
    	node n;
    	
    	while(r1 != null && r2 != null)
    	{
    		if(r1.data < r2.data)
    		{
    			n = new node(r1.data);
    			r1 = r1.next;
    		}
    		else
    		{
    			n = new node(r2.data);
    			r2 = r2.next;
    		}
    		
			if(r3 == null)
			{
    			r3 = n;
			}
			else
    		{
    			node t = r3;
    			while(t.next != null)
    				t = t.next;
    			t.next = n;
    		}
    	}

    	while(r1 != null)
    	{
    		n = new node(r1.data);
    		node t = r3;
    		while(t.next != null)
    			t = t.next;
    		t.next = n;
    		r1 = r1.next;
    	}
    	
    	while(r2 != null)
    	{
    		n = new node(r2.data);
    		node t = r3;
    		while(t.next != null)
    			t = t.next;
    		t.next = n;
    		r2 = r2.next;
    	}
    	
    	list3.root = r3;
    	return list3;
    }
    
    public static void main(String[] args)
    {
    	MergeLLL L1 = new MergeLLL();
    	MergeLLL L2 = new MergeLLL();
    	MergeLLL L3 = new MergeLLL();
    	
    	L1.insertleft(5);
    	L1.insertleft(4);
    	L1.insertleft(2);
    	L1.insertleft(1);
    	
    	L2.insertleft(8);
    	L2.insertleft(7);
    	L2.insertleft(6);
    	
    	L2.insertleft(3);
    
    	
    	L1.print();
    	L2.print();
    	
    	System.out.println("\nMerging above two lists");
    	L3 = mergelists(L1, L2);
    	
    	L3.print();
    }
}