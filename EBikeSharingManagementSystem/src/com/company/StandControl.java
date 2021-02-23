package com.company;

import java.sql.SQLOutput;

public class StandControl extends Stand {

    public StandControl(int l) {
        super(l);

    }

    public void transferFromStandA(Stand s1, Stand s2, Stand s3) {

        try {
            EBike E = s1.removeBike();

            // Code for the stand A to Stand C transfer
            if (E.health >= 6) {
                System.out.println("The EBIKE :" +E+ " is transfered to Stand C  ");
                s2.addBike(E);

                // The following code is based on assumption
                // The charge is directly increment depending on assumed condition
                // for the realtime system this block will be changed.
                if (E.batteryCharge == 100) {
                    System.out.println("Full Charged");
                } else if (E.batteryCharge <= 50 && E.batteryCharge > 20) {
                    E.batteryCharge += 40;
                } else if (E.batteryCharge > 50 && E.batteryCharge < 80)
                    E.batteryCharge += 20;

                else if (E.batteryCharge > 0 && E.batteryCharge <= 20)
                    E.batteryCharge += 70;
            }
            // Code the stand A to Stand M transfer
            else if (E.health <= 0) {

                s1.removeBike();
                // The following code is based on assumption
                // The low health bike will terminate.


                System.out.println(E + ": is terminated");
            }

            // Code the stand A to Stand M transfer
            else {
                System.out.println("The EBIKE :" +E+ " is transfered to Stand M  ");
                s3.addBike(E);
                // The following code is based on assumption
                // The health is awarded based on conditions
                // For the real system the could will be changed.
                if (E.health >= 4) {
                    E.health += 4;
                } else {
                    E.health += 6;
                }


            }
        } catch (NullPointerException e) {
            System.out.print("The Arrival stand is vacant");
        }
    }


    public void transferFromStandM(Stand standC, Stand standM) {
        try {

            EBike E = standM.removeBike();
            standC.addBike(E);

            // The following code is based on assumption
            // The charge is directly increment depending on assumed condition
            // for the realtime system this block will be changed.
            if (E.batteryCharge == 100) {
                System.out.println("Full Charged");
            } else if (E.batteryCharge <= 50 && E.batteryCharge > 20) {
                E.batteryCharge += 40;
            } else if (E.batteryCharge > 50 && E.batteryCharge < 80)
                E.batteryCharge += 20;

            else if (E.batteryCharge > 0 && E.batteryCharge < 20)
                E.batteryCharge += 70;
            System.out.println("The EBIKE :" +E+ " is transfered to Stand C  ");


        } catch (NullPointerException e) {
            System.out.println("The Maintenance Stand M is vacant");
        }
    }


    public EBike outofstandC(Stand standC) {
        EBike EXY;
        if (standC.emptyStand()) {
            System.out.println("the stand is empty");
            return null;
        }
        else {
            EXY = standC.removeBike();
        }
        return EXY;

    }

    public void allStandStatus(Stand stdA ,Stand stdC ,Stand stdM){
        System.out.println("\n______________ARRIVAL STAND A STATUS ______________");
        stdA.standStatus();
        System.out.println("\n___________________________________________________");

        System.out.println("\n_____________ CHARGING STAND C STATUS _____________");
        stdC.standStatus();
        System.out.println("\n___________________________________________________");

        System.out.println("\n_____________MAINTENANCE STAND M STATUS ____________");
        stdM.standStatus();

        System.out.println("\n___________________________________________________");
    }






    public void displayStandC(Stand s) {
        System.out.println("CHARGING STAND C");
        System.out.println("_____________________________________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.print("|");
        s.displayStand();


        System.out.println("\n_____________________________________________________________________________________________________________________________________________________________________________________________________________________________");


    }

    public void displayStandA(Stand s) {
        System.out.println("ARRIVAL STAND A");
        System.out.println("_____________________________________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.print("|");
        s.displayStand();


        System.out.println("\n_____________________________________________________________________________________________________________________________________________________________________________________________________________________________");


    }

    public void displayStandM(Stand s) {
        System.out.println("MAINTENANCE STAND M");
        System.out.println("_____________________________________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.print("|");
        s.displayStand();


        System.out.println("\n_____________________________________________________________________________________________________________________________________________________________________________________________________________________________");


    }

}


