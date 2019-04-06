/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

  public class RabinKarp {

//        private String[] pattern;
//        private long patternHash;
//        private int patternRowLength;
//        private int patternColumnLength;
//        private long largePrimeNumber = 1000000007L;
//        private int alphabetSize = 256;
//        private long[] rm;  // rm[i] = alphabetSize^i % largePrimeNumber
//
//        public RabinKarp(String[] pattern) {
//
//            if (pattern == null || pattern.length == 0) {
//                throw new IllegalArgumentException("Invalid pattern");
//            }
//
//            this.pattern = pattern;
//            patternRowLength = pattern.length;
//            patternColumnLength = pattern[0].length(); // Since the pattern is a rectangle of characters,
//                                                       // all pattern columns have the same length.
//            rm = new long[patternColumnLength];
//
//            rm[0] = 1;
//            for (int patternIndex = 1; patternIndex < rm.length; patternIndex++) {
//                // Compute alphabetSize^patternIndex % largePrimeNumber for use in removing leading digits.
//                rm[patternIndex] = (rm[patternIndex - 1] * alphabetSize) % largePrimeNumber;
//            }
//
//            patternHash = hash(pattern);
//        }
//
//        private boolean check(String[] text, int textRow, int textColumn) {
//
//            for (int row = 0; row < patternRowLength; row++) {
//                for (int patternIndex = 0; patternIndex < patternColumnLength; patternIndex++) {
//
//                    if (text.length <= textRow + row || text[textRow + row].length() <= textColumn + patternIndex) {
//                        return false;
//                    }
//
//                    if (pattern[row].charAt(patternIndex) != text[textRow + row].charAt(textColumn + patternIndex)) {
//                        return false;
//                    }
//                }
//            }
//
//            return true;
//        }
//
//        // Horner's method applied to modular hashing
//        // O(Mr * Mc), where Mr is the pattern row length and Mc is the pattern column length
//        private long hash(String[] key) {
//             
//            long hash = 0;
//            long currentHash=0;
//            for (int i = 0; i < patternRowLength; i++) {
//                currentHash = 0;
//                for (int j = 0; j < patternColumnLength; j++) {
//                    currentHash = (currentHash * alphabetSize + key[i].charAt(j))% largePrimeNumber;
//                }
//                hash += currentHash;
//            }
//            return hash;
//        }
////        H2 = 0;
////        for (int j = 0; j < M; j++) {//patternColumn
////            H2 = (H2 * R + key.get(i).charAt(j))% q;
////        }
////        h += H2;
//        // Search for a hash match in the text.
//        // Returns the index of the first occurrence of the pattern in the text or [textRowLength, textColumnLength]
//        // if no such match.
//        public int[] search(String[] text) {
//
//            if (text == null || text.length == 0) {
//                throw new IllegalArgumentException("Invalid text");
//            }
//
//            int textRowLength = text.length;
//            int textColumnLength = text[0].length();
//            int[] notFoundResult = {textRowLength, textColumnLength};
//            int[] result = new int[2];
//
//            if (textRowLength < patternRowLength || textColumnLength < patternColumnLength) {
//                return notFoundResult;  // no match
//            }
//
//            long initialColumnsHash = hash(text);
//            long textHash;
//            System.out.println(textRowLength - patternRowLength);
//            for (int textRow = 0; textRow <= textRowLength - patternRowLength; textRow++) {
//
//                if (textRow > 0) {
//                    // Remove previous row from rolling hash
//                    for (int patternColumn = 0; patternColumn < patternColumnLength; patternColumn++) {
//                        initialColumnsHash = (initialColumnsHash + largePrimeNumber -
//                                rm[patternColumnLength - 1 - patternColumn] *
//                                        text[textRow - 1].charAt(patternColumn) % largePrimeNumber) % largePrimeNumber;
//                    }
//
//                    // Add next row in rolling hash
//                    for (int patternColumn = 0; patternColumn < patternColumnLength; patternColumn++) {
//                            initialColumnsHash = (initialColumnsHash +rm[patternColumnLength - 1 - patternColumn] * text[textRow + patternRowLength - 1].charAt(patternColumn))% largePrimeNumber;
//                    }
//                }
//
//                textHash = initialColumnsHash;
//                System.out.println("bob"+textHash+" patternHash: "+patternHash);
//                if (textHash == patternHash && check(text, textRow, 0)) {
//                    result[0] = textRow;
//                    result[1] = 0;
//
//                    return result;  // match
//                }
//                
//                for (int textColumn = patternColumnLength; textColumn < textColumnLength; textColumn++) {
//
//                    // Remove previous column from rolling hash
//                    for (int patternRow = 0; patternRow < patternRowLength; patternRow++) {
//                        textHash = (textHash + largePrimeNumber -
//                                rm[patternColumnLength - 1] * text[textRow + patternRow].charAt(textColumn - patternColumnLength)
//                                        % largePrimeNumber) % largePrimeNumber;
//                    }
//
//                    // Add next column in rolling hash
//                    for (int patternRow = 0; patternRow < patternRowLength; patternRow++) {
//
//                        if (patternRow == 0) {
//                            textHash = (textHash * alphabetSize + text[textRow + patternRow].charAt(textColumn))
//                                    % largePrimeNumber;
//                        } else {
//                            textHash = (textHash + text[textRow + patternRow].charAt(textColumn)) % largePrimeNumber;
//                        }
//                    }
//
//                    int columnOffset = textColumn - patternColumnLength + 1;
//                    System.out.println("bob"+textHash+" patternHash: "+patternHash);
//                    if (textHash == patternHash && check(text, textRow, columnOffset)) {
//                        result[0] = textRow;
//                        result[1] = columnOffset;
//
//                        return result;  // match
//                    }
//                }
//                //System.out.println("bob"+textRow);
//            }
//            System.out.println("bob");
//            return notFoundResult;     // no match
//        }
//    }
////        private String[] pattern;
////        private long patternHash;
////        private int patternRowLength;
////        private int patternColumnLength;
////        private long largePrimeNumber = 1000000007L;
////        private int alphabetSize = 256;
////        private long[] rm;  // rm[i] = alphabetSize^i % largePrimeNumber
////
////        public RabinKarp(String[] pattern) {
////
////            if (pattern == null || pattern.length == 0) {
////                throw new IllegalArgumentException("Invalid pattern");
////            }
////
////            this.pattern = pattern;
////            patternRowLength = pattern.length;
////            patternColumnLength = pattern[0].length(); // Since the pattern is a rectangle of characters,
////                                                       // all pattern columns have the same length.
////            rm = new long[patternColumnLength];
////
////            rm[0] = 1;
////            for (int patternIndex = 1; patternIndex < rm.length; patternIndex++) {
////                // Compute alphabetSize^patternIndex % largePrimeNumber for use in removing leading digits.
////                rm[patternIndex] = (rm[patternIndex - 1] * alphabetSize) % largePrimeNumber;
////            }
////
////            patternHash = hash(pattern);
////        }
////
////        private boolean check(String[] text, int textRow, int textColumn) {
////
////            for (int row = 0; row < patternRowLength; row++) {
////                for (int patternIndex = 0; patternIndex < patternColumnLength; patternIndex++) {
////
////                    if (text.length <= textRow + row || text[textRow + row].length() <= textColumn + patternIndex) {
////                        return false;
////                    }
////
////                    if (pattern[row].charAt(patternIndex) != text[textRow + row].charAt(textColumn + patternIndex)) {
////                        return false;
////                    }
////                }
////            }
////
////            return true;
////        }
////
////        // Horner's method applied to modular hashing
////        // O(Mr * Mc), where Mr is the pattern row length and Mc is the pattern column length
////        private long hash(String[] key) {
////            // Compute hash for key[0            ..       patternColumnLength - 1]
////            //                     [.                                            ]
////            //                     [.                                            ]
////            //                     [patternRowLength - 1..patternColumnLength - 1]
////            long hash = 0;
////            long currentHash=0;
////            for (int i = 0; i < patternRowLength; i++) {
////                for (int j = 0; j < patternColumnLength; j++) {
////                    currentHash = (currentHash * alphabetSize + key[i].charAt(j))% largePrimeNumber;
////                }
////            }
////            return currentHash;
////        }
////        
////
////        // Search for a hash match in the text.
////        // Returns the index of the first occurrence of the pattern in the text or [textRowLength, textColumnLength]
////        // if no such match.
////        public int[] search(String[] text) {
////
////            if (text == null || text.length == 0) {
////                throw new IllegalArgumentException("Invalid text");
////            }
////
////            int textRowLength = text.length;
////            int textColumnLength = text[0].length();
////            int[] notFoundResult = {textRowLength, textColumnLength};
////            int[] result = new int[2];
////
////            if (textRowLength < patternRowLength || textColumnLength < patternColumnLength) {
////                return notFoundResult;  // no match
////            }
////
////            long initialColumnsHash = hash(text);
////            long textHash;
////
////            for (int textRow = 0; textRow <= textRowLength - patternRowLength; textRow++) {
////
////                if (textRow > 0) {
////                    // Remove previous row from rolling hash
////                    for (int patternColumn = 0; patternColumn < patternColumnLength; patternColumn++) {
////                        initialColumnsHash = (initialColumnsHash + largePrimeNumber -
////                                rm[patternColumnLength - 1 - patternColumn] *
////                                        text[textRow - 1].charAt(patternColumn) % largePrimeNumber) % largePrimeNumber;
////                    }
////
////                    // Add next row in rolling hash
////                    for (int patternColumn = 0; patternColumn < patternColumnLength; patternColumn++) {
////                            initialColumnsHash = (initialColumnsHash +
////                                    rm[patternColumnLength - 1 - patternColumn] * text[textRow + patternRowLength - 1].charAt(patternColumn))
////                                    % largePrimeNumber;
////                    }
////                }
////
////                textHash = initialColumnsHash;
////                System.out.println("bob"+textHash+" patternHash: "+patternHash);
////                if (textHash == patternHash && check(text, textRow, 0)) {
////                    result[0] = textRow;
////                    result[1] = 0;
////
////                    return result;  // match
////                }
////
////                for (int textColumn = patternColumnLength; textColumn < textColumnLength; textColumn++) {
////
////                    // Remove previous column from rolling hash
////                    for (int patternRow = 0; patternRow < patternRowLength; patternRow++) {
////                        textHash = (textHash + largePrimeNumber -
////                                rm[patternColumnLength - 1] * text[textRow + patternRow].charAt(textColumn - patternColumnLength)
////                                        % largePrimeNumber) % largePrimeNumber;
////                    }
////
////                    // Add next column in rolling hash
////                    for (int patternRow = 0; patternRow < patternRowLength; patternRow++) {
////
////                        if (patternRow == 0) {
////                            textHash = (textHash * alphabetSize + text[textRow + patternRow].charAt(textColumn))
////                                    % largePrimeNumber;
////                        } else {
////                            textHash = (textHash + text[textRow + patternRow].charAt(textColumn)) % largePrimeNumber;
////                        }
////                    }
////
////                    int columnOffset = textColumn - patternColumnLength + 1;
////                    System.out.println("bob"+textHash+" patternHash: "+patternHash);
////                    if (textHash == patternHash && check(text, textRow, columnOffset)) {
////                        result[0] = textRow;
////                        result[1] = columnOffset;
////
////                        return result;  // match
////                    }
////                }
////            }
////
////            return notFoundResult;     // no match
////        }
////    }
//
//        
//        
//        
//        
    private final ArrayList<String> pattern;
    private final long patternHash;
    private final int M;
    private final long q;
    private final int R = 256;
    private final long[] RM;

    public RabinKarp(ArrayList<String> pattern) {
        q=longRandomPrime();
        this.pattern = pattern;
        M = pattern.size();
        RM = new long[M];
        RM[0] = 1;
        for (int i = 1; i < RM.length; i++) 
            RM[i] = (RM[i-1]*R)%q;
        patternHash = hash(pattern);
    }
    private static long longRandomPrime() {
        return BigInteger.probablePrime(31, new Random()).longValue();
    }
    private boolean check(ArrayList<String> txt, int txtRow, int txtColNum) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (txt.size() <= txtRow+i || txt.get(txtRow+i).length() <= txtColNum+j)  return false;
                if (pattern.get(i).charAt(j) != txt.get(txtRow + i).charAt(txtColNum + j))return false;
            }
        }
        return true;
    }
    private long hash(ArrayList<String> key) {
        long h = 0;
        long H2;
        for (int i = 0; i < M; i++) {//patternRow
            H2 = 0;
            for (int j = 0; j < M; j++) {//patternColumn
                H2 = (H2 * R + key.get(i).charAt(j))% q;
            }
            h += H2;
        }
        return (h%q);
    }
    public String search(ArrayList<String> txt) {
        int N = txt.size();
        long colHash = hash(txt);
        long txtHash;
        //int txtColNumSize = txt.get(0).length();
        //System.out.println("N - M: "+(N - M)+" txt.size()-1: "+(txt.size()-1));
        for (int i = 0; i <= N - M; i++) {
            //System.out.println();
            if (i > 0) {
                for (int j = 0; j < M; j++)
                    colHash = (colHash+q-RM[M-1-j]*txt.get(i-1).charAt(j)%q)%q;
                for (int j = 0; j < M; j++)
                    colHash = (colHash+RM[M-1-j]*txt.get(i+M-1).charAt(j))%q;
            }
            txtHash = colHash;
            //System.out.println(patternHash+" "+txtHash+" N: "+N+" M: "+M);
            if (txtHash == patternHash && check(txt, i, 0)) return i+"," +0; // checking to see if we got a match
            for (int j = M; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    txtHash = (txtHash+q-RM[M-1]*txt.get(i+k).charAt(j-M)%q)%q;//txt.get(i+k).charAt(j-M)%
                }
                for (int k = 0; k < M; k++) {
                    if (k == 0)txtHash = (txtHash*R+txt.get(i+k).charAt(j))%q;
                    else       txtHash = (txtHash+txt.get(i+k).charAt(j))%q;
                }
                //txtHash=txtHash+
                //System.out.println((patternHash%q)+" "+txtHash);
                if (txtHash == patternHash && check(txt, i, (j-M+1))) return i+"," +(j-M+1); // checking to see if we got a match
            }
        }
        return "no match";
    }
//    static ArrayList<String> matrix = new ArrayList<String>();
//    static ArrayList<String> patterns = new ArrayList<String>();
//    public static void main(String args[]){
//        
//        patterns.add("950");
//        patterns.add("384");
//        patterns.add("353");
//        
//        matrix.add("728950");
//        matrix.add("384384");
//        matrix.add("898353");
//        matrix.add("383950");
//        matrix.add("950950");
//        matrix.add("384384");
//        RabinKarp RK = new RabinKarp(patterns);
//        System.out.println("Does big matrix contain small matrix: "+RK.search(matrix));
//    }
}







