
package com.phptravels.base;

import com.phptravels.util.TestUtils;
import java.io.IOException;

public  class valdiatedData extends TestBase{
    public static int counter=0;  // used for email checking

    public valdiatedData() throws IOException {
        super();
    }
    public static Object[][] validData() throws IOException
    {
        Object testData[][] = TestUtils.getDataFromExcel("RegistrationData");
        int countofvaliddata = 0;
        for(int i=0;i<testData.length;i++)
        {
                if(
                        validateFirstName(testData[i][0].toString())
                                && validateLastName(testData[i][0].toString(),testData[i][1].toString())
                                && validatePhoneNumber(testData[i][2].toString())
                                && validateEmail(testData[i][3].toString())
                                && validatePass(testData[i][4].toString())
                )
                {
                    System.out.println("data valid");
                    countofvaliddata++;
                }
                else {
                    System.out.println("Data is invalid");
                }
        }
        Object validData[][] = new Object[countofvaliddata][];
        int j=0;
        System.out.println("\n-------------------------------------------------------------\n");
        for(int i=0;i<testData.length;i++)
        {
            if(
                    validateFirstName(testData[i][0].toString())
                            && validateLastName(testData[i][0].toString(),testData[i][1].toString())
                            && validatePhoneNumber(testData[i][2].toString())
                            && validateEmail(testData[i][3].toString())
                            && validatePass(testData[i][4].toString())
            )
            {
                validData[j]=testData[i];
                j++;
            }
        }

        return validData;
    }
    public static boolean validateFirstName (String fname)
    {
        //First Name which must start with capital letter
        if(Character.isUpperCase(fname.charAt(0)))
        {
            // first name accepted
            return true;
        }
        // first name rejected
        return false;
    }
    public static boolean validateLastName(String lname , String fname)
    {
        if (!lname.equals(fname))
        {
            if (Character.isUpperCase(lname.charAt(0)))
            {
                // last name accepted
                return true;
            }
            // last name rejected (first char is low)
            return false;
        }
        // last name = first name
        return false;
    }
    public  static boolean validatePhoneNumber (String phone)
    {
        if(phone.length()==11)
        {
            if (phone.charAt(0)=='0')
            {
                // valid phone number starts with digit 0
                return true;
            }
            // invalid phone number does not starts with digit 0
            return false;
        }
        // less than 11 digits
        return false;
    }
    public static boolean validateEmail(String email)
    {
        String[] emails = new String[50];
        for (int i =0;emails[i]!=null;i++) {

            if (emails[i] == email)
            {
                // if email duplicate return false
                return false;
            }
        }

        for (int i=0;i<email.length();i++)
        {
            // try to find '@'special character
            if(email.charAt(i)=='@')
            {
                int n =(email.length())-4;
                if(email.charAt(n)=='.')
                {
                    // valid email
                    emails[counter]=email;
                    counter++;
                    return true;
                }
            }
        }
        //invalid email
        return false;
    }
    public static boolean validatePass(String pass)
    {
        int flag1 = 0 , flag2=0;
        if(pass.length()>=8)
        {
            for(int i= 0;i<pass.length();i++)
            {
                if(Character.isUpperCase(pass.charAt(i)))
                {
                    flag1=1;
                }
                if(Character.isLowerCase(pass.charAt(i)))
                {
                    flag2=1;
                }
            }
        }
        if((flag1+flag2)==2)
        {
            return true;
        }
        return false;
    }
}

