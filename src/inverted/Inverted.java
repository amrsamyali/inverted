/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inverted;
import java.io.* ;

import java.util.*;
/**
 *
 * @author ahmed abd elnabi
 */
public class Inverted {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner  write = new Scanner (System.in); //scan for inputs to write in consol
        int document_number;
        document_number = 1;   //document number start with 1 for 4 
      
        int num;
        for(num=0;num<=3;num++) //for loop to make 4 document
        {
           
        final Formatter x; //to make document
        try{
            x= new Formatter(document_number+".txt");  // make document
            
            System.out.println("you create Document"+document_number+" Write in it");
        
            
        String Filename = document_number+".txt"; 
     try{                                  
         PrintWriter write_in_file = new PrintWriter(Filename); // to write in document
          
        String pharse ;
             pharse = write.nextLine();
              write_in_file.print(pharse);
        
        
         write_in_file.close();
         System.out.println("Done");
         
         
     }
     catch(Exception e)
     {
         System.out.println("Failed");
     }
            
          }
        
        
        catch(Exception e)
        {
            System.out.println("created Document"+ document_number +"Failed");
        }
         
        
            document_number ++;
        
    }
        
        
        //toknize
        HashMap <String,ArrayList<Integer>> Words=new HashMap <String,ArrayList<Integer>>();
        
        int file_num;
        for(file_num=1;file_num<=4;file_num++)
        {
        try
      {
        FileInputStream file = new FileInputStream(file_num+".txt"); //to red file
        Scanner Scan1 = new Scanner(file);
        
        if(Scan1.hasNext())
        {
               String str =Scan1.nextLine();
    
                StringTokenizer stk=new StringTokenizer(str,("!@#$%^&*()_+=-/?.,<>|"+" "));
                
              
             while(stk.hasMoreTokens())
        {
            String element =stk.nextToken();
            
   
            
            ArrayList<Integer> arrlist =new ArrayList<>();
           
            if(Words.containsKey(element)){
            arrlist=Words.get(element);  
            if(! arrlist.contains(file_num)){
              arrlist.add(file_num);
              Words.put(element, arrlist);
            }
            
            }
            else{
                arrlist.add(file_num);
                Words.put(element, arrlist);
        }
              
        }
        }
           
          Scan1.close();
      }
      catch(Exception e)
      {
          System.out.println("file not found");
      }
        
        
        }
        System.out.println("words======>posting list");
        for(String token : Words.keySet())
        {
            System.out.println(token+"======>"+Words.get(token));// print the tokrn and the number of docoments
            
        } 
  
  
            
            
             System.out.println("INsert Your QUERY");

      
        String query=write.nextLine();
        StringTokenizer query_str=new StringTokenizer(query,"!@#$%^&*()_+=-/?.,<>|"+" ");
         if(query_str.countTokens()==3 )
        {
        
        String token1 = query_str.nextToken();
        String operator = query_str.nextToken();
        String token2 = query_str.nextToken(); 
         if(Words.containsKey(token1) && Words.containsKey(token2)){
        if(operator.equals("and")){
        
           
            
            ArrayList <Integer> list1= Words.get(token1);
            ArrayList <Integer> list2= Words.get(token2);    
       
            list1.retainAll(list2);
            
            for(int k=0; k<list1.size() ;k++){
                System.out.println("document"+ list1.get(k));
            } 
        }
        
         else if (operator.equals("or")){
            ArrayList <Integer> list1= Words.get(token1);
            ArrayList <Integer> list2= Words.get(token2);
       
            
            
            Set <Integer> list=new HashSet<Integer>();
            
            list.addAll(list1);
            list.addAll(list2);
            
            list1.clear();
            list2.clear();
            
            list1.addAll(list);
            for(int k=0; k<list1.size() ;k++){
                System.out.println("doc"+ list1.get(k));
            }
        }
        
         
        
            }else {System.out.println("not found");}
            
  
  
  
  
    }else{String token1 = query_str.nextToken();
        String token2 = query_str.nextToken(); 
             ArrayList <Integer> list1= Words.get(token1);
            ArrayList <Integer> list2= Words.get(token2);    
       
            list1.retainAll(list2);
            
            for(int k=0; k<list1.size() ;k++){
                System.out.println("Document"+ list1.get(k));
            } }
        
        
     
    
}
}
    
