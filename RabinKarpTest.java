/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;

/**
 *
 * @author computer
 */
public class RabinKarpTest {
    ///Global Variables///////////////////////////////////////
    ArrayList<String> matrix = new ArrayList<String>();
    ArrayList<String> patterns = new ArrayList<String>();
    Random rand = new Random();
    List<String> numbers = new ArrayList<String>();
    /////////////////////////////////////////////////////////
    @Test
    public void testSearch() throws FileNotFoundException, IOException {
        final String COMMA_DELIMITER= ",";
        BufferedReader br = null;
        br = new BufferedReader(new FileReader("octal"+ ".txt")); //importing the file
        String line = "";
        //List<String> numbers = new ArrayList<String>();
        for(int i = 0;(line = br.readLine())!=null;i++){
            numbers.add(line);
        }
        Collections.shuffle(numbers);//Randomization of all the the rows thus createing a random array
        //Random 2x2 matrix in a 5x5 Matrix
        int smallSize = 64;
        int LmallSize = 1000;
        //smallMatrix
        String[] patterns1 = new String[LmallSize];
        String[] matrix1 = new String[smallSize];
        int startY = rand.nextInt(LmallSize-smallSize+1);
        int startX = rand.nextInt(LmallSize-smallSize+1);
        System.out.println("i:"+ LmallSize);
        for(int i = 0; i < LmallSize;i++){
            patterns.add(numbers.get(i).substring(0,LmallSize));
            patterns1[i]= patterns.get(i);
        }
        for(int i = 0; i < LmallSize;i++){
            System.out.println(patterns1[i]);
        }
        for(int i = 0; i < smallSize;i++,startY++){
            matrix.add(patterns.get(startY).substring(startX,startX+smallSize));
            matrix1[i]= matrix.get(i);
        }
        //list matrix onto the screen
        System.out.println("smallSize: "+smallSize);
        for(int i = 0; i < smallSize;i++){
            System.out.println(matrix1[i]);
        }
//        patterns.add("04254");
//        patterns.add("14223");
//        patterns.add("11314");
//        patterns.add("25515");
//        patterns.add("64213");
//        matrix.add("54");
//        matrix.add("23");
//        for(int i = 0; i < LmallSize;i++){
//            System.out.println(patterns.get(i));
//        }
//        for(int i = 0; i < smallSize;i++){
//            System.out.println(matrix.get(i));
//        }
//        RabinKarp RK = new RabinKarp(matrix);
//        System.out.println("Does big matrix contain small matrix: "+RK.search(patterns));
        RabinKarp RabinKarpTest1 = new RabinKarp(matrix);
        //int[] location = RabinKarpTest1.search(patterns1);
        System.out.println("The Location is: "+RabinKarpTest1.search(patterns));//location[0]+" ,"+location[1]);//RabinKarpTest1.search(patterns1));
//        RabinKarp RabinKarpTest2 = new RabinKarp();
//        RabinKarpTest2.search(8,25);+RabinKarpTest1.search(patterns1));
//        RabinKarp RabinKarpTest3 = new RabinKarp();
//        {testMatrix(16,100);}
//        RabinKarp RabinKarpTest4 = new RabinKarp();
//        {testMatrix(64,1000);}
    }  
}
