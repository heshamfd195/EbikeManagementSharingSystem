package com.company;

import java.sql.SQLOutput;
import java.util.Arrays;

public  class Stand {
    protected EBike[] standArray;

    protected int back;
    protected int front;
    public int length;


    //Stand class parameterized constructor

    public Stand(int l) {
        length = l;
        this.standArray = new EBike[length];
        this.back = 0;
        this.front = 0;

    }
    public Boolean isFull(){
        if (front -1 == back)
            return true;
        return false;
    }


    public void standStatus() {
        int count = 0;
        int spaces;

        if (front <= back) {
            for (int i = front; i < back; i++) {

                count += 1;
            }
        }
        spaces = length - count;

        System.out.println("The Number of EBikes in Stand  is : " + count);
        System.out.println("The Number of spaces left in Stand  is : " + spaces);


    }


    //to display the Ebikes at the Stand
    public void displayStand() {

        if (front <= back) {
            for (int i = front; i < back; i++) {
                System.out.print("  " + standArray[i] + "  |");
            }
        }

    }


    // method to add bikes in stand / enqueue.
    public void addBike(EBike bike) {

        if (isFull()) {
            System.out.println("The Stand is Full");
        } else {
            standArray[back] = bike;
            back = (back + 1) % standArray.length;


        }
    }

    public EBike removeBike() {
        if (emptyStand()) {

            System.out.println("The stand is empty");
            return null;
        }
        else {
            EBike removedBike;

            removedBike = standArray[front];

            standArray[front] = null;
            front++;
            return removedBike;


        }

    }

        public Boolean emptyStand () {
            if (front == back)
                return true;
            else
                return false;
        }


    }




