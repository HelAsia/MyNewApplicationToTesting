package com.introtoandroid.mynewapplicationtotesting;

/**
 * Created by Asia on 2018-03-04.
 */

public class Counter {
    int numberOneInt;
    int numberTwoInt;
    String addResultsString;
    int addResultsInt;
    String subtractResultsString;
    int subtractResultsInt;
    String multiplyResultsString;
    int multiplyResultsInt;
    String divideResultsString;
    int divideResultsInt;

    public Counter(String numberOne, String numberTwo){
        this.numberOneInt = Integer.parseInt(numberOne);
        this.numberTwoInt = Integer.parseInt(numberTwo);

        this.addResultsInt = this.numberOneInt + this.numberTwoInt;
        this.addResultsString = Integer.toString(this.addResultsInt);

        this.subtractResultsInt = this.numberOneInt - this.numberTwoInt;
        this.subtractResultsString = Integer.toString(this.subtractResultsInt);

        this.multiplyResultsInt = this.numberOneInt * this.numberTwoInt;
        this.multiplyResultsString = Integer.toString(this.multiplyResultsInt);

        this.divideResultsInt = this.numberOneInt / this.numberTwoInt;
        this.divideResultsString = Integer.toString(this.divideResultsInt);
    }

    public void setResults(String numberOne, String numberTwo){
        this.numberOneInt = Integer.parseInt(numberOne);
        this.numberTwoInt = Integer.parseInt(numberTwo);

        this.addResultsInt = this.numberOneInt + this.numberTwoInt;
        this.addResultsString = Integer.toString(this.addResultsInt);

        this.subtractResultsInt = this.numberOneInt - this.numberTwoInt;
        this.subtractResultsString = Integer.toString(this.subtractResultsInt);

        this.multiplyResultsInt = this.numberOneInt * this.numberTwoInt;
        this.multiplyResultsString = Integer.toString(this.multiplyResultsInt);

        this.divideResultsInt = this.numberOneInt / this.numberTwoInt;
        this.divideResultsString = Integer.toString(this.divideResultsInt);
    }

    public String getAddResult() {
        return addResultsString;
    }

    public String getSubtractResult() {
        return subtractResultsString;
    }

    public String getMultiplyResult() {
        return multiplyResultsString;
    }

    public String getDivideResult() {
        return divideResultsString;
    }
}