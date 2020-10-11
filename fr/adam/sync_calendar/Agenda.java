package fr.adam.sync_calendar;


public class Agenda {
    public static void main(String[] args) throws Exception {

        Parameters p = new Parameters();
        p.handleParams(args);

        Authentication auth = new Authentication();
        System.out.println("Status code : " + auth.authenticate(auth.getInputs()));


    }

}
