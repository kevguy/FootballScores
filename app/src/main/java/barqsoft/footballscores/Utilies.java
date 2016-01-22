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
            case "Everton FC" : return R.drawable.everton_fc_logo1;
            case "Leicester City FC" : return R.drawable.leicester_city_fc_hd_logo;
            case "Liverpool FC" : return R.drawable.liverpool;
            case "Manchester United FC" : return R.drawable.manchester_united;
            case "Newcastle United FC" : return R.drawable.newcastle_united;
            case "Norwich City FC" : return R.drawable.norwich_city;
            case "Southampton FC" : return R.drawable.southampton_fc;
            case "Stoke City FC" : return R.drawable.stoke_city;
            case "Sunderland AFC" : return R.drawable.sunderland;
            case "Swansea City" : return R.drawable.swansea_city_afc;
            case "Tottenham Hotspur FC" : return R.drawable.tottenham_hotspur;
            case "Watford FC" : return R.drawable.watford_fc;
            case "West Bromwich Albion FC" : return R.drawable.west_bromwich_albion_hd_logo;
            case "West Ham United FC" : return R.drawable.west_ham;

            // Not sure if it's the right name, mostly English I guess
            case "Birmingham City" : return R.drawable.birmingham_city;
            case "Blackburn Rovers": return R.drawable.blackburn_rovers;
            case "Boltan Wanderers" : return R.drawable.bolton_wanderers;
            case "Burney FC" : return R.drawable.burney_fc_hd_logo;
            case "Cardiff City" : return R.drawable.cardiff_city;
            case "Celtic" : return R.drawable.celtic;
            case "Chelsea FC" : return R.drawable.chelsea;
            case "Coverntry City" : return R.drawable.coventry_city;
            case "Crystal Palace FC" : return R.drawable.crystal_palace_fc;
            case "Derby Country" : return R.drawable.derby_county;
            case "England" : return R.drawable.england;
            case "Fulham FC" : return R.drawable.fulham_fc;
            case "Glascow Rangers" : return R.drawable.glascow_rangers;
            case "Hearts FC" : return R.drawable.hearts_fc;
            case "Hull City AFC" : return R.drawable.hull_city_afc_hd_logo;
            case "Ipswich Town" : return R.drawable.ipswich_town;
            case "Ireland" : return R.drawable.ireland;
            case "Leeds United FC" : return R.drawable.leeds_united;
            case "Manchester City FC" : return R.drawable.manchester_city;
            case "Middles Brough" : return R.drawable.middlesbrough;
            case "Millwall FC" : return R.drawable.millwall_fc;
            case "Northern Ireland" : return R.drawable.northern_ireland;
            case "Nottingham Forest" : return R.drawable.nottingham_forest;
            case "Portsmouth FC" : return R.drawable.portsmouth_fc;
            case "Queens Park Rangers" : return R.drawable.queens_park_rangers_hd_logo;
            case "Reading" : return R.drawable.reading;
            case "Scotland" : return R.drawable.scotland;
            case "Sheffield Wednesday" : return R.drawable.sheffield_wendesday;
            case "Wigan Athletic" : return R.drawable.wigan_athletic;
            case "Wolverhampton Wanderers" : return R.drawable.wolverhampton_wanderers;
            case "Wrexham" : return R.drawable.wrexham;

            // Deutsch
            case "1. FC Köln" : return R.drawable.fc_koln;
            case "Bayer Leverkusen" : return R.drawable.bayer_leverkusen;
            case "Borussia Dortmund" : return R.drawable.borussia_dortmund;
            case "Bor. Mönchengladbach" : return R.drawable.borussia_monchengladbach;
            case "FC Bayern München" : return R.drawable.bayern_munchen;
            case "FC Hansa Rostock" : return R.drawable.hansa_rostock;
            case "Hamburger SV" : return R.drawable.hamburger_sv;
            case "Hannover 96" : return R.drawable.hannover_96;
            case "Hertha BSC" : return R.drawable.hertha_bsc;
            case "VfB Stuttgart" : return R.drawable.vfb_stuttgart;

            // Not sure if it's the right name, mostly Deutsch I guess
            case "Eintracht Frankfurt" : return R.drawable.eintracht_frankfurt;
            case "FC Kaiserslautern" : return R.drawable.fc_kaiserslautern;
            case "FC Nurnberg" : return R.drawable.fc_nurnberg;
            case "Germany" : return R.drawable.germany;
            case "Karlsruher SC" : return R.drawable.karlsruher_sc;
            case "MSV Duisburg" : return R.drawable.msv_duisburg;
            case "Schalke 04" : return R.drawable.schalke_04;
            case "VfL Bochum" : return R.drawable.vfl_bochum;
            case "VfL Wolfsburg" : return R.drawable.vfl_wolfsburg;
            case "Werder Bremen" : return R.drawable.werder_bremen;

            // Italian
            case "AC Milan" : return R.drawable.ac_milan;
            case "Atalanta BC" : return R.drawable.atalanta;
            case "Empoli FC" : return R.drawable.empoli;
            case "FC Internazionale Milano" : return R.drawable.inter_milan;
            case "Torino FC" : return R.drawable.torino;

            // Not sure if it's the right name, mostly Italian I guess
            case "AC Cesena" : return R.drawable.ac_cesena;
            case "AC Parma" : return R.drawable.ac_parma;
            case "AS Roma" : return R.drawable.as_roma;
            case "Bologna" : return R.drawable.bologna;
            case "Cagliari" : return R.drawable.cagliari;
            case "Chievo Verona" : return R.drawable.chievo_verona;
            case "Fiorentina" : return R.drawable.fiorentina;
            case "Genoa" : return R.drawable.genoa;
            case "Hellas Verona" : return R.drawable.hellas_verona;
            case "Italy" : return R.drawable.italy;
            case "Juventus" : return R.drawable.juventus;
            case "Livorno" : return R.drawable.livorno;
            case "Napoli" : return R.drawable.napoli;
            case "Palermo" : return R.drawable.palermo;
            case "Perugia" : return R.drawable.perugia;
            case "Sampdoria" : return R.drawable.sampdoria;
            case "SS Lazio" : return R.drawable.ss_lazio;
            case "Udinese" : return R.drawable.udinese;
            case "Vicenza" : return R.drawable.vicenza;


            // Spanish
            case "FC Barcelona" : return R.drawable.barcelona;
            case "Málaga CF" : return R.drawable.malaga_cf;
            case "Rayo Vallecano de Madrid" : return R.drawable.rayo_vallecano;
            case "Real Sociedad de Fútbol" : return R.drawable.real_sociedad;
            case "Sporting Gijón" : return R.drawable.sporting_gijon;

            // Not sure if it's the right name, mostly Spanish I guess
            case "Athletic Bilbao" : return R.drawable.athletic_bilbao;
            case "Atletico Madrid" : return R.drawable.atletico_madrid;
            case "Celta de Vigo" : return R.drawable.celta_de_vigo;
            case "Deportivo Alaves" : return R.drawable.deportivo_alaves;
            case "Deportivo la Coruna" : return R.drawable.deportivo_la_coruna;
            case "Espanyol" : return R.drawable.espanyol;
            case "Getafe" : return R.drawable.getafe;
            case "Osasuna" : return R.drawable.osasuna;
            case "Real Betis" : return R.drawable.real_betis;
            case "Real Madrid" : return R.drawable.real_madrid;
            case "Real Mallorca" : return R.drawable.real_mallorca;
            case "Real Oviedo" : return R.drawable.real_oviedo;
            case "Real Valladolid" : return R.drawable.real_valladolid;
            case "Real Zaragoza" : return R.drawable.real_zaragoza;
            case "Sevilla" : return R.drawable.sevilla;
            case "Spain 1" : return R.drawable.spain_1;
            case "Spain 2" : return R.drawable.spain_2;
            case "Tenerife" : return R.drawable.tenerife;
            case "Ud Las Palmas" : return R.drawable.ud_las_palmas;
            case "Valencia" : return R.drawable.valencia;
            case "Villareal" : return R.drawable.villareal;




            default: return R.drawable.no_icon;
        }
    }
}
