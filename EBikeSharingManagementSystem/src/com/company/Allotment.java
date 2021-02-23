package com.company;

import java.sql.SQLOutput;

public class Allotment extends MemberList {


    public void EBAssignmentToMember(MemberList mlist, Stand std, String id) {
        Member MXY;
        EBike EXY;
        if (!(mlist.memberInList(id))) {
            System.out.println();
        }


        else
        {   Boolean NAD = mlist.NADaysCheck(id);
            if (!NAD) {
                int bal = mlist.checkBalance(id);


                if (bal >= 30) {
                    if (!std.emptyStand()) {

                        EXY = std.removeBike();

                        MXY = mlist.removedMemberById(id);
                        mlist.addMember(MXY);
                        MXY.nonActiveDays = 0;
                        MXY.Balance -= 30;
                        int b = MXY.Balance;


                        System.out.println("The Balance after Allotment :" + b);
                        System.out.println("\n[ The member : " + MXY.ID + " is assigned the Ebike: E" + EXY.bikeNumber + "]\n");
                    }
                    else {
                        System.out.println("The Allotment can not be done due to no Ebike Available on the Stand");
                    }


                } else {
                    System.out.println("The member has Balance : " + bal);
                    System.out.println("Due to low balance N0 allotment ! ");
                }


            }

            else
                {
                System.out.println("The Member :" + id + " is non active.\n Can't Allot ! ");
            }


        }

    }





}


