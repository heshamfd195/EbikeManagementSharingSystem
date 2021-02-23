package com.company;

import java.util.NoSuchElementException;

public class MemberList {
    Member head, tail = null;

    int MemberCount = 0;
    int SizeOfDLL = 20;
    int vacantSpace;

    public boolean isEmpty(){
        return (head == null);
    }

    public void addMember ( Member MXY) {
        if (MemberCount < SizeOfDLL){


            if (head == null)
            {
                tail = MXY;
            } else {
                head.previous = MXY;
            }
            MXY.next = head;
            head = MXY;

            MemberCount = MemberCount + 1;
        }
        else {
            System.out.println("Sorry list is Full,you can't add member...!!!!");
        }
    }


    public void addNewMember(Member MXY) {
        Member temp = head;
        String id = MXY.ID;

        Boolean flag = false;


        while (temp != null) {

            if ((temp.ID).equals(id)) {
                flag = true;
            }
            temp = temp.next;
        }
            if (flag) {
                System.out.println("The Member " + MXY.ID + " already exits. \n Try new ID");
            } else {
                addMember(MXY);
                MXY.Balance = MXY.Balance + 50;
            }


        }

    public Boolean NADaysCheck(String MXY){
        Member current = head;


        if (head == null) {
            System.out.println("List is empty");
        }
        while (current != null) {

            if ((current.ID).equals(MXY) && current.nonActiveDays >=60) {

                return true;
            }
            current = current.next;


        }
        return false;

    }


    public void removeAtLast() {
        if(head == null) {
            System.out.println("List is empty.");
        }
        else {
            if(head.next == null){
                head = null;
            }
            else {
                tail.previous.next = null;
                tail = tail.previous;
            }
            MemberCount = MemberCount -1;
        }
    }

    public void removeNONActiveMember(String MXY) {
        Member temp = tail;
        while (((temp.previous).ID).equals(MXY)) {
            temp=temp.previous;
        }
            if (temp.nonActiveDays >= 60) {
                removeAtLast();
                System.out.println("Member :" +MXY + " is deleted");
            } else {
                System.out.println( "Member"+ MXY+ "can not be deleted");
            }


    }

    public int vacancy() {

        vacantSpace =SizeOfDLL - MemberCount;
        //System.out.println("Number vacancies available are : "+vacantSpace);
        return vacantSpace;
    }

    public void displayMemberList() {
        if(head == null)
        {
            System.out.println("The Member list is empty");
            return;
        }
        //System.out.println("");
        //System.out.println("_________________ MEMBER LIST _________________");


        Member temp;
        temp = head;

        while(temp != null){
            System.out.println();

            System.out.println(temp);
            temp=temp.next;
        }



    }

    public void displayBackward() {
        if(head == null)
        {
            System.out.println("Linked list is empty");
            return;
        }
        System.out.println("---->>>  Member list in backward traversal using previous pointer.  <<<----");

        Member temp = tail;


        while(temp != null){
            System.out.println();
            System.out.println(" Member id:" + temp.ID+" ------>    Member name:"+ temp.Name+" Balance:"+temp.Balance+" nonActive days:"+temp.nonActiveDays);
            temp=temp.previous;
        }
        System.out.println();


    }

    public boolean memberInList(String id) {
        Member current = head;


        if (head == null) {
            System.out.println("List is empty");
        }
        while (current != null) {

            if ((current.ID).equals(id)) {

                System.out.println("The Member "+id + " is found in the list ");
                return true;
            }
            current = current.next;


        }

        System.out.println("The Member "+id + " is not found in the list ");
        return false;
    }

    public int checkBalance(String MXY) {

        Member temp =head;
        while (temp != null){
            if ((temp.ID).equals(MXY)) {
                System.out.println("Member id " + MXY + " has balance :" + temp.Balance);

                return temp.Balance;
            }
            temp = temp.next;
        }

        return 0;



    }

    public void memberDetail(String MXY) {
        Member temp;
        temp = head;

        int flag = 0;
        while (temp != null) {
            if ((temp.ID).equals(MXY)) {
                System.out.println("");
                System.out.println(MXY+"  --->>> Details");
                System.out.println("Member name  : "+ temp.Name );
                System.out.println("Member id    : " + temp.ID);
                System.out.println("Balance      : "+temp.Balance);
                System.out.println("Non Active Days: "+temp.nonActiveDays);
                System.out.println("");

                flag =1;
                return;
            } else {
                temp = temp.next;

            }
        }
        if (flag == 0){
            System.out.println("Member Id is not found");
        }

    }

    public void TopUp(String MXY, int TopUpBalance) {
        Member temp;
        temp = head;

        int flag = 0;

        while (temp.next != null) {
            if ((temp.ID).equals(MXY)) {
                int preBal=temp.Balance;
                temp.Balance = temp.Balance + TopUpBalance;
                int totalBal =preBal+ TopUpBalance;
                System.out.println("Member :" + MXY + " has received topUp of :" + TopUpBalance);
                System.out.println(" The Current Balance is: "+ totalBal);
                flag =1;
                return;
            } else {
                temp = temp.next;
            }
        }
        if (flag == 0){
            System.out.println("Member Id is not found");
        }
    }

    public void msgNonActiveMember() {
        Member temp = tail;

        while (temp.nonActiveDays >= 30) {
            System.out.println("The message is send to the Member: "+temp);
            temp =temp.previous;

        }
    }

    public void memberListStatus() {
        Member temp;
        temp = head;
        int Active=0;
        int NonActive=0;


        if (head == null)
        {
            System.out.println("List is empty");
        }
        else{

            while (temp!= null) {
                if (temp.nonActiveDays < 60){
                    Active = Active +1;
                }
                else {
                    NonActive = NonActive +1;
                }
                temp=temp.next;
            }
            System.out.println("Active members are : "+Active);
            System.out.println("Non Active members are : "+NonActive );
            System.out.println("Number of vacant space in list : " + vacancy());
        }
    }

    public Member removedMemberById(String id){
        if(isEmpty())
            throw  new NoSuchElementException("Linked List is already Empty!");
        Member current = head;
        while (!(current.ID).equals(id) ){
            current = current.next;
            if(current == null)
                return null;
        }

        if(current == head){
            head = head.next;
        }else{
            current.previous.next = current.next;
        }

        if(current == tail){
            tail = tail.previous;
        }else{
            current.next.previous = current.previous;
        }
        return current;





    }




}

