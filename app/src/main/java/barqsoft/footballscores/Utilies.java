package barqsoft.footballscores;

/**
 * Created by yehya khaled on 3/3/2015.
 */
public class Utilies
{
    //public static final int SERIE_A = 357;
    //public static final int PREMIER_LEGAUE = 354;
    public static final int CHAMPIONS_LEAGUE = 362;
    //public static final int PRIMERA_DIVISION = 358;
    //public static final int BUNDESLIGA = 351;



    public static final int BUNDESLIGA1 = 394;
    public static final int BUNDESLIGA2 = 395;
    public static final int LIGUE1 = 396;
    public static final int LIGUE2 = 397;
    public static final int PREMIER_LEAGUE = 398;
    public static final int PRIMERA_DIVISION = 399;
    public static final int SEGUNDA_DIVISION = 400;
    public static final int SERIE_A = 401;
    public static final int PRIMERA_LIGA = 402;
    public static final int Bundesliga3 = 403;
    public static final int EREDIVISIE = 404;


    public static String getLeague(int league_num)
    {
        switch (league_num)
        {
            case BUNDESLIGA1 : return "Bundesliga 1";
            case BUNDESLIGA2 : return "Bundesliga 2";
            case LIGUE1 : return "Ligue 1";
            case LIGUE2 : return "Ligue 2";
            case PREMIER_LEAGUE : return "Premier League";
            case PRIMERA_DIVISION : return "Primera Division";
            case SEGUNDA_DIVISION : return "Segunda Division";
            case SERIE_A : return "Seria A";
            case PRIMERA_LIGA : return "Primera Liga";
            case Bundesliga3 : return "Bundesliga 3";
            case EREDIVISIE : return "Eredivisie";

            case CHAMPIONS_LEAGUE : return "UEFA Champions League";
            default: return "Not known League Please report";
        }
    }
    public static String getMatchDay(int match_day,int league_num)
    {
        if(league_num == CHAMPIONS_LEAGUE)
        {
            if (match_day <= 6)
            {
                return "Group Stages, Matchday : 6";
            }
            else if(match_day == 7 || match_day == 8)
            {
                return "First Knockout round";
            }
            else if(match_day == 9 || match_day == 10)
            {
                return "QuarterFinal";
            }
            else if(match_day == 11 || match_day == 12)
            {
                return "SemiFinal";
            }
            else
            {
                return "Final";
            }
        }
        else
        {
            return "Matchday : " + String.valueOf(match_day);
        }
    }

    public static String getScores(int home_goals,int awaygoals)
    {
        if(home_goals < 0 || awaygoals < 0)
        {
            return " - ";
        }
        else
        {
            return String.valueOf(home_goals) + " - " + String.valueOf(awaygoals);
        }
    }

    public static int getTeamCrestByTeamName (String teamname)
    {
        if (teamname==null){return R.drawable.no_icon;}
        switch (teamname)
        { //This is the set of icons that are currently in the app. Feel free to find and add more
            //as you go.
            case "Arsenal London FC" : return R.drawable.arsenal;

            case "Aston Villa FC" : return R.drawable.aston_villa;
            // Not sure if it's right name
            case "Burney FC" : return R.drawable.burney_fc_hd_logo;
            // Not sure if it's right name
            case "Chelsea FC" : return R.drawable.chelsea;
            // Not sure if it's right name
            case "Crystal Palace FC" : return R.drawable.crystal_palace_fc;

            case "Everton FC" : return R.drawable.everton_fc_logo1;

            // Not sure if it's right name
            case "Hull City AFC" : return R.drawable.hull_city_afc_hd_logo;

            case "Leicester City FC" : return R.drawable.leicester_city_fc_hd_logo;
            case "Liverpool FC" : return R.drawable.liverpool;

            // Not sure if it's right name
            case "Manchester City FC" : return R.drawable.manchester_city;

            case "Manchester United FC" : return R.drawable.manchester_united;

            // Not sure if it's right name
            case "Newcastle FC" : return R.drawable.newcastle_united;

            // Not sure if it's right name
            case "Queens Park Rangers" : return R.drawable.queens_park_rangers_hd_logo;

            case "Southampton FC" : return R.drawable.southampton_fc;
            case "Stoke City FC" : return R.drawable.stoke_city;
            case "Sunderland AFC" : return R.drawable.sunderland;
            case "Swansea City" : return R.drawable.swansea_city_afc;
            case "Tottenham Hotspur FC" : return R.drawable.tottenham_hotspur;
            case "West Bromwich Albion" : return R.drawable.west_bromwich_albion_hd_logo;
            case "West Ham United FC" : return R.drawable.west_ham;

            default: return R.drawable.no_icon;
        }
    }
}
