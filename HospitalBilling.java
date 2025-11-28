public class HospitalBilling {
    //Option 7: Generate and Shows specific bills

    // Standard Bill (Method Overloading - polymorphism)
    public void generateBill(Patient p, int amount) {
        System.out.println();
        System.out.println("                                                        --- FINAL BILL ---");
        System.out.println("                                                        Patient: " + p.getName());
        System.out.println("                                                        Total Amount: BDT " + amount);
    }

    // Discounted Bill (Method Overloading - polymorphism)
    public void generateBill(Patient p, int amount, int insuranceCoverage) {
        System.out.println();
        System.out.println("                                                      --- FINAL BILL (INSURANCE APPLIED) ---");
        System.out.println("                                                        Patient: " + p.getName());
        System.out.println("                                                        Base Amount: BDT " + amount);
        System.out.println("                                                        Insurance Paid: -BDT " + insuranceCoverage);
        System.out.println("                                                        Patient Pays: BDT " + (amount - insuranceCoverage));
    }
}