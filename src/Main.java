import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String> List = new ArrayList<>();

    public static void main(String[] args) {
        String cmd = "";
        Boolean done = false;
        Scanner in = new Scanner(System.in);
        do {
            final String menu = "A - add E - append D – Delete an item from the list P – Print the list Q – Quit the program";
            cmd = SafeInput.getRegExString(in,menu,"[AaEeDdPpQq]");
            cmd = cmd.toUpperCase();
            switch(cmd) {
                case "A":
                    adding();
                    break;
                case "E":
                    appending();
                    break;
                case "D":
                    deleting();
                    break;
                case "P":
                    displayList();
                    break;
                case "Q":
                    System.exit(0);
                    break;
            }
            Scanner input = new Scanner(System.in);
            done = SafeInput.getYNConfirm(input,"are you done?");
            }
        while(!done);
        }
        private static void displayList(){
            if (!List.isEmpty()) {
                for(int i = 0; i < List.size(); i++){
                  System.out.println(List.get(i));
                }
            }
            else{
                System.out.println("List is empty");
            }

        }
        private static void adding(){
            System.out.println("Enter your item");
            Scanner in = new Scanner(System.in);
            String item = in.nextLine();
            List.add(item);
        }
        private static void deleting(){
            int entry = 0;
            Scanner in = new Scanner(System.in);
            entry = SafeInput.getRangedInt(in,"Which number would you like to delete?",1,List.size());
            entry = entry - 1;
            List.remove(entry);
        }
        private static void appending(){
            int entry = 0;
            Scanner in = new Scanner(System.in);
            entry = SafeInput.getRangedInt(in,"Which number would you like to append into?",1,List.size());
            entry = entry - 1;
            System.out.println("Enter your item");
            String item = in.nextLine();
            List.add(entry,item);

        }

    }
