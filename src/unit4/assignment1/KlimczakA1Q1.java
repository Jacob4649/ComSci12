package unit4.assignment1;

import java.util.Scanner;

import utilities.ScannerUtils;

public class KlimczakA1Q1 {

    /*
     * Jacob Klimczak
     * Assignment 1, Question 1
     * March, 10, 2020
     * ICS4U0
     */

    static double[] m_readings = new double[16];
    static Scanner m_input = new Scanner(System.in);
    static double m_initialAverage = 0;
    static double m_improvedAverage = 0;
    static int m_discardIndex = 0;

    public static void main(String[] args) {

        // intro
        System.out.println("pH Reading Calculator");
        System.out.println();

        // populate array
        for (int i = 0; i < m_readings.length; i++) {
            System.out.print("Enter A Value For Reading " + (i + 1) + ": ");
            m_readings[i] = ScannerUtils.readDouble(m_input);
        }

        System.out.println();

        // calculate initial average
        for (double d : m_readings) {
            m_initialAverage += d / (double) m_readings.length;
        }

        // round initial average
        m_initialAverage = Math.round(m_initialAverage * 100d) / 100d;

        // find farthest value
        for (int i = 0; i < m_readings.length; i++) {
            if (Math.abs(m_readings[i] - m_initialAverage) > Math.abs(m_readings[m_discardIndex] - m_initialAverage)) {
                // value is newly found furthest value
                m_discardIndex = i;
            }
        }

        // calculate adjusted average
        for (int i = 0; i < m_readings.length; i++) {
            if (i != m_discardIndex) {
                m_improvedAverage += m_readings[i] / (double) (m_readings.length - 1);
            }
        }

        // round improved average
        m_improvedAverage = Math.round(m_improvedAverage * 100d) / 100d;

        // output values
        for (int i = 0; i < m_readings.length; i++) {
            System.out.print(i + 1);
            // Switches based on last digit of number
            switch (("" + (i + 1)).charAt(("" + (i + 1)).length() - 1)) {
                case '1':
                    if (("" + (i + 1)).length() >= 2 && ("" + (i + 1)).charAt(("" + (i + 1)).length() - 2) == '1') {
                        System.out.print("th");
                    } else {
                        System.out.print("st");
                    }
                    break;

                case '2':
                    if (("" + (i + 1)).length() >= 2 && ("" + (i + 1)).charAt(("" + (i + 1)).length() - 2) == '1') {
                        System.out.print("th");
                    } else {
                        System.out.print("nd");
                    }
                    break;

                case '3':
                    if (("" + (i + 1)).length() >= 2 && ("" + (i + 1)).charAt(("" + (i + 1)).length() - 2) == '1') {
                        System.out.print("th");
                    } else {
                        System.out.print("rd");
                    }
                    break;

                default:
                    System.out.print("th");
            }
            System.out.println(" Value: " + m_readings[i]);
        }
        System.out.println();
        System.out.println("Average Of All pH Values: " + m_initialAverage);
        System.out.println("Most Distant Value From Average: " + m_readings[m_discardIndex]);
        System.out.println("New Average Without Most Distant Value: " + m_improvedAverage);
    }
}