package com.zipcodewilmington;

import java.sql.Array;
import java.util.*;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {

        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {

        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {

        return array[array.length-1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {

        return array[array.length-2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        List<String> list = Arrays.asList(array);
        return list.contains(value);
//        return Arrays.asList(array).contains(value);
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        List<String> list = Arrays.asList(array);      //turning string Array into ArrayList
        Collections.reverse(list);                      //Collections is an Arraylist and this reverses the elements
        String[] newarray = list.toArray(array);       //String[] says variable is an array with values of type string
        return newarray;                               // .toArray dumps list into a newly allocated array of String
//        ArrayList<String> resultReverse = new ArrayList<String>();
//        for (int i = array.length - 1; i >= 0; i--){
//            resultReverse.add(array[i]);
//        }
//        return resultReverse.toArray(new String[resultReverse.size()]);

    }


    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        return Arrays.equals(StringArrayUtils.reverse(Arrays.copyOf(array,array.length)), array);
    }
    //.equals to compare 2 arrays. call the method class made above to make reverse, then compare with original array

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        String arrayString =Arrays.toString(array);
        Boolean lowerCase, upperCase,pangramic= true;
        for (int i =0;i<26;i++){
            lowerCase = arrayString.contains(Character.toString(('a'+i)));
            upperCase = arrayString.contains(Character.toString(('A'+i)));
            if ((lowerCase == false) && (upperCase == false)) {
                pangramic=false;
            }
        }
        return pangramic;
    }

//        String string1 = Arrays.toString(array);
//        String string2 = string1.toLowerCase();
//        return string2.chars().filter(i -> i >= 'a' && i <= 'z').distinct().count() == 26;


    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int count=0;
        for (String s: array){
            if (s.equals(value))
                count++;
        }
        return count;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        ArrayList<String> alteredArray = new ArrayList<String>(Arrays.asList(array));
        alteredArray.remove(valueToRemove);
        array = alteredArray.toArray(new String[0]);
        return array;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        ArrayList<String> consecRemoved = new ArrayList<String>();
        consecRemoved.add(array[0]);
        for (int i = 1; i < array.length; i++){
            if (!Objects.equals(array[i], array[i - 1])){
                consecRemoved.add(array[i]);
            }
        }
        return consecRemoved.toArray(new String[consecRemoved.size()]);
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        ArrayList<String> packConsec = new ArrayList<String>();
        String duplicate = "";
        for (int i=0; i <array.length; i++){ //going through each index of string array
            if( i == array.length-1){ //@ the last index of the array
                if(array[i].equals(array[i-1])){ //when last char is the same as char previous
                    duplicate += array[i];      // added duplicate char to string
                    packConsec.add(duplicate); // then add to the arraylist
                }
                else {
                    packConsec.add(array[i]);  //if not duplicated last char, then just add it to the arraylist..
                }
            }
            else if (array[i].equals(array[i+1])){ //when char is same as next char
                duplicate += array[i]; // added it to the string duplicate..
            }
            else {
                if (i==0){
                    packConsec.add(array[0]); //used to add the first char to arraylist..regardless
                }
                else if(array[i].equals(array[i-1])){ //comparing char and previous char

                    duplicate +=array[i];
                    packConsec.add(duplicate);
                    duplicate = ""; //add this to reset the varibable to empty string

                } else {
                    packConsec.add(array[i]);
                }
            }
        }
        return packConsec.toArray(new String[packConsec.size()]);
    }


}
