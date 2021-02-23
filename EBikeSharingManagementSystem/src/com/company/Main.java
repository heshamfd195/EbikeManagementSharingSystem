package com.company;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;



public class Main {


    public static void main(String[] args) {
        // Total Bikes
        // Reserved case
        EBike E1 = new EBike(1, 10, 5);
        EBike E2 = new EBike(2, 20, 6);
        EBike E3 = new EBike(3, 90, 8);
        EBike E4 = new EBike(4, 10, 10);

        // Creating Charging Stand
        Stand standC = new Stand(10);
        // Creating Arrival Stand
        Stand standA = new Stand(10);
        // Creating Maintenance  Stand
        Stand standM = new Stand(10);

        standA.addBike(E1);
        standA.addBike(E2);
        standC.addBike(E3);
        standM.addBike(E4);

        // creating stand control object s
        StandControl s = new StandControl(10);


        MemberList list = new MemberList();

        Member M1 = new Member("ALI", "M1", 50, 66);
        Member M2 = new Member("ahmed", "M2", 50, 40);
        Member M5 = new Member("omer", "M5", 30, 2);
        Member M6 = new Member("salman", "M6", 0, 10);
        Member M7 = new Member("fawad", "M7", 10, 1);
        list.addMember(M1);
        list.addMember(M2);
        list.addMember(M5);
        list.addMember(M6);



        Allotment a =new Allotment();

        System.out.println(list.NADaysCheck("M1"));






        //_____________________________ APPLICATION____________________________________
        boolean state = true;
        while (state) {
            Scanner input = new Scanner(System.in);
            System.out.println("____________________________ EBIKE SHARING MANAGEMENT SYSTEM _________________________");
            System.out.println("Press 1 : MEMBER MANAGEMENT OPTIONS");
            System.out.println("Press 2 : EBIKE MANAGEMENT OPTIONS");
            System.out.println("press 3 : ALLOTMENT ");
            System.out.println("Press 0 : EXIT");


            int displayOptions = input.nextInt();
            switch (displayOptions) {


                case 1:
                    //-------------------------------------------------------------MEMBER MANAGEMENT BLOCK----------------------------------------------
                    boolean state1=true;
                    while(state1){
                        System.out.println("_____________________ MEMBERS MANAGEMENT HUB _____________________");
                        System.out.println(" press 1 :  Display MEMBER LIST ");
                        System.out.println(" press 2 :  Check MEMBER in the list ");
                        System.out.println(" press 3 :  The MEMBER DETAILS ");
                        System.out.println(" press 4 :  The MEMBER LIST Status ");
                        System.out.println(" press 5 :  Add NEW MEMBER  ");
                        System.out.println(" press 6 :  Check Balance of MEMBER");
                        System.out.println(" press 7 :  Top UP MEMBER Balance");
                        System.out.println(" press 8 :  Message NonActive MEMBERS ");
                        System.out.println(" press 9 :  Remove Unsubscribed  MEMBER ");
                        System.out.println(" press 10 : Remove NonActive MEMBER ");
                        System.out.println(" press 0 : BACK ");


                        int displayOptions1 = input.nextInt();
                        switch (displayOptions1){

                            case 1:
                                System.out.println("--------------------[ MEMBER LIST DISPLAY ]-----------------");
                                list.displayMemberList();
                                System.out.println("____________________________________________________________");
                                break;

                            case 2:
                                System.out.println("---------------------[ MEMBER IN LIST ]---------------------");
                                list.memberInList(inputMemberID());
                                System.out.println("____________________________________________________________");
                                break;

                            case 3:
                                System.out.println("---------------------[ MEMBER DETAILS ]---------------------");
                                list.memberDetail(inputMemberID());
                                System.out.println("____________________________________________________________");
                                break;

                            case 4:
                                System.out.println("--------------------[ MEMBER LIST STATUS ]------------------");
                                list.memberListStatus();
                                System.out.println("____________________________________________________________");
                                break;

                            case 5:
                                System.out.println("---------------------[ ADD NEW MEMBER ]---------------------");
                                list.addNewMember(newMemberInput());
                                System.out.println("____________________________________________________________");
                                break;

                            case 6:
                                System.out.println("----------------------[ CHECK BALANCE ]---------------------");
                                list.checkBalance(inputMemberID());
                                System.out.println("____________________________________________________________");
                                break;

                            case 7:
                                System.out.println("---------------------[ BALANCE TOP UP ]---------------------");
                                list.TopUp(inputMemberID(),inputBalance());
                                System.out.println("____________________________________________________________");
                                break;

                            case 8:
                                System.out.println("-----------------[ MSG NON ACTIVE MEMBERS ]-----------------");
                                list.msgNonActiveMember();
                                System.out.println("____________________________________________________________");
                                break;

                            case 9:
                                System.out.println("----------------[ REMOVE UNSUBSCRIBED MEMBER ]---------------");
                                list.removedMemberById(inputMemberID());
                                System.out.println("____________________________________________________________");
                                break;

                            case 10:
                                System.out.println("-----------------[ REMOVE NON ACTIVE MEMBER ]----------------");
                                list.removeNONActiveMember(inputMemberID());
                                System.out.println("____________________________________________________________");
                                break;

                            case 0:
                                System.out.println("BACK");
                                state1=false;
                                break;
                            default:
                                System.out.println(" INVALID OPTION");
                                break;
                        }
                    }
                    break;
                    //__________________________________________________________________________________________________________________________________


                    //_________________________________________________________________EBIKE MANAGEMENT BLOCK_________________________________________________
                case 2:
                    boolean state2=true;
                    while(state2){
                        System.out.println("_____________________ EBIKE MANAGEMENT HUB _____________________");
                        System.out.println(" press 1 :  Display STANDS ");
                        System.out.println(" press 2 :  Transfer from STAND A ");
                        System.out.println(" press 3 :  Transfer from STAND M ");
                        System.out.println(" press 4 :  Get & Update ARRIVED EBIKE ");
                        System.out.println(" press 5 :  Add New EBIKE ");
                        System.out.println(" press 6 :  Check All STAND Status ");
                        System.out.println(" press 0 : BACK ");


                        int displayOptions2 = input.nextInt();
                        switch (displayOptions2){

                            case 1:
                                System.out.println("--------------------[ STANDS DISPLAY ]-----------------");
                                s.displayStandA(standA);
                                System.out.println();
                                s.displayStandC(standC);
                                System.out.println();
                                s.displayStandM(standM);
                                //System.out.println("____________________________________________________________");
                                break;

                            case 2:
                                System.out.println("-----------------[ TRANSFER FROM STAND A ]------------------");
                                s.transferFromStandA(standA,standC,standM);
                                System.out.println("____________________________________________________________");
                                break;

                            case 3:
                                System.out.println("-----------------[ TRANSFER FROM STAND M ]------------------");
                                s.transferFromStandM(standC,standM);
                                System.out.println("____________________________________________________________");
                                break;

                            case 4:
                                System.out.println("-----------------------[ARRIVED EBIKE]----------------------");
                                standA.addBike(apprivedBikes());
                                System.out.println("____________________________________________________________");
                                break;

                            case 5:
                                System.out.println("----------------------[ ADD NEW EBIKE ]---------------------");
                                standC.addBike(newBike());
                                System.out.println("____________________________________________________________");
                                break;

                            case 6:
                                System.out.println("----------------------[ ALL STAND STATUS ]------------------");
                                s.allStandStatus(standA ,standC,standM);
                                System.out.println("____________________________________________________________");
                                break;



                            case 0:
                                System.out.println("BACK");
                                state2=false;
                                break;
                            default:
                                System.out.println(" INVALID OPTION");
                                break;
                        }
                    }
                    break;

                    //--------------------------------------------------------------------------------------------------------------------------------------



                case 3:
                    //-------------------------------------------------------------ALLOTMENT BLOCK----------------------------------------------
                    boolean state3=true;
                    while(state3){
                        System.out.println("_____________________ ALLOTMENT _____________________");
                        System.out.println(" press 1 :  EBIKE Assignment to the MEMBER ");
                        System.out.println(" press 0 : BACK ");


                        int displayOptions1 = input.nextInt();
                        switch (displayOptions1){

                            case 1:
                                System.out.println("--------------------[ EBIKE ASSIGNMNET TO MEMBER ]-----------------");
                                a.EBAssignmentToMember(list,standC,inputMemberID());
                                System.out.println("____________________________________________________________");
                                break;





                            case 0:
                                System.out.println("BACK");
                                state3=false;
                                break;
                            default:
                                System.out.println(" INVALID OPTION");
                                break;
                        }
                    }
                    break;
                //__________________________________________________________________________________________________________________________________







                case 0:
                    System.out.println("exit");
                    state =false;
                    break;
                default:
                    System.out.println("invalid option");
                    break;
            }
        }





    }







    public static EBike newBike() {
        Scanner input = new Scanner(System.in);
        System.out.println("New EBIKE Entry Data Cell");
        System.out.println("Enter the new Bike Number ");
        int num = input.nextInt();
        System.out.println("Enter the Charge ");
        int ch = input.nextInt();
        System.out.println("Enter the health ");
        int hlth = input.nextInt();
        EBike E = new EBike(num, ch, hlth);
        return E;
    }


    public static EBike apprivedBikes() {
        Scanner input = new Scanner(System.in);
        System.out.println("Arrived bike Data Update");
        System.out.println("Enter the Bike Number ");
        int num = input.nextInt();
        System.out.println("Enter the Charge ");
        int ch = input.nextInt();
        System.out.println("Enter the health ");
        int hlth = input.nextInt();
        EBike E = new EBike(num, ch, hlth);
        return E;


    }


    public static String inputMemberID() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the member ID");
        String id = input.nextLine();

        return id;


    }

    public static Member newMemberInput(){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter MEMBER name:  ");
        String name = input.nextLine();
        System.out.println("Create MEMBER ID ");
        String  ID = input.nextLine();

        Member MXY = new Member(name,ID,0,0);
        return MXY;
    }

    public static int inputBalance(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Balance : ");
        int bal = input.nextInt();
        return bal;
    }



}