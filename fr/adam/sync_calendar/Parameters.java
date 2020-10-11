package fr.adam.sync_calendar;

import org.apache.commons.cli.*;

public class Parameters {

    private int n_days;
    
    public void handleParams(String[] args){
                //PARAMETRES

                Options opts = new Options();

                //Add specs to option, add it to the options
                Option days = new Option("d", "Days", true, "Nombre de jours à synchroniser");
                days.setRequired(true);
                opts.addOption(days);
        
                //Initialization of parser and formatter
                CommandLineParser parser = new DefaultParser();
                HelpFormatter formatter = new HelpFormatter();
        
                CommandLine cmd;
                
                try {
                    cmd = parser.parse(opts, args);
                    this.n_days = Integer.parseInt(cmd.getOptionValue("Days"));
                } catch (Exception e) {
                    System.out.println("Tu dois spécifier le nombre de jours à synchroniser");
                    formatter.printHelp("agenda", opts);
                    System.exit(1);
                }
    }

    public int get_days(){
        return this.n_days;
    }
}
