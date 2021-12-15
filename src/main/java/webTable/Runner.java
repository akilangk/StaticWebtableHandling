package webTable;

public class Runner {
    public static void main(String[] args) {
        WebTableOnStructures run = new WebTableOnStructures();
        run.openUrl();
        run.verifyTheStructureCount();
        run.printTheTableValues();
        run.findStructureHeight();
        run.verifySixthRowHasTwoColumns();
        run.closeTheBrowser();
    }
}
