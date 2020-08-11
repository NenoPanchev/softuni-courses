import java.util.Scanner;

public class SecretChat2{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);

        String concealed=sc.nextLine();
        String commands=sc.nextLine();

        while (!commands.equals("Reveal")){
            String[]input=commands.split(":\\|:");
            String cases=input[0];
            switch (cases){
                case"InsertSpace":
                    int index=Integer.parseInt(input[1]);
                    if(index>=0 && index<=concealed.length()-1) {
                        StringBuilder inserter=new StringBuilder();
                        inserter.append(concealed);
                        String toInsert=" ";
                        inserter.insert(index,toInsert);
                        concealed=inserter.toString();
                        System.out.print(concealed);
                        System.out.println();
                    }
                    break;
                case"Reverse":
                    String subS=input[1];
                    if(concealed.contains(subS)){
                        concealed=concealed.replaceFirst(subS,"");

                        String reverse = "";
                        for(int i = subS.length()-1 ; i >= 0; i--)
                        {
                            reverse = reverse + subS.charAt(i);
                        }
                        concealed=concealed+reverse;
                        System.out.print(concealed);
                        System.out.println();
                    }else{
                        System.out.print("error");
                        System.out.println();
                    }
                    break;
                case"ChangeAll":
                    String subString=input[1];
                    String replacement2=input[2];
                    if (concealed.contains(subString)) {
                        int indeXXX = concealed.indexOf(subString);
                        while (indeXXX >= 0) {
                            concealed = concealed.replace(subString, replacement2);
                            indeXXX = concealed.indexOf(subString.charAt(0));
                        }
                    }
                    System.out.print(concealed);
                    System.out.println();
                    break;

            }
            commands=sc.nextLine();
        }
        System.out.print("You have a new text message: "+concealed);
        //System.out.println();
    }
}