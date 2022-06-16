package com.company.arrays;

public class Hanoi {
    public static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod)
    {
        if (n == 0)
        {
            return;
        }
        towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
        System.out.println("Диск "+ n + " с башни " + from_rod +" переложить в башню " + to_rod );
        towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
    }

    public static void hanoiTower(int n) {
        towerOfHanoi(n, '1', '3', '2');
    }

    // Driver code
    public static void  main(String args[])
    {
        int n = 3; // Number of disks

    }
}


