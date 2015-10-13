public class Loan
{
    private static double  annualInterestRate,totalPayment, monthlyPayment;
    private static double loanAmount;
    private static int numberOfYears;
    private  double monthlyInterestRate=annualInterestRate/1200;
    public Loan()
    {
        annualInterestRate=5;
        numberOfYears=2;
        loanAmount=100;
        monthlyInterestRate=annualInterestRate/1200;

    }
    public void setAnnualInterestRate(double rate)
    {
        annualInterestRate=rate;
    }
    public void setNumberOfYears(int years)
    {
        numberOfYears=years;
    }
    public void setLoanAmount(double amount)
    {
        loanAmount=amount;
    }
    public double getMonthlyPayment()
    {
        monthlyPayment = loanAmount * monthlyInterestRate /(1 - (Math.pow(1 / (1 + monthlyInterestRate), numberOfYears * 12)));

        return monthlyPayment;
    }
    public double getTotalPayment()
    {
        totalPayment = monthlyPayment * numberOfYears * 12;
        return totalPayment;
    }
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }
}