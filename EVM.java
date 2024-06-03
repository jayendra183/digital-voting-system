import java.io.*;
import java.util.*;

interface client
{
    void vote();
    void result();
}

class server1 implements client
{
    private int count1=0;
    private int count2=0;
    private int count3=0;
    private int count4=0;
    private int total=0;

    public void vote()
    {
        int b=1;
        while(b!=0)
        {
            System.out.println("welcome to the voting of IIITN General Secratory election");
            System.out.println("\n" + "Press 1 for Voting OR 0 to stop voting");
            Scanner s3 =new Scanner(System.in);
            b=s3.nextInt();

            switch(b)
            {
                case 1 :
                System.out.println();
                System.out.println("ENTER YOUR COLLEGE ID in format of BT21....");
                Scanner s= new Scanner(System.in);
                String ID = s.nextLine();
                int temp=1;
                try
                {

                
                    File tt = new File("temp.txt");
                    FileReader fr1=new FileReader(tt);
                    BufferedReader br1=new BufferedReader(fr1);

                    String st3;
                    
                    while((st3=br1.readLine())!=null)
                    {
                        if(st3.contains(ID))
                        {
                            temp=0;
                        }
                    }
                }
                catch(IOException i)
                {
                    System.out.println("ERROR");
                }


                if(temp!=1)
                {
                    System.out.println("Already voted ! ");
                    continue;
                }
                else
                {
                    try
                    {
                        FileWriter fw2 = new FileWriter("temp.txt",true);
                        fw2.write(ID);
                        fw2.close();
                    }
                    catch(IOException i)
                    {
                        System.out.println("ERROR");
                    }
                    try
                    {
                    File input =new File("list.txt");
                    FileReader fr=new FileReader(input);
                    BufferedReader br=new BufferedReader(fr);

                    String str;
                    int flag=0;
                    while((str=br.readLine())!=null)
                    {
                        if(str.contains(ID))
                        {
                            System.out.println(str);
                            flag=1;
                        }
                    }
                    if(flag!=1)
                    {
                        System.out.println("SORRY....Your ID is not in a voter list, You can't vote");
                        continue;
                    }
                    fr.close();
                    }
                    catch(IOException e)
                    {
                        System.out.println("ERROR :-there would be some problem in reading of a file");
                    }

                    System.out.println("... -: Candidates are :- ..." + "\n");
                    System.out.println("1- ADITYA SINGH");
                    System.out.println("2- YASH MISHRA");
                    System.out.println("3- ANSHUMAN DAS");
                    System.out.println("4- NOTA"+"\n");

                    System.out.println("please select any one of them");
                    int a;
                    Scanner s2=new Scanner(System.in);
                    a=s2.nextInt();
                    
                    

                    if(a==1)
                    {
                        count1++;
                        total++;
                    }
                    else if(a==2)
                    {
                        count2++;
                        total++;
                    }
                    else if(a==3)
                    {
                        count3++;
                        total++;
                    }
                    else
                    {
                        count4++;
                        total++;
                    }
                    break;
                }

                case 0 :
                try
                {
                    FileWriter fw = new FileWriter("temp.txt", false);
                    PrintWriter pw = new PrintWriter(fw, false);
                    pw.flush();
                    pw.close();
                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
                try
                {
                    FileWriter fw =new FileWriter("votecount.txt");
                    fw.write("votes for ADITYA SINGH are :- " + count1 + "\n"+"votes for YASH MISHRA are :- "+ count2 + "\n"+
                            "votes for ANSHUMAN DAS are :- "+ count3 +"\n"+"votes for NOTA are :- "+ count4 +"\n");
                    fw.write("voting percentages are :- " + total*20+"%");        

                    fw.close();

                }
                catch(IOException i)
                {
                    System.out.println("ERROR:- ISSUE IN SECOND FILE WRITING");
                }
                break;

                default :
                System.out.println("Invalid Input");
                break;
            }
        }
        
    }


    public void result()
    {
        System.out.println("results are");
        try
        {

            File res= new File("votecount.txt");
            FileReader r=new FileReader(res);
            BufferedReader b=new BufferedReader(r);

            String str2;
            while((str2=b.readLine())!=null)
            {
                System.out.println(str2);
            }

            r.close();


        }
        catch(IOException i)
        {
            System.out.println("ERROR:- issue in a second file reading");
        }
        
    }
}

class VoterList
{
    void listcreation()
    {

        try
        {
            FileWriter f=new FileWriter("list.txt");
            
            
            String arr[]={"BT21CSE171 DEEPAK SINGH CHAUHAN","BT21CSE179 AAYUSH PATIL","BT21CSE206 PRIYANSHU SINGH"
            ,"BT21CSE200 VAIBHAV TAYVADE","BT21CSE131 PRANAV CHANDAK","BT21CSE183 JAYENDRA MISHRA"};

            int length=arr.length;
            for(int i=0;i<length;i++)
            {
                f.write(arr[i]+"\n");

            }
             f.close();

        }
        catch(IOException i)
        {
            System.out.println("ERROR:-there would be a problem in voter list creation");
        }
    }
}


class EVM
{
    public static void main( String args[])
    {
        VoterList obj2= new VoterList();
        obj2.listcreation();
        server1 obj=new server1();
        obj.vote();
        
        System.out.println("thanks for voting");
    }
}
